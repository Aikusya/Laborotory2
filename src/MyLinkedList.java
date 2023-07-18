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

    }

    @Override
    public boolean remove(T item) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }
}
