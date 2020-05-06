package DesignPatterns.CommandPattern;

public class RequirementGroup extends Group {

    @Override
    public void find() {
        System.out.println("找到了需求组....");
    }

    @Override
    public void add() {
        System.out.println("客户要求增加一个需求");
    }

    @Override
    public void delete() {
        System.out.println("客户要求删除一个需求");
    }

    @Override
    public void change() {
        System.out.println("客户要求修改一个需求");
    }

    @Override
    public void plan() {
        System.out.println("客户要求需求变更计划");
    }

    @Override
    public void rollback() {
        System.out.println("进行回滚操作");
    }
    
}