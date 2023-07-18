public class MyLinkedList<T> implements MyList<T> {
    private MyNode head;
    private MyNode tail;
    private int size;

    private class MyNode{
        T item;
        MyNode previous;
        MyNode next;

        MyNode(T item){
            this.item = item;
            this.previous = null;
            this.next = null;
        }
    }

    MyLinkedList(){
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        MyNode current = head;
        while(current != null){
            if(current.item.equals(o)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void add(T item) {
        MyNode node = new MyNode(item);
        if(size == 0){
            head = node;
        }
        else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
        size++;
    }

    @Override
    public void add(T item, int index) {
        checkIndex(index);
        if(index == size){
            add(item);
            return;
        }
        MyNode newNode = new MyNode(item);
        if (index == 0) {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        } else {
            MyNode current = getNodeAtIndex(index);
            newNode.next = current;
            newNode.previous = current.previous;
            current.previous.next = newNode;
            current.previous = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(T item) {
        MyNode current = head;
        while (current != null) {
            if (current.item.equals(item)) {
                removeNode(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        MyNode current = getNodeAtIndex(index);
        removeNode(current);
        return current.item;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        MyNode current = getNodeAtIndex(index);
        return current.item;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    private void checkIndex(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index not found");
        }
    }

    @Override
    public void sort() {

    }
}
