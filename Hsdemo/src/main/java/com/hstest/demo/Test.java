package com.hstest.demo;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
                int NUM = 5;
                int []a = new int[NUM];
                System.out.println("请输入数字:");

                for(int i=0;i<a.length;i++){
                        a[i] = input.nextInt();
                    }

                System.out.println("排序之前:");
                for (int i : a) {
                         System.out.print(i+"\t");
                     }

               //冒泡排序实现
                for(int i=0;i<a.length-1;i++){
                        for(int j=0;j<a.length-i-1;j++){
                                if(a[j]>a[j+1]){
                                        int temp = a[j];
                                        a[j] = a[j+1];
                                        a[j+1] = temp;
                                    }
                            }
                    }

               System.out.println("\n排序之后:");
                for (int i : a) {
                         System.out.print(i+"\t");
                    }


    }


}
