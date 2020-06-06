package DesignPatterns.AdapterPattern;

import java.util.HashMap;
import java.util.Map;

public class OuterUser implements IOutUser {

    @Override
    public Map getUserBaseInfo() {
        HashMap<String, String> baseUserInfoMap = new HashMap<>();
        baseUserInfoMap.put("userName", "user name");
        baseUserInfoMap.put("mobileNumber", "mobile number");
        return baseUserInfoMap;
    }

    @Override
    public Map getUserHomeInfo() {
        HashMap<String, String> officeInfoMap = new HashMap<>();
        officeInfoMap.put("homeTelNumber", "home telephone");
        officeInfoMap.put("homeAddress", "home address");
        return officeInfoMap;
    }

    @Override
    public Map getUserOfficeInfo() {
        HashMap<String, String> userOfficeInfoMap = new HashMap<>();
        userOfficeInfoMap.put("jobPosition", "jobPosition");
        userOfficeInfoMap.put("officeTelNumber", "office telephone");
        return userOfficeInfoMap;
    }
    
}