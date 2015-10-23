package com.altfuns.ica.data;

import android.content.Context;
import android.text.format.DateUtils;

import com.altfuns.ica.model.Event;
import com.altfuns.ica.util.AssetsUtil;
import com.altfuns.ica.util.JsonUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by altfuns on 10/8/15.
 */
public class EventDataAccess {

    public static List<Event> getAllPickups(Context context) {
        String json = AssetsUtil.loadJSONFromAsset(context, "pickups.json");
        List<Event> events = fromJsonList(json);
        deleteEvents(events);
        return events;
    }

    public static List<Event> getAllActivities(Context context){
        String json = AssetsUtil.loadJSONFromAsset(context, "activities.json");
        List<Event> events = fromJsonList(json);
        deleteEvents(events);
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

    /**
     * Deletes the events already occur
     * @param events
     */
    private static void deleteEvents(List<Event> events) {
        Date now = new Date();
        Iterator<Event> iterator =  events.iterator();
        while (iterator.hasNext()){
            Event event = iterator.next();
            if(now.after(event.getDatetime()) && !DateUtils.isToday(event.getDatetime().getTime())){
                iterator.remove();
            }
        }
    }
}
