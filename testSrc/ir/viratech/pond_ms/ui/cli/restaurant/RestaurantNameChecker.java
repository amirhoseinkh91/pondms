package ir.viratech.pond_ms.ui.cli.restaurant;

import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import javassist.NotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RestaurantNameChecker {

    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        AbstractEntityDAO.touchSession();
        List<PointObject> restaurants = new RestaurantCRUD().getAllRestaurants();
        Set<String> names = new HashSet<>();
        for (PointObject po : restaurants)
            names.add(po.getName());
        new RestaurantNameChecker().handleNames(names);
        AbstractEntityDAO.closeCurrentThreadSessions();
    }

    private void handleNames(Set<String> names) {
        for (String s : names) {
            System.out.println("=======>>\n" + s);
            if (containsParentheses(s)) {
                try {
                    System.out.println(getBetweenParentheses(s));
                } catch (NotFoundException e) {
                    System.out.println(s + " inside Parentheses " + e.getMessage());
                }
            } else if (containsPipe(s)) {
                try {
                    System.out.println(handlePipe(s));
                } catch (NotFoundException e) {
                    System.out.println(s + " " + e.getMessage());
                }
            } else if (isEnOnly(s)) {
                System.out.println(s);
            } else {
                System.out.println(s);
            }
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
