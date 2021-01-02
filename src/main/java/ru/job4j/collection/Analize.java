package ru.job4j.collection;

import java.util.*;

public class Analize {

    public Info diffArray(List<User> previous, List<User> current) {
        Map<Integer, User> currMap = new HashMap<>();
        int deleted = 0;
        int changed = 0;
        for (User rsl : current) {
            currMap.put(rsl.id, rsl);
        }
        for (User u : previous) {
            deleted += (!currMap.containsKey(u.id) ? 1 : 0);
            changed += (currMap.containsKey(u.id) && !u.name.equals(currMap.get(u.id).name) ? 1 : 0);
        }
        int added = current.size() + deleted - previous.size();
        return new Info(added, changed,  deleted);
    }

    public static class User {
        private final int id;
        private final String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
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
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "User{"
                    + "id="
                    + id
                    + ", name='"
                    + name
                    + '\''
                    + '}';
        }
    }

    public static class Info {
        public int added;
        public int changed;
        public int deleted;

        public Info() {
        }

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added
                    && changed == info.changed
                    && deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }

        @Override
        public String toString() {
            return "Info{"
                    + "added="
                    + added
                    + ", changed="
                    + changed
                    + ", deleted="
                    + deleted
                    + '}';
        }
    }
}
