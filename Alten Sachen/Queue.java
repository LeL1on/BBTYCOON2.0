package ContainerBoarding;
public class Queue {
   
   // Referenzen auf die Enden
  private Container head;
  private Container tail;
   
   // Konstruktor
  public Queue() {
    head = null;
    tail = null;
  }

   // Prüfen, ob die Schlange leer ist
  public boolean isEmpty() {
    if(head == null) {
      return true;
    } else {
      return false;
    }
  }
   
  public Container head() {
    return head;
  }
  
   
  // Namen des vordersten Containers zurückgeben und dann Container entfernen
  public Container dequeue() {
    Container merke = head;
    head = head.getNext();
    if(head == null) tail = null;
    return merke;
  }  
   
   // Neuen Container mit gegebenen Daten hinten anhängen
  public void enqueue(Container container) {
    if(isEmpty()) {
      head = container;
      tail = head;
    } else {
      Container newContainer = container;
      tail.setNext(newContainer);
      tail =  newContainer;
    }
  }
}
