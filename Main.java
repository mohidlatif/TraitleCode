import java.io.*;
public class Main {
    private final static double[] penetrances = {1.0, 0.95, 0.9, 0.85, 0.8, 0.75, 0.7, 0.65, 0.6, 0.55, 0.5, 0.45, 0.4, 0.35, 0.3, 0.25,0.2, 0.15, 0.1, 0.05};
    private final static DiseaseType[] DISEASE_TYPES = {DiseaseType.M, DiseaseType.XLD, DiseaseType.XLR, DiseaseType.YL, DiseaseType.AD, DiseaseType.AR};
    public static void main(String[] args){
        int ind;
        int cnt = 0;
        try(FileWriter writer = new FileWriter("results.csv")){
            writer.append("DiseaseType,Penetrance,Correct\n");
            while(cnt<DISEASE_TYPES.length){
                ind = 0;
            while(ind<penetrances.length){
            for(int x=0; x<100000; x++){
                writer.append(DISEASE_TYPES[cnt] + "," + penetrances[ind] + "," + Process.run(penetrances[ind], DISEASE_TYPES[cnt])+"\n");
            }
            ind++;
        }
        cnt++;
        }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
