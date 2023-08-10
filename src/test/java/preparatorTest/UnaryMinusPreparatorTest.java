package preparatorTest;

import org.junit.jupiter.api.Test;
import ru.yandex.kingartaved.preparator.UnaryMinusPreparator;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class UnaryMinusPreparatorTest {

    @Test
    public void unaryMinusChangerTest(){
        UnaryMinusPreparator unaryMinusPreparator = new UnaryMinusPreparator();
        ArrayList<String> actualList = unaryMinusPreparator.resultArrayAfterTransformation(" ( -1+ 5)");
        ArrayList<String> expectedList =new ArrayList<>(Arrays.asList("(","0","-","1","+","5",")"));
        assertEquals(expectedList, actualList);
    }
    @Test
    public void unaryMinusChangerNegativeTest(){
        UnaryMinusPreparator unaryMinusPreparator = new UnaryMinusPreparator();
        ArrayList<String> actualList = unaryMinusPreparator.resultArrayAfterTransformation("(- 1+2 )");
        ArrayList<String> expectedList =new ArrayList<>(Arrays.asList("(","-","1","+","2",")"));
        assertNotEquals(expectedList, actualList);
    }


}
