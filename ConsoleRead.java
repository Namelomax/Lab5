package Second_sem.lab5;

import com.google.gson.internal.LinkedTreeMap;

import java.util.Arrays;

public class ConsoleRead {
    static Object parametr;
    Object[] list;
    public Object[] Read(String txt){
        LinkedTreeMap<String, String> refactor = new LinkedTreeMap<>();
        txt =txt.replace("{", "").replace("}", "");
        String[] splittedcommand = txt.split(" ");  // Line со сканера
        String command = splittedcommand[0];
        String[] args = Arrays.copyOfRange(splittedcommand, 1, splittedcommand.length);
        if (args.length >= 1 && args[0].contains("=")) {
            Defaults df = new Defaults();
            for (String param : args) {
                String[] values = param.split("=");
                values[1]=values[1].replace("," , "");
                refactor.put(values[0], values[1]);
            }
        df.Defaults(refactor);
            System.out.println();
            int i =0;
           /* for(Object value:refactor.values()){
                list[i++]=value;
            }*/
            parametr = refactor;
           list = new Object[]{command,parametr};
           System.out.println(Arrays.toString(list));
        } else if (args.length == 1 && !args[0].contains("=")) {
            parametr = Double.parseDouble(args[0]);
            System.out.println(parametr);
            list = new Object[]{command,parametr};
        } else  {
            parametr = null;
            list = new Object[]{command,parametr};
        }
        return list;  // возвращаемая команда с параметром
    }

}
