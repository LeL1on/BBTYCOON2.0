package tycoon;

public class DynArray {
   
  // Referenzen auf die Enden
  private Besucher head;
  private Besucher tail;
   
   // Konstruktor
  public DynArray() {
    head = null;
    tail = null;
  }

  // Pruefen, ob die Reihung leer ist
  public boolean isEmpty() {
    if((head == null) && (tail == null)) {
      return true;
    } else {
      return false;
    }
  }
  
  // Länge vom Array zurueckgeben
  public int getLength() {
    if(isEmpty()){
    return 0;   
    } 
    else {
    return tail.getIndex();               
    } // end of if-else
  }

  // Neues Besucher tail an die Reihung anhaengen
  public void append() {
    if (isEmpty()) {
      Besucher temp = new Besucher(1, null);
      head =  temp;   
      tail = temp;  
    } else {
      Besucher temp = new Besucher( tail.getIndex() + 1, null);
      System.out.println(tail.getIndex()+"");
      // hier fehlt etwas
      tail.setNext(temp);
      tail = temp;
    }
  }
  
  // Inhalt an der Stelle i lesen und zurueckgeben
 /* 
  public String getItem(int i) {
    if (isEmpty()) {
      return "";  
    } 
    else {
      if (i <= tail.getIndex()) {
        // Kommentar ergaenzen
        Besucher temp = head;        
        while ((temp.getIndex() < i)) { 
          temp = temp.getNext();         
        }
        return temp.getNext(); 
      }
      else {
        return ""; 
      }   
    }
  }
   */
  
  // Inhalt an der Stelle i ueberschreiben 
  /*public void setItem(int i, String s) {
    if (isEmpty()) {
    
    }
    else {
      if (i <= tail.getIndex()) {
        
        Besucher temp = head;
         
        while(temp.getIndex() != i){
        temp = temp.getNext();
          }
        temp.setIndex(s);
      }       
    } 
  } */
  
  // Besucher an der Stelle i loeschen
  public Besucher dequeue() {
    Besucher merke = head;
    head = head.getNext();
    if(head == null) tail = null;
    return merke;
  }  
  
  public void delete(int i){
    if (isEmpty()) {
      // tue nichts
    }
    else {
      // falls 1 Besucher drin ist dann head und tail auf null setzen
      if (getLength() == 1) {
        head = null;
        tail = null;
      } 
      //jetzt wird die letzte zahl gelöscht
      else if (i==tail.getIndex()) {
        Besucher temp = head;
        // erst wird aufs erste Besucher in der schlange verwiesen dann werden die Besuchere durchgegangen bis der Index i-1 entspricht und dann wird das nächste Besucher auf null gesetzt
        while (temp.getIndex() < tail.getIndex()-1) {
          temp = temp.getNext();    
        }
        temp.setNext(null);
        tail = temp;  
      }
      // hier wird ein Besucher in der Mitte des Arrays gelöscht
      else if (i < tail.getIndex()) { 
        Besucher temp = head;
        // wieder temp auf das Besucher gesetzt und dann hochgezählt bis der index von temp i entspricht
        while ((temp.getIndex() < i)) {
          temp = temp.getNext();    
        } 
        // jetzt wird das nächste Besucher auf die stelle gesetzt wo wir gerade eben drauf waren und dann immer so weiter so das alle aufrücken
        while ((temp.getIndex() < tail.getIndex()-1)) { 
          temp.setNext(temp.getNext().getNext());
          temp = temp.getNext();  
        }
        //Das beendet das ganze und setzt das vorletzte Besucher auf das letzte und löscht das letzte im anschluss
        temp.setNext(tail.getNext());
        temp.setNext(null);
        tail=temp;
      }
    }   
  }
  //public Besucher gehHaus(){

  //}
  // Besucher an der Stelle i einfuegen, das alte Besucher an der Stelle i und alles weitere nach rechts schieben
  public void insertAt(int i) {
    if ((i < 1) || (i > getLength()+1)) {
      // tue nichts 
    }
    // wenn es an einer stelle weniger als 1 oder größer als alles + 1 eingesetzt werden soll und eine lücke enstehen soll, passiert nichts
    else if (isEmpty() || (i == getLength()+1)) {
      append();
    }
    // wenn das Array leer ist oder es an der stelle 1 nach dem letzten eingesetzt werden soll, dann wird es einfach appended
    else if ((i>=1) && (i<=getLength())) {
      if (i==1) {
        Besucher neu = new Besucher(1, head);
        Besucher temp = head;        
        int k = 1;
        // wenn es an erster stelle eingesetzt wird, wird es der neue head
        while (temp.getIndex() < getLength()) { 
          temp.setIndex(k+1);
          k++;
          temp=temp.getNext();
        }         
        tail.setIndex(k+1);
        head = neu;        
      }
      // dann werden alle indizes neu gesetzt und dann beendet außerhalb der while sobald das letzte erreicht wurde
      else {  
        Besucher temp = head;
        while(temp.getIndex() != i){
        temp = temp.getNext();
          }
        temp = new Besucher(i, temp);
        temp = temp.getNext();
          while (temp.getIndex() < getLength()) { 
          temp.setIndex(temp.getIndex()+1);
          temp=temp.getNext();
        }     
          
        // hier fehlt etwas
        
      }     
    } 
  }
}
