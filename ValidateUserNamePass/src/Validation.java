import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static void main(String[] args) {
        String password = "ivan.petrov";
        String passwordRegex = "^[a-zA-Z][a-zA-Z0-9._-]{3,}$";
        Pattern patternPassword = Pattern.compile(passwordRegex);
        Matcher matcher = patternPassword.matcher(password);
        System.out.println(matcher.matches());
    }
}
