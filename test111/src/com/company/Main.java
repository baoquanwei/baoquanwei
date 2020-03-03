package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a[]=new int[5];

        Scanner sc =new Scanner(System.in);

        for(int c=0;c<a.length;c++){
            a[c]=sc.nextInt();
        }
        for (int d=0;d<a.length;d++)
        {
            System.out.println(a[d]+" ");
        }


//        System.out.println(b);
	// write your code here
    }
}
