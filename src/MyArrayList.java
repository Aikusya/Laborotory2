public class MyArrayList<T> implements MyList<T> {
    private T[] arr;
    private int size;

    MyArrayList(){
        this.arr = (T[]) new Object[5];
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
        if(size == arr.length){
            increaseBuffer();
        }
        arr[size++] = item;
    }

    @Override
    public void add(T item, int index) {
        checkIndex(index);
        if(size == arr.length){
            increaseBuffer();
        }
        for(int i = size; i >= index; i--){
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        size++;
    }

    private void increaseBuffer(){
        T[] newArr = (T[]) new Object[arr.length * 2];
        for(int i = 0; i < size; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    private void checkIndex(int index){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("Index does not exist");
        }
    }

    @Override
    public boolean remove(T item) {
        int index=0;
        boolean found = false;
        for(int i=0; i<size; i++){
            if(arr[i]==item){
                index = i;
                found=true;
            }
        }
        if(found){
            remove(index);
        }
        return found;
    }

    @Override
    public T remove(int index) {
        T temp = arr[index];
        for(int i=index-1; i<size; i++){
            arr[i-1] = arr[i];
        }
        size--;
        return temp;
    }

    @Override
    public void clear() {

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
