/*
 * Given a singly linked list, write a function that
 * finds the nth-to-last element of the list
 */

/**
 *
 * @author Starlyn
 */


public class SinglyLinkedList {
    
    // NODE CLASS //
    class Node{
        private int value;
        private Node next;
    }


    // FIND THE NODE THAT THE USERS WANTS //
    public Node nthToLast(Node node, int n ){

        Node current  = node;
        Node follower = node;

        for(int i = 0; i < n; i++){
            if(current == null){
                return null;
            }
            else
                current = current.next;

        }
        
        while(current.next != null){
            current  = current.next;
            follower = follower.next;
        }
        
        return follower;

    }

    
     public void main(String[] args) {
        // TODO code application logic here
         int number = 5;
    }
    
}
