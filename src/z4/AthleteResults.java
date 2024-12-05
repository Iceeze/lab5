package z4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AthleteResults {
    public static void getAthleteResults(File file) throws FileNotFoundException {
        Scanner scanFile = new Scanner(file);

        // Чтение данных о количестве спортсменов и видов спорта
        int numberOfAthletes = Integer.parseInt(scanFile.nextLine());
        int numberOfSports = Integer.parseInt(scanFile.nextLine());

        // Используем LinkedHashMap для сохранения порядка добавления
        Map<String, Integer> athleteScores = new LinkedHashMap<>();

        // Чтение данных о спортсменах
        for (int i = 0; i < numberOfAthletes; i++) {
            String line = scanFile.nextLine();
            String[] parts = line.split(" ");
            String surname = parts[0];
            String name = parts[1];
            String fullName = surname + " " + name;

            // Вычисление суммы баллов
            int totalScore = 0;
            for (int j = 2; j < 2 + numberOfSports; j++) {
                totalScore += Integer.parseInt(parts[j]);
            }

            athleteScores.put(fullName, totalScore);
        }

        // Сортировка по убыванию суммы баллов
        List<Map.Entry<String, Integer>> sortedAthletes = athleteScores.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .toList();

        // Присваивание мест спортсменам
        int rank = 1;
        for (int i = 0; i < sortedAthletes.size(); i++) {
            if (i > 0 && !sortedAthletes.get(i).getValue().equals(sortedAthletes.get(i - 1).getValue())) {
                rank++; // Обновляем место, если баллы отличаются
            }
            System.out.println(sortedAthletes.get(i).getKey() + " " + sortedAthletes.get(i).getValue() + " " + rank);
        }

        scanFile.close(); // Закрытие файла
    }
}
