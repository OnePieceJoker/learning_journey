package DesignPatterns.PrototypePattern;

public class Mail implements Cloneable {

    private String receiver;
    
    private String subject;

    private String appellation;

    private String context;

    private String tail;

    public Mail(AdvTemplate advTemplate) {
        System.out.println("这里是new的对象:原型模式获取的对象不会执行构造函数");
        this.subject = advTemplate.getAdvSubject();
        this.context = advTemplate.getAdvContext();
    }

    @Override
    public Mail clone() {
        Mail mail = null;
        try {
            mail = (Mail) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return mail;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContext() {
        return this.context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTail() {
        return this.tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public String getAppellation() {
        return this.appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

}