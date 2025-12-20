package zadanie_3_1;

public class Element {

    private Integer value;

    public Element(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "E= " + value;
    }
}