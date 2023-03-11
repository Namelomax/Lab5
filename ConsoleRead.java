package Second_sem.lab5;

import com.google.gson.internal.LinkedTreeMap;

import java.util.Arrays;

public class ConsoleRead {
    static Object parametr;
    public Object[] Read(String txt){
        LinkedTreeMap<String, String> hm = new LinkedTreeMap<>();
        txt =txt.replace("{", "").replace("}", "");
        String[] command1 = txt.split(" ");  // Line со сканера
        String command = command1[0];
        String[] com = Arrays.copyOfRange(command1, 1, command1.length);
        if (com.length >= 1 && com[0].contains("=")) {
            Defaults df = new Defaults();
            for (String param1 : com) {
                String[] values = param1.split("=");
                values[1]=values[1].replace(",","");
                hm.put(values[0], values[1]);
            }
        df.Defaults(hm);
            parametr = hm;
        } else if (com.length == 1 && !com[0].contains("=")) {
            parametr = Double.parseDouble(com[0]);
            System.out.println(parametr);
        } else  {
            parametr = null;
        }
        Object[] ar = new Object[2];
        ar[0] = command;
        ar[1] = parametr;
        System.out.println(ar[0]+" "+ar[1]);
        return ar;  // возвращаемая команда с параметром
    }

}
