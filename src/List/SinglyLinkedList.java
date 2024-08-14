package List;
public class SinglyLinkedList
{
    private static ListNode head;
    private static class ListNode
    {
        private final int data;
        private ListNode next;
        public ListNode(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    // Print the elements of SLL.
    public void display()
    {
        ListNode current = head;
        while(current != null)
        {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");
    }

    // Find the length of SLL.
    public int findLength()
    {
        int count = 0;
        ListNode current = head;
        while (current != null)
        {
            count++;
            current = current.next;
        }
        return count;
    }

    // Insert node at first
    public void addFirst(int data)
    {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert node at last
    public void addLast(int data)
    {
        ListNode newNode = new ListNode(data);
        if(head == null)
        {
            head = newNode;
            return;
        }
        ListNode current = head;
        while(current.next != null)
        {
            current = current.next;
        }
        current.next = newNode;
    }

    // Insert node at given position
    public void addAtGivenPosition(int position, int data)
    {
        ListNode node = new ListNode(data);
        if(position == 1)
        {
            node.next = head;
            head = node;
        }
        else
        {
            ListNode previous = head;
            int count = 1;
            while(count < position-1)
            {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            node.next = current;
            previous.next = node;
        }
    }

    // Delete first node
    public ListNode deleteFirst()
    {
        if(head == null)
        {
            return null;
        }
        else
        {
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return temp;
        }
    }

    // Delete last node
    public ListNode deleteLast()
    {
        if(head == null || head.next == null)
        {
            return head;
        }
            ListNode current = head;
            ListNode previous = null;
            while(current.next != null)
            {
                previous = current;
                current = current.next;
            }
            previous.next = null;
            return current;

    }

    // Delete node at given position
    public void deleteAtGivenPosition(int position)
    {
        if(position == 1)
        {
            head = head.next;
        }
        else
        {
            ListNode previous = head;
            int count = 1;
            while(count < position-1)
            {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    // Find key in SLL
    public boolean findKey(int key)
    {
        ListNode current = head;
        if(head == null)
        {
            return false;
        }
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    // LC-206: Reverse Linked List
    public ListNode reverseList(ListNode head)
    {
        if(head == null)
        {
            return  head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while(current != null)
        {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return  previous;
    }

    // Find middle node of the list
    public ListNode findMiddle()
    {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr != null && fastPtr.next != null)
        {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    // Find nth node from the end
    public ListNode findNthNodeFromEnd(int n)
    {
        if(head == null)
        {
            return  null;
        }
        if(n <= 0)
        {
            throw new IllegalArgumentException("Invalid value: n = " + n);
        }
        ListNode refPtr = head;
        ListNode mainPtr = head;
        int count = 0;
        while(count < n)
        {
            if(refPtr == null)
            {
                throw new IllegalArgumentException(n + " is greater than the number of nodes in the list");
            }
            refPtr = refPtr.next;
            count++;
        }
        while(refPtr != null)
        {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return  mainPtr;

    }

    public static void main(String[] args)
    {
        SinglyLinkedList sll = new SinglyLinkedList();
        // Put the data in the ListNodes of the SLL
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        // Connected ListNodes next to eachother
        sll.head.next = second;
        second.next = third;
        third.next = fourth;

        // Usage of the methods
        System.out.println("-----------------------------------------");
        System.out.println("Singly Linked List");
        sll.display();
        System.out.println("Length of SLL: " + sll.findLength());
        System.out.println("-----------------------------------------");
        sll.head = sll.reverseList(sll.head);
        System.out.println("Reversed Singly Linked List");
        sll.display();
        System.out.println("Length of SLL: " + sll.findLength());
        System.out.println("-----------------------------------------");
        sll.addFirst(55);
        System.out.println("SLL after adding a new element at first");
        sll.display();
        System.out.println("Length of new SLL: " + sll.findLength());
        System.out.println("-----------------------------------------");
        sll.addLast(36);
        System.out.println("SLL after adding a new element at last");
        sll.display();
        System.out.println("Length of new SLL: " + sll.findLength());
        System.out.println("-----------------------------------------");
        sll.addAtGivenPosition(1,40);
        System.out.println("SLL after adding a new element at position 1");
        sll.display();
        System.out.println("-----------------------------------------");
        sll.addAtGivenPosition(3,19);
        System.out.println("SLL after adding a new element at position 2");
        sll.display();
        System.out.println("-----------------------------------------");
        sll.addAtGivenPosition(9,87);
        System.out.println("SLL after adding a new element at position 9");
        sll.display();
        System.out.println("-----------------------------------------");
        sll.deleteFirst();
        System.out.println("SLL after deleting first node");
        sll.display();
        System.out.println("-----------------------------------------");
        sll.deleteLast();
        System.out.println("SLL after deleting last node");
        sll.display();
        System.out.println("-----------------------------------------");
        sll.deleteAtGivenPosition(3);
        System.out.println("SLL after adding a new element at position 3");
        sll.display();
        System.out.println("-----------------------------------------");
        if(sll.findKey(57))
        {
            System.out.println("Search key found !!!");
        }else
        {
            System.out.println("Search key not found !!!");
        }
        System.out.println("-----------------------------------------");
        sll.display();
        System.out.println("Middle Node: "+(sll.findMiddle().data));
        System.out.println("-----------------------------------------");
        int nthNodeFromEnd = 3;
        sll.display();
        System.out.println(nthNodeFromEnd + " node from the end is : " +sll.findNthNodeFromEnd(nthNodeFromEnd).data);
        System.out.println("-----------------------------------------");
    }
}
