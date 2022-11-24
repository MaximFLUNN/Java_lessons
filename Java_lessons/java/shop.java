import java.util.*;

public class shop {
    ArrayList<Clock> list = new ArrayList<Clock>();
    HashMap<String, Integer> hm = new HashMap<String, Integer>();
    SortedSet<String> ss = new TreeSet<String>();

    public shop() {
        Collections.addAll(list,
                new Clock(),
                new Clock("Часики", 1300),
                new Clock("Другие часы", 100000, 10, 25),
                new Clock_s(),
                new Clock_s("New clock", 2500),
                new Clock_s("Chasi", 100, 10,5, 21)
        );
    }

    public void addElem(Clock newClock) {
        list.add(newClock);
    }

    public int getMaxCost() {
//        ArrayList<Integer> maxcost = new ArrayList<Integer>();
//        for (Clock o: list) {
//            maxcost.add(o.getCost());
//        }
        Comparator<Clock> comp = new Comparator<Clock>() {
            @Override
            public int compare(Clock o1, Clock o2) {
                if(o1.getCost() > o2.getCost()) return 1;
                if(o1.getCost() < o2.getCost()) return -1;
                return 0;
            }
        };

        return Collections.max(list,comp).getCost();
    }

    public void setTimeAllClocks(Clock_int.types_arrow type, int value) {
        for (Clock o: list) {
            o.settime(type, value);
        }
    }

    public String getMaxCountName() {
        for (Clock obj: list) {
            if (hm.containsKey(obj.getName())) {
                int count = hm.get(obj.getName());
                hm.put(obj.getName(), ++count);
            }
            else {
                hm.put(obj.getName(), 1);
            }
        }
        int maxcount = 0;
        for (Clock o: list) {
            int objc = hm.get(o.getName());
            if (objc > maxcount) {
                maxcount = objc;
            }
        }
        String answer = "None";
        for (Clock o: list) {
            if (hm.get(o.getName()) == maxcount) {
                answer = o.getName();
            }
        }
        return answer;
    }

    public void printAllMarksOneCount() {
        for (Clock o: list) {
            ss.add(o.getName());
        }
        Iterator iterator = ss.iterator();
        while (iterator.hasNext()) {
            System.out.println((String) iterator.next());
        }

        for (String c:ss)
        {
            System.out.println(c);
        }

        ss.forEach(s -> System.out.println(s));

    }


    @Override
    public String toString() {
        return "shop{" +
                "list=" + list +
                '}';
    }
}
