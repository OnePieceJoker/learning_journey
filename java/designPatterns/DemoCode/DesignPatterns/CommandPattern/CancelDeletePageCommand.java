package DesignPatterns.CommandPattern;

/**
 *
 * @author Mr.Joker
 * @date 2020/05/07
 * @time 00:17:57
 * @description 命令模式扩展：反悔问题
 */
public class CancelDeletePageCommand extends Command {

    public CancelDeletePageCommand() {
        super(new RequirementGroup(), new PageGroup(), new CodeGroup());
    }

    public CancelDeletePageCommand(RequirementGroup rg, PageGroup pg, CodeGroup cg) {
        super(rg, pg, cg);
    }

    @Override
    public void execute() {
        super.rg.rollback();
    }
    
}