import java.util.Objects;

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
        for(int i = 0; i < size; i ++){
            if(Objects.equals(arr[i], o)){
                return true;
            }
        }
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
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    @Override
    public T get(int index) {
        return arr[index];
    }

    @Override
    public int indexOf(Object o) {
        int index = -1;
        for(int i = 0; i < size; i++){
            if(Objects.equals(arr[i], o)){
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for(int i = size - 1; i >= 0; i++){
            if(Objects.equals(arr[i], o)){
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void sort() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (compare(arr[j], arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    private int compare(T o1, T o2) {
        if (o1 instanceof Number && o2 instanceof Number) {
            Double num1 = ((Number) o1).doubleValue();
            Double num2 = ((Number) o2).doubleValue();
            return num1.compareTo(num2);
        } else {
            String str1 = String.valueOf(o1);
            String str2 = String.valueOf(o2);
            return str1.compareTo(str2);
        }
    }

    public void printArray(){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
