import z1.Fraction;
import z2.Cat;
import z2.MeowHandler;
import z2.Meowable;
import z3.UniqueListHandler;
import z4.Athlete;
import z4.AthleteResults;
import z5.UniqueCharsInWords;
import z6.QueueReversal;
import z7.Point;
import z7.Polyline;
import z8.PeopleProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Вариант 10\n");
        System.out.println("Список заданий:");
        System.out.println("1. Дробь (1.1)");
        System.out.println("2. Количество мяуканий. (2.1)");
        System.out.println("3. Список (3.10)");
        System.out.println("4. Мап (4.10)");
        System.out.println("5. Сет (5.10)");
        System.out.println("6. Очередь (6.5)");
        System.out.println("7. Стрим 1 (7.1)");
        System.out.println("8. Стрим 2 (7.2)");
        System.out.print("\nВыберите номер задания: ");
        String choice = scanner.next();

        switch (choice) {
            // Задание 1.1
            case "1": {
                System.out.println("Создание дроби");
                int numer = getValidInt("Введите числитель: ", scanner);
                int denom = getValidInt("Введите знаменатель: ", scanner);
                while (denom <= 0) {
                    System.out.println("Знаменатель должен быть положительным числом!");
                    denom = getValidInt("Введите знаменатель: ", scanner);
                }

                Fraction fraction = new Fraction(numer, denom);
                System.out.println("Дробь: " + fraction);
                System.out.println("Кэшированное вещественное значение : " + fraction.getDecimalValue());

                Fraction fraction2 = new Fraction(numer, denom);

                numer = getValidInt("Введите новый числитель: ", scanner);
                fraction.setNumerator(numer); // Новый числитель

                denom = getValidInt("Введите новое значение знаменателя: ", scanner);
                while (denom <= 0) {
                    System.out.println("Знаменатель должен быть положительным числом!");
                    denom = getValidInt("Введите новое значение знаменателя: ", scanner);
                }
                fraction.setDenominator(denom); // Новый знаменатель

                System.out.println("Обновлённая дробь : " + fraction2);
                System.out.println("Кешированное вещественное значение : " + fraction.getDecimalValue());

                if (fraction.equals(fraction2)) System.out.println(fraction + " и " + fraction2 + " равны.");
                else System.out.println(fraction + " и " + fraction2 + " не равны.");
            } break;

            // Задание 2.1
            case "2": {
                System.out.print("Введите имя для кота: ");
                String catName = scanner.next();
                Cat cat = new Cat(catName);
                MeowHandler.makeAllMeow(new Meowable[] {cat, cat, cat});  // Кот мяукает 3 раза
                System.out.println(cat + " мяукал " + cat.getMeowCount() + " раз(а).");
            } break;

            // Задание 3.10
            case "3": {
                List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 1, 6, 4);
                System.out.println("Исходный список: " + UniqueListHandler.listToString(numbers));
                List<Integer> uniqueNumbers = UniqueListHandler.removeDuplicates(numbers);
                System.out.println("Список без дубликатов: " + UniqueListHandler.listToString(uniqueNumbers));
            } break;

            // Задание 4.10
            case "4": {
                String filePath = "src/z4/input.txt"; // Файл с входными данными
                try {
                    File file = new File(filePath);
                    AthleteResults.getAthleteResults(file);
                } catch (FileNotFoundException e) {
                    System.out.println("Файл не найден: " + filePath);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка формата чисел: " + e.getMessage());
                }
            } break;

            // Задание 5.10
            case "5": {
                String filePath = "src/z5/text.txt"; // Файл с текстом
                try {
                    File file = new File(filePath);
                    UniqueCharsInWords.printUniqueChars(file);
                } catch (FileNotFoundException e) {
                    System.out.println("Файл не найден: " + filePath);
                }
            } break;

            // Задание 6.5
            case "6": {
                Queue<Integer> L1 = new LinkedList<>();
                Queue<Integer> L2 = new LinkedList<>();

                L1.add(1);
                L1.add(2);
                L1.add(3);
                L1.add(4);
                L1.add(5);
                System.out.println("Очередь L1 до обработки: " + L1);

                QueueReversal.reverseQueue(L1, L2);
                System.out.println("Очередь L2 после обратной вставки: " + L2);
            } break;

            // Задание 7.1
            case "7": {
                List<Point> points = Arrays.asList(
                        new Point(1, -3),
                        new Point(2, 4),
                        new Point(1, -3),
                        new Point(3, -5),
                        new Point(2, -4),
                        new Point(4, 5)
                );

                for (Point p : points) {
                    System.out.println("Точка " + p);
                }

                // Обработка точек с использованием стримов
                Polyline polyline = points.stream()
                        .map(p -> new Point(p.getX(), Math.abs(p.getY()))) // Преобразуем отрицательные значения Y в положительные
                        .sorted(Comparator.comparing(Point::getX)) // Сортируем по координате X
                        .distinct() // Убираем дубликаты по координатам
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Polyline::new)); // Собираем результат в ломаную

                System.out.println("\n" + polyline);
            } break;

            // Задание 7.2
            case "8": {
                PeopleProcessor processor = new PeopleProcessor();
                try {
                    String filePath = "src/z8/people.txt";

                    Map<Integer, List<String>> result = processor.processPeopleFromFile(filePath);
                    System.out.println("Результат: " + result);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } break;

            default: System.out.println("Такого задания нет в списке");
        }
    }

    // Метод для проверки корректного ввода целого числа
    public static int getValidInt(String message, Scanner scanner) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) return scanner.nextInt();
            else {
                System.out.println("Ошибка: это не целое число. Попробуйте снова.");
                scanner.next();
            }
        }
    }

}