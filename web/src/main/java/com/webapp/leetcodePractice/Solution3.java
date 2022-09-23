package com.webapp.leetcodePractice;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class Solution3 {
    public int len;

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public Solution3(ListNode head) {
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
    }

    public int getRandom() {

        Random random = new Random();
        int i = random.nextInt();
        i = i % len;
        for (int j = 0; j <= i; j++) {
        }
        return 0;
    }

    public int longestContinuousSubstring(String s) {
        int max = 0;
        char last = s.charAt(0);
        max = 1;
        int mid = 1;


        for (int i = 1; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now - last == 1) {
                mid++;
                if (mid > max) {
                    max = mid;
                }
            } else {
                mid = 1;

            }
            last = now;
        }
        return max;
    }

    public Solution3() {
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.longestContinuousSubstring("abcde"));
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode reverseOddLevels(TreeNode root) {
            Queue<TreeNode> queue1 = new ArrayDeque<>();
            Queue<TreeNode> queue2 = new ArrayDeque<>();

            return null;

        }
    }
}
