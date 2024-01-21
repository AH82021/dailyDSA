package linkedList;


import java.util.PriorityQueue;

public class MergeKSortedLists {


    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists){

        if(lists ==null || lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((a,b) ->a.val -b.val);

        for (ListNode node : lists) {
            if(node != null){
                queue.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;
            if(node.next != null){
                queue.offer(node.next);
            }
        }
return  dummy.next;
    }

}
