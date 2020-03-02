package com.hsexample.hsexample.test;

import com.hsexample.hsexample.entity.User;

import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 存放即将被派任务的员工 
 * 每次取出员工时不移除该员工，而是将其放到队列末尾 
 * 如果员工已不存在，将其移除 
 * @author dg 
 * 
 */  
public class UserQueue {  
      
    private static UserQueue instance = null;  
    private static BlockingQueue<User> queue = null;
      
    private UserQueue(){  
        queue =  new LinkedBlockingDeque<User>();
    }  
      
    public static UserQueue getInstance(){  
        if(instance == null){  
            instance = new UserQueue();  
        }  
        return instance;  
    }  
  
    /** 
     * 取下一个员工 
     * @return 
     */  
    public User takeNext(){  
        User user = null;  
        try {  
            user = queue.take();  
            this.put(user);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        return user;  
    }  
      
    /** 
     * 将新员工放入队列中未尾 
     */  
    public void put(User user){  
        if(queue.contains(user)){  
            return;  
        }else{  
            try {  
                queue.put(user);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
      
    public void putAll(Collection<User> users){
        for(User user : users){  
            this.put(user);  
        }  
    }  
      
    /** 
     * 将已不存在的员工移除 
     */  
    public void remove(User user){  
        if(queue.contains(user)){  
            queue.remove(user);  
        }  
    }  
      
    /** 
     * 获取目前队列中所有的user 
     * @return 
     */  
    public Object[] getAllUsers(){  
        Object[] obj = queue.toArray();  
        return obj;  
    }  
      
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        User user1 = new User();  
        user1.setUid(1);  
        user1.setAccount("11");  
          
        User user2 = new User();  
        user2.setUid(1);  
        user2.setAccount("11");  
          
        User user3 = new User();  
        user3.setUid(3);  
        user3.setAccount("11");  
          
        User user4 = new User();  
        user4.setUid(4);  
        user4.setAccount("444");  
          
        User user5 = new User();  
        user5.setUid(5);  
        user5.setAccount("555");  
          
        UserQueue.getInstance().put(user1);  
        UserQueue.getInstance().put(user2);  
        UserQueue.getInstance().put(user3);  
        UserQueue.getInstance().put(user4);  
        UserQueue.getInstance().put(user5);  
          
        for(int i = 0 ; i < 20; i++){  
            System.out.println(UserQueue.getInstance().takeNext().getUid());  
            if(i == 5){  
                UserQueue.getInstance().remove(user2);  
            }  
        }  
          
        Object[] users = UserQueue.getInstance().getAllUsers();  
        System.out.println("=======");  
        for(Object user:users){  
            System.out.println(((User)user).getUid());  
        }  
    }  
  
}  