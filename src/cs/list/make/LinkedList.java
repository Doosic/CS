package cs.list.make;

public class LinkedList<T> implements List<T>{

    private Node head;
    private int count;

    LinkedList(){
        // linkedList의 시작 node를 가리키는 head
        this.head = null;
        // 총 저장된 노드의 수를 저장하는 count
        this.count = 0;
    }


    @Override
    public void printAll(){
        Node currentNode = this.head;
        String text = "[";

        // Node에 담긴 데이터를 전부 출력해준다.
        // nextNode를 계속 출력하며 null 나올때까지 반복한다.
        while(currentNode != null){
            text += currentNode.getData();
            currentNode = currentNode.getNext();

            if(currentNode == null) continue;
                text += ", ";
        }
        text += "]";
        System.out.println(text);
    }

    // clearAll 은 가리키는 Node를 제거 후, count를 0으로 만들면 된다.
    @Override
    public void clearAll() {
        this.head = null;
        this.count = 0;
    }


    @Override
    // 원하는 위치에 데이터를 저장해주는 insertAt
    public void insertAt(int index, T data) {
        // linkedList의 크기보다 크거나 작은곳에 저장하려는 경우 Exception을 발생시킨다.
        try{

            if(index > this.count || index < 0){
                throw new Exception("범위를 넘어갔습니다.");
            }

            Node newNode = new Node(data);

        /*
            구현시 고려해야 할 상황
            1.리스트의 가장 앞부분에 삽입하는 경우 새로 삽입하는 node가 head가 된다.
            2.head부터 next를 참조하여 끝까지 이동하는 경우
         */

            if(index == 0){
                newNode.setNext(this.head);
                this.head = newNode;
            }else{
                Node currentNode = this.head;

                // 현재Node에 nextNode를 계속 넣어 원하는 index의 Node로 이동한다.
                for(int i = 0; i < index - 1; i++){
                    currentNode = currentNode.getNext();
                }
                // 4번 현재 Node, 5번 데이터를 추가할 Node, 6번 원래 5번이였던 Node
                // 1.새롭게 추가된 5번 Node가 원래 5번이였던 Node를 Next로 가리켜준다. 그러므로 기존 5번 Node는 6번이 된다.
                // 2.현재 Node인 4번은 새롭게 추가된 5번 Node를 Next 노드로 가리켜준다.
                // 정리: 새롭게 추가될 Node에 바로 앞에 위치한 Node는 새로 추가될 Node를 가리키고, 새롭게 추가된 Node는 기존에 자리에 있던 Node를 가리킨다.
                newNode.setNext(currentNode.getNext());
                currentNode.setNext(newNode);
            }
            this.count ++;

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
