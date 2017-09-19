package com.code1j.logger;

import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.OutputStreamAppender;


import ch.qos.logback.core.joran.spi.ConsoleTarget;
import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.WarnStatus;
import ch.qos.logback.core.util.EnvUtil;
import ch.qos.logback.core.util.OptionHelper;
import org.slf4j.event.LoggingEvent;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.EventObject;


/**
 * @ wuhui
 * @ date  2017/9/19下午4:36
 */
public class TestLogger<E> extends ConsoleAppender<E> {

    @Override
    protected void append(E eventObject) {
        ch.qos.logback.classic.spi.LoggingEvent event = (ch.qos.logback.classic.spi.LoggingEvent) eventObject;

//        event.setMessage("abc");

        event.setMessage("dad");

        super.append(eventObject);
    }
}
