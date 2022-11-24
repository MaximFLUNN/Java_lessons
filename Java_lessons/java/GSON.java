import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class GSON {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public String writeJson(ArrayList<Clock> list, boolean flag) {
        String obj = gson.toJson(list);
        if (flag) {
            System.out.println("-----------------------To JSON-------------------");
            System.out.println(obj);
        }
        return obj;
    }
    public ArrayList<Clock> readJson(String obj, boolean flag) {
        ArrayList<Clock> list = (ArrayList<Clock>) (gson.fromJson(obj, ArrayList.class));
        if (flag) {
            System.out.println("-----------------------From JSON-------------------");
            System.out.println(list.toString());
        }
        return list;
    }
}
