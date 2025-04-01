package com.source.pekko;

import org.apache.pekko.actor.AbstractActor;
import org.apache.pekko.actor.ActorRef;
import org.apache.pekko.japi.pf.ReceiveBuilder;

/**
 * @Description
 * @Author gxl
 * @Date 2025/3/28
 */
public class PekkoRpcSenderActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        //接受到pekkoData的消息数据交给handleMessage 处理
        // flink的 PekkoRpcActor 155行也是这么处理的
        return ReceiveBuilder.create().match(PekkoData.class,this::handleMessage).build();
    }
    /**
     * 处理的消息
     * @param message
     */
    private void handleMessage(PekkoData message) {
        /**获取发送者，发送者对应的就是actorRef*/
        ActorRef sender = getSender();
        //打印
        System.out.println(sender+":接受到=>"+message.getInfo());
    }
}
