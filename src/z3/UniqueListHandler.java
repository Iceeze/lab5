package z3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueListHandler {

    // Метод для удаления всех повторяющихся элементов, оставляя только первые вхождения
    public static <T> List<T> removeDuplicates(List<T> list) {
        if (list == null) throw new IllegalArgumentException("Список не должен быть пустым.");

        List<T> result = new ArrayList<>();
        Set<T> seen = new HashSet<>(); // Множество для отслеживания уже добавленных элементов
        for (T item : list) {
            if (!seen.contains(item)) {
                result.add(item);  // Добавляем элемент, если его еще не было
                seen.add(item);    // Помечаем его как увиденный
            }
        }
        return result;
    }

    public static <T> String listToString(List<T> list) {
        return list.toString();
    }
}
