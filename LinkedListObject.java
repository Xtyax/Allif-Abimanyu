package RentalMobil;

public class LinkedListObject {

    private ListNodeObject head;
    private int size;

    public LinkedListObject() {
        head = new ListNodeObject();
        head.next = head;
        head.prev = head;
        size = 0;
    }

    public void addBefore(Object x, ListNodeObject bantu) {
        ListNodeObject baru = new ListNodeObject(x);
        baru.next = bantu;
        baru.prev = bantu.prev;
        bantu.prev.next = baru;
        bantu.prev = baru;
        size++;
    }

    public void addFirst(Object elemen) {
        addBefore(elemen, head.next);
    }

    public void addLast(Object elemen) {
        addBefore(elemen, head);
    }

    public Object removeFirst() {
        return remove(head.next);
    }

    public Object removeLast() {
        return remove(head.prev);
    }

    private Object remove(ListNodeObject bantu) {
        bantu.prev.next = bantu.next;
        bantu.next.prev = bantu.prev;
        size--;
        return bantu.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (head == head.next) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String temp = "";
        int i = 1;
        ListNodeObject bantu = head.next;
        while (bantu != head) {
            temp += i + ". " + bantu.data + "\n";
            bantu = bantu.next;
            i++;
        }
        return temp;
    }

   public ListNodeObject Search(Object search){
        ListNodeObject bantu = head.next;
        while (bantu != head){
            if(((Comparable)bantu.data).compareTo(search) == 0){
                return bantu;
            }
            bantu = bantu.next;
        }
        return null;
    }
   public Object grabNode(int search){
        ListNodeObject bantu = head.next;
        if(isEmpty()){
            return null;
        }
        for(int i = 1; i <= size(); i++){
            if(search == i){
                return bantu.data;
            }
            bantu = bantu.next;
        }
        return null;
    }

}
