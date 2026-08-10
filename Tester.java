//Goal: pass a penetrace var though the person constructor and make each person affected or not phenotypically based off whether they are initally afffected & penetrance. Then update your cheker to take this change into account and examine affectedness. Finally, get rid of the penetrance feautre in the MyPanel because you already implimented it.
public class Tester {
    public static Person possiblePerson(Couple c, Disease disease, double p){
        Person mother = c.getWife();
        Person father = c.getHusband();
         if(disease.getDiseaseType()== DiseaseType.M){
                return new Person(mother.getA1(), mother.getA2(), Math.random()>=0.5, disease, p);
            }
        else if(disease.getDiseaseType()== DiseaseType.AD||disease.getDiseaseType()== DiseaseType.AR){
                boolean allele1;
                boolean allele2;
                boolean gender = Math.random()>=0.5;
                //Distributes the alelles of mother and father to the alelles of the ofspring
                allele1 = (Math.random()>=0.5) ? mother.getA1() : mother.getA2();
                allele2 = (Math.random()>=0.5) ? father.getA1() : father.getA2();
                return new Person(allele1, allele2, gender, disease, p);
            }
        else if(disease.getDiseaseType()== DiseaseType.XLD||disease.getDiseaseType()== DiseaseType.XLR){
                boolean allele1 = (Math.random()>=0.5) ? mother.getA1() : mother.getA2();
                boolean gender = Math.random()>=0.5;
                boolean  allele2 = (gender) ? false : father.getA1();
                return new Person(allele1, allele2, gender, disease, p);
            }
        else if(disease.getDiseaseType()== DiseaseType.YL){
                boolean allele1 = false;
                boolean gender = Math.random()>=0.5;
                boolean allele2 = (gender) ? father.isAffected() : false;
                return new Person(allele1, allele2, gender, disease,p);
            }
        else
            return null;
        }
    }

