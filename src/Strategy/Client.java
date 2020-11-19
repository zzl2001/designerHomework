package Strategy;

/**
 * @author Zz1
 * @version 1.0
 * @date 2020/11/19 18:15
 */
interface Strategy{
    public void discount();
}
class Computer implements Strategy{
    @Override
    public void discount() {
        System.out.println("计算机7折");
    }
}
class English implements Strategy{
    @Override
    public void discount() {
        System.out.println("英语6折");
    }
}
class Bookstore {
    Strategy strategy;
    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
    public void bookStrategy(){
        strategy.discount();
    }
}
public class Client {
    public static void main(String[] args) {
        Strategy strategy = new Computer();
        Bookstore bookstore = new Bookstore();
        bookstore.setStrategy(strategy);
        bookstore.bookStrategy();
    }
}
