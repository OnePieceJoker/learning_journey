package DesignPatterns.AdapterPattern;

public class Client {
    
    public static void main(String[] args) {
        IUserInfo youngGirl = new UserInfo();
        youngGirl.getMobilePhone();

        IUserInfo outerYoungGirl = new OuterUserInfo();
        outerYoungGirl.getMobilePhone();

        // 对象适配器
        IOutUserBaseInfo baseInfo = new OutBaseUserInfo();
        IOutUserHomeInfo homeInfo = new OutUserHomeInfo();
        IOutUserOfficeInfo officeInfo = new OutUserOfficeInfo();

        IUserInfo youngGirl2 = new OutUserInfo(homeInfo, baseInfo, officeInfo);
        youngGirl2.getMobilePhone();
    }
}