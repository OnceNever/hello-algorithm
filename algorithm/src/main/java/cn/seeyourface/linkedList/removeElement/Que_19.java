package cn.seeyourface.linkedList.removeElement;

import cn.seeyourface.entity.ListNode;

/**
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 *
 * <p>
 * 提示：
 * <li>链表中结点的数目为 sz
 * <li>1 <= sz <= 30
 * <li>0 <= Node.val <= 100
 * <li>1 <= n <= sz
 * <p>
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 * </p>
 *
 * @author yangLei
 * @date 2022/12/6 15:12
 */
public class Que_19 {

    // 迭代 快慢指针
    // 先让快指针走 n 个单位，之后快慢指针同时走一个单位，当快指针为null时，慢指针指向下一个需要删除的节点
    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode slow = root, fast = root;
        while (true) {
            fast = fast.next;
            if (fast == null) {
                ListNode next = slow.next;
                slow.next = next.next;
                return root.next;
            }
            if (n-- <= 0)
                slow = slow.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode_1 = new ListNode(1);
        ListNode listNode_2 = new ListNode(2);
        ListNode listNode_3 = new ListNode(3);
        ListNode listNode_4 = new ListNode(4);
        ListNode listNode_5 = new ListNode(5);
        ListNode listNode_6 = new ListNode(6);
//        listNode_1.next = listNode_2;
//        listNode_2.next = listNode_3;
//        listNode_3.next = listNode_4;
//        listNode_4.next = listNode_5;
//        listNode_5.next = listNode_6;
        removeNthFromEnd(listNode_1, 1);
    }
}
