import java.io.Serializable;

public interface Clock_int extends Serializable {
    public enum types_arrow {H,M,S}
    public int getCost();
    public String getName();
    public int getHours();
    public int getMinuts();
    public String toString();
    public void PrintDisplay();
    public void settime(types_arrow type, int value);
}
