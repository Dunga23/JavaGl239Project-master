package problem;

import javax.media.opengl.GL2;
import java.util.ArrayList;

public class Circle {
    public Vector2 center;
    public double rad;

    public Circle(Vector2 pos, double rad) {
        this.center = pos;
        this.rad = rad;
    }
 static Circle getRandomCircle() {
        return(new Circle(new Vector2(Math.random(), Math.random()), Math.random()/2 ));
}//генерируем произвольный объект класса
    public void render(GL2 gl) {
        Figures.renderCircle(gl, center, rad, 400, false);
    }//рисуем
   public double plcircle(ArrayList<Point> points, Circle circle){
double k=0; double s=Math.PI*circle.rad*circle.rad;
        for (Point point : points) {
           if((point.x - circle.center.x) * (point.x - circle.center.x) +
                   (point.y - circle.center.y) * (point.y - circle.center.y) <= circle.rad * circle.rad){
  k++;
}
        }
        return(k/s);
        }//плотность точек внутри
}
