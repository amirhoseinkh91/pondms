package ir.viratech.pond_ms.core.db.data_import.restaurant;

import ir.viratech.base.SuppressWarningsOption;
import javassist.NotFoundException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings(SuppressWarningsOption.ALL)
public class FoursquareNameHandler {

    public String check(String name) {
        try {
            if (containsParentheses(name)) {
                return getBetweenParentheses(name);
            } else if (containsPipe(name)) {
                return handlePipe(name);
            } else if (isEnOnly(name)) {
                return name;
            } else {
                return name;
            }
        } catch (NotFoundException e) {
            return name;
        }
    }

    @SuppressWarnings("UnusedReturnValue")
    private String handlePipe(String s) throws NotFoundException {
        String res = getFromPipes_right(s);
        if (isEnOnly(res))
            res = getFromPipes_left(s);
        if (isEnOnly(res))
            throw new NotFoundException("only en... !!!");
        return res;
    }

    private String getBetweenParentheses(String s) throws NotFoundException {
        return get("\\(([^)]+)\\)", s, 1, 1);
    }

    private String getFromPipes_right(String s) throws NotFoundException {
        return get("\\|([^|]+)", s, 1, 1);
    }

    private String getFromPipes_left(String s) throws NotFoundException {
        return get("([^|]+)\\|", s, 1, 1);
    }


    @SuppressWarnings("SameParameterValue")
    private String get(String regex, String s, int find, int group) throws NotFoundException {
        Matcher m = Pattern.compile(regex).matcher(s);
        if (m.find(find))
            return m.group(group).trim();

        throw new NotFoundException("not found");
    }

    private boolean containsParentheses(String s) {
        return matches(".*\\(.*\\)", s);
    }

    private boolean containsPipe(String s) {
        return matches(".*\\|.*", s);
    }

    private boolean isEnOnly(String s) {
        return matches("[a-z A-Z]+", s);
    }

    private boolean matches(String regex, String s) {
        return Pattern.matches(regex, s);
    }

}
