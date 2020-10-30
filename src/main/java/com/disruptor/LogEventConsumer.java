package com.disruptor;


import com.lmax.disruptor.EventHandler;

/**
 * @Author yunnuo.yang
 * @Date 2020/10/28 15:40
 * @Description
 **/
public class LogEventConsumer implements EventHandler<LogEvent> {

    @Override
    public void onEvent(LogEvent logEvent, long l, boolean b) throws Exception {
        System.out.println(Thread.currentThread().getName() + " | Event : " + logEvent);
    }
}
