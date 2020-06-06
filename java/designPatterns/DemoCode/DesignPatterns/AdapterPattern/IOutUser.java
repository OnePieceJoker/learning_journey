package DesignPatterns.AdapterPattern;

import java.util.Map;

public interface IOutUser {
    public Map getUserBaseInfo();
    public Map getUserOfficeInfo();
    public Map getUserHomeInfo();
}