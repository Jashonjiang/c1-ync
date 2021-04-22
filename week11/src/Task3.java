import java.util.ArrayList;
import java.util.List;

/**
 * 题目三：回文链表
 * 请判断一个链表是否为回文链表。
 */
public class Task3 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l1.print();

        if(isHuiwen(l1)){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }

    public static boolean isHuiwen(ListNode L){
        List<Integer> list = new ArrayList<>();
        while(L != null){
            list.add(L.val);
            L = L.next;
        }
        for(int i = 0; i < list.size()/2; i++){
            if(list.get(i) != list.get(list.size()-1-i)){
                return false;
            }
        }
        return true;
    }
}
