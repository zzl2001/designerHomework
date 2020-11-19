package AbstractFactory;

/**
 * @author Zz1
 * @version 1.0
 * @date 2020/11/18 17:46
 */
abstract class Hamburg{//产品1
    public abstract void create();
}
class MHamburg extends Hamburg{//具体哪家的汉堡
    @Override
    public void create() {
        System.out.println("M汉堡");
    }
}
class KFCHamburg extends Hamburg{//具体哪家的汉堡
    @Override
    public void create() {
        System.out.println("KFC可乐");
    }
}
abstract class Cola{//产品2
    public abstract void create();
}
class MCola extends Cola{//具体哪家的可乐
    @Override
    public void create() {
        System.out.println("M可乐");
    }
}
class KFCCola extends Cola{//具体哪家的可乐
    @Override
    public void create() {
        System.out.println("KFC可乐");
    }
}
abstract class IFactory{//抽象工厂
    public abstract Hamburg CreateHamburg();//生产汉堡
    public abstract Cola CreateCola();//生成可乐
}
class KFCFactory extends IFactory{// 具体工程KFC
    @Override
    public Hamburg CreateHamburg() {
        return new KFCHamburg();
    }
    @Override
    public Cola CreateCola() {
        return new KFCCola();
    }
}
class MCFactory extends IFactory{// 具体工厂MC
    @Override
    public Hamburg CreateHamburg() {
        return new MHamburg();
    }
    @Override
    public Cola CreateCola() {
        return new MCola();
    }
}
public class Client {
    public static void main(String[] args) {
        IFactory shopFactory = new MCFactory();
        IFactory shopFactory1 = new KFCFactory();
        Hamburg hamburg = shopFactory.CreateHamburg();
        hamburg.create();
        Cola cola = shopFactory1.CreateCola();
        cola.create();
    }
}
