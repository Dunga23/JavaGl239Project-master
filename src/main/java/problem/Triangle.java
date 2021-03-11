package problem;

public class Triangle {
    public static Object pos;
    public static Object pos1;
    public Vector2 x;
    public Vector2 y;
    public Vector2 z;
    public String toString() {
        String s=String.format("(%.2f,%.2f)", x, y, z);
        return s;
    }
    public Triangle(Vector2 x,Vector2 y, Vector2 z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
}
