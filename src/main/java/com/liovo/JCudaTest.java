//package com.liovo;
//
//import jcuda.*;
//import jcuda.runtime.*;
//import jcuda.driver.*;
//import jcuda.jcublas.*;
///**
// * @Date 2023/3/31 0:45
// */
//public class JCudaTest {
//    public static void main(String[] args) {
//        JCublas.cublasInit(); // 初始化 JCublas 库
//
//        int n = 50; // 计算斐波那契数列的项数
//        float[] hostFibonacci = new float[n]; // 用于存储计算结果的数组
//        Pointer deviceFibonacci = new Pointer(); // 在设备端分配内存空间
//
//        // 在设备端分配斐波那契数列数组的内存空间
//        JCuda.cudaMalloc(deviceFibonacci, n * Sizeof.FLOAT);
//
//        // 设置数组前两个元素的值
//        hostFibonacci[0] = 0;
//        hostFibonacci[1] = 1;
//
//        // 将数组的前两个元素复制到设备端
//        JCuda.cudaMemcpy(deviceFibonacci, Pointer.to(hostFibonacci), 2 * Sizeof.FLOAT, cudaMemcpyKind.cudaMemcpyHostToDevice);
//
//        // 计算斐波那契数列的其余项
//        JCublas.cublasSgemv('n', n - 2, 2, 1.0f, deviceFibonacci.withByteOffset(0 * Sizeof.FLOAT), n, deviceFibonacci.withByteOffset((0 + 1) * Sizeof.FLOAT), 1, 1.0f, deviceFibonacci.withByteOffset((2 + 0) * Sizeof.FLOAT), 1);
//
//        // 将计算结果复制回主机端
//        JCuda.cudaMemcpy(Pointer.to(hostFibonacci), deviceFibonacci, n * Sizeof.FLOAT, cudaMemcpyKind.cudaMemcpyDeviceToHost);
//
//        // 输出斐波那契数列的计算结果
//        for (int i = 0; i < n; i++) {
//            System.out.println("Fibonacci " + i + " = " + (int)hostFibonacci[i]);
//        }
//
//        // 释放设备端斐波那契数列数组的内存空间
//        JCuda.cudaFree(deviceFibonacci);
//
//        // 关闭 JCublas 库
//        JCublas.cublasShutdown();
//    }
//}
