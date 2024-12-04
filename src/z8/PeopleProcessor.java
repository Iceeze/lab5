package z8;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class PeopleProcessor {
    // Метод для обработки людей из файла
    public Map<Integer, List<String>> processPeopleFromFile(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        System.out.println("Исходные данные: " + lines);

        // Обработка строк с использованием stream
        return lines.stream()
                .filter(line -> line.contains(":")) // Отбрасываем строки без номера (без ":")
                .map(line -> line.split(":")) // Преобразуем строки в пару "имя - номер"
                .filter(parts -> parts.length == 2 && !parts[1].isEmpty()) // Фильтруем тех, у кого нет корректного номера
                .map(parts -> new AbstractMap.SimpleEntry<>(
                        Integer.parseInt(parts[1].trim()), // Преобразуем номер в Integer, убираем лишние пробелы
                        capitalize(parts[0].trim()) // Преобразуем имя
                ))
                // Группируем по номеру
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey, // Номер
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList()) // Список имён
                ));
    }

    // Метод для преобразования строки: первая буква заглавная, остальные строчные
    private static String capitalize(String name) {
        if (name == null || name.isEmpty()) return name;
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}