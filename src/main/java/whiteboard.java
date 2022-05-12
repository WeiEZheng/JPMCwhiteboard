import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class whiteboard {
    public static String findConcat(String s, String[] strarr){
        List<Integer> result = new ArrayList<>();
        for (int i=0; i< strarr.length-1;i++){
            String tempFoward = strarr[i] + strarr[i+1];
            String tempBack = strarr[i+1] + strarr[i];
            if (s.contains(tempBack))
                result.add(s.indexOf(tempBack));
            if (s.contains(tempFoward))
                result.add(s.indexOf(tempFoward));
        }
        return print(result);
    }

    public static String findConcatPattern(String s, String[] strarr){
        List<Integer> result = new ArrayList<>();
        for (int i=0; i< strarr.length-1;i++){
            String tempFoward = strarr[i] + strarr[i+1];
            String tempBack = strarr[i+1] + strarr[i];
            Pattern pattern = Pattern.compile(tempBack);
            Pattern pattern1 = Pattern.compile(tempFoward);
            Matcher matcher = pattern.matcher(s);
            Matcher matcher1 = pattern1.matcher(s);
            while (matcher.find())
                result.add(matcher.start());
            while (matcher1.find())
                result.add(matcher1.start());
        }
        return print(result);
    }

    private static String print(List<Integer> result) {
        String s = "(" + result.get(0);
        for (int i = 1; i<result.size();i++){
            s+= ", " + result.get(i);
        }
        return s+")";
    }
}
