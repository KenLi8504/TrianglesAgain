public class Point{
  private double x,y;

  public Point(double X, double Y){
    x = X;
    y = Y;
  }

  public Point (Point p){
    x = p.x;
    y = p.y;
  }

  public double getX(){
    return x;
  }

  public double getY(){
    return y;
  }

  public double distanceTo(Point other){
    return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow (y - other.y, 2) );
  }

  public boolean equals (Point other){
    return (x == other.x && y == other.y);
  }
}

class Triangle{
  private Point v1,v2,v3;

  public Triangle(Point a, Point b, Point c){
    v1 = a;
    v2 = b;
    v3 = c;
  }

  public Triangle (double x1, double y1, double x2, double y2, double x3, double y3){
    v1 = new Point(x1,y1);
    v2 = new Point(x2,y2);
    v3 = new Point(x3,y3);
  }

  public double getPerimeter(){
    double x,y,z;
    x = v1.distanceTo(v2);
    y = v2.distanceTo(v3);
    z = v3.distanceTo(v1);
    return (x+y+z);
  }

  public double getArea(){
    double x,y,z,a;
    x = v1.distanceTo(v2);
    y = v2.distanceTo(v3);
    z = v3.distanceTo(v1);
    a = (x+y+z)/2;
    return (Math.sqrt(a*(a-x)*(a-y)*(a-z)));
  }

  public String Classify (){
    double x,y,z;
    x = (Math.round(v1.distanceTo(v2) * 10000)) / 10000;
    y = (Math.round(v2.distanceTo(v3) * 10000)) / 10000;
    z = (Math.round(v3.distanceTo(v1) * 10000)) / 10000;
    if (x == y && y ==z){
      return "Equilateral";
    }
    else if (x == y || y == z || x == z){
      return "Isosceles";
    }
    else {
      return "Scalene";
    }
  }
}
