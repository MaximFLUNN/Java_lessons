public class Clock_s extends Clock {
    protected int arrowSeconds;

    public Clock_s(){
        this.name = "Неизвестно";
        this.cost = 0;
        this.arrowHours = java.time.LocalDateTime.now().getHour();// % 2;
        this.arrowMinuts = java.time.LocalDateTime.now().getMinute();// % 12;
        this.arrowSeconds = java.time.LocalDateTime.now().getSecond();//
    }

    public Clock_s(String _name, int _cost) {
        this.name = _name;
        if (_cost >= 0) {
            this.cost = _cost;
        }
        else{
            throw new NullPointerException("Exception: Cost < 0!");
        }
        this.arrowHours = java.time.LocalDateTime.now().getHour();// % 2;
        this.arrowMinuts = java.time.LocalDateTime.now().getMinute();// % 12;
        this.arrowSeconds = java.time.LocalDateTime.now().getSecond();//
    }

    public Clock_s(String _name, int _cost, int aH, int aM,int aS) {
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
        if (aS >= 0) {
            this.arrowSeconds += aS;
            if (this.arrowSeconds > 60) {
                this.arrowSeconds %= 60;
            }
        }
        else {
            throw new NullPointerException("Exception: Seconds < 0");
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

    public int getSeconds() {
        return arrowSeconds;
    }

    public void plusTime(int aH, int aM, int aS){
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
        if (aS >= 0) {
            this.arrowSeconds += aS;
            if (this.arrowSeconds > 60) {
                this.arrowSeconds %= 60;
            }
        }
        else {
            throw new NullPointerException("Exception: Seconds < 0");
        }
    }

    @Override
    public String toString() {
        return "Clock{" +
                "name='" + name + '\'' +
                ", arrowHours=" + arrowHours +
                ", arrowMinuts=" + arrowMinuts +
                ", arrowSeconds=" + arrowSeconds +
                ", cost=" + cost +
                '}';
    }

    public void PrintDisplay(){
        System.out.println("Имя: " + this.name);
        System.out.println("Стоимость: " + this.cost);
        System.out.println("Часы: " + this.arrowHours);
        System.out.println("Минуты: " + this.arrowMinuts);
        System.out.println("Секунды: " + this.arrowSeconds);
    }

    public void settime (types_arrow type, int value) {
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
            else if (type == types_arrow.S) {
                this.arrowSeconds = value;
                if (this.arrowSeconds > 60) {
                    this.arrowSeconds %= 60;
                }
            }
        }
        else {
            throw new NullPointerException("Exception: Settime value < 0");
        }
    }
}
