package converterTest;

import org.junit.jupiter.api.Test;
import ru.yandex.kingartaved.converter.PolandNotationConverter;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolandNotationConverterTest {

    @Test
    public void convertToPostfixTest(){
        PolandNotationConverter polandNotationConverter = new PolandNotationConverter();
        //косяк в конвертации при добавлении в выражение ниже знака ^, выходит лишняя скобка,
        // во второй версии описал проблему.
        ArrayList<String> actualList = polandNotationConverter.resultArrayAfterConversation(" ( -1+ 5/2+3^)");
        ArrayList<String> expectedList =new ArrayList<>(Arrays.asList("0","1","-","5","2","/","+","3","^","+"));
        assertEquals(expectedList, actualList);
    }

}
