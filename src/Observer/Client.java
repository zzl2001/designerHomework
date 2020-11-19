package Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zz1
 * @version 1.0
 * @date 2020/11/19 18:15
 */
abstract class Observer{ //观察者
    public abstract void update(Product product);//更新消息
}
abstract class Product{ // 被观察者
    private List<Observer> observers = new ArrayList<Observer>();
    public List<Observer> getObservers(){
        return observers;
    }
    public void notifyToAll(){
        for (Observer observer:observers){
            observer.update(this);
        }
    }
    public abstract void attach(Observer observer);
    public abstract void detach(Observer observer);
}
class ConcreateObserver extends Observer{// 具体观察者
    private String name;
    private String price;

    public ConcreateObserver(String name){
        this.name = name;
    }

    @Override
    public void update(Product product) {
        price = ((ConcreateProduct)product).getPrice();
        System.out.println(name + "商品变价为"+ price);
    }
}
class ConcreateProduct extends Product{
    private String price;
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    @Override
    public void attach(Observer observer) {
        getObservers().add(observer);
    }
    @Override
    public void detach(Observer observer) {
        getObservers().remove(observer);
    }//具体被观察者
}
public class Client {
    public static void main(String[] args) {
        Product product = new ConcreateProduct();

        ConcreateObserver observer1 = new ConcreateObserver("会员1");
        ConcreateObserver observer2 = new ConcreateObserver("会员2");

        product.attach(observer1);
        product.attach(observer2);

        ((ConcreateProduct) product).setPrice("香蕉三块五了");

        product.notifyToAll();

    }
}
// out
// 会员1商品变价为香蕉三块五了
// 会员2商品变价为香蕉三块五了
