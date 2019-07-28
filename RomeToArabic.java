package JavaMentor;

public class RomeToArabic {  //Класс переводчика с римского

static int strLength = 0;
static int risingCount = 0;
static int reduceCount = 0;

    public static int romeToArabic(String romanNumber) throws MyException {
        strLength = romanNumber.length();
        int dec = 0;
        int finalNumeral = 0;
        int mcounter = 0, dcounter = 0, ccounter = 0, lcounter = 0, xcounter = 0, vcounter = 0, icounter = 0;
            for (int i = romanNumber.length() - 1; i >= 0; i--) {      //Задаём цикл с итератором i для прохода с конца в начало строки
            char ConvertToDec = romanNumber.charAt(i);     //Забиваем i-й символ в символьную переменную

            switch (ConvertToDec) {             //Включаем оператор ветвления на этот символ
                case 'M':                       //В случае, если символ равен "M", делаем:
                    dec = processNumeral(1000, finalNumeral, dec);      //вычисление выходной переменной
                    finalNumeral = 1000;        //присваиваем последнему числу значение "1000"
                    mcounter++;                 //Увеличиваем счетчик повторений на 1
                    dcounter = 0; ccounter = 0; lcounter = 0; xcounter = 0; vcounter = 0; icounter = 0; //остальные счетчики сбрасываем
                    if (mcounter > 3) throw new MyException("Wrong Rome number");
                    break;                      //Заканчиваем цикл , ниже несколько аналогий для остальных римских цифр

                case 'D':
                    dec = processNumeral(500, finalNumeral, dec);
                    finalNumeral = 500;
                    dcounter++;
                    mcounter = 0; ccounter = 0; lcounter = 0; xcounter = 0; vcounter = 0; icounter = 0;
                    if (dcounter > 3) throw new MyException("Wrong Rome number");
                    break;

                case 'C':
                    dec = processNumeral(100, finalNumeral, dec);
                    finalNumeral = 100;
                    ccounter++;
                    dcounter = 0; mcounter = 0; lcounter = 0; xcounter = 0; vcounter = 0; icounter = 0;
                    if (ccounter > 3) throw new MyException("Wrong Rome number");
                    break;

                case 'L':
                    dec = processNumeral(50, finalNumeral, dec);
                    finalNumeral = 50;
                    lcounter++;
                    dcounter = 0; ccounter = 0; mcounter = 0; xcounter = 0; vcounter = 0; icounter = 0;
                    if (lcounter > 3) throw new MyException("Wrong Rome number");
                    break;

                case 'X':
                    dec = processNumeral(10, finalNumeral, dec);
                    finalNumeral = 10;
                    xcounter++;
                    dcounter = 0; ccounter = 0; lcounter = 0; mcounter = 0; vcounter = 0; icounter = 0;
                    if (xcounter > 3) throw new MyException("Wrong Rome number");
                    break;

                case 'V':
                    dec = processNumeral(5, finalNumeral, dec);
                    finalNumeral = 5;
                    vcounter++;
                    dcounter = 0; ccounter = 0; lcounter = 0; xcounter = 0; mcounter = 0; icounter = 0;
                    if (vcounter > 3) throw new MyException("Wrong Rome number");
                    break;

                case 'I':
                    dec = processNumeral(1, finalNumeral, dec);
                    finalNumeral = 1;
                    icounter++;
                    dcounter = 0; ccounter = 0; lcounter = 0; xcounter = 0; vcounter = 0; mcounter = 0;
                    if ( icounter > 3 ) throw new MyException("Wrong Rome number");
                    break;
            }
        }
        return dec;  //Возвращаем методу значение выходной переменной после вычислений
    }

    public static int processNumeral(int decimal, int lastNumber, int lastDecimal) throws MyException { //Метод для определения "прибавить" или "вычесть"
        if (reduceCount > risingCount) throw new MyException("Wrong Rome number"); // Если убываний больше чем возрастаний - выбрасываем исключение

        if (lastNumber > decimal) {         //Если последняя цифра больше текущей
            reduceCount++;                  //увеличиваем счетчик убывания римских цифр на 1
            return lastDecimal - decimal;   //Вычитаем из последней текущую цифру и возвращаем значение методу
        } else {                            //Во всех остальных случаях
            risingCount++;                  //увеличиваем счетчик возрастания римских цифр на 1
            return lastDecimal + decimal;   //Прибавляем к последней цифре текущую и также возвращаем значение методу


        }
    }

}



