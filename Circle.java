import static java.lang.Math.*;

public class Circle {

    public static class Point {
        private int x;
        private int y;
    
        public int getX(){
            return x;
        }
        public void setX(int x){
            this.x = x;
        }
    
        public int getY(){
            return y;
        }
        public void setY(int y){
            this.y = y;
        }
    
    }
    
    public static boolean areClockwise(Point v1, Point v2) {
        return -v1.getX()*v2.getY() + v1.getY()*v2.getX() > 0;
    }
    
    public static boolean isWithinRadius(Point v1, Point v2, int radius) {
        
        double distance = Math.sqrt(Math.pow((v1.getX()-v2.getX()), 2) + Math.pow((v1.getY()-v2.getY()), 2));
        
        if (distance > radius) {
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean isInsideSector(Point point, Point sectorStarts, Point sectorEnds, Point center, int radius) {
        
        if (areClockwise(sectorEnds, point) && !areClockwise(sectorStarts, point) && isWithinRadius(center,point,radius)) {
            return true;
        } else {
            return false;
        }
        
    }

    public static void main(String[] args) {
    
        int radius = 1;
        
        Point center = new Point();
        center.setX(0);
        center.setY(0);
        
        Point point = new Point();
        point.setX(1);
        point.setY(1);
        
        Point sectorStarts = new Point();
        sectorStarts.setX(radius);
        sectorStarts.setY(0);
        
        Point sectorEnds = new Point();
        sectorEnds.setX(0);
        sectorEnds.setY(radius);
        
        //System.out.println(center.getX() + " " + center.getY() + " " + point.getX() + " " + point.getY() + "\n" + areClockwise(vector, point));
        //System.out.println(isWithinRadius(center,point,radius));
        System.out.println(isInsideSector(point, sectorStarts, sectorEnds, center, radius));
    
    }
}