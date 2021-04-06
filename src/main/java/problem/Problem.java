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
        if (points.size() > 500) {
            System.out.println("Введённое количество точек велико, поэтому программа может работать не мгновенно");
        }
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
                    Circle circle = triangle.tcircle(triangle);
                    circles.add(circle);
                    if (circle.plcircle(points, circle) > P) {
                        rescircle = circle;
                    }
                }
            }
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
        //Figures.renderCircle(gl, new Vector2(0.5, 0.5), 0.2, 400, true);
        // Triangle triangle = new Triangle(new Vector2(0.5, 0), new Vector2(-0.5, 0), new Vector2(0, 0.5));
        // Figures.renderQuad(gl, new Vector2(0.5, 0.5), new Vector2(0.5, -0.5), new Vector2(-0.5, -0.5), new Vector2(-0.5, 0.5), false);
        if (rescircle != null) {
            gl.glColor4f(1.0f, 0.0f, 1.0f, 0.0f);
            rescircle.render(gl);
            for (Point point : points) {
                if ((point.x - rescircle.center.x) * (point.x - rescircle.center.x) +
                        (point.y - rescircle.center.y) * (point.y - rescircle.center.y) <= rescircle.rad * rescircle.rad) {
                    Circle circle = new Circle(new Vector2(point.x, point.y), 0.01);
                    gl.glColor4f(0.0f, 1.0f, 1.0f, 1.0f);
                    circle.render(gl);
                }
            }
        }
        //Figures.renderCircle(gl, new Vector2(0.5, 0.5), 0.2, 400, true);
    }
}