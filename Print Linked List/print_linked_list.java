/*
class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
}*/

class Solution {
    public ArrayList<Integer> printList(Node head) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        while(head!=null)
        {
            ans.add(head.data);
            head=head.next;
        }
        return ans;
        
    }
}