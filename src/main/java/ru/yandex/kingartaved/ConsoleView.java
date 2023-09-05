package ru.yandex.kingartaved;

import ru.yandex.kingartaved.converter.PolandNotationConverter;
import ru.yandex.kingartaved.preparator.UnaryMinusPreparator;
import ru.yandex.kingartaved.service.ExpressionService;

import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        //примеры выражений и ОПН выражения:
        System.out.println("-3*1*2^+5/2 =     [0, 1, -, 3, *, 1, *, 2, ^, *, 5, 2, /, +]");
        System.out.println("-(-1-(1+2)) =     [0, 1, -, 0, 1, -, 1, *, 1, 2, +, -, *]");
        System.out.println("1-(1+2)-3+4-5*7 = [1, 1, 2, +, -, 3, -, 4, +, 5, 7, *, -]");
        System.out.println("-3+(1-(1+2)) =    [0, 1, -, 3, *, 1, 1, 2, +, -, +]");
        System.out.println("1*(2-(3-4)) =     [1, 2, 3, 4, -, -, *]");
        System.out.println("3+1*2^+5 =        [3, 1, 2, ^, *, +, 5, +]");
        System.out.println("( -1+ 5/2+3^) =   [0, 1, -, 5, 2, /, +, 3, ^, +]");
        System.out.println("-1+ 5/2+3^ =      [0, 1, -, 5, 2, /, +, 3, ^, +]");

        //присваиваем пользовательский ввод переменной inputExpression.
        String inputExpression = prompt();

        //
        UnaryMinusPreparator unaryMinusPreparator = new UnaryMinusPreparator();
        List<String> tempArray = unaryMinusPreparator.resultArrayAfterTransformation(inputExpression); // specialSymbolChanger();
        System.out.println("После трансформатора:\n" + tempArray);

        //Загоняем выражение, прошедшее проверку и преобразование в ОПН-конвертер.
        PolandNotationConverter polandNotationConverter = new PolandNotationConverter();
        List<String> resultArrayOfConversation = polandNotationConverter.resultArrayAfterConversation(inputExpression);
        System.out.println("ОПН:\n" + resultArrayOfConversation);

        //Загоняем ОПН-выражение в калькулятор (котор высчитывает ОПН).
        ExpressionService expressionService = new ExpressionService();
        Deque<Double> finalResultArray = expressionService.resultDequeAfterCalculation(inputExpression);
        //Выводим результат работы калькулятора.
        System.out.println("Результат:\n" + finalResultArray);


    }


    //    private static void start(){
//        while (true){
//            prompt();
//        }
//    }
    private static String prompt() {
        System.out.print("Введите выражение: ");
        return sc.nextLine();
    }
}

