package com.webapp.leetcodePractice;

import com.webapp.entity.TreeNode;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
//        int[] ints = new int[]{3, 7, 9, 23, 4, 5, 1, 0, 6};
//        System.out.println(Arrays.binarySearch(ints, 23));
//        System.out.println(solution2.constructMaximumBinaryTree(new int[]{12, 213, 213}));
//        System.out.println(solution2.findKthPositive(new int[]{1, 2, 3, 4}, 2));
//        System.out.println(solution2.search(new int[]{2, 5}, 5));

//        System.out.println(solution2.firstBadVersion(190));

//        solution2.rotate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2);
//        solution2.maxProfit2(new int[]{7, 2, 8, 1, 3, 1});
//        System.out.println(solution2.commonFactors(885, 885));
        System.out.println(solution2.maxSum(new int[][]{{6, 2, 1, 3}, {4, 2, 1, 5}, {9, 2, 8, 7}, {4, 1, 2, 9}}));
//        count(885);

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
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) {
                continue;
            } else {
                set.add(i);
            }
            int target = i + k;
            if (target > nums.length - 1) {
                target = target - nums.length;
            }
            int before = nums[i];
            int mid = 0;
            while (true) {
                if (target > nums.length - 1) {
                    target = target - nums.length - 1;
                }

                if (target == i) {
                    nums[i] = mid;
                    break;
                }
                mid = nums[target];
                nums[target] = before;
                before = mid;
                target = target + k;
            }

        }
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        int max = min;
        for (int price : prices) {
            if (price < min) {
                min = price;
                max = min;
            } else if (price > max) {
                max = price;
                int mid = max - min;
                res = Math.max(mid, res);
            }
        }
        return res;
    }

    public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public int commonFactors(int a, int b) {
        int mid = Math.min(a, b);

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= mid; i++) {
            if (a % i == 0 && b % i == 0) {
                if (!set.contains(i)) {
                    set.add(i);
                }
            }

        }
        return set.size();
    }

    static void count(int x) {
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                System.out.println(i);
            }
        }

    }

    public int maxSum(int[][] grid) {
        if (grid[0] == null) {
            return 0;
        }
        int res = 0;
        int length = grid[0].length;
        int width = grid.length;
        int l = 0;
        int r = grid[0].length - 1;
        int p = 1;
        boolean num = true;
        if (width % 2 != 0) {
            num = false;
        }
        for (int i = 0; i < width; i++) {
            for (int j = l; j <= r; j++) {
                res += grid[i][j];
            }
            if (l == r || l == r - 1) {
                if (num) {
                    num = false;
                } else {
                    p = -1;
                    l += p;
                    r -= p;
                }

            }else {
                l += p;
                r -= p;
            }

        }
        return res;
    }
}
