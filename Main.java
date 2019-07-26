package JavaMentor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {   //Точка входа в программу с вероятностью исключений
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));   //Создаем объект "Читателя"
            String expr = reader.readLine();        //Загоняем в переменную expr Пользовательский ввод
            Pattern1 parrr = new Pattern1();        //Создаем объект класса проверки строки на соответствие формату задачи
            if (!parrr.Pattern1(expr)) throw new  MyException("------Incorrect expression!---------"); //выбрасываем исключеие в случае несоответствия
            Calculations calc = new Calculations();        //Создаем объект класса "Считалки"
            if (expr.matches("^\\d+.*")) {                          //Проверка, начинается ли введенное выражение с арабской цифры
                String[] abstring = expr.split("[\\+-/*]",2);  //Разрезаем введенное выражение на первый и второй аргумент
                int aint1 = Integer.parseInt(abstring[0]);                  //Парсим первый аргумент в целочисленную переменную
                int bint1 = Integer.parseInt(abstring[1]);                  //Аналогично со вторым аргументом
                if (bint1 == 0) throw new  MyException("------Division by zero!---------");//Если второй аргумент равен "0", выбрасываем исключение
                char sign = expr.charAt(abstring[0].length());              //Извлекаем знак между аргументами
                System.out.println(calc.Calculate(aint1,bint1,sign));       //Выводим полученное значение при помощи объекта класса "Считалки"
            }
            else {  //Если выражение прошло проверку на соответствие, но не начинается с цифры, делаем указанное ниже
                RomanNumber rn = new RomanNumber();     //создаем объект класса "Переводчика на римский"
                String[] abstring = expr.split("[\\+-/*]",2); //Разрезаем введенное выражение на первый и второй аргумент
                String astring = abstring[0];   //Загоняем первый аргумент в строковую переменную
                String bstring = abstring[1];   //Также со вторым
                char sign = expr.charAt(abstring[0].length());//Извлекаем знак между аргументами
                System.out.println(rn.toRoman(calc.Calculate(astring,bstring,sign)));//Выводим то, что перевел переводчик с того, что насчитала считалка
            }
        }
        catch (MyException e) {                 //Отлов исключения
            System.out.println(e);              //Вывод текста исключения
        }
    }
}

