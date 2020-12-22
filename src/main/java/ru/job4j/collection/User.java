package ru.job4j.collection;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        Map<User, Object> map1 = new HashMap<>();
        User u1 = new User("Anton", 0, new GregorianCalendar(1992, Calendar.FEBRUARY, 11));
        User u2 = new User("Anton", 0, new GregorianCalendar(1992, Calendar.FEBRUARY, 11));
        map1.put(u1, 0);
        map1.put(u2, 0);
        for (User rsl : map1.keySet()) {
            System.out.println(rsl);
        }
        System.out.println(map1);
        System.out.println(u1);
        System.out.println(u2);
    }
}
