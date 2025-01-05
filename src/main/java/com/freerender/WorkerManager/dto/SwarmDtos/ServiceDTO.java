package com.freerender.WorkerManager.dto.SwarmDtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceDTO {
    public String id;
    public int version;
    public String createdAt;
    public String updatedAt;
    public Repository repository;
    public String serviceName;
    public String mode;
    public String stack;
    public String agent;
    public String immutable;
    public List<Object> links;
    public int replicas;
    public String state;
    public Status status;
    public List<Port> ports;
    public List<Object> mounts;
    public List<Object> networks;
    public List<Object> secrets;
    public List<Object> configs;
    public List<Host> hosts;
    public List<Variable> variables;
    public List<Object> labels;
    public List<Object> containerLabels;
    public Object command;
    public String user;
    public String dir;
    public Boolean tty;
    public Object healthcheck;
    public LogDriver logdriver;
    public Resources resources;
    public Deployment deployment;

    public int getReplicas() {
        return replicas;
    }

    public void setReplicas(int replicas) {
        this.replicas = replicas;
    }

    // Getters and Setters
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Repository {
        public String name;
        public String tag;
        public String image;
        public String imageDigest;

        // Getters and Setters
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Status {
        public Tasks tasks;
        public Object update;
        public Object message;

        // Getters and Setters
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Tasks {
            public int running;
            public int total;

            // Getters and Setters
        }
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Port {
        public int containerPort;
        public String protocol;
        public String mode;
        public int hostPort;

        // Getters and Setters
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Host {
        public String name;
        public String value;

        // Getters and Setters
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Variable {
        public String name;
        public String value;

        // Getters and Setters
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LogDriver {
        public String name;
        public List<Object> opts;

        // Getters and Setters
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Resources {
        public Reservation reservation;
        public Limit limit;

        // Getters and Setters
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Reservation {
            public double cpu;
            public int memory;

            // Getters and Setters
        }
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Limit {
            public double cpu;
            public int memory;

            // Getters and Setters
        }
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Deployment {
        public Update update;
        public int forceUpdate;
        public RestartPolicy restartPolicy;
        public Rollback rollback;
        public boolean rollbackAllowed;
        public boolean autoredeploy;
        public List<Placement> placement;

        // Getters and Setters

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Update {
            public int parallelism;
            public int delay;
            public String order;
            public String failureAction;

            // Getters and Setters
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class RestartPolicy {
            public String condition;
            public int delay;
            public int window;
            public int attempts;

            // Getters and Setters
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Rollback {
            public int parallelism;
            public int delay;
            public String order;
            public String failureAction;

            // Getters and Setters
        }

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Placement {
            public String rule;

            // Getters and Setters
        }
    }
}
