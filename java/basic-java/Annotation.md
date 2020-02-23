# 注解

注解（也被称为元数据）为我们在代码中添加信息提供了一种形式化的方法，使我们可以在稍后某个时刻非常方便地使用这些数据。它提供了一种结构化的，并且具有类型检查能力的新途径，使用注解可以帮助我们避免编写累赘的部署描述文件，以及其他生成的文件。

## 基本语法

### 定义注解

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {}
```

> Note: 没有元素的注解成为标记注解，如上面的@Test注解

### 使用注解

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    public int id() default 0;
    public String description() default "no description";
}

public class Demo() {
    @UseCase(id = 47, description = "something")
    public void demoMethodOne() {}

    @UseCase(id = 48)
    public void demoMethodTwo() {}
}
```

### 元注解

Java内置了三种标准注解和四种元注解，元注解专职负责注解其他的注解。

#### 标准注解

- @Override：表示当前的方法定义将覆盖超类中的方法。

- @Deprecated：表示当前方法已被弃用，编译器会发出警告信息。

- @SuppressWarnings：忽略当前方法出现的警告信息。

#### 元注解

- @Target：表示该注解可以用于什么地方。

    可选的ElementType参数：

        CONSTRUCTOR: 构造器的声明

        FIELD: 域声明（包括enum实例）

        LOCAL_VARIABLE: 局部变量声明

        METHOD: 方法声明

        PACKAGE: 包声明

        PARAMETER: 参数声明

        TYPE: 类、接口（包括注解类型）或enum声明

- @Retention：表示需要在什么级别保存该注解信息。

    可选的RetentionPolicy参数:

        SOURCE: 注解将在编译器丢弃。

        CLASS: 注解在class文件中可用，但会被VM丢弃。

        RUNTIME: VM将在运行期也保留注解，因此可以通过反射机制读取注解的信息。

- @Documented：将此注解包含在JavaDoc中。

- @Inherited: 允许子类继承父类中的注解。

### 注解元素

注解元素可用的类型：

    所有基本类型（int, float, boolean等）

    String

    Class

    enum

    Annotation

    以上类型的数组

### 默认值限制

元素不能有不确定的值，也就是说，元素必须要么具有默认值，要么在使用注解时提供元素的值。

其次，对于非基本类型的元素，无论是在源代码声明时，或是在注解接口中定义默认值时，都不能以**null**作为其值。为了绕开这个**约束**，习惯用法是使用空字符串或负数等一些特殊的值来表示某个元素不存在。

### 注解的快捷方式

如果程序的注解中定义了名为**value**的元素，并且在应用该注解的时候，如果该元素是唯一需要赋值的一个元素，那么此时无需使用名-值对的这种语法，而只需要在括号内给出value元素所需的值即可。
