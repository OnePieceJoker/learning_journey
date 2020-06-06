package DesignPatterns.AdapterPattern;

import java.util.HashMap;
import java.util.Map;

public class OutBaseUserInfo implements IOutUserBaseInfo {

    @Override
    public Map getUserBaseInfo() {
        HashMap<String, String> userBaseInfo = new HashMap<>();
        userBaseInfo.put("userName", "user name");
        userBaseInfo.put("mobilePhone", "mobile phone");
        return userBaseInfo;
    }
    
}