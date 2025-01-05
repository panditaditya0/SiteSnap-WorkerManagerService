package com.freerender.WorkerManager.dto.SwarmDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Update {
    public int parallelism;
    public int delay;
    public String order;
    public String failureAction;

    public Update(int parallelism, int delay, String order, String failureAction) {
        this.parallelism = parallelism;
        this.delay = delay;
        this.order = order;
        this.failureAction = failureAction;
    }

    public int getParallelism() {
        return parallelism;
    }

    public void setParallelism(int parallelism) {
        this.parallelism = parallelism;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getFailureAction() {
        return failureAction;
    }

    public void setFailureAction(String failureAction) {
        this.failureAction = failureAction;
    }
}
