package other;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comment {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = null;
        int count = 0;
        do{
            line =in.nextLine();
            if(line.equals("")) {
                break;
            }
//            Pattern patter = Pattern.compile("^//.*?$");
            String pat = "^//.*?$";
            Pattern patter = Pattern.compile(pat);
            Matcher matcher = patter.matcher(line);
            if(Pattern.matches(pat, line)) count++;
            if(!in.hasNextLine()) {
                in.close();
            }
        }while (in.hasNextLine());
        System.out.println(count);
    }
}
