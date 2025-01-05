package com.freerender.WorkerManager.scheduler;

import com.freerender.WorkerManager.dto.QueueInfoDto;
import com.freerender.WorkerManager.dto.SwarmDtos.ServiceDTO;
import com.freerender.WorkerManager.services.ContainerOrchestrationService;
import com.freerender.WorkerManager.services.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WorkerManagerScheduler {
    @Autowired
    private StreamingService streamingService;

    @Autowired
    private ContainerOrchestrationService containerOrchestrationService;

    @Value("${msg.per.service}")
    private int MSG_THRESHOLD_FOR_A_SERVICE;

    @Value("${max.replica}")
    private int MAX_SERVICE_REPLICAS;

    @Value("${queue.name}")
    private String QUEUE_NAME;

    @Scheduled(fixedDelay = 20000)
    public void checkAndScaleWebsiteRenderWorkers() {
        containerOrchestrationService.createService("");
        this.updateService(1);

        QueueInfoDto queueInfo = streamingService.getQueueInfo(QUEUE_NAME);
        if (queueInfo == null) {
            return;
        }

        if (queueInfo.consumerCount != 1 && queueInfo.messageCount == 0) {
            this.updateService(1);
            return;
        }

        double ratio = (double) (queueInfo.messageCount / (queueInfo.consumerCount * MSG_THRESHOLD_FOR_A_SERVICE));
        int requiredReplicaCount = (int) Math.ceil((double) queueInfo.messageCount / MSG_THRESHOLD_FOR_A_SERVICE);
        if (ratio > 1) {
            if (requiredReplicaCount > MAX_SERVICE_REPLICAS) {
                requiredReplicaCount = MAX_SERVICE_REPLICAS;
            }
            this.updateService(requiredReplicaCount);
        } else if(ratio < 0.2){
            this.updateService(1);
        }
    }

    private void updateService(int replicaCount){
        ServiceDTO currentServiceInfo = (ServiceDTO) containerOrchestrationService.serviceInfo("s");
        currentServiceInfo.setReplicas(replicaCount);
        containerOrchestrationService.updateService(currentServiceInfo);
    }
}