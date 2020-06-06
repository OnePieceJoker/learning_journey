package DesignPatterns.AdapterPattern;

import java.util.HashMap;
import java.util.Map;

public class OutUserHomeInfo implements IOutUserHomeInfo {

    @Override
    public Map getUserHomeInfo() {
        HashMap<String, String> userHomeInfo = new HashMap<>();
        userHomeInfo.put("homeTelNumber", "home telnumebr");
        userHomeInfo.put("homeAddress", "home address");
        return userHomeInfo;
    }
    
}