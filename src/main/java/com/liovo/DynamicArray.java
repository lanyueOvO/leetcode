package com.liovo;

public class DynamicArray {
    private int size = 0;
    private int capacity = 8; //容量
    private int[] array = new int[capacity];

//
    /**
     * add
     *
     * @param index 指定下标
     * @param element 插入的元素
     */
    public void add(int index,int element){
        checkAndGrow(); //check

        if (index >= 0 && index < size){
            System.arraycopy(array,index,
                    array,index+1,size-index);  //拷贝array数组。在指定index下标下插入，后拷贝index后的元素
        }
        /**
            src − 这是源数组。
            srcPos − 这是源数组中的起始位置。
            dest − 这是目标数组。
            destPos − 这是目标数据中的起始位置。
            length − 这是要复制的数组元素的数量。
            array[index] = element;
         */
        size++;
    }

    private void checkAndGrow() {
        //        容量检查（扩容1.5）
        if(size == capacity){
            capacity = capacity+capacity >> 1; //length
            int[] newArray = new int[capacity];
            System.arraycopy(array,0,
                    newArray,0,size);
            array = newArray;
        }
    }
}
