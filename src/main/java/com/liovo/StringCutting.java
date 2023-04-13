package com.liovo;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串切割
 * @date 2023/4/13
 */
public class StringCutting {
    public static void main(String[] args) {
        String str = "a$gj$kf$hhgjhgj$";
        List<String> resultList = new ArrayList<>();
        StringBuilder subStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c == '$') {
                resultList.add(subStr.toString());
                System.out.println("list:"+resultList);
                subStr.setLength(0); // 清空 StringBuilder 对象
            } else {
                System.out.println(c);
                subStr.append(c);
            }
        }

        if (subStr.length() > 0) {
            resultList.add(subStr.toString());
        }
        System.out.println(resultList);
    }
}
