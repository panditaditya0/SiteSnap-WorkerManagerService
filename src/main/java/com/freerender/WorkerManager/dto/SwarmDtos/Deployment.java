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
public class Deployment {
    public Update update;
    public int forceUpdate;
    public RestartPolicy restartPolicy;
    public Rollback rollback;
    public boolean rollbackAllowed;
    public boolean autoredeploy;
    public ArrayList<Placement> placement;

    public Update getUpdate() {
        return update;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }

    public int getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(int forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public RestartPolicy getRestartPolicy() {
        return restartPolicy;
    }

    public void setRestartPolicy(RestartPolicy restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    public Rollback getRollback() {
        return rollback;
    }

    public void setRollback(Rollback rollback) {
        this.rollback = rollback;
    }

    public boolean isRollbackAllowed() {
        return rollbackAllowed;
    }

    public void setRollbackAllowed(boolean rollbackAllowed) {
        this.rollbackAllowed = rollbackAllowed;
    }

    public boolean isAutoredeploy() {
        return autoredeploy;
    }

    public void setAutoredeploy(boolean autoredeploy) {
        this.autoredeploy = autoredeploy;
    }

    public ArrayList<Placement> getPlacement() {
        return placement;
    }

    public void setPlacement(ArrayList<Placement> placement) {
        this.placement = placement;
    }
}