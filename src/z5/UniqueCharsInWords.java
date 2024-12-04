package z5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UniqueCharsInWords {
    public static void printUniqueChars(File file) throws FileNotFoundException {
        Scanner scanFile = new Scanner(file);

        // Используем Set для хранения уникальных слов
        Set<Character> uniqueChars = new HashSet<>();
        Set<Character> nonUniqueChars = new HashSet<>();

        // Чтение файла построчно
        while (scanFile.hasNextLine()) {
            String line = scanFile.nextLine();
            String[] words = line.split("[\\s.,!?;:()\"-]+"); // Разделение строки на слова и очистка от знаков препинания

            for (String word : words) {
                Set<Character> currentWordChars = new HashSet<>();

                // Проходим по каждому символу в слове
                for (char c : word.toCharArray()) {
                    if (Character.isLetter(c)) { // Игнорируем символы, которые не буквы
                        c = Character.toLowerCase(c); // Приводим к нижнему регистру
                        if (!currentWordChars.contains(c)) { // Если символ не встречался в этом слове, добавляем его
                            currentWordChars.add(c);
                            if (!nonUniqueChars.contains(c)) uniqueChars.add(c); // Добавляем во множество уникальных
                            else uniqueChars.remove(c); // Если символ встречается повторно, удаляем из уникальных
                        }
                    }
                }
                nonUniqueChars.addAll(currentWordChars); // Обновляем множество неуникальных символов для символов из этого слова
            }
        }
        scanFile.close();

        // Выводим уникальные символы
        System.out.println("Символы, которые встречаются в одном и только в одном слове:");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }
    }
}
