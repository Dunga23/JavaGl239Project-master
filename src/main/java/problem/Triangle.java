package problem;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

public class Triangle {
    Vector2 a;
    Vector2 b;
    Vector2 c;

    public Triangle(Vector2 a, Vector2 b, Vector2 c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void render(GL2 gl) {
    }
}