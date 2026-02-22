public class assignment1 {
    static class Node 
    {
        int key;
        Node next;

        Node (int key) 
        {
            this.key = key;
            this.next = null;
        }
    }
        
    // Inserts a new node with key x at the head of the list and returns the new head of the list.
    static Node listInsert(Node head, Node x) 
    {
       x.next = head;
       return x;
    }

    // Searches for a node with key equal to key in the list starting from head and returns a pointer to the first node with key equal to key. 
    // If no such node is found, returns null.
    static Node listSearch (Node head, int key) 
    {
        Node current = head;
        while (current != null) 
        {
            if (current.key == key) 
            {
                return current;
            }
            current = current.next;
        }
        return null; // Key not found
    }

    static Node listDelete(Node head, Node x) 
    {
        if (head == null) 
        {
            return null; // List is empty
        }
        if (head == x) 
        {
            return head.next; // Deleted head node
        }
        Node current = head;
        while (current.next != null) 
        {
            if (current.next == x) 
            {
                current.next = current.next.next; // Bypass the node to be deleted
                return head; // Return the unchanged head of the list
            }
            current = current.next;
        }
        return head; // Node to delete not found, return unchanged head
    }


}