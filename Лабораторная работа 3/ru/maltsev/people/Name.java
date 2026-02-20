package ru.maltsev.people;

public final class Name {

    private final String lastName;
    private final String firstName;
    private final String patronymic;

    public Name(String firstName, String patronymic, String lastName) {
        this.firstName = normalize(firstName);
        this.patronymic = normalize(patronymic);
        this.lastName = normalize(lastName);

        validate();
    }

    public Name(String firstName, String lastName) {
        this(firstName, null, lastName);
    }

    public Name(String firstName) {
        this(firstName, null, null);
    }

    private String normalize(String s) {
        if (s == null)
            return null;
        s = s.trim();
        return s.isEmpty() ? null : s;
    }

    private void validate() {
        if (firstName == null && lastName == null && patronymic == null)
            throw new IllegalArgumentException("Хотя бы одно из ФИО должно быть написано");
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (lastName != null) sb.append(lastName).append(" ");
        if (firstName != null) sb.append(firstName).append(" ");
        if (patronymic != null) sb.append(patronymic);

        return sb.toString().trim();
    }
}