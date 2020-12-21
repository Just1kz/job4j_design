package ru.job4j.collection;

import java.util.*;

public class Analize {

    public Info diffArray(List<User> previous, List<User> current) {
        Info info = new Info();
        List<User> prev = new ArrayList<>(previous);
        List<User> curr = new ArrayList<>(current);
        int minLength = Math.min(prev.size(), curr.size());
        for (int i = 0; i < minLength; i++) {
                if (curr.get(i).getId() == prev.get(i).getId()) {
                    if (!curr.get(i).getName().equals(prev.get(i).getName())) {
                        info.changed++;
                    }
                } else {
                    if (!curr.equals(prev)) {
                        info.added++;
                    }
                }
        }
            for (int i = 0; i < minLength; i++) {
                    if (!prev.get(i).equals(curr.get(i))) {
                        info.deleted++;
                    }
            }
        return info;
    }

    public static class User {
        private int id;
        private String name;

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
