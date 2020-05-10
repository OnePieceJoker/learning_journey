package DesignPatterns.ChainofResponsibilityPattern;

public class Women implements IWomen {

    // 通过一个int类型的参数来描述妇女的个人状况
    // 1-- 未出嫁
    // 2-- 出嫁
    // 3-- 夫死
    private int type = 0;

    private String request = "";

    public Women(int _type, String _request) {
        this.type = _type;
        switch (this.type) {
            case 1:
                this.request = "女儿的请示是：" + _request;
                break;
            case 2:
                this.request = "妻子的请示是: " + _request;
                break;
            case 3:
                this.request = "母亲的请示是: " + _request;
        }
    }
    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String getRequest() {
        return this.request;
    }
    
}