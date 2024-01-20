package implmentaion.NodeList;

public  class ListNode<E> {
  static   class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

        Node<E> head;
        Node<E> tail;

        int size;

        public  void  addFirst(E element) {
            Node<E> newNode = new Node<E> (element);
            newNode.next = head;
            head = newNode;
            size++;
            if(tail == null) tail = head;


        }

        public void addLast(E element) {
            Node<E> newNode = new Node<E> (element);
            if(tail == null) head = tail = newNode;
           tail.next = newNode;
            tail = newNode;
            size++;

        }

        public static void main(String[] args) {
            ListNode<Integer> nums = new ListNode<Integer>();
            nums.addFirst(5);
            nums.addFirst(10);
            nums.addFirst(15);
            nums.addLast(20);

            Node<Integer> temp = nums.head;
            while(temp != null){
                System.out.print(temp.element+"->");
                temp= temp.next;
            }

        }








//        public static void main(String[] args) {
//            // create a linked list
//            //1-Declare head and tail
//            Node<String> head = null;
//            Node<String> tail = null;
//            head = new Node<>("Chicago");
//            tail = head;
//            //append the next node
//            tail.next = new Node<>("Denver");
//            tail = tail.next;
//            //Append the second node to the list.
//            tail.next = new Node<>("Washington DC");
//            tail = tail.next;
//
//            ListNode<Integer> nums = new ListNode<>();
//
//            Node<String> temp = head;
//            while (temp != null) {
//                System.out.println(temp.element);
//                temp = temp.next;
//            }
//
//
//        }
    }

