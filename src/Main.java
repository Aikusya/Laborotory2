import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(4);
        myArrayList.add(6);
        myArrayList.add(8);
        myArrayList.add(11);
        myArrayList.add(15);
        myArrayList.add(8);
        myArrayList.add("h");
        myArrayList.add(true);
        myArrayList.add(false);
        myArrayList.add(12.00);
        //myArrayList.add(scanner.nextInt());
        //System.out.println(myArrayList.get(0));
        //System.out.println(myArrayList.size());
        //System.out.println(myArrayList.getElement(15));
        //myArrayList.clear();
        //System.out.println(myArrayList.getSize());
        //System.out.println(myArrayList.get(3));
        //myArrayList.delete(3);
        //System.out.println(myArrayList.get(3));
        myArrayList.sort();
        myArrayList.printArray();
    }
}