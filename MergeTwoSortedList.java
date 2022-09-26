


public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 

public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        
        //Creating a temporary head node for us to start traversing from
        ListNode tempNode = new ListNode(0);
        ListNode currentNode = tempNode;
        
        //Make sure the two head nodes for both lists are working
        while(list1 != null && list2 != null){
            
            //Comparing the values for each item in both nodes and append them to the 
            //list as the condition dictates
            if(list1.val < list2.val){
                currentNode.next = list1;
                list1 = list1.next;
            }else {
                currentNode.next = list2;
                list2 = list2.next;
            }
            
            currentNode = currentNode.next;
        }
        
        //In case if one list is longer than the other, one will reach null before
        //the other.
        
        //These checks are for that: 
        
        if(list1 != null){
            currentNode.next = list1;
            list1 = list1.next;
        }
        
        if(list2 != null){
            currentNode.next = list2;
            list2 = list2.next;
        }
        
        return tempNode.next;
    }