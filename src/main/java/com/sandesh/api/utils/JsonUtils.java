package com.sandesh.api.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class JsonUtils {

    private JsonUtils() {}

    public static String readJson(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file", e);
        }
    }

}
