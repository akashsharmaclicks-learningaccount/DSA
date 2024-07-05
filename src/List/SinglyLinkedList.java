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
        sll.display();
        System.out.println("Length of SLL: " + sll.findLength());
        sll.addFirst(55);
        System.out.println("SLL after adding a new element at first");
        sll.display();
        System.out.println("Length of new SLL: " + sll.findLength());
    }
}
