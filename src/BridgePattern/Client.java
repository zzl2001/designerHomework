package BridgePattern;

import java.util.Date;

/**
 * @author Zz1
 * @version 1.0
 * @date 2020/11/18 20:43
 */
interface Coffee{// 接口
    public void Make();
}
class Milk implements Coffee{
    @Override
    public void Make() {
        System.out.println("Add Milk");
    }
}
class Sugar implements Coffee{
    @Override
    public void Make() {
        System.out.println("Add Suger");
    }
}
class Lemon implements Coffee{
    @Override
    public void Make() {
        System.out.println("Add Lemon");
    }
}
abstract class Different{
    protected Coffee coffee;
    public void SetCoffee(Coffee coffee){
        this.coffee = coffee;
    }
    public abstract void Make();
}
class SmallCoffee extends Different{
    @Override
    public void Make() {
        coffee.Make();
    }
}
class MediaCoffee extends Different{
    @Override
    public void Make() {
        coffee.Make();
    }
}
class BigCoffee extends Different{
    @Override
    public void Make() {
        coffee.Make();
    }
}

public class Client {
    public static void main(String[] args) {
        Different different = new BigCoffee();
        different.SetCoffee(new Lemon());
        different.Make();
    }
}
