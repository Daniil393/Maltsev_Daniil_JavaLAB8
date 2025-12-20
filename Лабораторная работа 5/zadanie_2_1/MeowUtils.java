package zadanie_2_1;

public class MeowUtils {

    public static String declension(int n) {
        int last = n % 10;
        if (last >= 2 && last <= 4 && (n % 100 < 10 || n % 100 >= 20))
            return "раза";
        return "раз";
    }
}