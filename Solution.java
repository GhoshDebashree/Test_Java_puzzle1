import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
            String[] newStr = s.split(":");
           
            int arr = Integer.parseInt(String.valueOf(newStr[0]));
            char[] ch = newStr[2].toCharArray();
            if(ch[2]=='P' && arr<12){
                    arr = arr +12;
                    return arr+":"+newStr[1]+":"+ch[0]+ch[1];
            }else if(ch[2]=='P' && arr==12){
                     return newStr[0]+":"+newStr[1]+":"+ch[0]+ch[1];
            } else if(ch[2]=='A'&& arr==12){
               return "00:" +newStr[1]+ ":" +ch[0]+ch[1];
            }
           else{
                return newStr[0]+":"+newStr[1]+":"+ch[0]+ch[1];
           }

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
