package cn.seeyourface.linkedList.exchange;

import cn.seeyourface.entity.ListNode;
/**
 * <p>
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * </p>
 *
 * <p>
 * 示例 1:
 * 输入：head = [1,2,3,4,5], k = 2 输出：[2,1,4,3,5]
 * </p>
 *
 * <p>
 * 示例 2:
 * 输入：head = [1,2,3,4,5], k = 3 输出：[3,2,1,4,5]
 * </p>
 *
 * <p>
 * 提示：
 * <li>链表中的节点数目为 n
 * <li>1 <= k <= n <= 5000
 * <li>0 <= Node.val <= 1000
 *
 * <p>
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 * @author yangLei
 * @date 2022/12/6 11:19
 */
public class Que_25 {

    // 前驱节点
    static ListNode precursor;
    // 后继节点
    static ListNode successor;

    static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null)
                return head;
            b = b.next;
        }
        // 翻转N个 K个节点
        ListNode newHead = reverse(a, b);
        // 将 N 个翻转好的头尾指针相连
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    static ListNode reverse(ListNode a, ListNode b) {
        ListNode prev, cur, next;
        prev = null; cur = a; next = null;
        while (cur != b) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
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
        ListNode listNode = reverseKGroup(listNode_1, 2);
        System.out.println("1");
    }
}
