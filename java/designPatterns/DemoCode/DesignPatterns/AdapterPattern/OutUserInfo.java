package DesignPatterns.AdapterPattern;

import java.util.Map;

/**
 *
 * @author Mr.Joker
 * @date 2020/06/06
 * @time 17:21:26
 * @description 对象适配器：通过类关联来实现适配的目的
 */
public class OutUserInfo implements IUserInfo {

    private IOutUserHomeInfo homeInfo= null;
    private IOutUserBaseInfo baseInfo= null;
    private IOutUserOfficeInfo officeInfo= null;

    private Map baseMap = null;
    private Map homeMap = null;
    private Map officeMap = null;

    public OutUserInfo(IOutUserHomeInfo homeInfo, IOutUserBaseInfo baseInfo, IOutUserOfficeInfo officeInfo) {
        this.baseInfo = baseInfo;
        this.homeInfo = homeInfo;
        this.officeInfo = officeInfo;

        this.baseMap = this.baseInfo.getUserBaseInfo();
        this.homeMap = this.homeInfo.getUserHomeInfo();
        this.officeMap = this.officeInfo.getUserOfficeInfo();
    }
    @Override
    public String getUserName() {
        String userName = (String) baseMap.get("userName");
        System.out.println(userName);
        return userName;
    }

    @Override
    public String getHomeAddress() {
        String homeAddress = (String) homeMap.get("homeAddress");
        System.out.println(homeAddress);
        return homeAddress;
    }

    @Override
    public String getMobilePhone() {
        String mobilePhone = (String) baseMap.get("mobilePhone");
        System.out.println(mobilePhone);
        return mobilePhone;
    }

    @Override
    public String getOfficeTelNumber() {
        String officeTelNumber = (String) officeMap.get("officeTelNumber");
        System.out.println(officeTelNumber);
        return officeTelNumber;
    }

    @Override
    public String getJobPositon() {
        String jobPosition = (String) officeMap.get("jobPosition");
        System.out.println(jobPosition);
        return jobPosition;
    }

    @Override
    public String getHomeTelNumber() {
        String homeTelNumber = (String) homeMap.get("homeTelNumber");
        System.out.println(homeTelNumber);
        return homeTelNumber;
    }
    
}