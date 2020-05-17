package DesignPatterns.DecoratorPattern;

public class FourthGradeSchoolReport extends SchoolReport {

    @Override
    public void report() {
        System.out.println("尊敬的XXX家长:");
        System.out.println(" .....");
        System.out.println("语文 68 数学 70 英语 60");
        System.out.println(".....");
        System.out.println("家长签名：");
    }

    @Override
    public void sign(String name) {
        System.out.println("     " + name);
    }

}