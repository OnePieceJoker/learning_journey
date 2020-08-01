# Spring-framework

官方教程文档学习笔记

---

## 1. IOC容器

### 1.1. Spring IOC容器和Bean简介

IoC: Inversion of Control，即所谓的控制反转，也被成为dependency injection(DI依赖注入).

IoC就是通过构造函数参数，工厂方法的参数或在构造或从工厂方法返回对象实例后在对象实例上设置的属性来定义其依赖项（即，跟它们一起使用的其他对象）.然后，容器在创建Bean时注入这些依赖项.这个过程从根本上说是反转（所以叫控制反转），即通过直接构造类或使用服务定位器模式等机制来控制bean本身的实例化或依赖的位置.

> package: org.springframework.beans & org.springframework.context是IoC容器的基础

**BeanFactory**接口提供了一个高级配置机制，能够管理任何类型的对象.

**ApplicationContext**是**BeanFactory**的一个子接口,它增加了一些新的功能：

- 更容易与Spring的AOP功能集成 (Easier integration with Spring's AOP features)

- 报文资源的处理（用于国际化）Message resource handling(for use in internationalization)

- 活动发布（Event publication）

- 应用层的特定上下文，如**WebApplicationContext**，用于web应用. (Application-layer specific contexts such as the **WebApplicationContext*8 for use in web applications)

简而言之，**BeanFactory**提供了配置框架和基本功能，**ApplicationContext**增加了更多企业特定的功能.**ApplicationContext**是**BeanFactory**的完整超集.

在Spring中，构成应用骨干并由Spring IoC容器管理的对象被称为bean.

Bean是一个由Spring IoC容器实例化、组装和管理的对象。否则，Bean只是应用程序中众多对象中的一个。Bean以及它们之间的依赖关系反映在容器使用的配置元数据中.

### 1.2 容器概述

**ApplicationContext**接口代表Spring IoC容器，并负责实例化、配置和组装bean.

容器通过读取配置元数据来获取其关于实例化、配置和组装哪些对象的指令.

配置元数据用XML、Java注解或Java代码表示。它可以让你表达组成你的应用程序的对象以及这些对象之间丰富的相互依赖关系.

Spring提供了ApplicationContext接口的几种实现.

在独立的应用程序中，通常创建一个**ClassPathXmlApplicationContext**或**FileSystemXmlApplicationContext**的实例.

XML一直是定义配置元数据的传统格式，但可以通过提供少量的XML配置来声明性地启用对这些附加元数据格式的支持，从而指示容器使用Java注解或代码作为元数据格式.

在大多数应用场景中，不需要显示用户代码即可实例化一个Spring IoC容器的一个或多个实例.

下图显示了Spring的工作原理的高级视图.通过将应用程序类与配置元数据结合在一起，以便在创建和初始化ApplicationContext之后，将拥有一个完全配置且可执行的系统或应用程序.

![Spring IoC容器](./images/container-magic.png)

#### 1.2.1 配置元数据

如上图所示，Spring IoC容器使用一种形式的配置元数据。此配置元数据表示作为应用程序开发人员如何搞作Spring容器实例化，配置和组装应用程序中的对象.传统上，配置元数据以简单直观的XML格式提供.

> 注：基于XML配置；基于注解配置(Spring2.5)；基于Java配置(Spring3.0)

Spring配置由至少一个且通常是多个容器必须管理的Bean定义组成.

基于XML的配置元数据将这些bean配置为顶层元素``<beans/>``,Java配置通常在``@Configuration``类中使用``@Bean**``注解方法.

这些bean定义对应于组成应用程序的实际对象.通常，定义服务层对象（service layer objects）,数据访问对象（data access objects）,表示对象例如Struts Action实例(presentation objects),基础结构对象例如Hibernate SessionFactories, JMS队列(infrastructure objects).

通常，我们不会在容器中配置细粒度的域对象，因为创建和加载域对象通常是DAO和业务逻辑的责任，然而，可以使用Spring和AspectJ的集成来配置在IoC容器控制之外创建的对象.

以下示例显示了基于XML的配置元数据的基本结构：

```XML
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="..." class="...">  
        <!-- collaborators and configuration for this bean go here -->
    </bean>

    <bean id="..." class="...">
        <!-- collaborators and configuration for this bean go here -->
    </bean>

    <!-- more bean definitions go here -->

</beans>
```

> 注:
>
> 1. **id**属性是一个字符串，用于标识单个bean定义.
> 2. **class**属性定义了Bean的类型，并使用完全限定的类名.

#### 1.2.2 实例化一个容器

提供给**ApplicationContext**构造函数的一个或多个位置路径是资源字符串，这些资源字符串使容器可以从各种外部资源（例如本地文件系统，Java CLASSPATH等）加载配置元数据.

```Java
ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");
```

以下示例显示了服务层对象（services.xml）配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- services -->

    <bean id="petStore" class="org.springframework.samples.jpetstore.services.PetStoreServiceImpl">
        <property name="accountDao" ref="accountDao"/>
        <property name="itemDao" ref="itemDao"/>
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>

    <!-- more bean definitions for services go here -->

</beans>
```

以下示例显示了数据访问对象（daos.xml）配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="accountDao"
        class="org.springframework.samples.jpetstore.dao.jpa.JpaAccountDao">
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>

    <bean id="itemDao" class="org.springframework.samples.jpetstore.dao.jpa.JpaItemDao">
        <!-- additional collaborators and configuration for this bean go here -->
    </bean>

    <!-- more bean definitions for data access objects go here -->

</beans>
```

在前面的示例中，服务层由PetStoreServiceImpl类和两个JpaAccountDao和JpaItemDao类型的数据访问对象组成（基于JPA对象关系映射标准）.属性名称元素引用JavaBean属性的名称，而ref元素引用另一个bean定义的名称.id和ref元素之间的这种联系表达了协作对象之间的依赖性.

##### 组成基于XML的配置元数据

让bean定义跨越多个XML文件可能很有用。通常情况下，每个单独的XML配置文件都代表了架构中的一个逻辑层或模块.

您可以使用应用程序上下文构造函数从所有这些XML片段中加载bean定义。 如上一节中所示，此构造函数具有多个Resource位置。 或者，使用一个或多个``<import />``元素从另一个文件中加载bean定义。

以下示例显示了如何执行此操作

```xml
<beans>
    <import resource="services.xml"/>
    <import resource="resources/messageSource.xml"/>
    <import resource="/resources/themeSource.xml"/>

    <bean id="bean1" class="..."/>
    <bean id="bean2" class="..."/>
</beans>
```

在前面的例子中，外部Bean定义从三个文件中加载：services.xml、messageSource.xml和themeSource.xml。所有的位置路径都是相对于做导入的定义文件而言的，所以services.xml必须和做导入的文件在同一个目录或classpath位置，而messageSource.xml和themeSource.xml必须在导入文件位置下面的资源位置。

可以看到，前面的斜线被忽略了。然而，鉴于这些路径是相对的，最好不要使用斜线。根据Spring Schema，导入的文件内容，包括顶层的``<beans/>``元素，必须是有效的XML bean定义。

> 注：
>
> 可以使用相对路径"./"来引用父目录中的文件，但不建议这样做。这样做会造成对当前应用程序之外的文件的依赖。特别是对于classpath，不推荐使用这种引用。URL（例如，classpath:.../services.xml），在这种情况下，运行时解析过程会选择 "最近的 "classpath根目录，然后查找其父目录。Classpath配置的更改可能会导致选择不同的、不正确的目录。
>
> 可以使用完全限定的资源位置而不是相对路径：例如，file:C:/config/services.xml或classpath:/config/services.xml。然而，请注意，您正在将应用程序的配置耦合到特定的绝对位置。一般来说，最好为这样的绝对位置保留一个间接性--例如，通过"${...}"占位符，在运行时针对 JVM 系统属性进行解析。

命名空间本身提供了导入指令功能。 Spring所提供的一系列XML名称空间（例如，上下文和util名称空间）中提供了超出普通bean定义的其他配置功能。

#### 1.2.3 使用容器

**ApplicationContext**是一个高级工厂的接口，该接口可以维护不同的**bean**及其依赖的注册表.通过使用方法`T getBean(String name, Class<T> requiredType)`，可以检索**bean**的实例.

通过**ApplicationContext**，可以读取**bean**的定义并访问它们，如以下示例所示：

```java
// create and configure beans
ApplicationContext context = new ClassPathXmlApplicationContext("services.xml", "daos.xml");

// retrieve configured instance
PetStoreService service = context.getBean("petStore", PetStoreService.class);

// use configured instance
List<String> userList = service.getUsernameList();
```

我们可以在同一ApplicationContext上混合和匹配此类阅读器委托，从不同的配置源读取Bean定义。然后，可以使用getBean检索bean的实例。 ApplicationContext接口还有其他几种检索bean的方法，但是理想情况下，我们的应用程序代码永远不要使用它们。 确实，我们的应用程序代码应该根本不调用`getBean()`方法，因此完全不依赖于Spring API。 例如，Spring与Web框架的集成为各种Web框架组件（如控制器和JSF托管的bean）提供了依赖注入，可以通过元数据（例如自动装配注释）声明对特定bean的依赖。

### 1.3 Bean概述

一个Spring IoC容器管理一个或多个**bean**. 这些**bean**是通过您提供给容器的配置元数据（例如，以`XML<bean/>`定义的形式）创建的.

在容器本身内，这些**bean**定义表示为**BeanDefination**对象，其中包含（除其他信息外）以下元数据：

- 一个包限定的类名：通常是被定义的bean的实际实现类

- Bean行为配置元素，它说明了bean在容器中的行为方式（作用域，生命周期回调等）

- 对其他Bean的引用，这些引用是bean完成其工作所需要的。这些引用也被称为协作者或依赖关系

- 要在新创建的对象中设置的其他配置设置--例如，池的大小限制或管理连接池的Bean中要使用的连接数

此元数据转换为构成每个Bean定义的一组属性

| Property | Explained in... |
| -------  | --------- |
| Class | 实例化Bean |
| Name | 命名Bean |
| Scope | Bean的范围 |
| Constructor arguments | 依赖注入 |
| Properties | 依赖注入 |
| Autowiring mode | 自动装配协作器 |
| Lazy initialization mode | 懒初始化Bean |
| Initialization method | 初始化回调 |
| Destruction method | 销毁回调 |

除了包含有关如何创建特定bean的信息的bean定义之外，ApplicationContext实现还允许注册在容器外部（由用户）创建的现有对象。

这是通过`getBeanFactory()`方法访问ApplicationContext的BeanFactory来实现的，该方法返回BeanFactory的DefaultListableBeanFactory实现。

DefaultListableBeanFactory通过`registerSingletom()`和`registerBeanDefinition()`方法支持这种注册。然而，典型的应用程序只使用通过常规Bean定义元数据定义的bean。

> 注：
>
> Bean 元数据和手动提供的单子实例需要尽早注册，以便容器在自动布线和其他反省步骤中对它们进行正确的推理。
>
> 虽然在一定程度上支持覆盖现有的元数据和现有的单子实例，
>
> 但官方并不支持在运行时注册新的bean（与工厂的实时访问同时进行），并且可能导致并发访问异常、bean容器中的状态不一致，或者两者兼而有之。

#### 1.3.1 Bean的命名

每个Bean具有一个或多个标识符. 这些标识符在承载Bean的容器内必须是唯一的。一个bean通常只有一个标识符。但是，如果需要多个，则可以将多余的标识符视为别名.

在基于XML的配置元数据中，可以使用id属性、name属性或两者都使用来指定bean标识符.

id属性可以让我们精确指定一个id. 按照惯例，这些名称可以是字符数字，但它们也可以包含特殊字符. 如果要为bean引入其他别名，还可以在**name**属性中指定它们, 并用逗号(,),分号(;),或空格分隔.

> Bean命名的约定: 按照Java约定的用于实例字段名，开头首字母小写，后续以驼峰格式来区分单词.
>
> 通过在类路径中进行组件扫描，Spring会按照前面描述的规则为未命名的组件生成bean名称。一般来说，采用简单的类名并将其初始字符转换为小写。但是，在特殊情况下，如果有多个字符并且第一个和第二个字符均为大写字母，则会保留原始大小写.

##### 在Bean定义之后为Bean创建别名

在基于XML配置元数据中，可以通过使用`<alias/>`元素来完成在别处定义bean的别名。

```xml
<alias name = "fromName" alias = "toName" />
```

例如，子系统A的配置元数据可以通过子系统A-dataSource的名称引用数据源。 子系统B的配置元数据可以通过子系统B-dataSource的名称引用数据源。 组成使用这两个子系统的主应用程序时，主应用程序通过myApp-dataSource的名称引用数据源。 要使所有三个名称都引用同一个对象，可以将以下别名定义添加到配置元数据中：

```XML
<alias name="myApp-dataSource" alias="subsystemA-dataSource"/>
<alias name="myApp-dataSource" alias="subsystemB-dataSource"/>
```

> 注：如果是通过Java配置的话，可以通过@Bean注解来提供别名功能.

#### 1.3.2 实例化Bean
