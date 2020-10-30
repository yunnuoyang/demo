package com.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;

/**
 * @Author yunnuo.yang
 * @Date 2020/10/28 15:42
 * @Description
 **/
public class LogEventMain {

    public static void main(String[] args) {
        LogEventFactory factory = new LogEventFactory();

        // 环形数组的容量，必须要是2的次幂
        int bufferSize = 1024;

        // 构造 Disruptor
        Disruptor<LogEvent> disruptor = new Disruptor<>(factory, bufferSize, DaemonThreadFactory.INSTANCE, ProducerType.MULTI,
                new YieldingWaitStrategy());

        // 设置消费者
        disruptor.handleEventsWith(new LogEventConsumer());
        disruptor.handleEventsWith(new LogEventConsumer());
        disruptor.handleEventsWith(new LogEventConsumer());

        // 启动 Disruptor
        disruptor.start();

        // 生产者要使用 Disruptor 的环形数组
        RingBuffer<LogEvent> ringBuffer = disruptor.getRingBuffer();

        LogEventProducer producer = new LogEventProducer(ringBuffer);

        // 模拟消息发送
        for (int i = 0; i < 10000; i++) {
            producer.onData(String.format("msg-%s", i));
        }
    }
}
