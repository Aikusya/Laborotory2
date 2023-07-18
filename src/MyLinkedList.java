public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
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
        MyNode current = head;
        int index = 0;
        while (current != null) {
            if (current.item.equals(o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        MyNode current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.item.equals(o)) {
                return index;
            }
            current = current.previous;
            index--;
        }
        return -1;
    }

    private void checkIndex(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index not found");
        }
    }

    @Override
    public void sort() {
        boolean swapped;
        do {
            swapped = false;
            MyNode current = head;
            while (current != null && current.next != null) {
                if (current.item.compareTo(current.next.item) > 0) {
                    T temp = current.item;
                    current.item = current.next.item;
                    current.next.item = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void print() {
        MyNode current = head;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    private MyNode getNodeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return current;
    }

    private void removeNode(MyNode node) {
        if (node == head) {
            head = node.next;
        } else {
            node.previous.next = node.next;
        }

        if (node == tail) {
            tail = node.previous;
        } else {
            node.next.previous = node.previous;
        }

        size--;
    }
}
