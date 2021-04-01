package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс задачи
 */
public class Problem {
    /**
     * текст задачи
     */
    public static final String PROBLEM_TEXT = "ПОСТАНОВКА ЗАДАЧИ:\n" +
            "Задано множество точек плоскости.\n" +
            "Требуется построить окружность, содержащую внутри себя хотя\n" +
            " бы две точки множества, имеющую наибольшую плотность точек\n" +
            " внутри себя.";

    /**
     * заголовок окна
     */
    public static final String PROBLEM_CAPTION = "Итоговый проект ученика 10-1 Ривина Дмитрия";

    /**
     * путь к файлу
     */
    private static final String FILE_NAME = "points.txt";

    /**
     * список точек
     */
    private ArrayList<Point> points;
    private ArrayList<Circle> circles;
    private Circle circle;
    private Triangle triangle;
    private Circle rescircle;

    /**
     * Конструктор класса задачи
     */
    public Problem() {
        points = new ArrayList<>();
        circles = new ArrayList<>();
    }

    /**
     * Добавить точку
     *
     * @param x координата X точки
     * @param y координата Y точки
     */
    public void addPoint(double x, double y) {
        Point point = new Point(x, y);
        points.add(point);
    }

    /**
     * Решить задачу
     */
    public void solve() {
        // перебираем пары точек
        for (Point p : points) {
            for (Point p2 : points) {
                // если точки являются разными
                if (p != p2) {
                    // если координаты у них совпадают
                    if (Math.abs(p.x - p2.x) < 0.0001 && Math.abs(p.y - p2.y) < 0.0001) {
                        p.isSolution = true;
                        p2.isSolution = true;
                    }
                }
            }
        }
        int P = -100;
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size() && j != i; j++) {
                for (int r = 0; r < points.size() && r != i && r != j; r++) {
                    Triangle triangle = new Triangle(new Vector2(points.get(i).x, points.get(i).y), new Vector2(points.get(j).x, points.get(j).y), new Vector2(points.get(r).x, points.get(r).y));
                    Circle circle = triangle.tcircle(triangle); circles.add(circle);
                    if (circle.plcircle(points, circle) > P) {
                        rescircle = circle;
                    }
                }
            }
            //circle = new Circle( new Vector2(0.5, 0.5), 0.3);
            //Triangle triangle = new Triangle(new Vector2(0.5, 0), new Vector2(-0.5, 0), new Vector2(0, 0.5));
//ArrayList<Point>
            // Circle circle= triangle.tcircle(triangle);
        }
    }

    /**
     * Загрузить задачу из файла
     */
    public void loadFromFile() {
        points.clear();
        try {
            File file = new File(FILE_NAME);
            Scanner sc = new Scanner(file);
            // пока в файле есть непрочитанные строки
            while (sc.hasNextLine()) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                sc.nextLine();
                Point point = new Point(x, y);
                points.add(point);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения из файла: " + ex);
        }
    }

    /**
     * Сохранить задачу в файл
     */
    public void saveToFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME));
            for (Point point : points) {
                out.printf("%.2f %.2f %d\n", point.x, point.y, point.setNumber);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл: " + ex);
        }
    }

    /**
     * Добавить заданное число случайных точек
     *
     * @param n кол-во точек
     */
    public void addRandomPoints(int n) {
        for (int i = 0; i < n; i++) {
            Point p = Point.getRandomPoint();
            points.add(p);
        }
    }

    /**
     * Очистить задачу
     */
    public void clear() {
        points.clear();
        circles.clear();
        rescircle = null;
        circle = null;
    }

    /**
     * Нарисовать задачу
     *
     * @param gl переменная OpenGL для рисования
     */
    public void render(GL2 gl) {
        for (Point point : points) {
            point.render(gl);
        }
           // Triangle triangle = new Triangle(new Vector2(0.5, 0), new Vector2(-0.5, 0), new Vector2(0, 0.5));
//ArrayList<Point>
            //Circle circle= triangle.tcircle(triangle);
       // Figures.renderQuad(gl, new Vector2(0.5, 0.5), new Vector2(0.5, -0.5), new Vector2(-0.5, -0.5), new Vector2(-0.5, 0.5), false);
        Figures.renderTriangle(gl, new Vector2(0.5, 0.5), new Vector2(0.0, 0.5), new Vector2(0.0, 0.0), false, new Color(0.5, 0.5, 0.1));
            if(rescircle!=null){
                rescircle.render(gl);
            }
            }
       // Triangle triangle = new Triangle(new Vector2(0.5, 0), new Vector2(-0.5, 0), new Vector2(0, 0.5));
       //circle = triangle.tcircle(triangle);
        //if (triangle.tcircle(triangle) != null){
        //    triangle.tcircle(triangle).render(gl);}
//        Triangle triangle = new Triangle(new Vector2(0.1,0.2),new Vector2(-0.5,0.1),new Vector2(0.5,-0.8));
//        triangle.render(gl);
//        Figures.renderPoint(gl, new Vector2(-0.5, 0.3), 3);
//        Figures.renderLine(gl, new Vector2(-0.6 ,-0.8), new Vector2(0.3, 0.1), 5);
//        Figures.renderCircle(gl, new Vector2(0.25, 0.45), 0.3,  200);
//        Figures.renderTriangles(gl, new Triangle(new Vector2(0.87, 0.3),new Vector2(0.67, 0.21),new Vector2(0.45, 0.4)), new Color(0.5, 0.5, 0.5));
    }
    //Triangle triangle = new Triangle(new Vector2(0.5, 0), new Vector2(-0.5, 0), new Vector2(0, 0.5));
    //public double tcircle(Triangle triangle){
      //  double D=2*(triangle.a.x*(triangle.b.y-triangle.c.y)+triangle.b.x*(triangle.c.y-triangle.a.y)+triangle.c.x*(triangle.a.y-triangle.b.y));
     //   Vector2 ce= new Vector2 ((((triangle.a.x*triangle.a.x)+(triangle.a.y*triangle.a.y))*(triangle.b.y-triangle.c.y)+((triangle.b.x*triangle.b.x)+(triangle.b.y*triangle.b.y))*(triangle.c.y-triangle.a.y)+((triangle.c.x*triangle.c.x)+(triangle.c.y*triangle.c.y))*(triangle.a.y-triangle.b.y))/D,
     //           ((triangle.a.x*triangle.a.x)+(triangle.a.y*triangle.a.y))*(triangle.c.x-triangle.b.x)+((triangle.b.x*triangle.b.x)+(triangle.b.y*triangle.b.y))*(triangle.a.x-triangle.c.x)+((triangle.c.x*triangle.c.x)+(triangle.c.y*triangle.c.y))*(triangle.b.x-triangle.a.x)/D);
     //   double r= Vector2.tdist(ce, triangle.a);
    //    Circle circle = new Circle(ce, r);
    //    return (r);
    //}