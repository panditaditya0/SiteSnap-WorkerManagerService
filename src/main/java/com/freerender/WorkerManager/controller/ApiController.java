package com.freerender.WorkerManager.controller;

import com.freerender.WorkerManager.dto.SwarmDtos.ServiceDTO;
import com.freerender.WorkerManager.services.ContainerOrchestrationService;
import com.freerender.WorkerManager.services.StreamingService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private ContainerOrchestrationService containerOrchestrationService;

    @Autowired
    private StreamingService streamingService;

    @GetMapping("/services")
    public ResponseEntity<Object> getServices() {
//        ServiceDTO[] services = (ServiceDTO[]) containerOrchestrationService.getAllServices();
//        containerOrchestrationService.createService("");
        ServiceDTO service =  (ServiceDTO)  containerOrchestrationService.serviceInfo("s");
        containerOrchestrationService.updateService(service);
        return new ResponseEntity<>("dcs", HttpStatus.OK);
    }


    @GetMapping("/streamingService/{queueName}")
    public ResponseEntity<Object> getStreamingService(@PathVariable String queueName) {
        streamingService.getQueueInfo(queueName);
        return ResponseEntity.ok().body("dcs");
    }
}
