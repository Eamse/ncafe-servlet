package com.newlecture.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Env {
    private static final Map<String, String> VALUES = load();

    private static Map<String, String> load() {
        Map<String, String> values = new HashMap<>();
        Path envFile = Path.of(".env");

        if (!Files.exists(envFile)) {
            return values;
        }

        try {
            for (String line : Files.readAllLines(envFile)) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                int idx = line.indexOf('=');
                if (idx == -1) {
                    continue;
                }
                values.put(line.substring(0, idx).trim(), line.substring(idx + 1).trim());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load .env file", e);
        }

        return values;
    }

    public static String get(String key) {
        return VALUES.get(key);
    }
}
