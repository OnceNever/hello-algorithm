package cn.seeyourface.linkedList.cycle;

import cn.seeyourface.entity.ListNode;

/**
 * <p>
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 *
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * <p>
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * <p>
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 *
 * <p>
 * 提示：
 * <li>链表中节点的数目范围在范围 [0, 104] 内
 * <li>-105 <= Node.val <= 105
 * <li>pos 的值为 -1 或者链表中的一个有效索引
 *
 * <p>
 * 进阶：你是否可以使用 O(1) 空间解决此题？
 * </p>
 *
 * @author yangLei
 * @date 2022/12/12 11:56
 * @since 1.7.1
 */
public class Que_142 {
    static ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 如果有环一定会进入这个逻辑
            if (slow == fast) {
                // 把一个指针重新指向头节点
                slow = head;
                // 当再次指向同一个节点时即为环的起点
                while (slow != fast) {
                    // 每次都只走一步
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        p1.next = p2;
        detectCycle(p1);
    }
}
