package Decorator;

/**
 * @author Zz1
 * @version 1.0
 * @date 2020/11/18 21:00
 */
abstract class Sheep{
    protected abstract String showAbility();
}
class XYY extends Sheep{
    @Override
    protected String showAbility() {
        return "正常能力";
    }
}
abstract class Apple extends Sheep{
    private Sheep sheep;//维护一个抽象构建对象
    public Apple(Sheep sheep) {
        this.sheep = sheep;
    }
    public Sheep getSheep(){
        return sheep;
    }
}
class RedApple extends Apple{
    public RedApple(Sheep sheep) {
        super(sheep);
    }
    @Override
    protected String showAbility() {
        return getSheep().showAbility()+" 有了保护罩";
    }
}
class YellowApple extends Apple{
    public YellowApple(Sheep sheep) {
        super(sheep);
    }

    @Override
    protected String showAbility() {
        return getSheep().showAbility()+" 可以趟水跑";
    }
}
class GreenApple extends Apple{
    public GreenApple(Sheep sheep) {
        super(sheep);
    }

    @Override
    protected String showAbility() {
        return getSheep().showAbility() + " 加速跑";
    }
}
public class Client {
    public static void main(String[] args) {
        Sheep sheep = new XYY();
        System.out.println(sheep.showAbility());
        Apple apple = new YellowApple(sheep);
        System.out.println(apple.showAbility());
        Apple apple1 = new GreenApple(apple);
        System.out.println(apple1.showAbility());
    }
}
