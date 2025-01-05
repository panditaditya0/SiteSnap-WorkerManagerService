package com.freerender.WorkerManager.dto.SwarmDtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resources {
    public Reservation reservation;
    public Limit limit;

    public Resources(Reservation reservation, Limit limit) {
        this.reservation = reservation;
        this.limit = limit;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Limit getLimit() {
        return limit;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }
}