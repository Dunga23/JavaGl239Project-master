package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;

public class Figures {
    public static void renderPoint(GL2 gl, Vector2 pos, float size) {
        gl.glPointSize(size);
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2d(pos.x, pos.y);
        gl.glEnd();
    }

    public static void renderLine(GL2 gl, Vector2 pos, Vector2 pos1, float width) {
        gl.glPointSize(width);
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
    public static void renderTriangle(GL2 gl, Vector2 posA, Vector2 posB, Vector2 posC, boolean filled, Color color) {
        if(filled==true) {
            gl.glBegin(GL.GL_TRIANGLES);
            gl.glColor3d(color.x, color.y, color.z);
            gl.glVertex3d(posA.x, posA.y, posA.z);
            gl.glVertex3d(posB.x, posB.y, posB.z);
            gl.glVertex3d(posC.x, posC.y, posC.z);
            gl.glEnd();
        } else {
            Figures.renderLine(gl, posA, posB, (float) 0.05);
            Figures.renderLine(gl, posB, posC, (float) 0.05);
            Figures.renderLine(gl, posC, posA, (float) 0.05);
        }
    }
    public static void renderQuad(GL2 gl, Vector2 posA, Vector2 posB, Vector2 posC, Vector2 posD, boolean filled){
        if(filled==true) {
            gl.glClear(GL.GL_COLOR_BUFFER_BIT);
            gl.glColor3d(0.13, 0.56, 0.13);
            gl.glBegin(GL2GL3.GL_QUADS);
            gl.glVertex2d(posA.x, posA.y);
            gl.glVertex2d(posB.x, posB.y);
            gl.glVertex2d(posC.x, posC.y);
            gl.glVertex2d(posD.x, posD.y);
            gl.glEnd();
        } else {
            Figures.renderLine(gl, posA, posB, (float) 0.05);
            Figures.renderLine(gl, posB, posC, (float) 0.05);
            Figures.renderLine(gl, posC, posD, (float) 0.05);
            Figures.renderLine(gl, posD, posA, (float) 0.05);
        }
    }
}
