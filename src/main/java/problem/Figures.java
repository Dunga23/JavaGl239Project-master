package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

public class Figures {
    public static void renderPoint(GL2 gl, Vector2 pos, float size) {
        gl.glPointSize(size);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2d(pos.x, pos.y);
        gl.glEnd();
    }

    public static void renderLine(GL2 gl, Vector2 pos, Vector2 pos1, float size) {
        gl.glPointSize(size);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(pos.x, pos.y);
        gl.glVertex2d(pos1.x, pos1.y);
        gl.glEnd();
    }
    public static void renderCircle(GL2 gl, Vector2 pos, double r, int amounts) {
        gl.glBegin(GL.GL_LINE_LOOP);
        for (int i = 0; i < amounts; i++) {
            double angle = (2.0 * 3.1415926 * i / amounts);
            double dx = r * Math.cos(angle);
            double dy = r * Math.sin(angle);
            gl.glVertex2d(pos.x + dx, pos.y + dy);
        }
        gl.glEnd();
    }
    public static void renderTriangles(GL2 gl, Triangle pos, Color color1) {
        gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3d(color1.x, color1.y, color1.z);
        gl.glVertex3d(pos.x.x, pos.x.y, pos.x.z);
        gl.glVertex3d(pos.y.x, pos.y.y, pos.y.z);
        gl.glVertex3d(pos.z.x,pos.z.y, pos.z.z);
        gl.glEnd();
    }
}
