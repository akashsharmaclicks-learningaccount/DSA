package List;
public class SinglyLinkedList
{
    private ListNode head;
    private static class ListNode
    {
        private int data;
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
    }
}
