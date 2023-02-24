package Second_sem.lab5;

import com.google.gson.internal.LinkedTreeMap;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        String data = WorkWithFile.readFromFile("D:\\Intelij IDEA projects\\untitled\\src\\Second_sem\\lab5\\Data.json");
        LinkedList listOfData = WorkWithFile.convertJSONtoLinkedList(data);
//        System.out.println(data);
//        System.out.println(" ");
//        System.out.println(listOfData);
        LinkedList<HumanBeing> test = makeListOfHumanBeing(listOfData);
    }

    private static LinkedList<HumanBeing> makeListOfHumanBeing(LinkedList data) {
        LinkedList<HumanBeing> listOfHumanBeing = new LinkedList<>();
        for (Object datum : data) {
            LinkedTreeMap description = (LinkedTreeMap) datum;
            //System.out.println(description);
            Object[] params = new Object[11];
            for (int i = 0; i < description.size(); i++) {
                params[i] = description.get(description.keySet().toArray()[i]);
                //System.out.println(params[i]+ "      " + params[i].getClass());
            }
            //System.out.println(" ");
            HumanBeing unit = new HumanBeing(params);
            System.out.println(unit);
        }
        return listOfHumanBeing;}

}
