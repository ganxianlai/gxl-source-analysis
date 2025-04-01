package com.source.pekko;

import org.apache.pekko.actor.ActorRef;
import org.apache.pekko.actor.ActorSystem;
import org.apache.pekko.actor.Props;

/**
 * @Description
 * @Author gxl
 * @Date 2025/3/31
 */
public class Demo {
    public static void main(String[] args) {
        // 创建 actorSystem
        ActorSystem actorSystem = ActorSystem.create("flink");
        // 构建 pekkoRpcRef 的ActorRef
        ActorRef pekkoRpcRef = actorSystem.actorOf(Props.create(PekkoRpcActor.class), "PekkoReceive");
        // 构建 pekkoRpcSendRef 的ActorRef
        ActorRef pekkoRpcSendRef = actorSystem.actorOf(Props.create(PekkoRpcSenderActor.class), "PekkoRpcSendActor");
        //pekkoRpcSendRef 作为发送者 向 pekkoRpcRef 发送 hello
        pekkoRpcRef.tell(new PekkoData("hello"),pekkoRpcSendRef);
    }

}
