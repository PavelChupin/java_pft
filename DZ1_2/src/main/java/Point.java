/**
 * Created by Summoner on 11.02.2017.
 */
 public class Point {
    private double x;
    private double y;

    public Point()
    {
    }

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double distance(Point p1, Point p2)
    {
        if(p1.getX() == p2.getX()) {
            return Math.abs(p1.getY() - p2.getY());
        }
        else
        if (p1.getY() == p2.getY()){
            return Math.abs(p1.getX() - p2.getX());
        }
        else {
            return Math.sqrt(Math.abs(p1.getX() - p2.getX()) * Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY()) * Math.abs(p1.getY() - p2.getY()));
        }
    }

    public static double distance1(Point p1, Point p2)
    {
        if(p1.getX() == p2.getX()) {
            return Math.abs(p1.getY() - p2.getY());
        }
        else
        if (p1.getY() == p2.getY()){
            return  Math.abs(p1.getX() - p2.getX());
        }
        else {
            return Math.sqrt(Math.abs(p1.getX() - p2.getX()) * Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY()) * Math.abs(p1.getY() - p2.getY()));
        }
    }
}
