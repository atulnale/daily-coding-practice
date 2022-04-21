package problems;

import utils.ListNode;


public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode itr = result;
        int carry = 0;
        while(l1 != null && l2 != null){
            int num1 = l1 == null ? -1 : l1.val;
            int num2 = l2 == null ? -1 : l2.val;
            itr.next = new ListNode((num1 + num2 + carry) % 10);
            carry = (num1+num2+carry) / 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry != 0){
            itr.next = new ListNode(carry);
        }
        return result.next;
    }
    public static void main(String[] args) {

    }
}
