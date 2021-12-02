import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args){
        new day2();
    }
    public day2(){
        List<Character> commands = new ArrayList<>();
        List <Integer> moves = new ArrayList<>();
        Pos subPos = new Pos(0,0);
        int aim = 0;

        try {
            File myObj = new File("resources/inputs2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                commands.add(data.charAt(0));
                moves.add(Character.getNumericValue(data.charAt(data.length()-1)));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find input for day2!");
            e.printStackTrace();
        }
        for (int i = 0; i < commands.size(); i++) {

            switch(commands.get(i)){
                case 'f':
                    subPos.moveX(moves.get(i));
                    subPos.moveY(moves.get(i)*aim);
                    break;
                case 'b':
                    subPos.moveX(-moves.get(i));
                    break;
                case 'u':
                    //subPos.moveY(-moves.get(i));
                    aim -= moves.get(i);
                    //System.out.println(aim + " up");
                    break;
                case 'd':
                    //subPos.moveY(moves.get(i));
                    aim += moves.get(i);
                    //System.out.println(aim + " down");
                    break;

            }
        }
        System.out.println(subPos.x);
        System.out.println(subPos.y);
        System.out.println(subPos.x * subPos.y);

    }

    private class Pos{
        private int x;
        private int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void moveX(int x){
            this.x += x;
        }

        public void moveY(int y){
            this.y += y;
        }

    }
}
