public class Name2 {

    private String lastName;
    private String firstName;
    private String patronymic;

    public Name2(String firstName, String patronymic, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    public Name2( String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Name2(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (lastName != null) {
            sb.append(lastName).append(" ");
        }
        if (firstName != null) {
            sb.append(firstName).append(" ");
        }
        if (patronymic != null) {
            sb.append(patronymic);
        }

        return sb.toString().trim();
    }
}