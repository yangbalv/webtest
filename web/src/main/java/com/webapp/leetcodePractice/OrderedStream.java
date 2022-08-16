package com.webapp.leetcodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class OrderedStream {
    public int[] key;
    public String[] values;
    public int ptr;

    public OrderedStream(int n) {
        key = new int[n];
        values = new String[n];
        System.out.println(Arrays.toString(key));
        System.out.println(Arrays.toString(values));
        ptr = 0;
    }

    public List<String> insert(int idKey, String value) {
        List<String> res = new ArrayList<>();
        key[idKey] = 1;
        values[idKey] = value;
        if (key[ptr] == 1) {
            while (ptr < key.length && key[ptr] == 1) {
                res.add(values[ptr]);
                ptr++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OrderedStream orderedStream = new OrderedStream(3);
        System.out.println(orderedStream.insert(2, "aaaa"));
        System.out.println(orderedStream.insert(1, "bbbb"));
        System.out.println(orderedStream.insert(0, "cccc"));
        System.out.println(Arrays.toString(orderedStream.key));
        System.out.println(Arrays.toString(orderedStream.values));

    }
}