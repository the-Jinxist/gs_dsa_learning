public class RemoveNthNodeFromList {
    
 // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
 
    //My solution:


    //First I iterated through the complete linked list and got the full length, then I 
    //got the index of the node I'm supposed to remove then I did the magic
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode currentNode = head;
        int numberOfNodes = 1;
        
        while(currentNode.next != null){
            numberOfNodes++;
            currentNode = currentNode.next; 
        }
        
        System.out.println("Number of nodes: " + numberOfNodes);
        int nodeAt = numberOfNodes - n;
        
        int counter = 0;
        
        currentNode = head;
        ListNode nodeBefore = head;
        ListNode nodeAfter = null;
        
        while(counter < numberOfNodes){
            
            if(counter == (nodeAt - 1)){
                nodeBefore = currentNode;
                System.out.println("Node before: "+ nodeBefore.val);
            }
            
            if(counter == (nodeAt + 1)){
                nodeAfter = currentNode;
                System.out.println("Node after: "+ nodeAfter.val);
            }
            
            currentNode = currentNode.next;
            counter++;            
            
        }
        
        if(nodeAt == 0 ){
            if(nodeAfter != null){
                return nodeAfter;
            }
            return null;
        }
        
        nodeBefore.next = null;
        if(nodeAfter != null){
            nodeBefore.next = nodeAfter;
        }
        
        return head;
    }

    //Optimal Solution

    //We using two pointer nodes to solve this problem. One fast node is sent far into the future using the first
    //for loop
    public ListNode removeNthFromEndOptimal(ListNode head, int n){

        //0 [1,2,3,4,5,6,7,8,9], n = 3

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode slow = dummyHead;
        ListNode fast = dummyHead;


        for(int i = 1; i <= n + 1; i++){
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummyHead.next;

    }

}
