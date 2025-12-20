package zadanie_1_1;

public class Fraction implements FractionalOperations {

    private int numerator;
    private int denominator;
    private Double cachedValue = null;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0)
            throw new IllegalArgumentException("Знаменатель не может быть нулем");

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    private void invalidateCache() {
        cachedValue = null;
    }

    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        invalidateCache();
    }

    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0)
            throw new IllegalArgumentException("Знаменатель не может быть нулем");

        if (denominator < 0) {
            denominator = -denominator;
            this.numerator = -this.numerator;
        }

        this.denominator = denominator;
        invalidateCache();
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public double getValue() {
        if (cachedValue == null)
            cachedValue = (double) numerator / (double) denominator;
        return cachedValue;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Fraction))
            return false;

        Fraction other = (Fraction) obj;

        return this.numerator == other.numerator && this.denominator == other.denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}