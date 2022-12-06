package cn.seeyourface.linkedList.reverse;

import cn.seeyourface.entity.ListNode;

/**
 * <p>
 *     给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * </p>
 *
 * <p>
 *     示例1：
 *     输入：head = [1,2,3,4,5] 输出：[5,4,3,2,1]
 * </p>
 *
 * <p>
 *     示例2：
 *     输入：head = [1,2]
 *     输出：[2,1]
 *     示例 3：
 * </p>
 *
 * <p>
 *     示例3：
 *     输入：head = []
 *     输出：[]
 * </p>
 *
 * <p>
 * 提示：
 * <li>链表中节点的数目范围是 [0, 5000]
 * <li>-5000 <= Node.val <= 5000
 * </p>
 * <p>
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 * @author yangLei
 * @date 2022/12/5 10:12
 */
public class Que_206 {

    // 递归
    static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode root = reverseList(head.next);
        // 翻转节点指向
        head.next.next = head;
        // 此时head节点变为 ‘最后'节点，指向null
        head.next = null;
        return root;
    }

    // 双指针迭代
    static ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            // 保存下一个节点
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode_1 = new ListNode(1);
        ListNode listNode_2 = new ListNode(2);
        ListNode listNode_3 = new ListNode(3);
        ListNode listNode_4 = new ListNode(4);
        ListNode listNode_5 = new ListNode(5);
        listNode_1.next = listNode_2;
        listNode_2.next = listNode_3;
        listNode_3.next = listNode_4;
        listNode_4.next = listNode_5;
        ListNode head = reverseList2(listNode_1);
        System.out.println("1");
    }
}
