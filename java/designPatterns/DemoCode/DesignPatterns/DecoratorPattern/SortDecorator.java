package DesignPatterns.DecoratorPattern;

public class SortDecorator extends Decorator {

    public SortDecorator(SchoolReport sr) {
        super(sr);
    }

    private void reportSort() {
        System.out.println("对排名进行修饰");
    }

    @Override
    public void report() {
        this.reportSort();
        super.report();
    }
    
}