package com.freerender.WorkerManager.services;

import com.freerender.WorkerManager.dto.QueueInfoDto;

public interface StreamingService {

    <T> QueueInfoDto getQueueInfo(String queueName);
}
