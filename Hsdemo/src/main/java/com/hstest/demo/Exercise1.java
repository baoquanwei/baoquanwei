package com.hstest.demo;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Exercise1 extends JFrame implements ActionListener{


	private JPanel p1 = new JPanel(); //创建面板
	 private JPanel p2 = new JPanel(); //创建面板
	 private JTextField t1; //文本框1用来显示输入信息
	 StringBuffer str;//输入的字符串
	 JButton[] b=new JButton[10];
	 JButton b1,b2,b3,b4,b5,b6;//16个按钮
	 double x,y;
	 int n;
	public Exercise1() {
		
		 super("网上下载来的");
		 setSize(350,300); //设置窗口大小
	  setLocationRelativeTo(null);	 //显示到中间 	  
	   Container c = getContentPane(); //创建内容面板对象
	 
	   t1 = new JTextField(25);
	   t1.setEditable(false); //只能显示，不能编辑
	  
	   p2.add(t1); //添加文本框到面板

	   p2.setLayout(new GridLayout(3,2)); //把面扳布局为4行1列

	   str=new StringBuffer();
	   //实例化各个按钮
	   for(int i=0;i<10;i++) //分别为数组中0~9号的按钮设置标签，并注册监听器
	   {
	    String s=""+i;
	    b[i]= new JButton(s); 
	    b[i].addActionListener(this); 
	   } 	   
	   b1=new JButton("+");
	   b2=new JButton("-");
	   b3=new JButton("*");
	   b4=new JButton("/"); 
	   b5=new JButton("=");
	   b6=new JButton("delete"); 
   
	   //添加到面板
	   p1.add(b[7]);
	   p1.add(b[8]);
	   p1.add(b[9]);
	   p1.add(b1);
	   p1.add(b[4]);
	   p1.add(b[5]);
	   p1.add(b[6]);
	   p1.add(b2);
	   p1.add(b[1]);
	   p1.add(b[2]);
	   p1.add(b[3]); 
	   p1.add(b3);
	   p1.add(b[0]);
	   p1.add(b5);
	   p1.add(b6);
	   p1.add(b4);  
	   p1.setLayout(new GridLayout(4,5,10,10));
	  
	   //注册监听器
	    
	   b1.addActionListener(this);
	   b2.addActionListener(this);
	   b3.addActionListener(this);
	   b4.addActionListener(this);
	   b5.addActionListener(this);
	   b6.addActionListener(this);
	 
	   //将内容添加到面板上然后添加到容器里
	   c.add(p2);
	   c.add(p1);
	   c.setLayout(new FlowLayout()); //设置为顺序布局
	   //设置窗口关闭动作
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置窗口关闭动作
	   setVisible(true); //设置为可见
	   setResizable(false); //禁止调整框架大小
	 
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		Exercise1 calculate=new Exercise1();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
		
		if(e.getSource()==b6){
	   t1.setText("0");//清零
	   t1.setHorizontalAlignment(JTextField.RIGHT);//右对齐
	   str.setLength(0);
		}
     
       //Double.parseDouble 将字符串转化为double类型
      //t1.getText().trim() 获取字符保存后并且清除
      else if (e.getSource()==b1)//单击加号按钮获得x的值并清空y的值
	  {
		   x=Double.parseDouble(t1.getText().trim());
		   str.setLength(0);
		   y=0d;
		   n=0;
		 }else if(e.getSource()==b2)//减法运算
		 {
			 x=Double.parseDouble(t1.getText().trim());
		   str.setLength(0);
		   y=0d;
		   n=1;
		}else if(e.getSource()==b3)//乘法运算
		{
			x=Double.parseDouble(t1.getText().trim());
		   str.setLength(0);
		   y=0d;
		   n=2;
		}else if(e.getSource()==b4)//除法运算
		{
			x=Double.parseDouble(t1.getText().trim());
		   str.setLength(0);
		   y=0d;
		   n=3;
		}else if(e.getSource()==b5)//等号
		{
			str.setLength(0);
			switch(n){
			case 0:t1.setText(""+(x+y));break;
			case 1:t1.setText(""+(x-y));break;
			case 2:t1.setText(""+(x*y));break;
			case 3:t1.setText(""+(x/y));break;
			}		
		}else{
		if(e.getSource()==b[0])
		{
			if(t1.getText().trim().equals("0"))//如果显示屏显示的为零不做操作
	    {}
	    else
			t1.setText(str.append(e.getActionCommand()).toString());
			t1.setHorizontalAlignment(JTextField.RIGHT);
			y=Double.parseDouble(t1.getText().trim());
			}
		else
    {
    t1.setText(str.append(e.getActionCommand()).toString());
    t1.setHorizontalAlignment(JTextField.RIGHT);
    y=Double.parseDouble(t1.getText().trim());
     }
		}
	}	
}
