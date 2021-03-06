import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class whiteboard {
    public static String findConcat(String s, String[] strarr){
        List<Integer> result = new ArrayList<>();
        Integer padding = 0, stringSize = strarr[0].length();
        for (int i=0; i < strarr.length-1;i++){
            if (i==j)
                continue;
            for (int j = 0; j < strarr.length; j++) {
                String tempFoward = strarr[i] + strarr[j];
                String tempBack = strarr[j] + strarr[i];
                while (s.contains(tempBack)) {
                    Integer temp = s.indexOf(tempBack);
                    result.add(temp + padding);
                    padding += temp + (stringSize * 2) + 1;
                    if (temp + (stringSize * 2) + 1 > s.length())
                        break;
                    s = s.substring(temp + (stringSize * 2) + 1);
                }
                while (s.contains(tempFoward)) {
                    Integer temp = s.indexOf(tempFoward);
                    result.add(temp + padding);
                    padding += temp + (stringSize * 2) + 1;
                    if (temp + (stringSize * 2) + 1 > s.length())
                        break;
                    s = s.substring(temp + (stringSize * 2) + 1);
                }
            }
        }
        return print(result);
    }

    public static String findConcatPattern(String s, String[] strarr){
        List<Integer> result = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        for (int i=0; i< strarr.length-1;i++) {
            for (int j = 0; j < strarr.length; j++) {
                if (i==j)
                    continue;
                String tempFoward = strarr[i] + strarr[j];
                String tempBack = strarr[j] + strarr[i];
                if (seen.add(tempBack)) {
                    Pattern pattern = Pattern.compile(tempBack);
                    Matcher matcher = pattern.matcher(s);
                    while (matcher.find())
                        result.add(matcher.start());
                }
                if (seen.add(tempFoward)) {
                    Pattern pattern1 = Pattern.compile(tempFoward);
                    Matcher matcher1 = pattern1.matcher(s);
                    while (matcher1.find())
                        result.add(matcher1.start());
                }
            }
        }
        return print(result);
    }

    private static String print(List<Integer> result) {
        if (result.size() == 0)
            return "";
        String s = "(" + result.get(0);
        for (int i = 1; i<result.size();i++){
            s+= ", " + result.get(i);
        }
        return s+")";
    }
}
