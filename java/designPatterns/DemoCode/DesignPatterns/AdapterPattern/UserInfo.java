package DesignPatterns.AdapterPattern;

public class UserInfo implements IUserInfo {

    @Override
    public String getUserName() {
        System.out.println("user name");
        return null;
    }

    @Override
    public String getHomeAddress() {
        System.out.println("home address");
        return null;
    }

    @Override
    public String getMobilePhone() {
        System.out.println("mobile phone");
        return null;
    }

    @Override
    public String getOfficeTelNumber() {
        System.out.println("office telnumber");
        return null;
    }

    @Override
    public String getJobPositon() {
        System.out.println("job position");
        return null;
    }

    @Override
    public String getHomeTelNumber() {
        System.out.println("home telnumber");
        return null;
    }
    
}