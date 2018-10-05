package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {


    public static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean isPolygonContainsPoint(List<Point> mPoints, Point point) {
        int nCross = 0;
        for (int i = 0; i < mPoints.size(); i++) {
            Point p1 = mPoints.get(i);
            Point p2 = mPoints.get((i + 1) % mPoints.size());
            if (p1.y == p2.y)
                continue;
            if (point.y < Math.min(p1.y, p2.y))
                continue;
            if (point.y >= Math.max(p1.y, p2.y))
                continue;
            double x = (point.y - p1.y) * (p2.x - p1.x) / (p2.y - p1.y) + p1.x;
            if (x > point.x)
                nCross++;
        }
        return (nCross % 2 == 1);
    }

    public static int getDistance(List<Point> mPoints, Point point) {
        int nCross = 0;
        int minDistance = 0;

        for (int i = 0; i < mPoints.size(); i++) {
            Point p1 = mPoints.get(i);
            Point p2 = mPoints.get((i + 1) % mPoints.size());
            if (p1.y == p2.y)
                continue;
            if (point.y < Math.min(p1.y, p2.y))
                continue;
            if (point.y >= Math.max(p1.y, p2.y))
                continue;
            double x = (point.y - p1.y) * (p2.x - p1.x) / (p2.y - p1.y) + p1.x;
            if (x > point.x)
                nCross++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = in.nextInt();
        int y = in.nextInt();
        String duobianxing = in.nextLine();
        String[] xychar = duobianxing.split(",");

        List<Point> area = new ArrayList<>();
        for(int i =0; i<xychar.length; i++) {
            area.add(new Point(Double.parseDouble(xychar[i]), Double.parseDouble(xychar[i+1])));
        }

        boolean exist = false;

        if(isPolygonContainsPoint(area, new Point(x, y))){
            exist = true;
        }

        if(exist) {
            System.out.println("yes,0");
        } else {
//            System.out.println("no,"+getDistance());
        }




        System.out.println("PAUSE");
    }
}
