package problem;

import javax.media.opengl.GL2;

public class Figures {
    public static void renderPoint(GL2 gl,Vector2 pos){gl.glVertex3d(pos.x, pos.y,pos.z);};
}
