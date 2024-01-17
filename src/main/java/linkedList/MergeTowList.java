package linkedList;

public class MergeTowList {
      public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
          final ListNode root = new ListNode();
          ListNode previous = root;
          while ((list1 !=null && list2 !=null)){
              if(list1.val < list2.val){
                  previous.next = list1;
                  list1 = list1.next;
              } else {
                  previous.next = list2;
                  list2 = list2.next;
              }
              previous = previous.next;
          }
        previous.next = list1 != null ? list1 : list2;
          return root.next;
    }
}
