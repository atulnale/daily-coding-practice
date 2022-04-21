package problems;

import utils.ListNode;

import java.util.PriorityQueue;

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode itr = result;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        boolean retry = true;
        while(retry){
            retry = false;
            for(int i = 0; i<lists.length; i++) {
                ListNode curr = lists[i];
                if(curr != null){
                    retry = true;
                    min.add(curr.val);
                    lists[i] = curr.next;
                }
            }
            if(retry){
            itr.next = new ListNode(min.poll());
            itr = itr.next;
            }
        }
        while(!min.isEmpty()){
            itr.next = new ListNode(min.poll());
            itr = itr.next;
        }
        return result.next;
    }
}
