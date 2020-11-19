package Facade;

/**
 * @author Zz1
 * @version 1.0
 * @date 2020/11/19 18:02
 */
class Camera{
    public void on(){
        System.out.println("录像机打开");
    }
    public void close(){
        System.out.println("录像机关闭");
    }
}
class Light{
    public void on(){
        System.out.println("灯打开");
    }
    public void close(){
        System.out.println("灯关闭");
    }
}
class Sensor{
    public void on(){
        System.out.println("感应器打开");
    }
    public void close(){
        System.out.println("感应器关闭");
    }
}
class Alarm{
    public void on(){
        System.out.println("警报器打开");
    }
    public void close(){
        System.out.println("警报器关闭");
    }
}
class Facade{
    private Camera camera;
    private Light light;
    private Sensor sensor;
    private Alarm alarm;

    public Facade(){
        camera = new Camera();
        light = new Light();
        sensor = new Sensor();
        alarm = new Alarm();
    }

    public void on(){
        try{
            camera.on();
            light.on();
            sensor.on();
            alarm.on();
        }catch (Exception e){
            System.out.println("error");
        }
    }

    public void close(){
        try {
            camera.close();
            light.close();
            sensor.close();
            alarm.close();
        }catch (Exception e){
            System.out.println("error");
        }
    }
}
public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.on();
        System.out.println("启动成功");
        facade.close();
        System.out.println("关闭了");
    }
}
