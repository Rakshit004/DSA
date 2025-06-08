class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int currSize;

    MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        currSize = 0;
    }

    void push(int x) {
        if (currSize >= 100) {
            System.out.println("Queue is full!");
            return;
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        currSize++;
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    int pop() {
        peek();
        return s1.pop();
    }

    int peek() {
        return s1.peek();
    }

    boolean empty() {
        return s1.isEmpty();
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */