package linkedList;



public class LinkedListCycle {
    class ListNode{
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }
    public boolean hasCycle(ListNode head){
        ListNode fast = head;// moves by 2
        ListNode slow = head;// moves by 1
        while(fast!=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;

        }
        return false;
    }
}
