package tycoon;

public class Besucher {
   
  private int index;
  private Besucher next;
   // Konstruktor, legt Element mit Inhalt und Index an und legt Verweis zu naechstem Element fest
  public Besucher(int s, Besucher n) {
    this.index = s;
    this.next = n;
  }                                                
   
   // Gibt inhalt zurück
  public int getIndex() {
    return index;
  }
  
  //setzt Namen
  public void setIndex(int s) {
    this.index = s;
  }
    
  // Gibt Verweis zum nächsten Element zurück
  public Besucher getNext() {
    return next;
  }  
    
  // Setzt Verweis zu nächsten Element
  public void setNext(Besucher n) {
    this.next = n;
  }
   
}
