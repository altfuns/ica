package com.altfuns.ica.util;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

/**
 * Contains useful and common function to parse JSON object.
 *
 */
public class JsonUtil {

    /**
     * Get the common Gson parser.
     */
    public static Gson getParser() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        return gsonBuilder.create();
    }

    /**
     * Get a Gson parser to serialize and deserialize byte arrays.
     * @return
     */
    public static Gson getByteArrayParser() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(byte[].class,
                new ByteArrayToBase64TypeAdapter()).create();
        gsonBuilder.setDateFormat("YYYY-MM-DD");
        return gsonBuilder.create();
    }

    /**
     * Parse the object to an JSON string object.
     * @param object The object to parse.
     * @return
     */
    public static String toJson(Object object) {
        return getParser().toJson(object);
    }

    /**
     * Build an object of the type of the given class from JSON string object.
     * @param clasz
     * @param json
     * @return
     */
    public static <T> T fromJson(Class<T> clasz, String json) {
        return getParser().fromJson(json, clasz);
    }

    /**
     * Builds a list of objects from the json.
     * @param clasz
     * @param json
     * @param <T>
     * @return
     */
    public static <T> List<T> fromJsonList(Class<T> clasz, String json){
        Type type = new TypeToken<List<T>>() {
        }.getType();

        return getParser().fromJson(json, type);
    }

    // Using Android's base64 libraries. This can be replaced with any base64 library.
    private static class ByteArrayToBase64TypeAdapter implements
            JsonSerializer<byte[]>, JsonDeserializer<byte[]> {
        public byte[] deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return Base64.decode(json.getAsString(), Base64.NO_WRAP);
        }

        public JsonElement serialize(byte[] src, Type typeOfSrc,
                JsonSerializationContext context) {
            return new JsonPrimitive(Base64.encodeToString(src, Base64.NO_WRAP));
        }
    }
}
