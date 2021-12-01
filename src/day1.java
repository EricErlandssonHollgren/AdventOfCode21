import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day1 {
    public static void main(String[] args){
        new day1();
    }
    public day1(){

        //1
        try (BufferedReader br = new BufferedReader(new FileReader("resources/inputs.txt"))) {
            String line;
            int increases = 0;
            int oldDepth = -1;
            while ((line = br.readLine()) != null) {
                if(oldDepth != -1){
                    int depth = Integer.valueOf(line);
                    if(depth > oldDepth){
                        increases++;
                    }
                    oldDepth = depth;
                }else{
                    oldDepth = Integer.valueOf(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //2
        List<Integer> depths = new ArrayList<>();

        try {
            File myObj = new File("resources/inputs.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                depths.add(Integer.parseInt(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find input for day1!");
            e.printStackTrace();
        }


        int oldTrippleDepth = -1;
        int depthincrease = 0;
        for (int i = 0; i < depths.size()-2; i++) {

            if(oldTrippleDepth != -1){
                int trippleDepth = threeMesurementsSum(depths.get(i),depths.get(i+1), depths.get(i+2));
                if(trippleDepth > oldTrippleDepth){
                    depthincrease++;
                }
                oldTrippleDepth = trippleDepth;
            }else{
                oldTrippleDepth = depths.get(0);
            }
        }
        System.out.println(depthincrease);

    }


    public int threeMesurementsSum(int a, int b, int c){
        return a+b+c;
    }
}
