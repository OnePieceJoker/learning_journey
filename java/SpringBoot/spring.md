# Spring学习笔记

## Spring-petclinic（宠物医院）案例

### 1. 注解的使用

#### 1.1 类上注解

- @MappedSuperclass

    @MappedSuperclass 代表使用该注解的类是一个超类，不会实例化到数据库表中，用于封装公用属性提供给子类

- @Entity

    @Entity 使用该注解的累将会被实体化映射到数据库表中

- @Table

    @Table 该注解表示标识了实体类与数据库表的对应关系

    属性：

        name: 代表数据库表的名称，没有指定的话默认为类名
    
        catalog: 表的目录，默认为默认目录
    
        schema: 表的架构，默认为默认架构
    
        uniqueConstraints: Unique constraints that are to be placed on the table. These are only used if table generation is in effect. These constraints apply in addition to any constraints specified by the Column and JoinColumn annotations and constraints entailed by primary key mappings. Defaults to no additional constraints.
    
        indexes: Indexes for the table. These are only used if table generation is in effect. Note that it is not necessary to specify an index for a primary key, as the primary key index will be created automatically.

- @SpringBootApplication

    @SpringBootApplication 等同于同时声明了@SpringBootConfiguration,@EnableAutoConfiguration,@ComponentScan

    属性：

        Class<?>[] exclude: Exclude specific auto-configuration class names such that they will never be applied.

        String[] excludeName: Exclude specific auto-configuration class names such that they will never be applied.

        String[] scanBasePackages: Base packages to scan for annotated components.

        Class<?>[] scanBasePackagesClasses: Type-safe alternative to {@link #scanBasePackages} for specific the packagesto scan for annotated components. The package of each class specified will be scanned.

        boolean proxyBeanMethods: Specify whether @Bean methods should get proxied in order to enforce bean lifecycle behavior.(指定是否应代理@Bean方法以强制执行bean生命周期行为)

- @Controller

    @Controller Indicates that an annotated class is a "Controller"(e.g. a web controller)

- @XmlRootElement

    @XmlRootElement Maps a class or an enum type to an XML element.

- @Component

    @Component Indicates that an annotated class is a "component". Such classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.

- @RequestMapping

    @RequestMapping Annotation for mapping web requests onto methods in request-handling classes with flexible method signatures. Note: This annotation can be used both at the class and at the method level. In most cases, at the method level applications will prefer to use one of the HTTP method specific variants @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping.

    属性：

        String name:

        String[] value: 

        String[] path:

        RequestMethod[] method:

        String params:

        String[] headers:

        String[] consumes:

        String[] produces:

- @AliasFor
