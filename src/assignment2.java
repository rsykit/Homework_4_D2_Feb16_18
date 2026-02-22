public class assignment2 {

    static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    // Tracks the "left" pointer across recursive calls
    static Node left;

    // Recurse to the end; on the way back, compare left (front) vs current (back)
    static boolean check(Node right) {
        // Base case: past the end — start unwinding
        if (right == null) return true;

        // Recurse deeper first
        boolean innerResult = check(right.next);

        // On the way back: compare front (left) with back (right)
        boolean match = (left.key == right.key);

        // Advance the left pointer forward for the next comparison
        left = left.next;

        return innerResult && match;
    }

    // If the list is a palindrome, return true; otherwise, left should be null and return false
    static boolean isPalindrome(Node head) 
    {
        left = head; 
        return check(head); //recursive check starting from head
    }

    // Helper method to build a linked list from an array of values
    static Node buildList(int[] values) {
        Node head = null; //empty list
        for (int i = values.length - 1; i >= 0; i--) // Insert at head to maintain order
        {
            Node node = new Node(values[i]); //new node with current value at index i
            node.next = head; //point new node's next to current head
            head = node; //update head to new node
        }
        return head;
    }

    // Helper method to print the linked list
    static void printList(Node head) 
    {
        Node current = head; //Stating current at the head
        while (current != null) //Traverse until the end of the list
        { 
            System.out.print(current.key); // Print the current node's key
            if (current.next != null) System.out.print(" -> "); // Print arrow if not the last node
            current = current.next;
        }
        System.out.println();
    }

    //main method
    public static void main(String[] args) {
        int[][] testCases = {
            {1, 2, 3, 2, 1},
            {10, 20, 20, 10},
            {5, 10, 17}
        };

        for (int[] tc : testCases) {
            Node list = buildList(tc);
            System.out.print("List: ");
            printList(list);
            System.out.println("Result: " + (isPalindrome(list) ? "Palindrome" : "Not a palindrome"));
            System.out.println();
        }
    }
}