package com.disruptor;

/**
 * @Author yunnuo.yang
 * @Date 2020/10/28 15:36
 * @Description
 **/
public class LogEvent {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LogEvent{" +
                "message='" + message + '\'' +
                '}';
    }
}
