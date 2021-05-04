/**
 * 2. 存在一个按升序排列的链表，给你这个链表的头节点 head ，
 * 请你删除所有重复的元素，使每个元素 只出现一次 。
 */
public class Task2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        ListNode head = l1;
        System.out.print("head = ");
        head.print();
        deleteDuplicates(head);
        head.print();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while(p.next != null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            }
            p = p.next;
        }
        return head;
    }

}
