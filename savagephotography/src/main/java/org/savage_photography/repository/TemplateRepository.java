package org.savage_photography.repository;

import org.springframework.context.annotation.Bean;

import java.util.HashMap;

public class TemplateRepository {
    private static HashMap<String, String> templates = new HashMap<String, String>() {
    {
        put(
                "confirmation",
                "Name: %s, Link: %s"
        );
        put(
                "contact",
                "Name: %s, Email: %s, Phone number: %s, Order Info: %s"
        );
    }};

    public static String getTemplate(String key){
        return templates.get(key);
    }
}
