package com.example.demo.com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IsPtInPoly {


    public static boolean isPtInPoly(Point2D point, List<Point2D> pts){

        int N = pts.size();
        boolean boundOrVertex = true;
        int intersectCount = 0;
        double precision = 2e-10;
        Point2D p1, p2;
        Point2D p = point;

        p1 = pts.get(0);
        for(int i = 1; i <= N; ++i){
            if(p.equals(p1)){
                return boundOrVertex;
            }

            p2 = pts.get(i % N);
            if(p.x < Math.min(p1.x, p2.x) || p.x > Math.max(p1.x, p2.x)){
                p1 = p2;
                continue;
            }

            if(p.x > Math.min(p1.x, p2.x) && p.x < Math.max(p1.x, p2.x)){
                if(p.y <= Math.max(p1.y, p2.y)){
                    if(p1.x == p2.x && p.y >= Math.min(p1.y, p2.y)){
                        return boundOrVertex;
                    }

                    if(p1.y == p2.y){
                        if(p1.y == p.y){
                            return boundOrVertex;
                        }else{
                            ++intersectCount;
                        }
                    }else{
                        double xinters = (p.x - p1.x) * (p2.y - p1.y) / (p2.x - p1.x) + p1.y;
                        if(Math.abs(p.y - xinters) < precision){
                            return boundOrVertex;
                        }

                        if(p.y < xinters){
                            ++intersectCount;
                        }
                    }
                }
            }else{
                if(p.x == p2.x && p.y <= p2.y){
                    Point2D p3 = pts.get((i+1) % N);
                    if(p.x >= Math.min(p1.x, p3.x) && p.x <= Math.max(p1.x, p3.x)){
                        ++intersectCount;
                    }else{
                        intersectCount += 2;
                    }
                }
            }
            p1 = p2;
        }

        if(intersectCount % 2 == 0){//偶数在多边形外
            return false;
        } else { //奇数在多边形内
            return true;
        }

    }
    public static double PointLine_Disp(double xx, double yy, double x1, double y1, double x2, double y2){
        double a, b, c, ang1, ang2, ang, m;
        double result = 0;
        //分别计算三条边的长度
        a = Math.sqrt((x1 - xx) * (x1 - xx) + (y1 - yy) * (y1 - yy));

        if (a == 0)
            return -1;
        b = Math.sqrt((x2 - xx) * (x2 - xx) + (y2 - yy) * (y2 - yy));
        if (b == 0)
            return -1;
        c = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        //如果线段是一个点则退出函数并返回距离
        if (c == 0)
        {
            result = a;
            return result;
        }
        //如果点(xx,yy到点x1,y1)这条边短
        if (a < b)
        {
            //如果直线段AB是水平线。得到直线段AB的弧度
            if (y1 == y2)
            {
                if (x1 < x2)
                    ang1 = 0;
                else
                    ang1 = Math.PI;
            }
            else
            {
                m = (x2 - x1) / c;
                if (m - 1 > 0.00001)
                    m = 1;
                ang1 = Math.acos(m);
                if (y1 >y2)
                    ang1 = Math.PI*2  - ang1;//直线(x1,y1)-(x2,y2)与折X轴正向夹角的弧度
            }
            m = (xx - x1) / a;
            if (m - 1 > 0.00001)
                m = 1;
            ang2 = Math.acos(m);
            if (y1 > yy)
                ang2 = Math.PI * 2 - ang2;//直线(x1,y1)-(xx,yy)与折X轴正向夹角的弧度

            ang = ang2 - ang1;
            if (ang < 0) ang = -ang;

            if (ang > Math.PI) ang = Math.PI * 2 - ang;
            //如果是钝角则直接返回距离
            if (ang > Math.PI / 2)
                return a;
            else
                return a * Math.sin(ang);
        }
        else//如果(xx,yy)到点(x2,y2)这条边较短
        {
            //如果两个点的纵坐标相同，则直接得到直线斜率的弧度
            if (y1 == y2)
                if (x1 < x2)
                    ang1 = Math.PI;
                else
                    ang1 = 0;
            else
            {
                m = (x1 - x2) / c;
                if (m - 1 > 0.00001)
                    m = 1;
                ang1 = Math.acos(m);
                if (y2 > y1)
                    ang1 = Math.PI * 2 - ang1;
            }
            m = (xx - x2) / b;
            if (m - 1 > 0.00001)
                m = 1;
            ang2 = Math.acos(m);//直线(x2-x1)-(xx,yy)斜率的弧度
            if (y2 > yy)
                ang2 = Math.PI * 2 - ang2;
            ang = ang2 - ang1;
            if (ang < 0) ang = -ang;
            if (ang > Math.PI) ang = Math.PI * 2 - ang;//交角的大小
            //如果是对角则直接返回距离
            if (ang > Math.PI / 2)
                return b;
            else
                return b * Math.sin(ang);//如果是锐角，返回计算得到的距离
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String s1 []= s.nextLine().split(",");
        String s2 []= s.nextLine().split(",");
        Point2D point = new Point2D(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]));

        // 测试一个点是否在多边形内
        List<Point2D> pts = new ArrayList<Point2D>();
        for(int i = 0;i<s2.length-1;i+=2){
            int x = Integer.parseInt(s2[i]);
            int y = Integer.parseInt(s2[i+1]);
            pts.add(new Point2D(x,y));
        }

        if(isPtInPoly(point, pts)){
            System.out.println("yes,"+0);
        }else{
            long min = Integer.MAX_VALUE;
            for(int i = 0;i<pts.size()-1;i++){
                System.out.println(PointLine_Disp(point.x,point.y,pts.get(i).x,pts.get(i).y,pts.get(i+1).x,pts.get(i+1).x));
                long d = Math.round(PointLine_Disp(point.x,point.y,pts.get(i).x,pts.get(i).y,pts.get(i+1).x,pts.get(i+1).x));
                if(min>d){
                    min = d;
                }
            }
            long d = Math.round(PointLine_Disp(point.x,point.y,pts.get(0).x,pts.get(0).y,pts.get(pts.size()-1).x,pts.get(pts.size()-1).x));
            System.out.println(d);
            if(min>d){
                min = d;
            }
            System.out.println("no,"+min);
        }

    }

}

class Point2D {

    public double x;
    public double y;

    public Point2D(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

}
