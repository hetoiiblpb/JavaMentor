package JavaMentor;

public class Calculations {         //Класс "Считалка"
    private static int answer = 0;  //Статичная переменная, будущий ответ
    public static int Calculate (String astr, String bstr, char signstr) throws MyException{    //Метод подсчета для строчных (римских) аргументов
            RomeToArabic rtd = new RomeToArabic();      //создаем объект класса переводчика Римского в арабский
            int a = rtd.romeToArabic(astr);         //перефодим строковые римские в числовые арабские
            int b = rtd.romeToArabic(bstr);
        switch (signstr){               //Веттвление исходя из значения символьной переменной , которая хранит знак выражения
            case '+':                   //Случай с плюсом
                answer = a + b;            //Складываем аргументы
                break;                     //прерываем, ниже аналогично с вычитанием,делением и умножением

            case  '-':
                answer = a - b;
                break;

            case '/':
                answer = a / b;
                break;

            case '*':
                answer = a * b;
                break;
        }
        return answer; //Возвращаем методу ответ
    }

     public static int Calculate (int aint, int bint, char signint) throws MyException{ //Перегружаем метод на целочисленные аргументы
     switch (signint){  //Аналогично предыдущему варианту метода
                  case '+':
                      answer = aint + bint;
                      break;

                  case  '-':
                      answer = aint - bint;
                      break;

                  case '/':
                      answer = aint / bint;
                      break;

                  case '*':
                      answer = aint * bint;
                      break;
              }
    return answer;      //Возвращаем методу ответ
    }
}
