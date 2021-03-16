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

    public void render(GL2 gl) {
        Figures.renderCircle(gl, center, rad, 200);
    }
}
