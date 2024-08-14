package Arrays.LinkedList;

/**
 * Undo/Redo Functionality: In applications that support undo/redo functionality, a doubly linked list can be used to
 * maintain a sequence of states. Each state change is stored as a node in the list, allowing easy navigation between
 * previous and next states, enabling undoing and redoing of actions.
 * null<>1
 *1<>2<>3<>4<>5
 *     1
 * */

public class UndoRedoManager<T> {
    private class Node{
        private T state;
        private Node prev;
        private Node next;
        private Node (T state){
            this.state = state;
        }
    }
    private Node currentState;
    public T undo(){
        if (currentState == null) {
            System.out.println("No state to undo");
            return null;
        }

        //Get the previous state
        Node previousState = currentState.prev;
        if (previousState == null) {
            System.out.println("Reached the initial State");
            return null;
        } else {
            //update the current state to the previos state
            currentState = previousState;
        }
        return currentState.state;
    }

    //Implement Redo Operation


    public void performAction (T newState){
        //create a new node for the new task
        Node newNode = new Node(newState);

        //Set the links for the new node
        newNode.prev = currentState;
        newNode.next = null;

        //Update the next link for the current state
        if(currentState !=null){
            currentState.next = newNode;
        }
        //update the current to the new state
        currentState = newNode;

    }

    //state1 <> State 2 <> State 3 <> State 4 <> State 5
    //state1 <> State 2 <> State 3 <> State 4


    public static void main(String[] args) {
        UndoRedoManager<String> undoRedoManager = new UndoRedoManager<>();
        undoRedoManager.performAction("State 1");
        undoRedoManager.performAction("State 2");
        undoRedoManager.performAction("State 3");
        undoRedoManager.performAction("State 4");
        undoRedoManager.performAction("State 5");

        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);
        undoRedoManager.undo();
        System.out.println("Current state: " + undoRedoManager.currentState.state);





    }
}
