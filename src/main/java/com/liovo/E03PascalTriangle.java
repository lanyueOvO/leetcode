package com.liovo;


/**
 * 杨辉三角
 * @Date 2023/4/5 22:30
 */
public class E03PascalTriangle {
    public static void main(String[] args) {
//        System.out.println(coordinate(5,3));
        print2(6);
    }

    /**
     * 根据杨辉三角规律求坐标值
     *
     * 行 i，列 j，那么[i][j]取值为[i-1][j-1] + [i-1][j]  == x+y
     * 当 j=0 或者 i=j 时，[i][j] = 1
     *
     * @return
     */
    private static int coordinate(int i,int j) {
        if (j==0 || i==j){
            return 1;
        }
        return coordinate((i-1),j-1)+coordinate((i-1),j);
    }

    /**
     * 打印杨辉三角
     * @param n 打印几列
     */
    private static void print(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.printf("%-4d",coordinate(i,j));  //"%-4d" 左对齐以及间隔为4
            }
            System.out.println();
        }
    }
    /* (n-i-1)*2
     */
    private static void printSpan(int n,int i){
        int num = (n-i-1)*2;
        for (int j = 0; j < num; j++) {
            System.out.print(" ");
        }

    }

    /**
     *
     * @param
     */
    private static void print2(int n){
        for (int i = 0; i < n; i++) {
            printSpan(n,i);
            for (int j = 0; j <= i; j++) {
                System.out.printf(" * ");

            }
            System.out.println();
        }
    }

    /**
     * 杨辉三角优化  --一维数组记忆法
     */
    private static void coordinate2(int[] row,int i){
        if (i==0){
            row[0] = 1;
            return;
        }
        for (int j = 0; j > 0 ; j--) {
            row[j] = row[j]+row[j-1];
        }
    }
}
