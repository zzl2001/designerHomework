package Factory;

/**
 * @author Zz1
 * @version 1.0
 * @date 2020/11/17 20:50
 * TODO 使用反射机制解耦
 */
abstract class Laptop{ // 角色1 抽象产品类Laptop
    public abstract void create();
}
class HPLaptop extends Laptop{//角色2 具体产品
    @Override
    public void create() {
        System.out.println("生成惠普电脑");
    }
}
class LenovoLaptop extends Laptop{
    @Override
    public void create() {
        System.out.println("生成联想电脑");
    }
}
class AcerLaptop extends Laptop{
    @Override
    public void create() {
        System.out.println("生成外星人电脑");
    }
}
class DellLaptop extends Laptop{
    @Override
    public void create() {
        System.out.println("生成戴尔电脑");
    }
}
abstract class Creator{//角色3 抽象工厂
    public abstract Laptop factoryMethod();
}

class HPCreator extends Creator{//角色4 具体工厂
    @Override
    public Laptop factoryMethod() {
        return new HPLaptop();
    }
}
class LenovoCreator extends Creator{
    @Override
    public Laptop factoryMethod() {
        return new LenovoLaptop();
    }
}
class AcerCreator extends Creator{
    @Override
    public Laptop factoryMethod() {
        return new AcerLaptop();
    }
}
class DellCreator extends Creator{
    @Override
    public Laptop factoryMethod() {
        return new DellLaptop();
    }
}

public class Client {
    public static void main(String[] args) {
        try{
            Creator creator = new LenovoCreator();
            Laptop lenovoLaptop = creator.factoryMethod();
            lenovoLaptop.create();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
