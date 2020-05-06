package DesignPatterns.CommandPattern;

/**
 *
 * @author Mr.Joker
 * @date 2020/05/06
 * @time 23:39:46
 * @description 命令模式：命令类
 */
public abstract class Command {

    // 定义组
    protected final RequirementGroup rg;
    protected final PageGroup pg;
    protected final CodeGroup cg;

    public Command(RequirementGroup rg, PageGroup pg, CodeGroup cg) {
        this.rg = rg;
        this.pg = pg;
        this.cg = cg;
    }

    // 定义执行方法
    public abstract void execute();
    
}