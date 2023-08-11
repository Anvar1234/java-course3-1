package serviceTest;

import org.junit.jupiter.api.Test;
import ru.yandex.kingartaved.service.ExpressionService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ExpressionServiceTest {
    @Test
    public void calculatePostfixNotationTest1() throws RuntimeException {
        ExpressionService expressionService = new ExpressionService();
        Deque<Double> actualDeque = expressionService.resultDequeAfterCalculation(" ( -1+ 5/2+3^)");
        Deque<Double> expectedDeque = new ArrayDeque<>(List.of(10.5));
        if (actualDeque.size() == expectedDeque.size()) {
            assertEquals(expectedDeque.peek(), actualDeque.peek());
        } else throw new RuntimeException("ATTENTION! The queue size of expected and current values does not match.");
    }

    @Test
    public void calculatePostfixNotationTest2() throws RuntimeException {
        ExpressionService expressionService = new ExpressionService();
        Deque<Double> actualDeque = expressionService.resultDequeAfterCalculation("1-(1+2)-3+4-5*7");
        Deque<Double> expectedDeque = new ArrayDeque<>(List.of(-36.0));
        if (actualDeque.size() == expectedDeque.size()) {
            assertEquals(expectedDeque.peek(), actualDeque.peek());
        } else throw new RuntimeException("ATTENTION! The queue size of expected and current values does not match.");
    }


    @Test
    public void calculatePostfixNotationNegativeTest1() throws RuntimeException {
        ExpressionService expressionService = new ExpressionService();
        Deque<Double> actualDeque = expressionService.resultDequeAfterCalculation(" ( 1+ 5/2+3^)");
        Deque<Double> expectedDeque = new ArrayDeque<>(List.of(10.5)); //12.5
        if (actualDeque.size() == expectedDeque.size()) {
            assertNotEquals(expectedDeque.peek(), actualDeque.peek());
        } else throw new RuntimeException("ATTENTION! The queue size of expected and current values does not match.");
    }

    @Test
    public void calculatePostfixNotationNegativeTest2() throws RuntimeException {
        ExpressionService expressionService = new ExpressionService();
        Deque<Double> actualDeque = expressionService.resultDequeAfterCalculation("-1-(1+2)-3+4-5*7");
        Deque<Double> expectedDeque = new ArrayDeque<>(List.of(-36.0)); //-38.0
        if (actualDeque.size() != expectedDeque.size()) {
            //чисто ради эксперимента перенес эксепшн в иф.
            throw new RuntimeException("ATTENTION! The queue size of expected and current values does not match.");
        } else assertNotEquals(expectedDeque.peek(), actualDeque.peek());
    }


}
