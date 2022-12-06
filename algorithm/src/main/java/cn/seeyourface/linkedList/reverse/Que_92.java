package cn.seeyourface.linkedList.reverse;

import cn.seeyourface.entity.ListNode;

/**
 * <p>
 *     给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 *     请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * </p>
 *
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * <p>
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 * <p>
 * 提示：
 * <li>链表中节点数目为 n
 * <li>1 <= n <= 500
 * <li>-500 <= Node.val <= 500
 * <li>1 <= left <= right <= n
 *
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 *
 * @author yangLei
 * @date 2022/12/5 14:23
 */
public class Que_92 {

    static ListNode node;

    static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1)
            return reverseN(head, right);
        // 如果left != 1，一直前进到第left节点，也就是开始翻转节点，这时候可以将left看作1，也就变成了翻转前N个节点，只不过此时的N为 right - left + 1
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    // 翻转前 N 个节点
    static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            node = head.next;
            return head;
        }
        // 以head.next为起点，还需要反转 n - 1 个节点
        ListNode root = reverseN(head.next, n - 1);
        head.next.next = head;
        // 翻转后的节点与后面的节点连接起来
        head.next = node;
        return root;
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
        ListNode head = reverseBetween(listNode_1, 2, 4);
        System.out.println("1");
    }
}
