package com.steven.jdk.disruptor.demo2;

import com.lmax.disruptor.ExceptionHandler;
import org.w3c.dom.events.EventException;

/**
 * Created by Steven on 2017/5/29.
 */
public class IntEventExceptionHandler implements ExceptionHandler {
    @Override
    public void handleEventException(Throwable throwable, long l, Object o) {

    }

    @Override
    public void handleOnStartException(Throwable throwable) {

    }

    @Override
    public void handleOnShutdownException(Throwable throwable) {

    }
}
