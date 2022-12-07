import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriteObject {
    public static void write(ArrayList<Clock> lst, boolean flag) {
        ArrayList<Clock> list = lst;
        {
            try {
                FileOutputStream fos = new FileOutputStream("Clocks.bin");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeInt(list.size());
                for (Clock obj: list) {
                    oos.writeObject(obj);
                }
                if (flag) {
                    System.out.println("-----------------Write Object --------------");
                    for (Clock obj : list) {
                        System.out.println(obj);
                    }
                }
                oos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
