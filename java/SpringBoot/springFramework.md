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
