package cn.seeyourface.linkedList.exchange;

import cn.seeyourface.entity.ListNode;

/**
 * <p>
 *     给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *
 * <p>
 * 提示：
 * <li>链表中节点的数目在范围 [0, 100] 内
 * <li>0 <= Node.val <= 100
 * </p>
 *
 * @author yangLei
 * @date 2022/12/5 15:27
 */
public class Que_24 {

    // 迭代
    static ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode cur = root;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;
            ListNode temp1 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = temp;
            cur.next.next.next = temp1;

            cur = cur.next.next;
        }
        return root.next;
    }

    // 递归 code by me
    // 遵循定义 ：交换两个节点，然后返回交换后的头节点，与上一组的尾节点相连
    static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 交换后的头节点
        ListNode temp = head.next;
        // 保存下一个递归的临时节点
        ListNode temp1 = head.next.next;
        // 交换两个节点
        head.next.next = head;
        // 置为null，否则节点成环
        head.next = null;
        // 交换后的节点与下一组的头节点相连
        head.next = swapPairs2(temp1);
        // 返回头节点
        return temp;
    }

    public static void main(String[] args) {
        ListNode listNode_1 = new ListNode(1);
        ListNode listNode_2 = new ListNode(2);
        ListNode listNode_3 = new ListNode(3);
        ListNode listNode_4 = new ListNode(4);
        ListNode listNode_5 = new ListNode(5);
        ListNode listNode_6 = new ListNode(6);
        listNode_1.next = listNode_2;
        listNode_2.next = listNode_3;
        listNode_3.next = listNode_4;
        listNode_4.next = listNode_5;
        listNode_5.next = listNode_6;
        ListNode listNode = swapPairs2(listNode_1);
        System.out.println("1");
    }
}
