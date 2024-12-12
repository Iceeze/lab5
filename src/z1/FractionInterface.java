package z1;

public interface FractionInterface<T extends Number> {
    double getDecimalValue();
    void setNumerator(T numerator);
    void setDenominator(T denominator);
}