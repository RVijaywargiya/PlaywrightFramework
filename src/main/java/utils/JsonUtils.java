package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER =
            new ObjectMapper();

    private JsonUtils() {
    }

    public static <T> T fromJson(
            String json,
            Class<T> clazz) {

        try {
            return OBJECT_MAPPER.readValue(
                    json,
                    clazz
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}