import com.webapp.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;


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
        Stack <TreeNode> stack = new Stack<>();
        stack.peek();
        stack.pop();
        
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


}
