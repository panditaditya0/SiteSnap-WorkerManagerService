package com.freerender.WorkerManager.services;

public interface ContainerOrchestrationService {
    <T> Object[] getAllServices();
    <T> Object serviceInfo(T service);
    <T> Object updateService(T service);
    <T> T deleteService(T service);
    <T> Object createService(T service);
}
