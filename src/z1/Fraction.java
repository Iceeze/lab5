package z1;

import java.util.Objects;

public class Fraction<T extends Integer> implements FractionInterface<T> {
    private T numerator;
    private T denominator;
    private Double cachedDecimalValue;
    private boolean isCacheValid;

    // Конструктор
    public Fraction(T numerator, T denominator) {
        if (denominator.intValue() <= 0) throw new IllegalArgumentException("Ошибка! Знаменатель должен быть положительным.");
        this.numerator = numerator;
        this.denominator = denominator;
        this.isCacheValid = false;
    }

    // Получение вещественного значения с кэшированием
    @Override
    public double getDecimalValue() {
        if (!isCacheValid) {
            cachedDecimalValue = numerator.doubleValue() / denominator.doubleValue();
            isCacheValid = true;
        }
        return cachedDecimalValue;
    }

    // Установка числителя и сброс кэша
    @Override
    public void setNumerator(T numerator) {
        this.numerator = numerator;
        this.isCacheValid = false; // кэш становится невалидным
    }

    // Установка знаменателя с проверкой
    @Override
    public void setDenominator(T denominator) {
        if (denominator.intValue() <= 0) throw new IllegalArgumentException("Ошибка! Знаменатель должен быть положительным.");
        else this.denominator = denominator;
        this.isCacheValid = false;
    }

    // Переопределение toString()
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Переопределение equals() для сравнения дробей
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction<?> fraction = (Fraction<?>) o;
        return Objects.equals(numerator, fraction.numerator) && Objects.equals(denominator, fraction.denominator);
    }

    // Переопределение hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}