class Solution {
    public static boolean searchKey(Node head, int key) {
        Node current = head;

        while (current != null)
        {
            if (current.data == key)
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}