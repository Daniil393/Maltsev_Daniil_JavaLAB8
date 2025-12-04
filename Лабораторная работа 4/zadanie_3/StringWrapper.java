package zadanie_3;

public class StringWrapper {
    private String value;

    public StringWrapper() {
        this.value = "";
    }

    public StringWrapper(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}