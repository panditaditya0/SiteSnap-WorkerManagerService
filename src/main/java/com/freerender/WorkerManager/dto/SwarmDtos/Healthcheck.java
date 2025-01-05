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
public class Healthcheck {
    public ArrayList<String> test;
    public int interval;
    public int timeout;
    public int retries;

    public Healthcheck(ArrayList<String> test, int interval, int timeout, int retries) {
        this.test = test;
        this.interval = interval;
        this.timeout = timeout;
        this.retries = retries;
    }

    public ArrayList<String> getTest() {
        return test;
    }

    public void setTest(ArrayList<String> test) {
        this.test = test;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }
}
