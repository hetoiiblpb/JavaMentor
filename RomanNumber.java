package JavaMentor;

import java.util.TreeMap;   // Импортируем "деревянную", а точнее древовидную "карту" из редких пород дерева

public class RomanNumber {      //Объявляем класс для перевода наших цифр римлянам

    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>(); //объявляем метод-конструктор карте

    static {            //делаем статичный метод в карте для её заполнения
        map.put(1000000, "Ṁ");      // указываем ключом  целочисленный миллион, а значением - хитрый символ М с (будем считать) чертой сверху, означающий "Тысяча тысяч"
        map.put(900000, "ĆṀ");      //по аналогии все ключи и значения с меньшим номиналом
        map.put(500000,"Ď");
        map.put(400000,"ĆĎ");
        map.put(100000,"Ć");
        map.put(90000,"ẊĆ");
        map.put(50000,"Ĺ");
        map.put(40000,"ẊĹ");
        map.put(10000, "Ẋ");
        map.put(9000, "MẊ");
        map.put(5000, "Ṽ");
        map.put(4000, "MṼ");
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public final static String toRoman(int number) { //Метод-переводчик в классе-переводчике
        int l =  map.floorKey(number);          //присваеваем локальной переменной ближайшее к полученному методом целочисленному ключу в карте
        if ( number == l ) {                    //если полученное значение равно ближайшему
            return map.get(number);             //возвращаем методу полученное из карты
        }
        return map.get(l) + toRoman(number-l); // возвращаем методу полученное значение с помощью рекурсии
    }

}
