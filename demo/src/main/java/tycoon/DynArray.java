package tycoon;

public class DynArray {
   
  // Referenzen auf die Enden
  private Besucher vorne;
  private Besucher hinten;
   
   // Konstruktor
  public DynArray() {
    vorne = null;
    hinten = null;
  }

  // Pruefen, ob die Reihung leer ist
  public boolean isEmpty() {
    if ((vorne == null) && (hinten == null)) {
      return true;
    } else {
      return false;
    }
  }
  
  // Länge vom Array zurueckgeben
  public int getLength() {
    if((vorne == null) && (hinten == null)){
    return 0;   
    } 
    else {
    return hinten.getIndex();               
    } // end of if-else
  }

  // Neues Besucher hinten an die Reihung anhaengen
  public void append() {
    if (isEmpty()) {
      Besucher temp = new Besucher(1, null);
      vorne =  temp;   
      hinten = temp;  
    } else {
      Besucher temp = new Besucher( hinten.getIndex() + 1, null);
      System.out.println(hinten.getIndex()+"");
      // hier fehlt etwas
      hinten.setNext(temp);
      hinten = temp;
    }
  }
  
  // Inhalt an der Stelle i lesen und zurueckgeben
 /* 
  public String getItem(int i) {
    if (isEmpty()) {
      return "";  
    } 
    else {
      if (i <= hinten.getIndex()) {
        // Kommentar ergaenzen
        Besucher temp = vorne;        
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
      if (i <= hinten.getIndex()) {
        
        Besucher temp = vorne;
         
        while(temp.getIndex() != i){
        temp = temp.getNext();
          }
        temp.setIndex(s);
      }       
    } 
  } */
  
  // Besucher an der Stelle i loeschen
  public void delete(int i){
    if (isEmpty()) {
      // tue nichts
    }
    else {
      // falls 1 Besucher drin ist dann head und tail auf null setzen
      if (getLength() == 1) {
        vorne = null;
        hinten = null;
      } 
      //jetzt wird die letzte zahl gelöscht
      else if (i==hinten.getIndex()) {
        Besucher temp = vorne;
        // erst wird aufs erste Besucher in der schlange verwiesen dann werden die Besuchere durchgegangen bis der Index i-1 entspricht und dann wird das nächste Besucher auf null gesetzt
        while (temp.getIndex() < hinten.getIndex()-1) {
          temp = temp.getNext();    
        }
        temp.setNext(null);
        hinten = temp;  
      }
      // hier wird ein Besucher in der Mitte des Arrays gelöscht
      else if (i < hinten.getIndex()) { 
        Besucher temp = vorne;
        // wieder temp auf das Besucher gesetzt und dann hochgezählt bis der index von temp i entspricht
        while ((temp.getIndex() < i)) {
          temp = temp.getNext();    
        } 
        // jetzt wird das nächste Besucher auf die stelle gesetzt wo wir gerade eben drauf waren und dann immer so weiter so das alle aufrücken
        while ((temp.getIndex() < hinten.getIndex()-1)) { 
          temp.setNext(temp.getNext().getNext());
          temp = temp.getNext();  
        }
        //Das beendet das ganze und setzt das vorletzte Besucher auf das letzte und löscht das letzte im anschluss
        temp.setNext(hinten.getNext());
        temp.setNext(null);
        hinten=temp;
      }
    }   
  }
  
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
        Besucher neu = new Besucher(1, vorne);
        Besucher temp = vorne;        
        int k = 1;
        // wenn es an erster stelle eingesetzt wird, wird es der neue head
        while (temp.getIndex() < getLength()) { 
          temp.setIndex(k+1);
          k++;
          temp=temp.getNext();
        }         
        hinten.setIndex(k+1);
        vorne = neu;        
      }
      // dann werden alle indizes neu gesetzt und dann beendet außerhalb der while sobald das letzte erreicht wurde
      else {  
        Besucher temp = vorne;
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
