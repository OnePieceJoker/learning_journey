package DesignPatterns.CommandPattern;

/**
 *
 * @author Mr.Joker
 * @date 2020/05/06
 * @time 23:42:02
 * @description 具体的命令模式
 */
public class AddRequirementCommand extends Command {

    public AddRequirementCommand() {
        super(new RequirementGroup(), new PageGroup(), new CodeGroup());
    }

    public AddRequirementCommand(RequirementGroup rg, PageGroup pg, CodeGroup cg) {
        super(rg, pg, cg);
    }

    @Override
    public void execute() {
        super.rg.find();
        super.rg.add();
        super.rg.plan();
    }
    
}