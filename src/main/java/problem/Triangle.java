package problem;

public class Triangle {
    public static Object pos;
    public static Object pos1;
    public Vector2 a;
    public Vector2 b;
    public Vector2 c;
    public String toString() {
        String s=String.format("(%.2f,%.2f)", a, b, c);
        return s;
    }
    public Triangle(Vector2 a,Vector2 b, Vector2 c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
   public Circle tcircle(Triangle triangle){
        double D = 2*(triangle.a.x*(triangle.b.y-triangle.c.y)+triangle.b.x*(triangle.c.y-triangle.a.y)+triangle.c.x*(triangle.a.y-triangle.b.y));
        Vector2 ce= new Vector2 (((((triangle.a.x*triangle.a.x)+(triangle.a.y*triangle.a.y))*(triangle.b.y-triangle.c.y)+((triangle.b.x*triangle.b.x)+(triangle.b.y*triangle.b.y))*(triangle.c.y-triangle.a.y)+((triangle.c.x*triangle.c.x)+(triangle.c.y*triangle.c.y))*(triangle.a.y-triangle.b.y))/D),
                (((triangle.a.x*triangle.a.x)+(triangle.a.y*triangle.a.y))*(triangle.c.x-triangle.b.x)+((triangle.b.x*triangle.b.x)+(triangle.b.y*triangle.b.y))*(triangle.a.x-triangle.c.x)+((triangle.c.x*triangle.c.x)+(triangle.c.y*triangle.c.y))*(triangle.b.x-triangle.a.x)/D));
        double r= Vector2.tdist(ce, triangle.a);
       Circle circle = new Circle(ce, r);
       return (circle);
    }

}
