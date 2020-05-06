package DesignPatterns.CommandPattern;

public abstract class Group {

    public abstract void find();

    public abstract void add();

    public abstract void delete();

    public abstract void change();

    public abstract void plan();

    // 命令模式扩展：反悔问题
    // 增加一个命令，用于处理任务回退
    public abstract void rollback();
    
}