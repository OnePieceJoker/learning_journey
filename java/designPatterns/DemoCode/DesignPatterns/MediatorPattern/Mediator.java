package DesignPatterns.MediatorPattern;

public class Mediator extends AbstractMediator {

    @Override
    public void execute(String str, Object... objects) {
        if ("purchase.buy".equals(str)) {
            // 采购电脑
            this.buyComputer((Integer) objects[0]);
        } else if ("sale.sell".equals(str)) {
            // 销售电脑
            this.sellComputer((Integer) objects[0]);
        } else if ("sale.offsell".equals(str)) {
            this.offSell();
        } else if ("stock.clear".equals(str)) {
            this.clearStock();
        }
    }

    private void buyComputer(int number) {
        int saleStatus = super.sale.getSaleStatus();
        if (saleStatus > 80) {
            System.out.println("采购IBM电脑" + number + "台");
            super.stock.increase(number);
        } else {
            int buyNumber = number / 2;
            System.out.println("采购IBM电脑: " + buyNumber + "台");
            super.stock.increase(buyNumber);
        }
    }

    private void sellComputer(int number) {
        if (super.stock.getStockNumber() < number) {
            super.purchase.buyIBMComputer(number);
        }
        super.stock.decrease(number);
    }

    private void offSell() {
        System.out.println("折价销售IBM电脑" + super.stock.getStockNumber() + "台");
    }

    private void clearStock() {
        super.sale.offSale();
        super.purchase.refuseBuyIBM();
    }

}