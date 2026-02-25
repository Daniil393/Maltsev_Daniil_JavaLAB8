package zadanie_1_1;

/**
 * Класс, представляющий дробное число и реализующий интерфейс {@link FractionalOperations}.
 * <p>
 * Дробь хранится в виде числителя и знаменателя. Поддерживается кэширование
 * вычисленного значения дроби в типе {@code double}.
 */
public class Fraction implements FractionalOperations {

    /** Числитель дроби */
    private int numerator;

    /** Знаменатель дроби */
    private int denominator;

    /** Кэшированное значение дроби */
    private Double cachedValue = null;

    /**
     * Создает дробь с указанным числителем и знаменателем.
     *
     * @param numerator числитель дроби
     * @param denominator знаменатель дроби (не может быть 0)
     * @throws IllegalArgumentException если знаменатель равен 0
     */
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

    /** Инвалидирует кэшированное значение дроби.
     * Вызывается при изменении числителя или знаменателя. */
    private void invalidateCache() {
        cachedValue = null;
    }

    /**
     * Устанавливает числитель дроби и инвалидирует кэш.
     *
     * @param numerator новое значение числителя
     */
    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        invalidateCache();
    }

    /**
     * Устанавливает знаменатель дроби.
     * <p>
     * Если передан отрицательный знаменатель, знак числителя инвертируется.
     * Инвалидирует кэш.
     *
     * @param denominator новое значение знаменателя
     * @throws IllegalArgumentException если знаменатель равен 0
     */
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


    /**
     * Возвращает числитель дроби.
     *
     * @return числитель
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Возвращает знаменатель дроби.
     *
     * @return знаменатель
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Возвращает численное значение дроби в формате {@code double}.
     * <p>
     * Если значение уже было вычислено, возвращается кэшированное значение.
     *
     * @return значение дроби
     */
    @Override
    public double getValue() {
        if (cachedValue == null)
            cachedValue = (double) numerator / (double) denominator;
        return cachedValue;
    }

    /**
     * Проверяет, равна ли текущая дробь другой дроби.
     * <p>
     * Дроби считаются равными, если совпадают числитель и знаменатель.
     *
     * @param obj другой объект
     * @return {@code true}, если дроби равны, иначе {@code false}
     */
    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Fraction))
            return false;

        Fraction other = (Fraction) obj;

        return this.numerator == other.numerator && this.denominator == other.denominator;
    }

    /**
     * Возвращает строковое представление дроби в формате "числитель/знаменатель".
     *
     * @return строковое представление дроби
     */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}