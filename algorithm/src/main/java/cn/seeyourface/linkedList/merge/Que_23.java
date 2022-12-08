package cn.seeyourface.linkedList.merge;

import cn.seeyourface.entity.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>
 *     给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * <p>
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * <pre>{@code
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]}</pre>
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * <p>
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 *
 * <p>
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 *
 * <p>
 * 提示：
 * <li>k == lists.length
 * <li>0 <= k <= 10^4
 * <li>0 <= lists[i].length <= 500
 * <li>-10^4 <= lists[i][j] <= 10^4
 * <li>lists[i] 按 升序 排列
 * <li>lists[i].length 的总和不超过 10^4
 * </p>
 *
 * @author yangLei
 * @date 2022/12/7 11:15
 */
public class Que_23 {
    // 方法1 ：化整为零，先将两个有序链表合为一个，再将合并的链表与原有链表进行合并，直到只剩下一个链表
    static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        int k = lists.length;
        while (k > 1) {
            ListNode p1 = lists[k - 1];
            ListNode p2 = lists[k - 2];
            // 合并两个有序链表
            ListNode newNode = mergeTwoLists(p1, p2);
            lists[k - 1] = null;
            lists[k - 2] = newNode;
            k--;
        }
        return lists[0];
    }

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

    // 方法二：利用优先队列（二叉堆）添加数据后会自动排序
    static ListNode mergeKLists2(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        // 最小堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new comp());

        for (ListNode list : lists) {
            if (list != null)
                queue.add(list);
        }


        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            temp.next =node;
            if (node.next != null) {
                queue.add(node.next);
            }
            temp = temp.next;
        }
        return head.next;
    }

    static class comp implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[1];
        lists[0] = new ListNode(1);
        mergeKLists2(lists);
    }
}
