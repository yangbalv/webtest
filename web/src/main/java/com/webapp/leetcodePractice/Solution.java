package com.webapp.leetcodePractice;

import com.alibaba.fastjson.JSONObject;
import com.webapp.entity.TreeNode;

import java.util.*;

class Solution {
    public static void main(String[] args) {
//        System.out.println(solveEquation("x+5-3+x=6+x-2"));
//        System.out.println(reformat("12345abcdef"));
//        System.out.println(minStartValue(new int[]{-3, 2, -3, 4, 2}));
//        System.out.println(groupThePeople(new int[]{3, 2, 3, 2, 1, 3}));

//        System.out.println(maximumUnits(new int[][]{{1, 3}, {5, 5}, {2, 5}, {4, 2}, {4, 1}, {3, 1}, {2, 2}, {1, 3}, {2, 5}, {3, 2}}, 35));
//        System.out.println(maximumUnits(new int[][]{{1, 3}, {5, 5}, {2, 5}, {4, 2}, {4, 1}, {3, 1}, {2, 2}, {1, 3}, {2, 5}, {3, 2}}, 35));
//        System.out.println(generateParenthesis(4));
//        System.out.println(isPowerOfThree(27));
//        forFor();
//        System.out.println(reverse(-2147483412));
        System.out.println(myAtoi("-91283472332"));
    }

    public static String solveEquation(String equation) {


        int side = 1;
        int count = 0;
        int temporaryCount = 0;
        int num = 0;
        int on = 1;

        boolean start = false;
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == 'x') {
                if (start) {
                    start = false;
                    count = temporaryCount * side + count;
                    temporaryCount = 0;
                } else {
                    count = side * on + count;
                }
                on = 1;

                continue;
            }
            if (equation.charAt(i) == '=') {
                if (start) {
                    start = false;
                    num = temporaryCount * side * (-1) + num;
                }
                on = 1;
                temporaryCount = 0;
                side = -1;
                continue;
            }
            if (equation.charAt(i) == '+' || equation.charAt(i) == '-') {
                if (start) {
                    start = false;
                    num = temporaryCount * side * (-1) + num;
                }
                temporaryCount = 0;
                if (equation.charAt(i) == '-') {
                    on = -1;
                } else {
                    on = 1;
                }
                continue;
            }
            temporaryCount = (equation.charAt(i) - '0') * on + (temporaryCount * 10);
            start = true;
        }
        if (start) {
            num = temporaryCount * side * (-1) + num;
        }
        if (count == 0 && num == 0) {
            return "Infinite solutions";
        }
        if (count == 0 && num != 0) {
            return "No solution";
        }
        return "x=" + (num / count);
    }

    public static String reformat(String s) {
        char[] num = new char[(s.length() + 1) / 2];
        int pn = 0;
        char[] chars = new char[(s.length() + 1) / 2];
        int pc = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
                if (pc >= chars.length) {
                    return "";
                }
                chars[pc++] = s.charAt(i);
            } else {
                if (pn >= num.length) {
                    return "";
                }
                num[pn++] = s.charAt(i);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (pn > pc) {
            for (int j = 0; j < pn - 1; j++) {
                stringBuffer.append(num[j]);
                stringBuffer.append(chars[j]);
            }
            stringBuffer.append(num[pn - 1]);
        }
        if (pn == pc) {
            for (int j = 0; j < pn; j++) {
                stringBuffer.append(num[j]);
                stringBuffer.append(chars[j]);
            }
        }
        if (pn < pc) {
            for (int j = 0; j < pc - 1; j++) {
                stringBuffer.append(chars[j]);
                stringBuffer.append(num[j]);
            }
            stringBuffer.append(chars[pc - 1]);
        }
        return new String(stringBuffer);
    }

    public static int minStartValue(int[] nums) {
        int mins = 0;
        int last = 0;
        for (int i : nums) {
            last = last + i;
            mins = Math.min(mins, last);
        }
        if (mins < 0) {
            return 0 - mins + 1;
        } else {
            return 1;
        }
    }

    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) {
            return s;
        }
        int cnt = 0, left = 0;
        List<String> subs = new ArrayList<String>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                ++cnt;
            } else {
                --cnt;
                if (cnt == 0) {
                    subs.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }

        Collections.sort(subs, (a, b) -> b.compareTo(a));
        StringBuilder ans = new StringBuilder();
        for (String sub : subs) {
            ans.append(sub);
        }
        return ans.toString();
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<int[]> stack = new ArrayDeque<int[]>(); // {idx, 开始运行的时间}

        int[] res = new int[n];
        for (String log : logs) {
            String[] split = log.split(":");
            int idx = Integer.parseInt(split[0]);
            String type = split[1];
            int timestamp = Integer.parseInt(split[2]);
            if ("start".equals(type)) {
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] += timestamp - stack.peek()[1];
                    stack.peek()[1] = timestamp;
                }
                stack.push(new int[]{idx, timestamp});
            } else {
                int[] t = stack.pop();
                res[t[0]] += timestamp - t[1] + 1;
                if (!stack.isEmpty()) {
                    stack.peek()[1] = timestamp + 1;
                }
            }
        }
        return res;
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res1 = new ArrayList();
        List<String> res = new ArrayList();
        res1.add("()");
        if (n == 1) {
            return res1;
        }
        res1.add(")(");


        List<String> res2 = new ArrayList();
        List<String>[] lists = new List[2];
        lists[0] = res1;
        lists[1] = res2;
        int tp = 1;

        for (int i = 1; i < n; i++) {
            for (String s : lists[(tp + 1) % 2]) {
                lists[tp % 2].add(s + "()");
                lists[tp % 2].add(s + ")(");
                lists[tp % 2].add("()" + s);
                lists[tp % 2].add(")(" + s);
                lists[tp % 2].add(")" + s + "(");
                lists[tp % 2].add("(" + s + ")");
            }
            lists[(tp + 1) % 2].clear();
            tp++;
        }

        for (String s : lists[(tp + 1) % 2]) {
            if (check(s)) {
                if (!res.contains(s)) {
                    res.add(s);
                }
            }
        }
        return res;
    }

    public static boolean check(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    return false;
                }
            }
        }
        if (count == 0) {
            return true;

        } else {
            return false;
        }
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (null == map.get(groupSizes[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(groupSizes[i], list);
            } else {
                map.get(groupSizes[i]).add(i);
            }
        }
        System.out.println(JSONObject.toJSONString(map));
        for (Map.Entry entry : map.entrySet()) {
            int count = (int) entry.getKey();
            List<Integer> list = (List<Integer>) entry.getValue();

            while (list.size() > 0) {
                List<Integer> mode = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    mode.add(list.get(0));
                    list.remove(0);
                }
                res.add(mode);
            }
        }
//        List<List<Integer>> res = new ArrayList<>();
        return res;
    }

    public List<List<Integer>> groupThePeople2(int[] groupSizes) {
        Map<Integer, List<Integer>> groups = new HashMap<Integer, List<Integer>>();
        int n = groupSizes.length;
        for (int i = 0; i < n; i++) {
            int size = groupSizes[i];
            groups.putIfAbsent(size, new ArrayList<Integer>());
            groups.get(size).add(i);
        }
        List<List<Integer>> groupList = new ArrayList<List<Integer>>();
        for (Map.Entry<Integer, List<Integer>> entry : groups.entrySet()) {
            int size = entry.getKey();
            List<Integer> people = entry.getValue();
            int groupCount = people.size() / size;
            for (int i = 0; i < groupCount; i++) {
                List<Integer> group = new ArrayList<Integer>();
                int start = i * size;
                for (int j = 0; j < size; j++) {
                    group.add(people.get(start + j));
                }
                groupList.add(group);
            }
        }
        return groupList;
    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n % 3 != 0) {
            return false;
        }
        while (n > 0) {
            if (n == 1) {
                return true;
            }
            if (n % 3 != 0) {
                return false;
            }
            n = n / 3;
        }
        return true;

    }

    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        Set<Integer> set = new HashSet();

        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - t.charAt(i);
            if (x < 0) {
                x = 26 + x;
            }

            if (x < k) {
                if (!set.contains(x)) {
                    set.add(x);

                } else {
                    x = 26 + x;
                    while (x < k) {

                    }

                }

            }

        }
        return true;
    }

    public static int reverse(int x) {
        int num = x;
        int p;
        int q = 1;
        int res = 0;
        while (num != 0) {
            p = num % 10;
            num /= 10;
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res = (res * q) + p;
            q = 10;

        }
        return res;
    }

    public static int myAtoi(String s) {
        boolean start = false;
        char c;
        int type = 1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!start) {
                if (c == '+' || c == '-') {
                    if (c == '-') {
                        type = -1;
                    } else {
                        type = 1;
                    }
                    start = true;
                    continue;
                }
                if (c == ' ') {
                    continue;
                } else {
                    start = true;
                }
            }
            if (c > '9' || c < '0') {
                return res * type;
            }
            if (res*type < Integer.MIN_VALUE / 10) {
                return -2147483648;
            }
            if (res*type > Integer.MAX_VALUE / 10) {
                return 2147483647;
            }
            res = res * 10 + (c - '0');

        }
        return res * type;

    }

    public static void forFor() {

        for (int i = 1; i <= 4; i++) {
            System.out.println("i = " + i);
            ok:
            for (int j = 1; j <= 3; j++) {
                System.out.println("j = " + j);
                for (int k = 1; k <= 3; k++) {
                    System.out.println("i * j * k = " + (i * j * k));
                    if (i * j * k == 18) {
                        break ok;
                    }
                }
            }
        }
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] count = new int[boxTypes.length];
        int res = 0;
        int p = 0;
        for (int[] ints : boxTypes) {
            if (!map.containsKey(ints[1])) {
                map.put(ints[1], ints[0]);
                count[p++] = ints[1];
            } else {
                int x = map.get(ints[1]);
                map.put(ints[1], x + ints[0]);
            }
        }
        Arrays.sort(count);
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] == 0) {
                return res;
            }
            if (map.get(count[i]) < truckSize) {
                truckSize = truckSize - map.get(count[i]);
                res = res + (map.get(count[i]) * count[i]);
            } else {
                res = res + (truckSize * count[i]);
                return res;
            }
        }
        return res;
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root1);
        queue.add(root2);
        while (queue.size() != 0) {
            if (null != queue.peek().left) {

            }
        }
        return null;
    }

}