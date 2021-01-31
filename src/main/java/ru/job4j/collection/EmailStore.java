package ru.job4j.collection;

import java.util.*;

public class EmailStore {
    private Map<String, Set<String>> map = new HashMap<>();

    private void splitMain(List<String> list) {
        for (String x : list) {
            String[] a = x.split(" ->");
            map.putIfAbsent(a[0], splitEmail(a[1]));
        }
    }

    private Set<String> splitEmail(String list) {
        String[] x = list.split(",");
        return new HashSet<>(Arrays.asList(x));
    }

    private Map<String, Set<String>> merge() {
        Map<String, Set<String>> map2 = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            for (String z : entry.getValue()) {
                if (!findDuplicateEmail(z).equals("")) {
                    set = splitEmail(findDuplicateEmail(z));
                }
            }
            map2.put(entry.getKey(), set);
            set = null;
        }
        return map2;
    }

    private Map<String, Set<String>> merge2(Map<String, Set<String>> start) {
        Map<Set<String>, String> start2 = new HashMap<>();
        Map<String, Set<String>> start3 = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : start.entrySet()) {
            start2.put(entry.getValue(), entry.getKey());
        }
        for (Map.Entry<Set<String>, String> entry : start2.entrySet()) {
            start3.put(entry.getValue(), entry.getKey());
        }
        return start3;
    }

    private void result() {
        map = merge2(merge());
        map = merge2(merge());
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " ->" + entry.getValue());
        }
    }


    private String findDuplicateEmail(String x) {
        StringBuilder zxc = new StringBuilder();
            for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
                    if (entry.getValue().contains(x)) {
                        zxc
                                .append(entry.getValue()).append(" ");
                }
            }
            String rsl = zxc.toString();
            String modified1 = rsl.replace("[", " ");
            String modified2 = modified1.replace("]", ", ");
            String modified3 = modified2.replace(" ", "");
        return modified3.substring(0, modified3.length() - 1);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru");
        list.add("user2 ->foo@gmail.com,ups@pisem.net");
        list.add("user3 ->xyz@pisem.net,vasya@pupkin.com");
        list.add("user4 ->ups@pisem.net,aaa@bbb.ru");
        list.add("user5 ->xyz@pisem.net");
        EmailStore emailStore = new EmailStore();
        emailStore.splitMain(list);
        emailStore.result();
    }
}
