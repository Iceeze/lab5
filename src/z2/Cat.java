package z2;

public class Cat implements Meowable {
    private final String name;
    private int meowCount = 0;

    // Конструктор с указанием имени кота
    public Cat(String name) {
        this.name = name;
    }

    // Реализация метода мяуканья
    public void meow() {
        System.out.println(name + ": мяу!");
        meowCount++;
    }

    // Метод для получения количества мяуканий
    public int getMeowCount() {
        return meowCount;
    }

    // Текстовое представление кота
    public String toString() {
        return "Кот " + name;
    }
}