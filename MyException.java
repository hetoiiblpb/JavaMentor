package JavaMentor;

public class MyException extends Exception {    //Класс "МоегоИсключения" наследует признаки класса "Исключение"
        public MyException(String message) {
        super(message);      //Конструктор, выводящий сообщение, используя метод родительского класса
    }
}