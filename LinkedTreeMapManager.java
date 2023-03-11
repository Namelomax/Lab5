package Second_sem.lab5;

import com.google.gson.internal.LinkedTreeMap;

public class LinkedTreeMapManager {

    private static String[] fieldNames = {"id", "name", "coordinates", "creationDate",
            "realHero", "hasToothpick", "impactSpeed", "soundtrackName",
            "minutesOfWaiting", "mood", "car"};


    public static LinkedTreeMap<String, Object> makeLinkedTreeMap(Object[] params){
        LinkedTreeMap<String, Object> linkedTreeMap = new LinkedTreeMap<>();
        for(int i = 0; i<fieldNames.length;i++){
            linkedTreeMap.put(fieldNames[i], params[i]);
        }
        return linkedTreeMap;
    }

    public static Object[] getParams(LinkedTreeMap<String, Object> linkedTreeMap){
        Object[] array = new Object[linkedTreeMap.size()];
        for(int i = 0; i< linkedTreeMap.size(); i++){
            array[i] = linkedTreeMap.get(fieldNames[i]);
        }
        return array;
    }

}
