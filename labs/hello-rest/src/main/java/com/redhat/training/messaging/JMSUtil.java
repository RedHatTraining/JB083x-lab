package com.redhat.training.messaging;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.JMSContext;
import javax.inject.Inject;

@Startup
@Singleton
public class JMSUtil {

    @Resource(mappedName = "java:jboss/jms/queue/helloWorldQueue")
    private Queue helloWorldQueue;

    @Inject
    JMSContext context;

    public void sendMessage(String msg) {
        try {
            context.createProducer().send(helloWorldQueue, msg);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
