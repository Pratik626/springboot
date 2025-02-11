package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is responsible for running a scheduled task that prints the current time every 5 seconds.
 */
@Component  // Marks this class as a Spring-managed component, so Spring can detect and use it.
public class ScheduledTasks {

    // Logger to display messages in the console/logs.
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    // Date formatter to display time in "HH:mm:ss" format (e.g., 14:30:15).
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * This method is automatically executed every 5 seconds.
     * It logs the current time to the console.
     */
    @Scheduled(fixedRate = 5000)  // Ensures the task runs every 5 seconds.
    public void reportCurrentTime() {
        // Log the current time in the format HH:mm:ss.
        log.info("The time is now {}", dateFormat.format(new Date()));
    }
}
