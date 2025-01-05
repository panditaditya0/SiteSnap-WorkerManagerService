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
public class LogDriver {
    public String name;
    public ArrayList<Object> opts;

    public LogDriver(String name, ArrayList<Object> opts) {
        this.name = name;
        this.opts = opts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Object> getOpts() {
        return opts;
    }

    public void setOpts(ArrayList<Object> opts) {
        this.opts = opts;
    }
}