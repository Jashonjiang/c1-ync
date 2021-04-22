/**
 * 题目二：合并链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class Task2 {
    public static void main(String[] args) {
        //第一个链表
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l1.print();
        //第二个链表
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        l4.print();

        ListNode merged = merge(l1, l4);
        merged.print();
    }

    public static ListNode merge(ListNode L1, ListNode L2){
        ListNode q = new ListNode();
        ListNode p;
        ListNode end = q;
        while(L1 != null && L2 != null){
            if(L1.val <= L2.val){
                p = L1;
                L1 = L1.next;
                p.next = end.next;
                end.next = p;
                end = end.next;
            }else {
                p = L2;
                L2 = L2.next;
                p.next = end.next;
                end.next = p;
                end = end.next;
            }
        }
        if(L1 != null){
            end.next = L1;
        }
        else if(L2 != null){
            end.next = L2;
        }

        return q.next;
    }
}
