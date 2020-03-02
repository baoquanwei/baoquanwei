package com.hsexample.hsexample.test;

import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class TaskQueue {

    private static TaskQueue instance;

    private static BlockingQueue queue = null;

    private TaskQueue(){
        queue = new LinkedBlockingDeque();
    }

    public static TaskQueue getInstance(){
        if(instance == null){
            instance = new TaskQueue();
        }
        return instance;
    }

    /**
     * 获取队列大小
     * @return
     */
    public static int getSize(){
        return queue.size();
    }

    /**
     * 放入队列中
     * @param msg
     */
    public void put(Object obj){
        if(obj != null){
            try {
                queue.put(obj);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 放入队列中
     * @param msg
     */
    public void putAll(Collection objs){
        if(objs != null){
            queue.addAll(objs);
        }
    }

    /**
     * 从队列中取出一个
     * @return
     */
    public Object take(){
        try {
            Object obj = queue.take();
            return obj;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
