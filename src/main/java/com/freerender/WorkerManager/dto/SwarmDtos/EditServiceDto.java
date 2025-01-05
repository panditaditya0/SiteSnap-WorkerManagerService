package com.freerender.WorkerManager.dto.SwarmDtos;

import java.util.ArrayList;

public class EditServiceDto {
    public boolean agent;
    public ArrayList<Object> configs;
    public ArrayList<Object> command;
    public ArrayList<Host> hosts;
    public boolean immutable;
    public String user;
    public ArrayList<Object> containerLabels;
    public LogDriver logdriver;
    public boolean tty;
    public Repository repository;
    public ArrayList<Object> networks;
    public String mode;
    public ArrayList<Object> labels;
    public ArrayList<Object> mounts;
    public String serviceName;
    public Deployment deployment;
    public Healthcheck healthcheck;
    public String dir;
    public ArrayList<Variable> variables;
    public ArrayList<Object> links;
    public int version;
    public int replicas;
    public ArrayList<Object> secrets;
    public Resources resources;
    public ArrayList<Port> ports;
    public String stack;

    public boolean isAgent() {
        return agent;
    }

    public void setAgent(boolean agent) {
        this.agent = agent;
    }

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

    public boolean isImmutable() {
        return immutable;
    }

    public void setImmutable(boolean immutable) {
        this.immutable = immutable;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ArrayList<Object> getContainerLabels() {
        return containerLabels;
    }

    public void setContainerLabels(ArrayList<Object> containerLabels) {
        this.containerLabels = containerLabels;
    }

    public LogDriver getLogdriver() {
        return logdriver;
    }

    public void setLogdriver(LogDriver logdriver) {
        this.logdriver = logdriver;
    }

    public boolean isTty() {
        return tty;
    }

    public void setTty(boolean tty) {
        this.tty = tty;
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

    public Healthcheck getHealthcheck() {
        return healthcheck;
    }

    public void setHealthcheck(Healthcheck healthcheck) {
        this.healthcheck = healthcheck;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public ArrayList<Variable> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<Variable> variables) {
        this.variables = variables;
    }

    public ArrayList<Object> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<Object> links) {
        this.links = links;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }
}