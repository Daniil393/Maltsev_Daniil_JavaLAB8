package ru.maltsev.directory;

import java.util.*;

public class TelephoneDirectory {

    private final Map<String, String> directory = new HashMap<>();

    public String add(String phone, String name) {
        Objects.requireNonNull(name, "Имя не может быть null");
        Objects.requireNonNull(phone, "Телефон не может быть null");

        return directory.put(name, phone);
    }

    public String remove(String name) {
        return directory.remove(name);
    }

    public String getPhone(String name) {
        return directory.get(name);
    }

    public boolean containsName(String name) {
        return directory.containsKey(name);
    }

    public boolean containsPhone(String phone) {
        return directory.containsValue(phone);
    }

    public int size() {
        return directory.size();
    }

    public Map<String, String> getAllPairs() {
        return new HashMap<>(directory);
    }

    public String[] getAllNames() {
        return directory.keySet().toArray(new String[0]);
    }

    public String[] getAllPhones() {
        return directory.values().toArray(new String[0]);
    }

    public String[] getNamesByPrefix(String prefix) {
        return directory.keySet().stream().filter(name -> name.startsWith(prefix)).toArray(String[]::new);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : directory.entrySet()) {
            sb.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }

        return sb.toString().trim();
    }
}