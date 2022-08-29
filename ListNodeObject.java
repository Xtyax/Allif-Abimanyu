package RentalMobil;

public class ListNodeObject {

    Object data;
    ListNodeObject next;
    ListNodeObject prev;
    
    ListNodeObject() {
    
    }

    ListNodeObject(Object data) {
        this.data = data;
        next = null;
    }

    ListNodeObject(Object data, ListNodeObject next) {
        this.data = data;
        this.next = next;
    }

    

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }

    public void setNext(ListNodeObject next) {
        this.next = next;
    }

    public ListNodeObject getNext() {
        return this.next;
    }

    public String toString() {
        return String.valueOf(data);
    }
}
