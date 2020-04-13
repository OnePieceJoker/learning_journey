package DesignPatterns.FactoryPattern;

public class HumanFactory extends AbstractHumanFactory {

    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = (T)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("人类生成失败");
        }
        return (T)human;
    }

    /**
     *
     * @author Mr.Joker
     * @date 2020/04/13
     * @time 23:20:20
     * @description 简单工厂模式
     */
    public static <T extends Human> T createHumanBySimpleFactoryPattern(Class<T> c) {
        Human human = null;
        try {
            human = (T)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("人类生成失败");
        }
        return (T)human;
    }

    /**
     *
     * @author Mr.Joker
     * @date 2020/04/13
     * @time 23:24:34
     * @description 工厂模式的扩展：升级为多个工厂类，假设该类指定生成黄色人种
     */
    @Override
    public Human createHuman() {
        return new YellowHuman();
    }

}