package zadanie_1_1;

/**
 * Интерфейс, задающий операции для работы с дробными числами.
 * <p>
 * Предоставляет методы для получения численного значения дроби и
 * для изменения числителя и знаменателя.
 */
public interface FractionalOperations {

    /**
     * Возвращает численное (дробное) значение объекта.
     *
     * @return значение дроби в виде double
     */
    double getValue();

    /**
     * Устанавливает числитель дроби.
     *
     * @param numerator новое значение числителя
     */
    void setNumerator(int numerator);

    /**
     * Устанавливает знаменатель дроби.
     *
     * @param denominator новое значение знаменателя
     */
    void setDenominator(int denominator);
}