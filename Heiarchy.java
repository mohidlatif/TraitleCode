import java.util.*;
public class Heiarchy {
    private ArrayList<Generation> heiarchy;
    private ArrayList<DiseaseType> diseaseTypes;
    public Heiarchy(){
        heiarchy = new ArrayList<>();
        diseaseTypes = new ArrayList<>();
    }
    public void addGeneration(int x, Generation g){
        heiarchy.add(x, g);
    }
    public void addDisease(DiseaseType d){
        diseaseTypes.add(d);
    }
    public Generation getGeneration(int n){
        if(n<heiarchy.size())
        return heiarchy.get(n);
        else
        return null;
    }

    public ArrayList<DiseaseType> getDiseases(){
        return diseaseTypes;
    }
    public String toString(){
        return ""+heiarchy;
    }

    public ArrayList<Generation> getHeiarchy(){
        return heiarchy;
    }
}
