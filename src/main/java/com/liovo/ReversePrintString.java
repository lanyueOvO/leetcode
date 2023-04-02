package com.liovo;

/**
 * @Date 2023/3/28 22:29
 */
public class ReversePrintString {

    public static void printF(int n,String str){
        if (n == str.length()) return;
        printF(n+1,str);
        System.out.println(str.charAt(n));
    }
    public static void main(String[] args) {
        printF(2,"qwert");
    }
}
