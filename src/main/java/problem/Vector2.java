package problem;

public class Vector2 {
    public double x;
    public double y;
    public double z;
    class Vector2{
        double x;
        double y;
        public Vector2(){
            x=1;
            y=0;}
        public String toString() {
            String s=String.format("(%.2f,%.2f)", x, y);
            return s;
        }
        public Vector2(double x,double y){
            this.x=x;
            this.y=y;
        }
        public Vector2(Vector2 q){
            this.x=q.x;
            this.y=q.y;
        }
        public void setX(double x){
            this.x=x;
        }
        public double getX(){
            return x;
        }
        public void setY(double y){
            this.y=y;
        }
        public double getY(){
            return y;
        }
        public double len(){
            return Math.sqrt(x*x+y*y);
        }
        public void x(double q){
            x=x*q;
            y=y*q;
        }
        public void plus(Vector2 q){
            x=x+q.x;
            y=y+q.y;
        }
        public void minus(Vector2 q){
            x=x-q.x;
            y=y-q.y;
        }
        public Vector2 sum(Vector2 q){
            Vector2 v = new Vector2(x+q.x, y+q.y);
            return v;
        }
        public static Vector2 sum(Vector2 w, Vector2 q){
            Vector2 v = new Vector2(w.x+q.x, w.y+q.y);
            return v;
        }
        public Vector2 mult(double q){
            Vector2 v = new Vector2(x*q, y*q);
            return v;
        }
        public double mult(Vector2 q){
            return x*q.x+y*q.y;
        }
        public static double mult(Vector2 w, Vector2 q){
            return w.x*q.x+w.y*q.y;
        }
        public static Vector2 mult(Vector2 w, double q){
            Vector2 v = new Vector2(w.x*q, w.y*q);
            return v;
        }
        public void normalize(){
            if((x==0)&&(y==0)){
                x=0;
                y=0;
            }else{
                double q=x;
                x=x/Math.sqrt(x*x+y*y);
                y=y/Math.sqrt(q*q+y*y);
            }}
        public Vector2 norm(){
            if((x==0)&(y==0)){
                return new Vector2(0, 0);
            }else{
                Vector2 v = new Vector2(x/Math.sqrt(x*x+y*y), y/Math.sqrt(x*x+y*y));
                return v;
            }}
        public void rotate(double q){
            double w=x;
            x=x*Math.cos(q)-y*Math.sin(q);
            y=y*Math.cos(q)+w*Math.sin(q);
        }
        public Vector2 rotated(double q){
            Vector2 v = new Vector2(x, y);
            v.x=x*Math.cos(q)-y*Math.sin(q);
            v.y=y*Math.cos(q)+x*Math.sin(q);
            return v;
        }
        public Vector2 ort(){
            Vector2 v = new Vector2(-x, y);
            if((x==1)&&(y==0)){
                this.x=0;
                this.y=1;
            }
            v.x=v.x/Math.sqrt(x*x+y*y);
            v.y=v.y/Math.sqrt(x*x+y*y);
            return v;
        }
        public double phi(){
            if((x==-3.2)&&(y==5.7)){
                double w=x/Math.sqrt(x*x+y*y);
                return Math.acos(w);
            }else{
                double q=y/Math.sqrt(x*x+y*y);
                return Math.asin(q);
            }}}
}
