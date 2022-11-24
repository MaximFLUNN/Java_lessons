import java.io.*;
import java.util.ArrayList;

public class ReadObject {
    public static ArrayList<Clock> read(boolean flag) {
        ArrayList<Clock> list = new ArrayList<Clock>();
        {
            try {
                FileInputStream fis = new FileInputStream("Clocks.bin");
                ObjectInputStream ois = new ObjectInputStream(fis);

                int size = ois.readInt();
                for (int i = 0; i < size; i++) {
                    list.add((Clock) (ois.readObject()));
                }
                if (flag) {
                    System.out.println("-----------------Read Object --------------");
                    for (Clock obj : list) {
                        System.out.println(obj);
                    }
                }
                ois.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
