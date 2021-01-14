package ru.job4j.spammer;

import ru.job4j.jdbc.CustomSettingsConnect;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class ImportDB {

    private final CustomSettingsConnect csc;
    private final String dump;

    public ImportDB(CustomSettingsConnect csc, String dump) {
        this.csc = csc;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
                         rd.lines()
                        .map(line -> line.split(";"))
                                 .filter(x -> x.length == 1)
                        .forEach(x -> users.add(new User(x[0], x[1])));
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        try (Connection cnt = DriverManager.getConnection(
                csc.getUrl(), csc.getLogin(), csc.getPassword()
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("insert into users(name, email) values(?, ?);")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }


    public static void main(String[] args) throws Exception {
        ImportDB db = new ImportDB(new CustomSettingsConnect(), "./dump.txt");
        db.save(db.load());
    }
}
