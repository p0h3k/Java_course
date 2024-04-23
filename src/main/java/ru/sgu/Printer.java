package ru.sgu;

import java.util.HashMap;
import java.util.Map;

public class Printer {
    private static final Map<String, Printer> instances = new HashMap<>();

    private String id;

    private Printer(String id) {
        this.id = id;
    }

    public static synchronized Printer getInstance(String id) {
        if (!instances.containsKey(id)) {
            System.out.println("Создан новый принтер с идентификатором: " + id);
            instances.put(id, new Printer(id));
        } else {
            System.out.println("Принтер с  идентификатором " + id + " уже существует " );
        }
        return instances.get(id);
    }

    public void print(String document) {
        System.out.println("Принтер " + id + " печатает: " + document);
    }
}
