package com.freerender.WorkerManager.dto.SwarmDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateServiceDto {
    public ArrayList<Object> configs;
    public ArrayList<Object> command;
    public ArrayList<Host> hosts;
    public LogDriver logdriver;
    public Repository repository;
    public ArrayList<Object> networks;
    public String mode;
    public ArrayList<Object> labels;
    public ArrayList<Object> mounts;
    public String serviceName;
    public Deployment deployment;
    public ArrayList<Variable> variables;
    public int replicas;
    public ArrayList<Object> secrets;
    public Resources resources;
    public ArrayList<Port> ports;

    public ArrayList<Object> getConfigs() {
        return configs;
    }

    public void setConfigs(ArrayList<Object> configs) {
        this.configs = configs;
    }

    public ArrayList<Object> getCommand() {
        return command;
    }

    public void setCommand(ArrayList<Object> command) {
        this.command = command;
    }

    public ArrayList<Host> getHosts() {
        return hosts;
    }

    public void setHosts(ArrayList<Host> hosts) {
        this.hosts = hosts;
    }

    public LogDriver getLogdriver() {
        return logdriver;
    }

    public void setLogdriver(LogDriver logdriver) {
        this.logdriver = logdriver;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public ArrayList<Object> getNetworks() {
        return networks;
    }

    public void setNetworks(ArrayList<Object> networks) {
        this.networks = networks;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public ArrayList<Object> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<Object> labels) {
        this.labels = labels;
    }

    public ArrayList<Object> getMounts() {
        return mounts;
    }

    public void setMounts(ArrayList<Object> mounts) {
        this.mounts = mounts;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Deployment getDeployment() {
        return deployment;
    }

    public void setDeployment(Deployment deployment) {
        this.deployment = deployment;
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }

    public int getReplicas() {
        return replicas;
    }

    public void setReplicas(int replicas) {
        this.replicas = replicas;
    }

    public ArrayList<Object> getSecrets() {
        return secrets;
    }

    public void setSecrets(ArrayList<Object> secrets) {
        this.secrets = secrets;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public ArrayList<Port> getPorts() {
        return ports;
    }

    public void setPorts(ArrayList<Port> ports) {
        this.ports = ports;
    }
}