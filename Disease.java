public class Disease{
    private DiseaseType diseaseType;
    public Disease(int t){
        diseaseType = DiseaseType.fromCode(t);
    }
    public int getType(){
        return diseaseType.getType();
    }
    public DiseaseType getDiseaseType(){
        return diseaseType;
    }
    public String toString(){
        switch(diseaseType.getType()){
        case(1):
            return "Mitochondrial"; 
        
        case(2):
            return "X-Linked Dominant"; 
        
        case(3):
            return "X-Linked Recessive"; 

        case(4):
            return "Y-Linked"; 
        
        case(5):
            return "Autosomal Dominant"; 
        
        case(6):
            return "Autosomal Recessive"; 
        default:
            throw new IllegalArgumentException("Disease Does Not Exsist");
    }
}
}