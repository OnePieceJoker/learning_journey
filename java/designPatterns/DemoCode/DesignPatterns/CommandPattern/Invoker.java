package DesignPatterns.CommandPattern;

/**
 *
 * @author Mr.Joker
 * @date 2020/05/06
 * @time 23:44:31
 * @description 负责人
 */
public class Invoker {
    
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    // 执行客户的命令
    public void action() {
        this.command.execute();
    }
}