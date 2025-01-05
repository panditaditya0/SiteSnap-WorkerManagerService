package com.freerender.WorkerManager.services.Impl;

import com.freerender.WorkerManager.services.ContainerOrchestrationService;
import org.springframework.stereotype.Service;

@Service
public class DockerEngineApiService implements ContainerOrchestrationService {
    @Override
    public <T> Object[] getAllServices() {
        return null;
    }

    @Override
    public <T> Object serviceInfo(T service) {
        return null;
    }

    @Override
    public <T> T updateService(T service) {
        return null;
    }

    @Override
    public <T> T deleteService(T service) {
        return null;
    }

    @Override
    public <T> T createService(T service) {
        return null;
    }
}
