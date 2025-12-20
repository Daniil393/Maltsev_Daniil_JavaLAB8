package zadanie_3_1;

import java.util.ArrayList;
import java.util.List;

public class ElementList {

    private List<Integer> list;

    public ElementList(List<Integer> list) {
        if (list == null)
            throw new IllegalArgumentException("Список пустой");

        this.list = new ArrayList<>(list);
    }

    public List<Integer> getList() {
        return list;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}