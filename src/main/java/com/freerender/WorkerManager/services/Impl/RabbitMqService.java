package com.freerender.WorkerManager.services.Impl;

import com.freerender.WorkerManager.dto.QueueInfoDto;
import com.freerender.WorkerManager.services.StreamingService;
import org.springframework.amqp.core.QueueInformation;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService implements StreamingService {

    @Autowired
    private RabbitAdmin rabbitAdmin;



    @Override
    public <T> QueueInfoDto getQueueInfo(String queueName) {
        QueueInformation queueInformation = rabbitAdmin.getQueueInfo(queueName);

        if (queueInformation != null) {
            QueueInfoDto queueInfoDto = new QueueInfoDto();
            queueInfoDto.setConsumerCount(queueInformation.getConsumerCount());
            queueInfoDto.setMessageCount(queueInformation.getMessageCount());
            return queueInfoDto;
        }
        throw new RuntimeException("queueInformation is null");
    }
}
