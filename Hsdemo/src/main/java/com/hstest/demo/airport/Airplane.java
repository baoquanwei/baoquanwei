package com.hstest.demo.airport;

import java.util.Random;
 
 

 
public class Airplane extends FlyingObject implements Enemy {
    private int speed = 3;  //移动步骤
 
    /** 初始化数据 */
    public Airplane(){
        this.image = ShootGame.airplane;
        width = image.getWidth();
        height = image.getHeight();
        y = -height;         
        Random rand = new Random();
        x = rand.nextInt(ShootGame.WIDTH - width);
    }
 
    /** 获取分数 */
    @Override
    public int getScore() { 
        return 5;
    }
 
    /** //越界处理 */
    @Override
    public     boolean outOfBounds() {  
        return y>ShootGame.HEIGHT;
    }
 
    /** 移动 */
    @Override
    public void step() {  
        y += speed;
    }
 
}