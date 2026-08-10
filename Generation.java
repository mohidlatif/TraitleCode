import java.util.*;
public class Generation {
    private ArrayList<Couple> generation;
   public Generation(){
        generation = new ArrayList<>();
   }
 
   public void addCouple(Couple c){
    generation.add(c);
   }  
   
   public int numCouple(){
      return generation.size();
   }

   public String toString(){
    return generation+"";
   }

   public Couple getCouple(int x){
     return generation.get(x);
   }

   public ArrayList<Couple> getGeneration(){
    return generation;
   }
}
