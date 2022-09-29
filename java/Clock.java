public class Clock implements Clock_int {
    protected String name;
    protected int arrowHours;
    protected int arrowMinuts;
    protected int cost;

    public Clock() {
        this.name = "Неизвестно";
        this.cost = 0;
        this.arrowHours = java.time.LocalDateTime.now().getHour();// % 2;
        this.arrowMinuts = java.time.LocalDateTime.now().getMinute();// % 12;
    }

    public Clock(String _name, int _cost) {
        this.name = _name;
        if (_cost >= 0) {
            this.cost = _cost;
        }
        else{
            throw new NullPointerException("Exception: Cost < 0!");
        }
        this.arrowHours = java.time.LocalDateTime.now().getHour();// % 2;
        this.arrowMinuts = java.time.LocalDateTime.now().getMinute();// % 12;
    }

    public Clock(String _name, int _cost, int aH, int aM) {
        this.name = _name;
        if (_cost >= 0) {
            this.cost = _cost;
        }
        else{
            throw new NullPointerException("Exception: Cost < 0!");
        }
        if (aH >= 0 ) {
            this.arrowHours += aH;
            if (this.arrowHours > 12) {
                this.arrowHours %= 12;
            }
        }
        else {
            throw new NullPointerException("Exception: Hours < 0!");
        }
        if (aM >= 0) {
            this.arrowMinuts += aM;
            if (this.arrowMinuts > 12) {
                this.arrowMinuts %= 12;
            }
        }
        else {
            throw new NullPointerException("Exception: Minuts < 0");
        }
    }

    public int getCost(){
        return this.cost;
    }

    public String getName(){
        return this.name;
    }

    public int getHours(){
        return arrowHours;
    }

    public int getMinuts(){
        return arrowMinuts;
    }

    public void plusTime(int aH, int aM){
        if (aH >= 0 ) {
            this.arrowHours += aH;
            if (this.arrowHours > 12) {
                this.arrowHours %= 12;
            }
        }
        else {
            throw new NullPointerException("Exception: Hours < 0!");
        }
        if (aM >= 0) {
            this.arrowMinuts += aM;
            if (this.arrowMinuts > 12) {
                this.arrowMinuts %= 12;
            }
        }
        else {
            throw new NullPointerException("Exception: Minuts < 0");
        }
    }

    @Override
    public String toString() {
        return "Clock{" +
                "name='" + name + '\'' +
                ", arroyHours=" + arrowHours +
                ", arroyMinuts=" + arrowMinuts +
                ", cost=" + cost +
                '}';
    }

    public void PrintDisplay(){
        System.out.println("Имя: " + this.name);
        System.out.println("Стоимость: " + this.cost);
        System.out.println("Часы: " + this.arrowHours);
        System.out.println("Минуты: " + this.arrowMinuts);
    }

    public void settime(types_arrow type, int value) {
        if (value >= 0) {
            if (type == types_arrow.H) {
                this.arrowHours = value;
                if (this.arrowHours > 12) {
                    this.arrowHours %= 12;
                }
            }
            else if (type == types_arrow.M) {
                this.arrowMinuts = value;
                if (this.arrowMinuts > 12) {
                    this.arrowMinuts %= 12;
                }
            }
        }
        else {
            throw new NullPointerException("Exception: Settime value < 0");
        }
    }
}
