package genericMotivation;

public class MyLinkedList<E> {
    private class ListNode{
        E data;
        ListNode next;
    }
    private ListNode head;

    public boolean add(E n) {
        ListNode newNode = new ListNode();
        newNode.data = n;
        newNode.next = head;
        head = newNode;
        return true;
    }
}
