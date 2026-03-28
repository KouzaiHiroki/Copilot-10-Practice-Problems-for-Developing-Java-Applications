import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("最初の数字を入力してください: ");
        double firstNumber = scanner.nextDouble();

        System.out.print("演算子を入力してください(+,-,*,/): ");
        String operator = scanner.next();

        System.out.print("次の数字を入力してください: ");
        double secondNumber = scanner.nextDouble();

        double result = calculate(firstNumber, operator, secondNumber);

        System.out.println("結果: " + result);
    }

    public static double calculate(double firstNumber, String operator, double secondNumber) {
        switch (operator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                return secondNumber != 0 ? firstNumber / secondNumber : 0;
            default:
                System.out.println("不正な演算子です: " + operator);
                return 0;
        }
    }
    
}