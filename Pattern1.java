package JavaMentor;

import java.util.regex.Matcher; //Импортируем Матчера (совпадальщика)
import java.util.regex.Pattern; //Импортируем пакет регулярных выражений

public class Pattern1 {
    public static boolean Pattern1(String s) //Метод конструктор, принимающий значения True или False после проверки

    {
        Pattern p1 = Pattern.compile("[ ]*\\d+[ ]*[\\+-/*]?[ ]*\\d+[ ]*");                  //создаем паттерн проверки на выражение из арабских цифр
        Pattern p2 = Pattern.compile("[ ]*[CDILMVX]+[ ]*[\\+-/*]?[ ]*[CDILMVX]+[ ]*");      //создаем паттерн проверки на выражение из римских цифр
        Matcher m1 = p1.matcher(s);     //Создаем объект-матчер (совпадальщик) по правилам первого паттерна
        Matcher m2 = p2.matcher(s);     //Аналогично со вторым
        return (m1.matches()||m2.matches()); //Проверяем, проходит ли хотя бы по одному из условий переданное методу выражение и возвращаем методу ответ
    }
}
