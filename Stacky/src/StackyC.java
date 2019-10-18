public class StackyC 
{

    private int arr[];
    private int size, top;

    public StackyC(int n) {
        arr = new int[n];
        // Set top to -1 so the first element on top of stack is 0
        top = -1;
    }

    public int length() {
        return arr.length;
    }
    
    // Increment top before assigning to num
    public void push(int n) {
        arr[++top] = n;
    }

    public int pop() {
        return arr[top--];
    }

    public boolean empty() {
        return top == -1;
    }
    
}