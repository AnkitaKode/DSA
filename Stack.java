import java.util.Scanner;

public class Stack {
    private int[] arr;
    private int top;

    // Initialize the stack
    public Stack(int size) {
        arr = new int[size];
        top = -1;
    }

    // To push an element onto the stack
    public void push(int num) {
        if (top == arr.length - 1) {
            System.out.println("Stack is full");
        } else {
            top++;
            arr[top] = num;
        }
    }

    // To pop an element from the stack
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int poppedElement = arr[top];
            top--;
            return poppedElement;
        }
    }

    // To get the top element of the stack
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return arr[top];
        }
    }

    // To check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack elements: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Initialize a stack:");
        Stack stack = new Stack(5);
        System.out.println("Is the stack empty? " + stack.isEmpty());
        System.out.println("\nInput some elements on the stack:");
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();

        System.out.println("Top element of the stack: " + stack.peek());
        System.out.println("Remove two element from the stack:");
        stack.pop();
        stack.pop();
        stack.display();
        System.out.println("Top element of the stack after popping: " + stack.peek());
        System.out.println("Is the stack empty? " + stack.isEmpty());
    }
}
