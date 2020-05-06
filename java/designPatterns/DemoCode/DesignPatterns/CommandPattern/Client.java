package DesignPatterns.CommandPattern;

public class Client {

    public static void main(String[] args) {
        // 定义负责人
        Invoker joker = new Invoker();
        // 客户提出一个新的需求
        System.out.println("--------------------客户要求增加一个新的需求---------");
        // 需求变动，准备删除一个页面
        // Command command = new AddRequirementCommand();
        // 修改一行代码即可
        Command command = new DeletePageCommand();
        joker.setCommand(command);
        joker.action();
    }
}