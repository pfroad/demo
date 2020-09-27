package com.pfroad.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForeachTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            if ("2".equals(item)) {
//                iterator.remove();
//            }
//        }
        for (String item : list) {
            if ("1".equals(item)) {
                list.remove(item);
            }
        }
    }
}
