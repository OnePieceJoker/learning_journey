package DesignPatterns.CommandPattern;

public class DeletePageCommand extends Command {

    public DeletePageCommand() {
        super(new RequirementGroup(), new PageGroup(), new CodeGroup());
    }

    public DeletePageCommand(RequirementGroup rg, PageGroup pg, CodeGroup cg) {
        super(rg, pg, cg);
    }

    @Override
    public void execute() {
        super.pg.find();
        super.pg.delete();
        super.pg.plan();
    }
    
}