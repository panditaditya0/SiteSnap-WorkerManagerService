package com.freerender.WorkerManager.dto.SwarmDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Port {
    public int containerPort;
    public String protocol;
    public String mode;
    public int hostPort;

    public Port(int containerPort, String protocol, String mode, int hostPort) {
        this.containerPort = containerPort;
        this.protocol = protocol;
        this.mode = mode;
        this.hostPort = hostPort;
    }

    public int getContainerPort() {
        return containerPort;
    }

    public void setContainerPort(int containerPort) {
        this.containerPort = containerPort;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getHostPort() {
        return hostPort;
    }

    public void setHostPort(int hostPort) {
        this.hostPort = hostPort;
    }
}