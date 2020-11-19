package Adapter;

import com.sun.javaws.IconUtil;

/**
 * @author Zz1
 * @version 1.0
 * @date 2020/11/18 20:04
 */
abstract class Graphics{
    public abstract void Draw();
}
class Circle extends Graphics{
    @Override
    public void Draw() {
        System.out.println("Draw a circle");
    }
}
class Rectangle extends Graphics{
    @Override
    public void Draw() {
        System.out.println("Draw a rectangle");
    }
}
class Line extends Graphics{
    @Override
    public void Draw() {
        System.out.println("Draw a line");
    }
}
class Adapter extends Graphics{
    private Angle angle = new Angle();
    @Override
    public void Draw() {
        angle.DrawAngle();
    }
}
class Angle{
    public void DrawAngle(){
        System.out.println("Draw an angle");
    }
}
public class Client {
    public static void main(String[] args) {
        Graphics a = new Adapter();
        a.Draw();
    }
}
