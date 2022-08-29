package RentalMobil;

public class StackDinamisObject {

    private LinkedListObject tumpukan;
    private int size;

    public StackDinamisObject() {
        tumpukan = new LinkedListObject();
        size = 0;
    }

    public void push(Object data) {
        tumpukan.addFirst(data);
        size++;
    }

    public Object pop() {
        size--;
        return tumpukan.removeFirst();
    }

    public int size() {
        return tumpukan.size();
    }

    public boolean isEmpty() {
        return tumpukan.isEmpty();
    }

    public String toString() {
     return tumpukan.toString();
    }
}
