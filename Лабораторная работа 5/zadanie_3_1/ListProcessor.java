package zadanie_3_1;

public class ListProcessor {

    private ElementList elementList;
    private Element element;

    public ListProcessor(ElementList elementList, Element element) {
        if (elementList == null || element == null)
            throw new IllegalArgumentException("Объекты не могут быть null");

        this.elementList = elementList;
        this.element = element;
    }

    public void removeElement() {
        elementList.getList().removeIf(x -> x.equals(element.getValue()));
    }

    @Override
    public String toString() {
        return "Обработчик списка: удаление" + element;
    }
}