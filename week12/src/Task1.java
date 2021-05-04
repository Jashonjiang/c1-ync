/**
 * 1. 将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Task1 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode1.print();
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode4.print();
        ListNode l = mergeTwoLists(listNode1, listNode4);
        l.print();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ll = new ListNode();
        ListNode p = ll;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            }else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }

        return ll.next;
    }
}

class ListNode {

    int val;  //链表中节点的值
    ListNode next;  //引用

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void print(){
        System.out.print("[");
        System.out.print(this.val);
        ListNode p = this.next;
        while(p != null){
            System.out.print("," + p.val);
            p = p.next;
        }
        System.out.println("]");
    }
}