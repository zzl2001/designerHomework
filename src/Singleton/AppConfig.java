package Singleton;

/**
 * @author Zz1
 * @version 1.0
 * @date 2020/11/17 19:02
 *
 * 单例模式实现 确保一个类只有一个实例
 * 优点：
 * 1、提供了对唯一实例的受控访问
 * 2、由于系统中只存在一个对象，因此可以节约系统资源，对于频繁创建和删除的对象使用单例模式肯定好
 * 3、允许可变数目的实例
 */
public class AppConfig {
    private String ParameterA; // 参数A
    private static AppConfig appConfig;
    // 构造函数
    private AppConfig() {
    }
    public static AppConfig getInstance(){
        // 1、如果在main方法调用本类的非静态方法 必须先new一个本类的对象，通过这个实例调用
        // 2、在需要调用的方法前加static
        if (appConfig == null) {
            appConfig = new AppConfig();
        }
        return appConfig;
    }
    private void setParameterA(String parameter){// 设置参数
        this.ParameterA = parameter;
    }
    private void getParameterA(){// 得到参数
        System.out.println(this.ParameterA);
    }
    public static void main(String[] args) {
        AppConfig a1, a2; //声明对象
        a1 = getInstance();// 实例化对象
        a2 = getInstance();
        a1.setParameterA("A1"); //从A1设置参数
        a2.getParameterA(); // 从A2得到参数
        if (a1 == a2) {
            System.out.println("一样");
        }
    }
}
