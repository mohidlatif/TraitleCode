import java.util.*;
public class Pedigree{
   private Heiarchy heiarchy;
   private int affectedFemaleCount;
   private int affectedMaleCount;
   public Pedigree(Heiarchy h){
	heiarchy=h;
	affectedFemaleCount = 0;
	affectedMaleCount = 0;
   }
   public Heiarchy getHeiarchy(){
	return heiarchy;
   }
   //Loops through the datasets and checks if pedigree is valid for specific disease
    public void evaluateDiseases() {
    for (DiseaseType type : DiseaseType.values()) {
        if (isValidFor(type)) {
            heiarchy.addDisease(type);
        }
    }
}
	public void resetTypes(){
		affectedFemaleCount=0;
		affectedMaleCount = 0;
	}

	public boolean checkM(Person male, Person female){
		if(female != null && female.hasParent()){
				boolean wifeParentAffected = female.getParent().getWife().isPenetranceAffected();
				if(female.isPenetranceAffected() ^ wifeParentAffected)
					return false;
				}
				if(male != null && male.hasParent()){
				boolean husbandParentAffected = male.getParent().getWife().isPenetranceAffected();
				if(male.isPenetranceAffected() ^ husbandParentAffected)
					return false;
				}
				if(female != null && female.hasChildren()){
					for(int p=0; p<female.getChildren().size(); p++){
						if(female.isPenetranceAffected() ^ female.getChildren().get(p).isPenetranceAffected())
							return false;
					}
				}
				return true;
	}

	public boolean checkXLD(Person male, Person female){
		if(male != null && male.hasParent()){
					boolean maleParentAffected = male.getParent().getWife().isPenetranceAffected();
					if(male.isPenetranceAffected() && !maleParentAffected){
						return false;
					}
				}
				if(male != null && male.hasChildren()){
					for(int p=0; p<male.getChildren().size(); p++){
					Person child = male.getChildren().get(p);
					if(!child.getGender() && male.isPenetranceAffected() && !child.isPenetranceAffected()){
							 return false;
						}
					}
				}
			return true;
	}

	public boolean checkXLR(Person male, Person female){
		if(female != null && female.hasParent()){
					boolean fatherAffected = female.getParent().getHusband().isPenetranceAffected();
					if(female.isPenetranceAffected() && !fatherAffected){
						return false;
					}          
				}
				if(female != null && female.hasChildren()){
					for(int p=0; p<female.getChildren().size(); p++){
					Person child  = female.getChildren().get(p);
					if(child.getGender() && female.isPenetranceAffected() && !child.isPenetranceAffected()){
							return false;
						}
					}
				}
			return true;
	}

	public boolean checkYL(Person male, Person female){
		if(male != null && male.hasParent()){
				boolean husbandParentAffected = male.getParent().getHusband().isPenetranceAffected();
				if(male.isPenetranceAffected() ^ husbandParentAffected)
					return false;
				}
				if(female != null && female.isPenetranceAffected())
					return false;
				if(male != null && male.hasChildren()){
					for(int p=0; p<male.getChildren().size(); p++){
						if((male.isPenetranceAffected() ^ male.getChildren().get(p).isPenetranceAffected()) && male.getChildren().get(p).getGender())
							return false;
					}
				}
		return true;
	}

	public boolean checkAD(Person male, Person female){
		if (female != null && female.hasParent()) {
            boolean fatherAffected = female.getParent().getHusband().isPenetranceAffected();
            boolean motherAffected = female.getParent().getWife().isPenetranceAffected();
				if((!fatherAffected && !motherAffected) && female.isPenetranceAffected())
							return false;
                        }
                if (male != null && male.hasParent()) {
                            boolean fatherAffected = male.getParent().getHusband().isPenetranceAffected();
                            boolean motherAffected = male.getParent().getWife().isPenetranceAffected();
				if((!fatherAffected && !motherAffected) && male.isPenetranceAffected())
								return false;
            }
			return true;
	}

	public boolean checkAR(Person male, Person female){
		 if (female != null && female.hasParent()) {
                        boolean fatherAffected = female.getParent().getHusband().isPenetranceAffected();
                        boolean motherAffected = female.getParent().getWife().isPenetranceAffected();
                        if ((fatherAffected && motherAffected) && !female.isPenetranceAffected())
                            return false;
                        }
                    if (male != null && male.hasParent()) {
                        boolean fatherAffected = male.getParent().getHusband().isPenetranceAffected();
                        boolean motherAffected = male.getParent().getWife().isPenetranceAffected();
                        if ((fatherAffected && motherAffected) && !male.isPenetranceAffected())
                            return false;
                        }
		return true;
	}
   public boolean isValidFor(DiseaseType disease){
	int type = disease.getType();
	resetTypes();
	ArrayList<Generation> list = heiarchy.getHeiarchy();
	for(int x=0; x<list.size(); x++){
		ArrayList<Couple> clist = list.get(x).getGeneration();
		for(int y=0; y<clist.size(); y++){
			//List of all couples in a generation
			Couple c = clist.get(y);
			Person male = c.getHusband();
			Person female = c.getWife();
			if (male != null && male.isPenetranceAffected()) 
				affectedMaleCount++;
            if (female != null && female.isPenetranceAffected()) 
				affectedFemaleCount++;
			switch(type){
				case 1: 
				if(!checkM(male, female))
					return false;
				break;
				case 2:
				if(!checkXLD(male, female))
					return false;
				break;
				case 3:
				if(!checkXLR(male, female))
					return false;
				break;
				case 4:
				if(!checkYL(male, female))
					return false;
				break;
				case 5: 
                if(!checkAD(male, female))
					return false;
				break;
                case 6: 
				if(!checkAR(male, female))
					return false;
				break;
			}
		}
	}
	
	return true;
   }



}
