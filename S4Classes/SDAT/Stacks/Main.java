package Stacks;

public class Main {
    public static void main(String[] args) {
        StackArrays stack = new StackArrays(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.isEmpty();
        stack.isFull();
    }
}
