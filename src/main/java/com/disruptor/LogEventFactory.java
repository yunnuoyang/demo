package com.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @Author yunnuo.yang
 * @Date 2020/10/28 15:36
 * @Description
 **/
public class LogEventFactory implements EventFactory<LogEvent> {
    @Override
    public LogEvent newInstance() {
        return new LogEvent();
    }
}
