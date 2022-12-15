package cn.seeyourface.linkedList.symmetric;

import cn.seeyourface.entity.ListNode;

/**
 * <p>
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * <p>
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * <p>
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 *
 * <p>
 * 提示：
 * <li>链表中节点数目在范围[1, 105] 内
 * <li>0 <= Node.val <= 9
 * <li>进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * </p>
 *
 * @author yangLei
 * @date 2022/12/12 17:15
 * @since 1.7.1
 */
public class Que_234 {

    /**
     * 快慢指针，fast指针帮助slow指针寻找链表中点
     * 找到中点后翻转slow后面的节点
     */
    public boolean isPalindrome(ListNode head) {
        // 快指针用于寻找中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 如果fast不为空，则是奇数个节点，slow指针需要往后再走一步
        if (fast != null)
            slow = slow.next;
        // 指针指向左边和右边
        ListNode left = head;
        // 翻转slow后的节点，返回反转后的头结点
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    ListNode reverse(ListNode node) {
        ListNode prev = null, curr = node, temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
