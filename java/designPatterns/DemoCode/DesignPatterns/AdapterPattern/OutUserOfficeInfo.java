package DesignPatterns.AdapterPattern;

import java.util.HashMap;
import java.util.Map;

public class OutUserOfficeInfo implements IOutUserOfficeInfo {

    @Override
    public Map getUserOfficeInfo() {
        HashMap<String, String> officeInfo = new HashMap<>();
        officeInfo.put("officeTelNumber", "office telnumber");
        officeInfo.put("jobPosition", "job position");
        return officeInfo;
    }
    
}