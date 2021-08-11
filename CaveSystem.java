import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



class Cave {
    int caveNo;
    boolean hasIdol = false;
    
}


public class CaveSystem {
    int NoOfTotalIdles;
    int NoOfCaves;
    int NoOfTunnels;
    int totalAir;
    Map<Integer, Cave> caveMap = new HashMap<Integer,Cave>();
    Map<Integer, Integer> tunnelsMap = new TreeMap<Integer, Integer>();

    public static void main(String args[]) throws FileNotFoundException {
        CaveSystem caveSystem = new CaveSystem();

        System.out.println("Starting Cave System");
        File testInputFile = new File("C:\\Users\\chmtr\\Desktop\\cave.txt");
        Scanner scanner = new Scanner(testInputFile);

        String nextLine0 = scanner.nextLine();
        System.out.println("Number of testCases" + nextLine0);
        int NoOfTestCases = Integer.parseInt(nextLine0);
        System.out.println("---------------------------------------");
        for (int k=0; k< NoOfTestCases; k++)
        {
            System.out.println("Test Cases No ===== "+k);
            String nextLine1 = scanner.nextLine();
            System.out.println("nextLine"+ nextLine1);
            String[] cavesAndTunnels = nextLine1.split(" ");
            int NoOfCaves = Integer.parseInt(cavesAndTunnels[0]);
            caveSystem.NoOfCaves = NoOfCaves;

            // System.out.println("NoOfCaves = "+ NoOfCaves);
            int NoOfTunnels = Integer.parseInt(cavesAndTunnels[1]);
            caveSystem.NoOfTunnels = NoOfTunnels;

            for(int i=0; i<NoOfTunnels; i++){
                String nextLine2 = scanner.nextLine();
                System.out.println("nextLine" + nextLine2);
                String[] numbrs = nextLine2.split("");

                Cave eCave = new Cave();
                eCave.caveNo = Integer.parseInt(numbrs[1]);
                caveSystem.caveMap.put(eCave.caveNo,eCave);
                //System.out.println("eCave.caveNo ==" +eCave.CaveNo);

                int reqAir = Integer.parseInt(numbrs[2]);
                //System.out.println("eCave.caveNo ==" eCave.reqAir);
                caveSystem.tunnelsMap.put(eCave.caveNo, reqAir);


            }

            String nextLine3 = scanner.nextLine();
            System.out.println("nextLine" + nextLine3);
            int nofIdles = Integer.parseInt(nextLine3);

            caveSystem.NoOfTotalIdles = nofIdles;
            // System.out.println("NoOfTotalIdles ==" eCaveSystem.NoOfTotalIdles);


            String nextLine4 = scanner.nextLine();
            System.out.println("nextLine4=  "+ nextLine4);
            String[] caveNoContainingIdels = nextLine4.split("");

            for (int i=0; i< caveNoContainingIdels.length; i++){
                int caveNumber = Integer.parseInt(caveNoContainingIdels[i]);
                if(caveSystem.caveMap.containsKey(caveNumber)){
                    caveSystem.caveMap.get(caveNumber).hasIdol=true;
                }
            }

            String nextLine5 = scanner.nextLine();
            System.out.println("nextLine5 ="+ nextLine5);
            caveSystem.totalAir = Integer.parseInt(nextLine5);

            //  System.out.println("totalAir ==" CaveSystem.totalAir);
        
            int totalAirtemp = caveSystem.totalAir;
            int Noofidolrecovered = 0;

            for( Map.Entry<Integer, Integer> tunnelEntry : caveSystem.tunnelsMap.entrySet()){
                if(caveSystem.caveMap.get(tunnelEntry.getKey()).hasIdol){
                    int consumedAir = tunnelEntry.getValue();
                    if(totalAirtemp >= consumedAir*2){
                        Noofidolrecovered++;
                        totalAirtemp = totalAirtemp - consumedAir*2;
                    }
                    else{
                        break;
                    }
                    }
            }


                System.out.println("--------------FINAL RESULT-----------------------------"); 
                System.out.println("Noofidolsrecovered ::::::::::::::::::" + Noofidolrecovered);
                System.out.println("---------------------------------------------------------");

        }


           


    }
        






        }
    