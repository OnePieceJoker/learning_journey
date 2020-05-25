package DesignPatterns.StrategyPattern;

/**
 *
 * @author Mr.Joker
 * @date 2020/05/25
 * @time 21:18:00
 * @description 策略枚举
 */
public enum Calculator {
    ADD("+") {
        public int exec(int a, int b) {
            return a + b;
        }
    },

    SUB("-") {
        public int exec(int a, int b) {
            return a - b;
        }
    };

    String value = "";

    private Calculator(String _value) {
        this.value = _value;
    }

    public String getValue() {
        return this.value;
    }

    public abstract int exec(int a, int b);
}