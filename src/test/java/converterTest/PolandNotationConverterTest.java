package converterTest;

import org.junit.jupiter.api.Test;
import ru.yandex.kingartaved.converter.PolandNotationConverter;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class PolandNotationConverterTest {

    @Test
    public void convertToPostfixTest1(){
        PolandNotationConverter polandNotationConverter = new PolandNotationConverter();
        //косяк в конвертации при добавлении в выражение ниже знака ^, выходит лишняя скобка,
        // во второй версии описал проблему.
        ArrayList<String> actualList = polandNotationConverter.resultArrayAfterConversation(" ( -1+ 5/2+3^)");
        ArrayList<String> expectedList =new ArrayList<>(Arrays.asList("0","1","-","5","2","/","+","3","^","+"));
        assertEquals(expectedList, actualList);
    }
    @Test
    public void convertToPostfixTest2(){
        PolandNotationConverter polandNotationConverter = new PolandNotationConverter();
        ArrayList<String> actualList = polandNotationConverter.resultArrayAfterConversation("1-(1+2)-3+4-5*7");
        ArrayList<String> expectedList =new ArrayList<>(Arrays.asList("1", "1", "2", "+", "-", "3", "-", "4", "+", "5", "7", "*", "-"));
        assertEquals(expectedList, actualList);
    }


    @Test
    public void convertToPostfixNegativeTest1() {
        PolandNotationConverter polandNotationConverter = new PolandNotationConverter();
        //косяк в конвертации при добавлении в выражение ниже знака ^, выходит лишняя скобка,
        // во второй версии описал проблему.
        ArrayList<String> actualList = polandNotationConverter.resultArrayAfterConversation(" ( -1+ 5/2+3^)");
        ArrayList<String> expectedList = new ArrayList<>(Arrays.asList("0", "1", "-", "5", "2", "/", "+", "3", "^", "("));
        assertNotEquals(expectedList, actualList);
    }
    @Test
    public void convertToPostfixNegativeTest2() {
        PolandNotationConverter polandNotationConverter = new PolandNotationConverter();
        //косяк в конвертации при добавлении в выражение ниже знака ^, выходит лишняя скобка,
        // во второй версии описал проблему.
        ArrayList<String> actualList = polandNotationConverter.resultArrayAfterConversation("1-(1+2)-3+4-5*7");
        ArrayList<String> expectedList =new ArrayList<>(Arrays.asList("1", "1", "2", "+", "-", "3", "-", "4", "+", "5", "7", "*", "("));
        assertNotEquals(expectedList, actualList);
    }


}
