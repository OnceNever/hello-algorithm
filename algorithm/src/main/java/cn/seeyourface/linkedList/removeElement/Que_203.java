package cn.seeyourface.linkedList.removeElement;

import cn.seeyourface.entity.ListNode;

/**
 * <p>
 *     给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * <p>
 *
 * <p>
 * 提示：
 * <li>列表中的节点数目在范围 [0, 104] 内
 * <li>1 <= Node.val <= 50
 * <li>0 <= val <= 50
 * </p>
 *
 * @author yangLei
 * @date 2022/12/2 13:49
 */
public class Que_203 {

    // [1, 6, 2, 3, 4, 6, 5, 6]
    static ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(-1);
        ListNode node = temp;
        for (ListNode x = head; x != null; x = x.next) {
            if (x.val == val) {
                temp.next = null;
                continue;
            }
           temp.next = x;
           temp = temp.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode listNode_1 = new ListNode(1);
        ListNode listNode_2 = new ListNode(6);
        ListNode listNode_3 = new ListNode(2);
        ListNode listNode_4 = new ListNode(3);
        ListNode listNode_5 = new ListNode(4);
        ListNode listNode_6 = new ListNode(6);
        ListNode listNode_7 = new ListNode(5);
        ListNode listNode_8 = new ListNode(6);
        listNode_1.next = listNode_2;
        listNode_2.next = listNode_3;
        listNode_3.next = listNode_4;
        listNode_4.next = listNode_5;
        listNode_5.next = listNode_6;
        listNode_6.next = listNode_7;
        listNode_7.next = listNode_8;
        removeElements(listNode_1, 6);
    }


}
