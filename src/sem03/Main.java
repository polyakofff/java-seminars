package sem03;

import java.util.*;

public class Main {

    static int xStatic, yStatic;



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        Point p1 = new Point(1, 2);
//        Object p2 = new Point(1, 2);
//
//        System.out.println(p1.equal((Point) p2));


        HashMap<Integer, Double> map = new HashMap<>();
        map.put(0, 3.6d);
        map.put(1, 2.5d);
        map.put(2, 13.4d);

        ArrayList<Integer> al = new ArrayList<>(map.keySet());

        Collections.sort(al, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Double val1 = map.get(o1);
                Double val2 = map.get(o2);
                return val1.compareTo(val2);
            }
        });

        for (int i : al) {
            System.out.println(i);
        }


    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean equal(Point p) {
        return x == p.x && y == p.y;
    }
}