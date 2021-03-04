package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

public class Figures {
    public static void renderPoint(GL2 gl, Vector2 pos, float size) {
        gl.glPointSize(size);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2d(pos.x,pos.y);
        gl.glEnd();
    }
public static void renderLine(GL2 gl, Vector2 pos, Vector2 pos1, float size) {
gl.glPointSize(size);
gl.glBegin(GL.GL_LINES);
    gl.glVertex2d(pos.x,pos.y);
    gl.glVertex2d(pos1.x,pos1.y);
    gl.glEnd();
};

}
