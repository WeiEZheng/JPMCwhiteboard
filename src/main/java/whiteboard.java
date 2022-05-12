import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class whiteboard {
    public static String findConcat(String s, String[] strarr){
        String result = "";
        for (int i=0; i< strarr.length-1;i++){
            String tempFoward = strarr[i] + strarr[i+1];
            String tempBack = strarr[i+1] + strarr[i];
            if (s.contains(tempBack))
                result+= s.indexOf(tempBack) + ", ";
            if (s.contains(tempFoward))
                result+= s.indexOf(tempFoward) + ", ";
        }
        return result;
    }

    public static String findConcatPattern(String s, String[] strarr){
        String result = "";
        for (int i=0; i< strarr.length-1;i++){
            String tempFoward = strarr[i] + strarr[i+1];
            String tempBack = strarr[i+1] + strarr[i];
            Pattern pattern = Pattern.compile(tempBack);
            Pattern pattern1 = Pattern.compile(tempFoward);
            Matcher matcher = pattern.matcher(s);
            Matcher matcher1 = pattern1.matcher(s);
            while (matcher.find())
                result+=matcher.start() + " , ";
            while (matcher1.find())
                result+=matcher1.start() + " , ";
        }
        return result;
    }
}
