package com.yugutou.charpter2_reverselist.level2.topic2_3链表加1;

import com.yugutou.charpter1_linklist.level1.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * LeetCode369 单链表加1
 */
public class PlusOne {
    public static void main(String[] args) {
//        int[] a = {9, 9, 9};
        int[] a = {1, 2, 3};
        ListNode nodeA = initLinkedList(a);

        ListNode node = plusOne(nodeA);

        System.out.println(toString(node));

    }

    public static ListNode plusOne(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        ListNode dummyNode = new ListNode(-1);
        int adder = 1;
        int carry = 0;

        while (!stack.empty() || carry != 0 || adder != 0) {
            int dist = stack.empty() ? 0 : stack.pop();
            int sum = dist + adder + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            ListNode cur = new ListNode(sum);
            cur.next = dummyNode.next;
            dummyNode.next = cur;
            adder = 0;
        }

        return dummyNode.next;

    }

    public static ListNode plusOne2(ListNode head) {
        Stack<Integer> stack = new Stack();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int carry = 0;
        ListNode dummy = new ListNode(0);
        int adder = 1;
        while (!stack.empty() || adder != 0 || carry > 0 ) {
            int digit = stack.empty() ? 0 : stack.pop();
            int sum = digit + adder + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            ListNode listNode = new ListNode(sum);
            listNode.next = dummy.next;
            dummy.next = listNode;
            adder = 0;
        }
        return dummy.next;
    }


    /**
     * 初始化链表
     *
     * @param array
     * @return
     */
    private static ListNode initLinkedList(int[] array) {
        ListNode head = null, cur = null;

        for (int i = 0; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
        }
        return head;
    }


    /**
     * 输出链表
     *
     * @param head 头节点
     */
    public static String toString(ListNode head) {
        ListNode current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.val).append("\t");
            current = current.next;
        }
        return sb.toString();
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
