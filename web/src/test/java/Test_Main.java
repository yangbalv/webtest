import com.webapp.entity.TreeNode;
import com.webapp.util.HttpHelper;
import org.junit.Test;

import java.util.*;


public class Test_Main {
    //    队列 （add、offer是添加返回布尔值）
//    peek,element,poll是获取，队列获取最先添加的元素，poll还会将元素删除
//    remove删除，删除队列首个元素。
    @Test
    public void queue() {

        Queue<TreeNode> queue = new ArrayDeque();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
//        添加
        queue.add(treeNode1);
        boolean add = queue.add(treeNode2);
        queue.add(treeNode3);
        System.out.println(queue.size());
        boolean offer = queue.offer(treeNode4);
        System.out.println(queue);
        //    peek,element,poll是获取，队列获取最先添加的元素，poll还会将元素删除
        System.out.println(queue.peek());
        System.out.println(queue.remove());
//        包含
        System.out.println(queue.contains(treeNode1));
//        判空
        System.out.println(queue.isEmpty());
        System.out.println(queue);
//        清空
        queue.clear();
        System.out.println(queue);
    }

    @Test
    public void testStack() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        Stack<TreeNode> stack = new Stack<>();
//        添加 add push
        stack.add(treeNode1);
        stack.push(treeNode2);
        stack.addElement(treeNode3);
//        stack.pop();
//        stack.forEach(a -> System.out.println(a));


        //        位置添加
        stack.add(1, treeNode3);

        Enumeration<TreeNode> elements = stack.elements();

//        获取不删除
        stack.peek();

//        获取并删除
        stack.pop();

        stack.push(treeNode4);
//        System.out.println(stack);
//        System.out.println(stack.empty());
//
//        System.out.println(stack);

    }

    @Test
    public void testDeepestLeavesSum() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode root = treeNode1;
        treeNode4.left = treeNode7;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode6.right = treeNode8;
        treeNode3.right = treeNode6;
        root.left = treeNode2;
        root.right = treeNode3;
        System.out.println(deepestLeavesSum(root));


    }

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        int last = 1;
        int next = 0;
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode pop = queue.poll();
            last--;
            res += pop.val;
            if (pop.left != null) {
                queue.add(pop.left);
                next++;
            }
            if (pop.right != null) {
                queue.add(pop.right);
                next++;
            }

            if (last == 0) {
                if (next != 0) {
                    res = 0;
                }
                last = next;
                next = 0;

            }
        }

        return res;
    }

    //
//    @Test
//    public void ArrayDeque() {
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(4);
////        栈与队列
//        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque();
////都是返回第一个，但是只有peek不会抛出异常
//        System.out.println(arrayDeque.peek());
////        System.out.println(arrayDeque.element());
////        System.out.println(arrayDeque.getFirst());
//
////        尾部添加
//        arrayDeque.add(treeNode1);
////        头部添加
//        arrayDeque.addFirst(treeNode2);
//        arrayDeque.add(treeNode3);
//
////        返回头部，空则返回空
//        System.out.println(arrayDeque.peek());
////        返回并删除
//        System.out.println(arrayDeque.poll());
//        arrayDeque.addFirst(treeNode2);
////
//        System.out.println(arrayDeque.offer(treeNode4));
//        System.out.println(arrayDeque);
//
//    }
    @Test
    public void tsetIsmatch() {
        System.out.println(isMatch("djklawjkldajdwjiadwjalo", ".*m.*"));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    @Test
    public void testGetNumber() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);

        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode2.left = treeNode1;
        treeNode5.right = treeNode6;
        treeNode7.left = treeNode5;
        treeNode4.left = treeNode2;
        treeNode4.right = treeNode7;

        TreeNode root = treeNode4;

        System.out.println(getNumber(root, new int[][]{{0, 2, 2}, {1, 1, 5}, {0, 4, 5}, {1, 5, 7}}));

    }

    public static Set<Integer> set = new HashSet<>();

    public static int getNumber(TreeNode root, int[][] ops) {

        makeMap(root);
        Set <Integer> resSet = new HashSet<>();

        for (int[] mode : ops) {
            if (mode[0] == 0) {
                for (int i = mode[1]; i <= mode[2]; i++) {
                    if (set.contains(i)) {
                        resSet.remove(i);
                    }

                }
            } else {
                for (int i = mode[1]; i <= mode[2]; i++) {
                    if (set.contains(i)) {
                        resSet.add(i);
                    }
                }
            }
        }

        return resSet.size();
    }

    public static void makeMap(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        set.add(treeNode.val);
        makeMap(treeNode.left);
        makeMap(treeNode.right);
    }
}
