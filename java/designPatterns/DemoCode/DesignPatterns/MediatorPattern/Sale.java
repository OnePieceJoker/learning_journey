package DesignPatterns.MediatorPattern;

import java.util.Random;

public class Sale extends AbstractColleague {

    public Sale(AbstractMediator _mediator) {
        super(_mediator);
    }

    public int getSaleStatus() {
        Random random = new Random(System.currentTimeMillis());
        int saleStatus = random.nextInt(100);
        System.out.println("IBM电脑的销售情况为:" + saleStatus);
        return saleStatus;
    }

    public void offSale() {
        super.mediator.execute("sale.offsell");
    }

    public void sellIBMComputer(int number) {
        super.mediator.execute("sale.sell", number);
        System.out.println("销售电脑" + number + "台");
    }
}