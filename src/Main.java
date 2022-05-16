import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //Проверка является ли число Арабским
    static boolean isArabicNumber(String num){
        String[] arabic_number_arr = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        return Arrays.asList(arabic_number_arr).contains(num);
    }

    //Проверка является ли число Римским
    static boolean isRomanNumber(String num){
        String[] roman_number_arr = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        return Arrays.asList(roman_number_arr).contains(num);
    }

    //Проверка на валидность оператора
    static boolean isOperator(String symb){
        String[] symb_arr = new String[] {"+", "-", "/", "*"};
        return Arrays.asList(symb_arr).contains(symb);
    }

    //Функция счета
    static int Calculator(int num_1, int num_2, char oper){
        int result;
        if(oper == '+'){
            result = num_1+num_2;
        }
        else if (oper == '-') {
            result = num_1-num_2;
        }
        else if (oper == '/') {
            result = num_1/num_2;
        }
        else if (oper == '*') {
            result = num_1*num_2;
        }
        else{
            result = num_1*num_2;
        }
        return result;
    }

    //Функция перевода str -> int

    //Main функция
    public static void main(String[] args) throws Exception {

        //Для цикла While
        boolean excep = true;


        while (excep){
            try {
                Scanner in = new Scanner(System.in);
                System.out.print("Введите строку: ");
                String str = in.nextLine();
                String[] split_string = str.split(" ");

                if (split_string.length!=3){
                    throw new java.lang.Exception("throws Exception");
                }

                // Если числа арабские
                if(isArabicNumber(split_string[0])&& split_string[0].length()<2
                        && isOperator(split_string[1])
                        && isArabicNumber(split_string[2])
                        && split_string[2].length()<2) {

                    //Создание переменных для счета

                    int number_1 = Integer.parseInt(split_string[0]);
                    int number_2 = Integer.parseInt(split_string[2]);
                    char operation = split_string[1].charAt(0);

                    //Вывод функции Calculator
                    System.out.println(Calculator(number_1, number_2, operation));
                }
                // Если римские числа тогда
                else if (isRomanNumber(split_string[0])
                        && isOperator(split_string[1])
                        && isRomanNumber(split_string[2])
                )
                {
                    //Создание переменных для счета и преобразование Roman в Arabic
                    int number_1 = Roman.romanToArabic(split_string[0]);
                    int number_2 = Roman.romanToArabic(split_string[2]);
                    char operation = split_string[1].charAt(0);
                    //Рассчет с последующим выводом
                    int result = Calculator(number_1, number_2, operation);
                    System.out.println(Roman.arabicToRoman(result));
                }
                else{
                    excep = false;
                    System.out.println("throws Exception");
                }
            }
            catch (ArrayIndexOutOfBoundsException exc){
                System.out.println("throws Exception");


            }

        }
        // ввод строки в консоль и ее разбиение

    }

}
