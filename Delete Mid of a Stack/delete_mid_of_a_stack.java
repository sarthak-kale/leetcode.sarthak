class Solution {
    public void deleteMid(Stack<Integer> s, int count) {
        if (count == 0) {
            s.pop();
            return;
        }
        int tope = s.peek();
        s.pop();
        
        deleteMid(s, count - 1);
        s.push(tope);
    }
    
    void deleteMid(Stack<Integer> s) {
        int count = s.size() / 2;
        deleteMid(s, count);
    }
}