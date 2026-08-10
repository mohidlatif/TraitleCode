//Goal: pass a penetrace var though the person constructor and make each person affected or not phenotypically based off whether they are initally afffected & penetrance. Then update your cheker to take this change into account and examine affectedness. Finally, get rid of the penetrance feautre in the MyPanel because you already implimented it.
import java.util.*;
public class Person{
private boolean allele1;
private boolean allele2;
private boolean gender;
private Disease disease; 
private boolean isAffected;
private static int type;
private Couple parent;
private ArrayList<Person> children;
private double penetrace;
private static double penetraces;

public Person(boolean a1, boolean a2, boolean g, Disease d, double penetrace){
    allele1=a1;
    allele2=a2;
    gender=g;
    disease=d;
    type = disease.getType();
    parent =null;
    children = new ArrayList<>();
    this.penetrace = penetrace;
    this.setPenetranceAffected();
    penetraces=penetrace;
}
/* 
public Person(boolean a1, boolean a2, boolean g, Disease d, boolean isA){
    allele1=a1;
    allele2=a2;
    gender=g;
    disease=d;
    type = disease.getType();
    parent =null;
    children = new ArrayList<>();
    isAffected=isA;
}
*/
public Person(boolean a1, boolean a2, boolean g, Disease d, Couple p){
    allele1=a1;
    allele2=a2;
    gender=g;
    disease=d;
    type = disease.getType();
    parent = p;
    children = new ArrayList<>();
}

public Person(boolean a1, boolean a2, boolean g, Disease d, Couple p, ArrayList<Person> c){
    allele1=a1;
    allele2=a2;
    gender=g;
    disease=d;
    type = disease.getType();
    parent =null;
    parent = p;
    children = c;
}

public boolean getA1(){
    return allele1;
}

public boolean getA2(){
    return allele2;
}

public boolean getGender(){
    return gender;
}

public Disease getDisease(){
    return disease;
}

public void addParent(Couple p){
    parent = p;
}

public void addChild(Person p){
    children.add(p);
}

public Couple getParent(){
    if(parent!=null)
    return parent;
    else
    throw new NullPointerException("No Parent Saved");
}

public boolean isPenetranceAffected(){
    return isAffected;
}

public void setPenetranceAffected(){
    isAffected = isAffected() && Math.random()<penetrace;
}

public boolean hasParent(){
    return parent!=null;
}

public ArrayList<Person> getChildren(){
    if(!children.isEmpty())
    return children;
    else
    throw new NullPointerException("No Child Saved");
}

public boolean hasChildren(){
    return !children.isEmpty();
}

public boolean sameParent(Person p){
    return this.parent == p.getParent();
}

 public boolean isAffected(){
    switch(disease.getDiseaseType()){
        case M -> {
            return allele1||allele2;
        }
        case  XLD -> {
            return gender ? allele1 : (allele1 || allele2);
        }
        case XLR -> {
            return gender ? !allele1 : !allele1 && ! allele2;
        }
        case YL -> {
            return gender && (allele1||allele2);
        }
        case AD -> {
            return allele1||allele2;
        }
        case AR -> {
            return !allele1&&!allele2;
        }
        default -> throw new IllegalArgumentException("Disease Type does not exsist");
    }
    }

public static Person random(boolean gender){
    if(!gender && type!=4 )
    return new Person(Math.random()>=0.5, Math.random()>=0.5, gender, new Disease(type), penetraces);
    else
    return new Person(false, false, gender, new Disease(type), penetraces);
}


public String toString(){
    String s = "";
    if(allele1){
        s = s + "Domiant ";
    }
    else{
        s = s+"Recessive ";
    }
    if(allele2){
        s = s + "Domiant ";
    }
    else{
        s = s+"Recessive ";
    }
    if(gender){
        s = s + "Male ";
    }
    else{
        s = s+"Female ";
    }
    return s;
} 
}