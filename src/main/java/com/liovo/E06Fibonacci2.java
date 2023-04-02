package com.liovo;

/**
 * @Date 2023/3/29 23:07
 */
public class E06Fibonacci2 {
    public static int fibonacci(int n){
//        if (n==0) return 0;
//        if (n==1) return 1;
        int a = 1,b=1,c=0;
        for (int i = 0; i < n-2; i++) {
            c=a+b;
            a=b;
            b=c;
//            int t = 0;
//            t = (n-1)+(n-2);
//            sum+=t;
//            System.out.println(sum);
//            n--;
        }
        return c;
    }
    public static int fibonacci2(int n){
//        int t = 2*(n+1)-1;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(1));
    }
}
