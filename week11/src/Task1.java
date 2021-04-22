import org.w3c.dom.ls.LSException;

/**
 * 题目一：反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Task1 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l1.print();
        ListNode reversedListNode = reverse(l1);
        reversedListNode.print();
    }

    public static ListNode reverse(ListNode L){
        ListNode p;
        ListNode q = new ListNode();
        while(L != null){
            p = L;
            L = L.next;
            p.next = q.next;
            q.next = p;
        }
        return q.next;
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
        System.out.print(this.val);
        ListNode p = this.next;
        while(p != null){
            System.out.print("->" + p.val);
            p = p.next;
        }
        System.out.println("->NULL");
    }
}
