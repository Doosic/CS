package cs.list.make;

public class linkedListMain {

    public static void main(String[] args) throws Exception {
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//
//        node1.setNext(node2);
//        node2.setNext(node3);
//
//        System.out.println(node1.getData());
//        System.out.println(node1.getNext().getData());
//        System.out.println(node1.getNext().getNext().getData());

        LinkedList list = new LinkedList<>();
        list.insertAt(0, 0);
        list.insertAt(1, 1);
        list.insertAt(2, 2);
        list.insertAt(3, 3);
        list.insertAt(4, 4);
        list.printAll();

        list.clearAll();
        list.printAll();
    }
}
