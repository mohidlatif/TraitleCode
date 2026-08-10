public class Process {
    public static Heiarchy h;
    public static Disease d;
    public static DiseaseType dt;
    public static boolean run(double pen, DiseaseType dissid) {
        double penetrace = pen;
        dt = dissid;
        d = new Disease(dt.getType());
        h = new Heiarchy();
        HeiarchyCreator h0 = new HeiarchyCreator();
        Person p0 = new Person(Math.random()>=0.5, Math.random()>=0.5, true, d, penetrace);
        Person p1;
            if(d.getDiseaseType()!=DiseaseType.YL)
                p1 = new Person(Math.random()>=0.5, Math.random()>=0.5, false, d, penetrace);
            else
                p1 = new Person(false,false, false, d, penetrace);
        Couple couple = new Couple(p0, p1);
        Gen g = new Gen(couple, d, penetrace);
       	h0.createHeiarchy(couple, 0, g);
        h = h0.getHeiarchy();
        Pedigree p = new Pedigree(h);
        p.evaluateDiseases();
        return (h.getDiseases().contains(dt));
    }
}
