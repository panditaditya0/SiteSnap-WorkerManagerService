package com.freerender.WorkerManager.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QueueInfoDto {
    public long messageCount;
    public long consumerCount;

    public long getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(long messageCount) {
        this.messageCount = messageCount;
    }

    public long getConsumerCount() {
        return consumerCount;
    }

    public void setConsumerCount(long consumerCount) {
        this.consumerCount = consumerCount;
    }
}
