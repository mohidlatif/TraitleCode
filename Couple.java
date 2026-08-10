public class Couple {
    private Person husband;
    private Person wife;

    public Couple(Person p0, Person p1){
        if(p0.getGender()){
            husband = p0; wife = p1;
        }
        else{
            husband = p1; wife = p0;
        }
    }
    public Person getWife(){
        return wife;
    }
    public Person getHusband(){
        return husband;
    }
    public boolean isSingle(){
        return husband==null||wife==null;
    }
    @Override
    public String toString(){
        return husband + " " + wife;
    }
    public Couple getCouple(){
        return new Couple(wife, husband);
    }
}