public class Main {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertInLinkedList(1, 0);
        singleLinkedList.insertInLinkedList(2, 1);
        singleLinkedList.insertInLinkedList(3, 2);
        singleLinkedList.insertInLinkedList(4, 3);
        singleLinkedList.traverseLinkedList();
        singleLinkedList.searchNode(2);
    }
}



/*Assignment Question number
*
* 1. Investigate and fix
*   Why when inserting a value at a position that is already, occupied it throws a null pointer exception*/