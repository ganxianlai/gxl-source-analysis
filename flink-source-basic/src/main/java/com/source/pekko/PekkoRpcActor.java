package com.source.pekko;


import org.apache.pekko.actor.AbstractActor;
import org.apache.pekko.actor.ActorRef;
import org.apache.pekko.japi.pf.ReceiveBuilder;

/**
 * @Description
 * @Author gxl
 * @Date 2025/3/28
 */
public class PekkoRpcActor extends AbstractActor {
    /**
     * 实现接收的消息
     * @return
     */
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().match(PekkoData.class,this::handleMessage).build();
    }

    /**
     * 处理的消息
     * @param message
     */
    private void handleMessage(PekkoData message) {
        /**获取发送者，发送者对应的就是actorRef*/
        ActorRef sender = getSender();
        ActorRef self = getSelf();
        //打印
        System.out.println(sender+":发送者=>"+message.getInfo());
        //回复消息 向发送者sender 回复word的消息 回复者是当前的actorRef
        //actor 可以改变他自身的状态，可以接受消息，也可以发送消息，还可以生成的actor
        sender.tell(new PekkoData("PekkoRpcActor-world"),self);
    }






}
