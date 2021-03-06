import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class whiteboardTest {

    @Test
    void findConcat() {
        String result = whiteboard.findConcat("barfoothefoobarman", new String[]{"foo", "bar"});
        System.out.println(result);
        Assertions.assertTrue(result.contains("0") && result.contains("9"));
    }

    @Test
    void findConcatPat() {
        String result = whiteboard.findConcatPattern("barfoothefoobarman", new String[]{"foo", "bar"});
        System.out.println(result);
        Assertions.assertTrue(result.contains("0") && result.contains("9"));
    }

    @Test
    void findConcat1() {
        String result = whiteboard.findConcat("barfoothefoobarmanfoobar", new String[]{"foo", "bar"});
        System.out.println(result);
        Assertions.assertTrue(result.contains("0") && result.contains("9")&& result.contains("18"));
    }

    @Test
    void findConcatPat1() {
        String result = whiteboard.findConcatPattern("barfoothefoobarmanfoobar", new String[]{"foo", "bar"});
        System.out.println(result);
        Assertions.assertTrue(result.contains("0") && result.contains("9") && result.contains("18"));
    }


    @Test
    void findConcatPat2() {
        String result = whiteboard.findConcatPattern("barfoothefoobarmanfoobar", new String[]{"foo", "bar", "the"});
        System.out.println(result);
        Assertions.assertTrue(result.contains("0"));
    }
}