package cn.seeyourface.linkedList.merge;

import cn.seeyourface.entity.ListNode;

/**
 * <p>
 *     将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * <p>
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * <li>两个链表的节点数目范围是 [0, 50]
 * <li>-100 <= Node.val <= 100
 * <li>l1 和 l2 均按 非递减顺序 排列
 *
 * @author yangLei
 * @date 2022/12/6 19:10
 */
public class Que_21 {
    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                temp.next = p2;
                p2 = p2.next;
                temp = temp.next;
                continue;
            }
            if (p2 == null) {
                temp.next = p1;
                p1 = p1.next;
                temp = temp.next;
                continue;
            }
            if (p1.val <= p2.val) {
                temp.next = p1;
                p1 = p1.next;
            } else {
                temp.next = p2;
                p2 = p2.next;
            }
            temp = temp.next;
        }
        return head.next;
    }
}
