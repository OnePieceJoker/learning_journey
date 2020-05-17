package DesignPatterns.DecoratorPattern;

public class Father {

    public static void main(String[] args) {
        SchoolReport sr = null;
        // 原装的成绩单
        sr = new FourthGradeSchoolReport();
        // 加了最高分的成绩单
        sr = new HignScoreDecorator(sr);
        // 加了成绩排名的说明
        sr = new SortDecorator(sr);
        // 看成绩单
        sr.report();
        // 签名
        sr.sign("Joker");
    }
    
}