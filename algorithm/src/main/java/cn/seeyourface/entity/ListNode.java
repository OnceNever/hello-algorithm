package cn.seeyourface.entity;

import lombok.Data;

/**
 * <p>
 *     链表节点
 * </p>
 *
 * @author yangLei
 * @date 2022/12/2 13:52
 */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) {this.val = val;}
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
