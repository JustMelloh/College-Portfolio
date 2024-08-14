package Stacks;

public class StackArrays {

    int [] arr;
    int topOfStack;

    public StackArrays(int size) {
        this.arr = new int[size];
        this.topOfStack = -1;
        System.out.println("Stack created with size of: " + size);
    }

    /* Check to see if is Empty */

    public boolean isEmpty() {
        if (topOfStack == -1) {
            System.out.println("Stack is empty");
            return true;
        } else {
            System.out.println("Stack is not empty");
            return false;
        }
    }

    /* Check if Stack is full */

    public boolean isFull() {
        if (topOfStack == arr.length - 1) {
            System.out.println("Stack is full");
            return true;
        } else {
            System.out.println("Stack is not full");
            return false;
        }
    }


    /* Here we implement a push method */

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push");
        } else {
            arr[topOfStack + 1] = value;
            topOfStack++;
            System.out.println("Value has been pushed to the stack");
        }
    }

    /* This is where we implement a pop method */

    public Object pop() {
        /* Uses isEmpty boolean to see if stack is empty if it is , prints.*/
        if (isEmpty()) {
            System.out.println("Stack is empty,Cannot pop");
        } else {
            /* Otherwise pops from stack.*/
            System.out.println("Value has been popped from the stack");
            topOfStack--;
        }
        return null;
    }


    /* Peek method implementation */

    public void peek(){
        /* Uses isEmpty boolean to see if stack is empty or not*/
        if (isEmpty()) {
            System.out.println("Cannot peek at stack because it is empty.");
        } else {
            /* Otherwise displays the value at the top of the stack using arr*/
            System.out.println("Top of the stack is: " + arr[topOfStack]);
        }
    }

    /* This is a Delete implementation */

    public void deleteStack() {
        /* Changes the array to null and then prints completion.*/
        arr = null;
        System.out.println("Stack has been deleted");
    }



    /* Using a data structure to check whether a word is a palindrome or not */

    public void isPalindrome(String word) {
        /* Here we initialize a new stack for the isPalindrome Method */
        StackArrays stack = new StackArrays(word.length());
        /* This is where we initialize a string builder to allow for appending and inserting of Strings*/
        StringBuilder originalWord = new StringBuilder();
        originalWord.append(word);

        /* Pushing the word into the stack through a For loop which iterates the whole length of the word
        * allowing each character to be processed */
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }
        /* Here another String builder is created for the reverse word */
        StringBuilder reversedWord = new StringBuilder();
        /* For loop which  iterates over the length of the word for each iteration, we introduce a pop method and
        * the character is appended to reversedWord */
        for (int i = 0; i < word.length(); i++) {
            reversedWord.append(stack.pop());
        }
        /* Here we compare the original word to the reversed word and print out whether the word is a palindrome or not */
        if (originalWord.toString().contentEquals(reversedWord)) {
            System.out.println("The word is a palindrome");
        } else {
            System.out.println("The word is not a palindrome");
        }
    }


    // Implement a stack DataStructure using LinkedList instead of Arrays.


    /** Represents a node in a linked list, where each node holds a value and a reference to the next node.*/

    public static class Node {
        int value;
        Node next;
    }
    /* Top of Stack, represents first node in LL*/
    Node top;


    /* Constructor for creating a new StackArrays instance with an empty stack. */


    public StackArrays() {
        this.top = null;
    }


    /* Push new value in stack */
    public void pushLL(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        System.out.println(value + " has been pushed to the stack");
    }


    /* Pop value from stack */
    public void popLL() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println(top.value + " has been popped from the stack");
            top = top.next;
        }
    }

    /* Peek value from stack */
    public void peekLL() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top of the stack is: " + top.value);
        }
    }

    /* Delete stack by clearing content*/
    public void deleteStackLL() {
        top = null;
        System.out.println("Stack deleted");
    }

    public void isPalindromeLL(String word) {
        StackArrays stack = new StackArrays();
        StringBuilder originalWord = new StringBuilder();
        originalWord.append(word);

        for (int i = 0; i < word.length(); i++) {
            stack.pushLL(word.charAt(i));
        }

        StringBuilder reversedWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            reversedWord.append(stack.top.value);
            stack.popLL();
        }

        if (originalWord.toString().contentEquals(reversedWord)) {
            System.out.println("The word is a palindrome");
        } else {
            System.out.println("The word is not a palindrome");
        }
    }
}
