package DesignPatterns.SingletonPattern;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mr.Joker
 * @date 2020/04/12
 * @time 20:18:04
 * @description 单例模式的扩展，有上限的多例模式
 */
public class Emperor {

    // 定义最多能产生的实例数量
    private static int maxNumOfEmperor = 2;

    private static ArrayList<String> nameList = new ArrayList<String>();

    private static ArrayList<Emperor> emperorList = new ArrayList<Emperor>();

    // 当前实例序列号
    private static int countNumOfEmperor = 0;

    // 产生所有的对象
    static {
        for (int i = 0; i < maxNumOfEmperor; i++) {
            emperorList.add(new Emperor("皇" + (i + 1) + "帝"));
        }
    }

    private Emperor() {}

    private Emperor(String name) {
        nameList.add(name);
    }

    // 随机获取一个对象
    public static Emperor getInstance() {
        Random random = new Random();
        countNumOfEmperor = random.nextInt(maxNumOfEmperor);
        return emperorList.get(countNumOfEmperor);
    }

    public static void say() {
        System.out.println(nameList.get(countNumOfEmperor));
    }
}