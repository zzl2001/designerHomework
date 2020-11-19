package Builder;

/**
 * @author Zz1
 * @version 1.0
 * @date 2020/11/18 18:09
 */
class Car{
    private String Wheel;
    private String OilBox;
    private String Body;

    public String getWheel() {
        return Wheel;
    }

    public void setWheel(String wheel) {
        Wheel = wheel;
    }

    public String getOilBox() {
        return OilBox;
    }

    public void setOilBox(String oilBox) {
        OilBox = oilBox;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    @Override
    public String toString() {
        return "Car[wheel=" + Wheel + ",OilBox="+OilBox+",Body="+Body+"]" ;
    }
}
abstract class Builder{
    protected Car car = new Car(); //builder 构建
    public abstract void BuildWheel();
    public abstract void BuildOilBox();
    public abstract void BuildBody();
    public Car GetResult(){
        return car;
    };
}
class BMWBuilder extends Builder {

    @Override
    public void BuildWheel() {
        car.setWheel("BMW生成wheel");
    }

    @Override
    public void BuildOilBox() {
        car.setOilBox("BMW生成oilBox");
    }

    @Override
    public void BuildBody() {
        car.setBody("BMW生成body");
    }
}
class BenZBuilder extends Builder{

    @Override
    public void BuildWheel() {
        car.setWheel("Benz生成wheel");
    }

    @Override
    public void BuildOilBox() {
        car.setOilBox("Benz生成oilBox");
    }

    @Override
    public void BuildBody() {
        car.setBody("Benz生成body");
    }
}
class Director{//聚合builder对象，指挥产品建造过程
    private Builder builder;
    public void setBuilder(Builder builder){
        this.builder = builder;
    }
    public Car getCar(){
        builder.BuildBody();
        builder.BuildOilBox();
        builder.BuildWheel();
        return builder.GetResult();
    }
}
public class Client {
    private static Director director;

    public static void main(String[] args) {
        Builder builder = new BenZBuilder();
        director = new Director();
        director.setBuilder(builder);
        Car car = director.getCar();
        System.out.println(car.toString());
    }
}
