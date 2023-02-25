package Second_sem.lab5;

import java.util.HashMap;

public class ConsoleRead {
    Object parametr;
    public Object[] Read(String txt){
    HashMap<String, String> hm= new HashMap<>();
  //      for(Object o : listOfData){
            //       String Line = sc.nextLine();  // тут был сканер
        String[] command1 =Line.split(" ");  // Line со сканера
        String command = command1[0];
        String param="";
        for(int i=1;i<command1.length;i++){
            param+= command1[i]+" ";}
        System.out.println(param);
        if(command1.length>2){
            String[] params = Line.split(","); // Line со сканера
            for (String param1 : params) {
                String[] values = param1.split("=");
                hm.put(values[0], values[1]);
                parametr=hm;
            }
        } else if(command1.length==1){ parametr= Integer.parseInt(param);}
        else if(command1.length<1) {parametr=null;}
            Object[] ar = new Object[2];
            ar[0] = command;
            ar[1] = parametr;
            return ar;  // возвращаемая команда с параметром

    }
}
