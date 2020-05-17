package DesignPatterns.DecoratorPattern;

public class HignScoreDecorator extends Decorator {

    public HignScoreDecorator(SchoolReport sr) {
        super(sr);
    }

    // 汇报最高成绩
    private void reportHighScore() {
        System.out.println("汇报最高的成绩");
    }

    @Override
    public void report() {
        this.reportHighScore();
        super.report();
    }
}