import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static Node SortedMerge(Node a, Node b)  
    {  
        Node result = null;  
        /* Base cases */
        if (a == null)  
            return b;  
        else if(b == null)  
            return a;  
    
        /* Pick either a or b, and recur */
        if(a.data <= b.data)  
        {  
            result = a;  
            result.next = SortedMerge(a.next, b);  
        }  
        else
        {  
            result = b;  
            result.next = SortedMerge(a, b.next);  
        }  
    
        return result;  
    }  
    
    public static Node mergeKLists(Node arr[], int last)  
    {  
        // repeat until only one list is left  
        while (last != 0)  
        {  
            int i = 0, j = last;  
    
            // (i, j) forms a pair  
            while (i < j)  
            {  
                // merge List i with List j and store  
                // merged list in List i  
                arr[i] = SortedMerge(arr[i], arr[j]);  
    
                // consider next pair  
                i++; j--;  
    
                // If all pairs are merged, update last  
                if (i >= j)  
                    last = j;  
            }  
        }  
    
        return arr[0];  
    }  
    
    public static Node mergeKSortedLists(Node arr[], int k) 
    {  
        Node head = null, last=null;  
    
        // priority_queue 'pq' implemeted as min heap with the  
        // help of 'compare' function  
        PriorityQueue<Node> pq=new PriorityQueue<>(new Comparator<Node>(){ 
            public int compare(Node a, Node b) 
            { 
                return a.data-b.data; 
            } 
        }); 
    
        // push the head nodes of all the k lists in 'pq'  
        for (int i = 0; i < k; i++)  
            pq.add(arr[i]);  
    
        // loop till 'pq' is not empty  
        while (!pq.isEmpty())  
        {  
            // get the top element of 'pq'  
            Node top = pq.peek();  
            pq.remove();  
    
            // check if there is a node next to the 'top' node  
            // in the list of which 'top' node is a member  
            if (top.next != null)  
                // push the next node in 'pq'  
                pq.add(top.next); 
    
            // if final merged list is empty  
            if (head == null) 
            { 
                head = top; 
                // points to the last node so far of  
                // the final merged list  
                last = top;  
            }  
            else 
            {  
                // insert 'top' at the end of the merged list so far  
                last.next = top;  
                // update the 'last' pointer  
                last = top;  
            }  
        }   
        // head node of the required merged list  
        return head;  
    }
    
    public static void printList(Node node)  
    {  
        while (node != null)  
        {  
            System.out.print(node.data+" "); 
            node = node.next;  
        }  
    }  
    
    public Node push(int data) 
    { 
        Node newNode=new Node(data); 
        newNode.next=null; 
        return newNode; 
    } 
    
    public static void main(String[] args) {
        int k = 3; // Number of linked lists  
        int n = 4; // Number of elements in each list  
    
        // an array of pointers storing the head nodes  
        // of the linked lists  
        Node arr[]=new Node[k];  
    
        arr[0] = new Node(1);  
        arr[0].next = new Node(3);  
        arr[0].next.next = new Node(5);  
        arr[0].next.next.next = new Node(7);  
    
        arr[1] = new Node(2);  
        arr[1].next = new Node(4);  
        arr[1].next.next = new Node(6);  
        arr[1].next.next.next = new Node(8);  
    
        arr[2] = new Node(0);  
        arr[2].next = new Node(9);  
        arr[2].next.next = new Node(10);  
        arr[2].next.next.next = new Node(11);  
    
        // Merge all lists  
        Node head = mergeKLists(arr, k - 1);  
        //Node head = mergeKSortedLists(arr, k);  
        printList(head);  
    }
}

class Node 
{ 
    int data; 
    Node next; 
    Node(int data) 
    { 
        this.data=data; 
        next=null; 
    } 
} 