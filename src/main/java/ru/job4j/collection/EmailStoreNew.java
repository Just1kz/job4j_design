package ru.job4j.collection;

import java.util.*;

public class EmailStoreNew {

    private Set<String> splitEmail(String list) {
        String[] x = list.split(",");
        return new HashSet<>(Arrays.asList(x));
    }

    private Map<String, Set<String>> splitMain(List<String> list) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String x : list) {
            String[] a = x.split(" ->");
                map.put(a[0], splitEmail(a[1]));
        }
        return map;
    }

    private Map<String, Set<String>> merge(Map<String, Set<String>> map) {
        Map<String, Set<String>> rsl = new HashMap<>();
        Map<String, String> rslX = new TreeMap<>();

        for (String name : map.keySet()) {
            String rslName = name;

            for (String email : map.get(name)) {
                    if (rslX.containsKey(email)) {
                        rslName = rslX.get(email);
                        break;
                    }
            }

            for (String email : map.get(name)) {
                rslX.put(email, rslName);
            }

        }

        for (String email : rslX.keySet()) {
            String rslName = rslX.get(email);
            if (!rsl.containsKey(rslName)) {
                rsl.put(rslName, new HashSet<>());
            }
            if (rsl.containsKey(rslName)) {
                rsl.get(rslName).add(email);
            }
        }

        return rsl;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru");
        list.add("user2 ->foo@gmail.com,ups@pisem.net");
        list.add("user3 ->xyz@pisem.net,vasya@pupkin.com");
        list.add("user4 ->ups@pisem.net,aaa@bbb.ru");
        list.add("user5 ->xyz@pisem.net");
        EmailStoreNew storeNew = new EmailStoreNew();
        System.out.println(storeNew.merge(storeNew.splitMain(list)));
    }
}
