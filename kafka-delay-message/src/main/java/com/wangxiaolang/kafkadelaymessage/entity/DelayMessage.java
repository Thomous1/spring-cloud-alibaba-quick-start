package com.wangxiaolang.kafkadelaymessage.entity;

import java.io.Serializable;

/**
 * @description:
 * @author: ZuoYu Wang
 * @create: 2025年03月31日 10:18
 **/

public class DelayMessage implements Serializable {
    private String message;
    private long delayMs;
    private long createTime;

    public DelayMessage(String message, long delayMs) {
        this.message = message;
        this.delayMs = delayMs;
    }

    public String getMessage() {
        return message;
    }

    public long getDelayMs() {
        return delayMs;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}