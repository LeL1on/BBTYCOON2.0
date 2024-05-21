package tycoon;

public class Hotel{
    private int number;
    private String style;
    private int multiplikator;
    private int maxVisitors;

    public Hotel(int number, String style, int multiplikator, int maxVisitors) {
        this.number = number;
        this.style = style;
        this.multiplikator = multiplikator;
        this.maxVisitors = maxVisitors;
      }   
      public int getNumber(){
        return this.number;
      } 
      public String getStyle(){
        return this.style;
      } 
      public int getMultiplikator(){
        return this.multiplikator;
      } 
      public int maxVisitors(){
        return this.maxVisitors;
      } 
      public void setMultiplikator(int lvl){
        this.multiplikator = lvl;
      }
}