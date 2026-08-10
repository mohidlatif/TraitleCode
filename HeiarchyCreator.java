import java.util.*;
public class HeiarchyCreator {
    private Heiarchy heiarchy;   
    public HeiarchyCreator(){
        heiarchy= new Heiarchy();
        heiarchy.addGeneration(0, new Generation());
        heiarchy.addGeneration(1, new Generation());
        heiarchy.addGeneration(2, new Generation());
    }
    public Heiarchy getHeiarchy(){
        return heiarchy;
    }
  public void createHeiarchy(Couple c, int n, Gen gen) {
    if (n == 0) {
        heiarchy.getGeneration(0).addCouple(c);  
    }
    else if (n == 1) {
        heiarchy.getGeneration(1).addCouple(c);
    }
    else if (n == 2) {                                                                                                                   
       Person child = (c.getHusband() != null) ? c.getHusband() : c.getWife();
        heiarchy.getGeneration(2).addCouple(new Couple(child, null));
        return;  
    }
    int x = (n==1) ? (int)(Math.random() * 2 + 3) : (int)(Math.random() * 3 + 5); 
    Person[] people = gen.nextGen(x);
    ArrayList<Person> tempList = new ArrayList<>(Arrays.asList(people));
    linkParentChild(c, tempList);
    for (int v = 0; v < x; v++) {
        Couple nextCouple;
        if (n + 1 == 2) {
            nextCouple = new Couple(people[v], null);   
        }
        else {
            nextCouple = new Couple(people[v], Person.random(!people[v].getGender()));
        }
        Gen nextGen = new Gen(nextCouple, gen.getDisease(), gen.getPenetrance());
    createHeiarchy(nextCouple, n + 1, nextGen);
    }
}

    private void linkParentChild(Couple parents, ArrayList<Person> children){
        for(int x=0; x<children.size(); x++){
            parents.getHusband().addChild(children.get(x));
            parents.getWife().addChild(children.get(x));
            children.get(x).addParent(parents);
        }
    }

}
