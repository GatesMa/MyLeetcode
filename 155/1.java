class MinStack {

    private Stack s;
    private Stack minS;
    private int m_in;

    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack();
        minS = new Stack();
        m_in = Integer.MIN_VALUE;
    }
    
    public void push(int x) {
        s.push(x);
        if (minS.isEmpty() || (int)minS.peek() >= x) {
            minS.add(x);
        } else {
            minS.add(minS.peek());
        }
    }
    
    public void pop() {
        if(s.size() > 0) {
            minS.pop();
            s.pop();
        }
    }
    
    public int top() {
        if(s.size() > 0) {
            return (int)s.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if(s.size() > 0) {
            return (int)minS.peek();
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
