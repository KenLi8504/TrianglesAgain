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

  public String classify (){
    double x,y,z;
    x = (Math.round(v1.distanceTo(v2) * 10000.0)) / 10000.0;
    y = (Math.round(v2.distanceTo(v3) * 10000.0)) / 10000.0;
    z = (Math.round(v3.distanceTo(v1) * 10000.0)) / 10000.0;
    if (x == y && y == z && x == z){
      return "equilateral";
    }
    else if (x == y || y == z || x == z){
      return "isosceles";
    }
    else {
      return "scalene";
    }
  }

  public String toString (){
    return ("v1(" + v1.getX() + ", " + v1.getY() + ") v2(" + v2.getX() + ", " + v2.getY() + ") v3(" + v3.getX() + ", " + v3.getY() + ")" );
  }

  public void setVertex(int index, Point newP){
    if (index == 0){
      v1 = newP;
    }
    else if (index == 1){
      v2 = newP;
    }
    else{
      v3 = newP;
    }
  }
}
