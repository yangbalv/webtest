package com.webapp.leetcodePractice;

import com.webapp.entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
//        int[] ints = new int[]{3, 7, 9, 23, 4, 5, 1, 0, 6};
//        System.out.println(Arrays.binarySearch(ints, 23));
//        System.out.println(solution2.constructMaximumBinaryTree(new int[]{12, 213, 213}));
//        System.out.println(solution2.findKthPositive(new int[]{1, 2, 3, 4}, 2));
//        System.out.println(solution2.search(new int[]{2, 5}, 5));
        System.out.println(solution2.searchInsert(new int[]{1, 3, 5, 6}, 2));
//        System.out.println(solution2.firstBadVersion(190));


    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int maxPoint = getMaxPoint(nums);
        TreeNode treeNode = new TreeNode(nums[maxPoint]);


        return null;
    }

    int getMaxPoint(int[] ints) {
        int max = Arrays.stream(ints).max().getAsInt();
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == max) {
                return i;
            }
        }
        return -1;
    }


    public int findKthPositive(int[] arr, int k) {
        int p = 0;
        int pk = 0;
        for (int i = 1; i <= arr.length + k; i++) {
            if (p == arr.length) {
                return arr[p - 1] + k - pk;
            }
            if (arr[p] == i) {
                p++;

            } else {

                pk++;
                if (pk == k) {
                    return i;
                }

            }


        }
        return -1;

    }

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[(right + left) / 2] == target) {
                return (right + left) / 2;
            } else if (nums[(right + left) / 2] > target) {
                right = ((right + left) / 2) - 1;
            } else if (nums[(right + left) / 2] < target) {
                left = ((right + left) / 2) + 1;
            }
        }
        return -1;
    }


    public int firstBadVersion(int n) {
        if (n == 1) {
            if (isBadVersion(1)) {
                return 1;
            } else {
                return 0;
            }
        }
        int left = 1;
        int right = n;

        while (true) {
            if (left == right) {
                return left;
            }
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (isBadVersion(mid)) {
                right = mid;

            } else {
                if (isBadVersion((left + right) / 2 + 1)) {
                    return (left + right) / 2 + 1;
                } else {
                    left = mid + 1;
                }
            }
        }

    }

    public boolean isBadVersion(int i) {
        if (i >= 8) {
            return true;
        } else {
            return false;
        }
    }

//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < k; i++) {
//            res.add(arr[i]);
//        }
//
//    }

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        for (int i = 0; i < n; i++) {
            res[2 * i] = nums[i];
            res[2 * i + 1] = nums[n + i];
        }
        return res;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        if (target <= nums[0]) {
            return 0;
        }
        int right = nums.length - 1;
        while (left < right) {
            if (left == right - 1) {
                return right;
            }

            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid;
            }

        }

        return right;
    }

    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];

        int pl = 0;
        int pr = nums.length - 1;
        for (int i = res.length - 1; i >= 0; i--) {
            if (nums[pl] * nums[pl] > nums[pr] * nums[pr]) {
                res[i] = nums[pl] * nums[pl];
                pl++;
            } else {
                res[i] = nums[pr] * nums[pr];
                pr--;
            }
        }
        return res;
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int target = i + k;
            if (target >= nums.length) {
                target = target % nums.length;
            }
            int mid = nums[target];
            nums[target] = nums[i];
            nums[i] = mid;
        }
    }
}
