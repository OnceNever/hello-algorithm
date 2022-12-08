package cn.seeyourface.linkedList.separate;

import cn.seeyourface.entity.ListNode;

/**
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * <p>
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * <p>
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 * <p>
 * 提示：
 * <li>链表中节点的数目在范围 [0, 200] 内
 * <li>-100 <= Node.val <= 100
 * <li>-200 <= x <= 200
 * <li></p>
 *
 * @author yangLei
 * @date 2022/12/7 10:25
 */
public class Que_86 {
    /**
     * 使用两个虚拟头节点p1, p2，分别保存比 x 小 和 大于等于 x 的节点
     * 使用一个指针遍历head链表，结束后连接 p1.next -> p2.next，返回 p1.next
     */
    static ListNode partition(ListNode head, int x) {
        // 保存比 x 小的节点
        ListNode p1 = new ListNode(-1);
        ListNode tmp1 = p1;
        // 保存比 x 大的节点
        ListNode p2 = new ListNode(-1);
        ListNode tmp2 = p2;
        while (head != null) {
            int val = head.val;
            // 保存下一个节点
            ListNode tmp = head.next;
            if (val < x) {
                tmp1.next = head;
                tmp1 = tmp1.next;
                // 注意设为null 防止成环
                tmp1.next = null;
            } else {
                tmp2.next = head;
                tmp2 = tmp2.next;
                // 注意设为null 防止成环
                tmp2.next = null;
            }
            head = tmp;
        }
        tmp1.next = p2.next;
        return p1.next;
    }
}
