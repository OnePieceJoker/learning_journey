package DesignPatterns.AdapterPattern;

import java.util.Map;

/**
 *
 * @author Mr.Joker
 * @date 2020/06/06
 * @time 17:20:36
 * @description 类适配器，通过类继承的方式来达到适配的目的
 */
public class OuterUserInfo extends OuterUser implements IUserInfo {

    private Map baseInfo = super.getUserBaseInfo();
    private Map homeInfo = super.getUserHomeInfo();
    private Map officeInfo = super.getUserOfficeInfo();

    @Override
    public String getUserName() {
        String userName = (String) baseInfo.get("userName");
        System.out.println(userName);
        return userName;
    }

    @Override
    public String getHomeAddress() {
        String homeAddress = (String) homeInfo.get("homeAddress");
        System.out.println(homeAddress);
        return homeAddress;
    }

    @Override
    public String getMobilePhone() {
        String mobilePhone = (String) baseInfo.get("mobileNumber");
        System.out.println(mobilePhone);
        return mobilePhone;
    }

    @Override
    public String getOfficeTelNumber() {
        String officeTelNumber = (String) officeInfo.get("officeTelNumebr");
        System.out.println(officeTelNumber);
        return officeTelNumber;
    }

    @Override
    public String getJobPositon() {
        String jobPosition = (String) officeInfo.get("jobPosition");
        System.out.println(jobPosition);
        return jobPosition;
    }

    @Override
    public String getHomeTelNumber() {
        String homeTelNumber = (String) homeInfo.get("homeTelNumber");
        System.out.println(homeTelNumber);
        return homeTelNumber;
    }
    
}