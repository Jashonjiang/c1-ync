/**
 * 3. 给定一个链表，判断链表中是否有环。
 */
public class Task3 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode head = l1;
        int pos = 1;
        System.out.print("head = ");
        head.print();
        System.out.println("pos = " + pos);
        l4.next = l2;
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

}
