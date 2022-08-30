package com.webapp.leetcodePractice;

import java.util.*;

class RangeFreqQuery {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);

            } else {
                map.put(arr[i], new ArrayList<>());
                map.get(arr[i]).add(i);
            }
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> list = map.get(value);
        int first = left;
        while (list.indexOf(first) == -1 && first <= list.get(list.size() - 1)) {
            first++;
        }
        if (first == list.get(list.size() - 1)) {
            return 0;
        }
        while (list.lastIndexOf(right) == -1 && right > 0) {
            right--;
        }
        if (right == 0) {
            return 0;
        }
        return right - first;

    }

    public static void main(String[] args) {

        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
        System.out.println(rangeFreqQuery.query(1, 2, 4));
        System.out.println(rangeFreqQuery.query(0, 11, 33));
//        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[]{1, 1, 1, 2, 2});
//        System.out.println(rangeFreqQuery.query(0, 1, 2));
//        System.out.println(rangeFreqQuery.query(0, 2, 1));
//        System.out.println(rangeFreqQuery.query(3, 3, 2));
//        System.out.println(rangeFreqQuery.query(2, 2, 1));


//        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[]{8, 4, 2, 5, 4, 5, 8, 6, 2, 3});
//        System.out.println(rangeFreqQuery.query(0, 3, 5));
//        System.out.println(rangeFreqQuery.query(5, 6, 2));
//        System.out.println(rangeFreqQuery.query(6, 8, 4));
//        System.out.println(rangeFreqQuery.query(2, 8, 3));
//        System.out.println(rangeFreqQuery.query(4, 5, 1));
//        System.out.println(rangeFreqQuery.query(2, 4, 2));
    }
}