package JavaMentor;

public class RomeToArabic {  //Класс переводчика с римского
   static int count = 0;
    public static int romeToArabic(String romanNumber) throws MyException {
       int dec = 0;
        int finalNumeral = 0;
        String romanNumeral = romanNumber.toUpperCase();
            for (int i = romanNumeral.length() - 1; i >= 0; i--) {      //Задаём цикл с итератором i для прохода с конца в начало строки
            if (count > 3) throw new MyException("Ошибка ввода Римских Цифр!");     //Выдаем ошибку, если "счетчик ошибок" превышен
            char ConvertToDec = romanNumeral.charAt(i);     //Забиваем i-й символ в символьную переменную

            switch (ConvertToDec) {             //Включаем оператор ветвления на этот символ
                case 'M':                       //В случае, если символ равен "M", делаем:
                    dec = processNumeral(1000, finalNumeral, dec);      //вычисление выходной переменной
                    finalNumeral = 1000;        //присваиваем последнему числу значение "1000"
                    break;                      //Заканчиваем цикл , ниже несколько аналогий для остальных римских цифр

                case 'D':
                    dec = processNumeral(500, finalNumeral, dec);
                    finalNumeral = 500;
                    break;

                case 'C':
                    dec = processNumeral(100, finalNumeral, dec);
                    finalNumeral = 100;
                    break;

                case 'L':
                    dec = processNumeral(50, finalNumeral, dec);
                    finalNumeral = 50;
                    break;

                case 'X':
                    dec = processNumeral(10, finalNumeral, dec);
                    finalNumeral = 10;
                    break;

                case 'V':
                    dec = processNumeral(5, finalNumeral, dec);
                    finalNumeral = 5;
                    break;

                case 'I':
                    count++; //Повышаем значение счетчика ошибок, чтобы при вводе пользователя более 3 палок программа выбросила исключение
                    dec = processNumeral(1, finalNumeral, dec);
                    finalNumeral = 1;
                    break;
            }
        }
        return dec;  //Возвращаем методу значение выходной переменной после вычислений
    }

    public static int processNumeral(int decimal, int lastNumber, int lastDecimal) {        //Метод для определения "прибавить" или "вычесть"
        if (lastNumber > decimal) {         //Если последняя цифра больше текущей
            count++;                        //Прибавляем счетчик "ошибки"
            return lastDecimal - decimal;   //Вычитаем из последней текущую цифру и возвращаем значение методу
        } else {                               //Во всех остальных случаях
            return lastDecimal + decimal;       //Прибавляем к последней цифре текущую и также возвращаем значение методу
        }
    }
}
