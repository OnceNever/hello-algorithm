package cn.seeyourface.linkedList.design;

/**
 * <p>
 *     设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * <p>
 * 示例：
 * <pre>{@code
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 * }</pre>
 *
 * </p>
 *
 * @author yangLei
 * @date 2022/12/2 16:07
 */
// Que_707
public class MyLinkedList {

    int val;
    int size = 0;
    MyLinkedList prev;
    MyLinkedList next;
    MyLinkedList head;
    MyLinkedList tail;

    public MyLinkedList() {

    }

    public int get(int index) {
        MyLinkedList node = getIndex(index);
        if (null == node)
            return -1;
        return node.val;
    }

    public MyLinkedList getIndex(int index) {
        if (index > size - 1)
            return null;
        if (index <= (size >> 1)) {
            // 从前往后遍历
            MyLinkedList x = head;
            for (int i = 0; i < index; ++i)
                x = x.next;
            return x;
        } else {
            // 从后往前遍历
            MyLinkedList x = tail;
            for (int i = size - 1; i >= 0; --i)
                x = x.prev;
            return x;
        }
    }

    public void addAtHead(int val) {
        if (size == 0) {
            MyLinkedList newNode = new MyLinkedList();
            newNode.val = val;
            head = newNode;
            tail = newNode;
            size++;
            return;
        }

        MyLinkedList first = getIndex(0);
        if (first != null) {
            MyLinkedList newNode = new MyLinkedList();
            newNode.val = val;
            newNode.next = first;
            first.prev = newNode;
            head = newNode;
            size++;
            return;
        }
    }

    public void addAtTail(int val) {
        if (size == 0) {
            MyLinkedList newNode = new MyLinkedList();
            newNode.val = val;
            head = newNode;
            tail = newNode;
            size++;
        }

        MyLinkedList last = getIndex(size - 1);
        if (last != null) {
            MyLinkedList newNode = new MyLinkedList();
            newNode.val = val;
            newNode.prev = last;
            last.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0)
            addAtHead(val);
        if (index == size )
            addAtTail(val);
        MyLinkedList node = getIndex(index - 1);
        MyLinkedList nextNode = node.next;
        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;
        newNode.prev = node;
        newNode.next = nextNode;
        node.next = newNode;
        nextNode.prev = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;
        MyLinkedList delNode = getIndex(index);
        MyLinkedList prev = delNode.prev;
        MyLinkedList next = delNode.next;
        prev.next = next;
        next.prev = prev;
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        int i = linkedList.get(1);// 返回2
        linkedList.deleteAtIndex(1);    // 现在链表是1-> 3
        int i1 = linkedList.get(1);
    }
}
