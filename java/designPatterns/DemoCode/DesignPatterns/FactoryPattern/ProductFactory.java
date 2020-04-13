package DesignPatterns.FactoryPattern;

import java.util.HashMap;
import java.util.Map;

public class ProductFactory {
    
    private static final Map<String, Human> prMap = new HashMap<String, Human>();

    public static synchronized Human createProduct(String type) throws Exception {
        Human human = null;
        // 如果map中已经有这个对象
        if (prMap.containsKey(type)) {
            human = prMap.get(type);
        } else {
            if ("BlackHuman".equals(type)) {
                human = new BlackHuman();
            } else {
                human = new YellowHuman();
            }
            // 同时把对象放到缓存容器中
            prMap.put(type, human);
        }
        return human;
    }

}