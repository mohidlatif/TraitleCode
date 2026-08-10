public enum DiseaseType {
    M(1), XLD(2), XLR(3), YL(4), AD(5), AR(6);
    private int d;
    DiseaseType(int x){
        d=x;
    }
    public static DiseaseType fromCode(int x) {
        for (DiseaseType t : values()) {
            if (t.d == x) {
                return t;
            }
        }
        throw new IllegalArgumentException("Invalid disease code");
    }
    public int getType(){
        return d;
    }
}
