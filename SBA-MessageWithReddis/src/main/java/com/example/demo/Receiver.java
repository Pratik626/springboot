package com.example.demo;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Receiver {
	//logs the messages in the console
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
//store the count of the received messages
    private AtomicInteger counter = new AtomicInteger();

    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
        counter.incrementAndGet();//It logs the received message and increments the counter 
    }

    public int getCount() {
        return counter.get();//it returns the total count
    }
}