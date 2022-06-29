import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    Pattern pattern = Pattern.compile("(?=(^\\S+\\s\\S+$))(.{3,19})");

    public boolean checkNameToEmboss() {
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
