package Second_sem.lab5.Java;

import com.google.gson.internal.LinkedTreeMap;

public class LinkedTreeMapManager {

    /**
     * fields of HumanBeing class in right order
     */
    private static final String[] fieldNames = {"id", "name", "coordinates", "creationDate",
            "realHero", "hasToothpick", "impactSpeed", "soundtrackName",
            "minutesOfWaiting", "mood", "car"};


    /**
     * Returns LinkedTreeMap, where keys are HumanBeing's fields and values from params
     * @param params Array of parameters of HumanBeing in right order.
     * @author KrugovEgor
     */
    public static LinkedTreeMap<String, Object> makeLinkedTreeMap(Object[] params){
        LinkedTreeMap<String, Object> linkedTreeMap = new LinkedTreeMap<>();
        for(int i = 0; i<fieldNames.length;i++){
            linkedTreeMap.put(fieldNames[i], params[i]);
        }
        return linkedTreeMap;
    }

    /**
     * Returns array of LinkedTreeMap values in right order (like in HumanBeing).
     * @param linkedTreeMap contains keys as HumanBeing's fields and their values.
     * @author KruglovEgor
     */
    public static Object[] getParams(LinkedTreeMap<String, Object> linkedTreeMap){
        Object[] array = new Object[linkedTreeMap.size()];
        for(int i = 0; i< linkedTreeMap.size(); i++){
            array[i] = linkedTreeMap.get(fieldNames[i]);
        }
        return array;
    }

}
