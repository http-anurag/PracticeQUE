class MyQueue {
    Stack<Integer> stack_in;
    Stack<Integer> stack_out;

    public MyQueue() {
        stack_in = new Stack<>();
        stack_out = new Stack<>();
    }

    public void push(int x) {
        stack_in.push(x);
    }

    public int pop() {
        if (stack_out.isEmpty()) {
            while (!stack_in.isEmpty()) {
                stack_out.push(stack_in.pop());
            }
        }
        return stack_out.pop();
    }

    public int peek() {
        if (stack_out.isEmpty()) {
            while (!stack_in.isEmpty()) {
                stack_out.push(stack_in.pop());
            }
        }
        return stack_out.peek();
    }

    public boolean empty() {
        return stack_in.isEmpty() && stack_out.isEmpty();
    }
}
