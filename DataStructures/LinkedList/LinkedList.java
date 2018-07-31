public class LinkedList
{
    Node head;
    
    class Node
    {
        Node next;
        String data;
        
        public Node(String data)
        {
            this.data = data;
        }
    }

    public void insert(String data)
    {
        head = insertData(head, data);
    }
        
    public Node insertData(Node head, String data)
    {
        if( head == null )
        {
            head = new Node(data);
            return head;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
            
        return head;
    }
        
    public void printList()             // Priting data from head of List
    {
        Node n = head;
        while( n != null)
        {
            System.out.println(n.data);
            n = n.next;
        }
    }
        
    public void printFromLast(Node head)  // Printing data from End of List
    {
        if( head == null) return;
            
        printFromLast(head.next);
        System.out.print(" " + head.data);
    }
    
    public static void main(String[] args)
    {
        LinkedList llist = new LinkedList();
        
        llist.insert("Hello");
        llist.insert("Ken, ");
        llist.insert("How");
        llist.insert("are ");
        llist.insert("you?");
        
        llist.printList();
        System.out.println();
        llist.printFromLast(llist.head);
    }
}