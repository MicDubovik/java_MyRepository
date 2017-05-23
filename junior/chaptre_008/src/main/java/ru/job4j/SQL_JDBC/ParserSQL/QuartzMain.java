package ru.job4j.SQL_JDBC.ParserSQL;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * My scheduler for app.
 */
public class QuartzMain {
    /**
     * main.
     *
     * @param args
     * @throws SchedulerException
     */
    public static void main(String[] args) throws SchedulerException {

        JobDetail job = JobBuilder.newJob(Parse.class).build();
        Trigger t3 = TriggerBuilder.newTrigger().withIdentity("CronTrigger").withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(24).repeatForever()).build();

        Scheduler sc = StdSchedulerFactory.getDefaultScheduler();

        sc.start();

        sc.scheduleJob(job, t3);

    }
}
