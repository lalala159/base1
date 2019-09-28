//package com.hc.system.controller.shuapiao.entrance;
//
//import com.hc.system.controller.shuapiao.pojo.IpInfo;
//import com.hc.system.controller.shuapiao.thread.IPCollectTask;
//import com.hc.system.controller.shuapiao.thread.VoteThread;
//import org.apache.log4j.Logger;
//
//import java.util.Timer;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
//
//
//public class Vote {
//    private BlockingQueue<IpInfo> ipInfoQueue;
//    private IPCollectTask ipCollectTask;
//    private VoteThread voteThread;
//    protected Logger logger = Logger.getLogger(this.getClass());
//    public Vote() {
//        ipInfoQueue = new LinkedBlockingQueue<IpInfo>();
//        ipCollectTask = new IPCollectTask(ipInfoQueue);
//        voteThread = new VoteThread(ipInfoQueue);
//    }
//
//    public void vote() {
//        Timer timer = new Timer();
//        long delay = 0;
//        long period = 1000 * 60 * 60;
//        // 每一个小时采集一次ip
//        timer.scheduleAtFixedRate(ipCollectTask, delay, period);
//
//        // 开启投票任务
//        logger.info("开始投票");
//        voteThread.start();
//    }
//
//    public static void main(String[] args) {
//        Vote vote = new Vote();
//        vote.vote();
//    }
//}