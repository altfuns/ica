package com.altfuns.ica.data;

import android.content.Context;

import com.altfuns.ica.model.Event;
import com.altfuns.ica.util.AssetsUtil;
import com.altfuns.ica.util.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by altfuns on 10/8/15.
 */
public class EventDataAccess {

    public static List<Event> getAllPickups(Context context){
        String json = AssetsUtil.loadJSONFromAsset(context, "pickups.json");
        List<Event> events = fromJsonList(json);
        return events;
    }

    public static List<Event> getAllActivities(Context context){
        String json = AssetsUtil.loadJSONFromAsset(context, "activities.json");
        List<Event> events = fromJsonList(json);
        return events;
    }

    /**
     * Builds a list of objects from the json.
     * @param json
     * @return
     */
    public static List<Event> fromJsonList(String json){
        Type type = new TypeToken<List<Event>>() {
        }.getType();

        return JsonUtil.getParser().fromJson(json, type);
    }
}
