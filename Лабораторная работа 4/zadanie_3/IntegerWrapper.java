package zadanie_3;

public class IntegerWrapper {
    private int value;

    public IntegerWrapper() {
        this.value = 0;
    }

    public IntegerWrapper(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}