package tycoon;

public class Hotel{
    private int number;
    //private String style;
    private double multiplikator;
    private int maxVisitors;
    private double geldPro;

    public Hotel(int number, double multiplikator, int maxVisitors, int geldPro) {
        this.number = number;
        //this.style = style;
        this.multiplikator = multiplikator;
        this.maxVisitors = maxVisitors;
        this.geldPro = geldPro;
      }   
      public int getNumber(){
        return this.number;
      } 
      /*public String getStyle(){
        return this.style;
      } */
      public double getMultiplikator(){
        return this.multiplikator;
      } 
      public int getMaxVisitors(){
        return this.maxVisitors;
      } 
      public void setMultiplikator(int lvl){
        this.multiplikator = lvl;
      }
      public double getGeldpro(){
        return this.geldPro;
      } 
}