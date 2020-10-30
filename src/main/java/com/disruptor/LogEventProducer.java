package com.disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

/**
 * @Author yunnuo.yang
 * @Date 2020/10/28 15:41
 * @Description
 **/
public class LogEventProducer {

    private final RingBuffer<LogEvent> ringBuffer;

    public LogEventProducer(RingBuffer<LogEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    private static final EventTranslatorOneArg<LogEvent, String> TRANSLATOR = new EventTranslatorOneArg<LogEvent, String>() {
        public void translateTo(LogEvent event, long sequence, String bb) {
            event.setMessage(bb);
        }
    };


    public void onData(String msg){
        ringBuffer.publishEvent(TRANSLATOR, msg);
    }
}
