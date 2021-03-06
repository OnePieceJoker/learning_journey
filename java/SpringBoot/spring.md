# Spring学习笔记

## Spring-petclinic（宠物医院）案例

### 1. 注解的使用

#### 1.1 类上注解

**@MappedSuperclass** 代表使用该注解的类是一个超类，不会实例化到数据库表中，用于封装公用属性提供给子类

**@Entity** 使用该注解的累将会被实体化映射到数据库表中

**@Table** 该注解表示标识了实体类与数据库表的对应关系

    属性：

        name: 代表数据库表的名称，没有指定的话默认为类名
    
        catalog: 表的目录，默认为默认目录
    
        schema: 表的架构，默认为默认架构
    
        uniqueConstraints: Unique constraints that are to be placed on the table. These are only used if table generation is in effect. These constraints apply in addition to any constraints specified by the Column and JoinColumn annotations and constraints entailed by primary key mappings. Defaults to no additional constraints.
    
        indexes: Indexes for the table. These are only used if table generation is in effect. Note that it is not necessary to specify an index for a primary key, as the primary key index will be created automatically.

**@SpringBootApplication** 等同于同时声明了@SpringBootConfiguration,@EnableAutoConfiguration,@ComponentScan

    属性：

        Class<?>[] exclude: Exclude specific auto-configuration class names such that they will never be applied.

        String[] excludeName: Exclude specific auto-configuration class names such that they will never be applied.

        String[] scanBasePackages: Base packages to scan for annotated components.

        Class<?>[] scanBasePackagesClasses: Type-safe alternative to {@link #scanBasePackages} for specific the packagesto scan for annotated components. The package of each class specified will be scanned.

        boolean proxyBeanMethods: Specify whether @Bean methods should get proxied in order to enforce bean lifecycle behavior.(指定是否应代理@Bean方法以强制执行bean生命周期行为)

**@Controller** Indicates that an annotated class is a "Controller"(e.g. a web controller)

**@XmlRootElement** Maps a class or an enum type to an XML element.

**@Component** Indicates that an annotated class is a "component". Such classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.

**@RequestMapping** Annotation for mapping web requests onto methods in request-handling classes with flexible method signatures. Note: This annotation can be used both at the class and at the method level. In most cases, at the method level applications will prefer to use one of the HTTP method specific variants @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping.

    属性：

        String name: Assign a name to this mapping.

        String[] value: The primary mapping expressed by this annotation. This is an alias for #path. (e.g. {@code @RequestMaping("/foo/")} is equivalent to {@code @RequestMapping(path="/foo")}) NOTE: A handler method that is not mapped to any path explicitly is effectively mapped to any empty path.

        String[] path: The path mapping URIs. NOTE: A handler method that is not mapped to any path explicitly is effectively mapped to any empty path.

        RequestMethod[] method: The HTTP request methods to map to, narrowing the primary mapping: GET, POST, HEAD, OPTION, PUT, PATCH, DELETE, TRACE.

        String params: The parameter of the mapped request, narrowing the primary mapping. The primary path mapping still has to uniquely identify the target handler, with parameter mappings simply expressing preconditions for invoking the handler.

        String[] headers: The headers of the mapped request, narrowing the primary mapping.

        String[] consumes: Narrows the primary mapping by media types that can be consumed by the mapped handler. Consists of one or more media types one of which mush match to the request {@code Content-Type} header.

        String[] produces: Narrows the primary mapping by media types that can be produced by the mapped handler. Consists of one or more media types one of which must be chosed via content negotiation the "acceptable" media types of the request. Typically those are extracted from the {@code "Accept"} header but may be derived from query parameters, or other.

**@AliasFor** is an annotation that is used to declare aliases for annotation attributes.

    使用场景：

        1. Explicit aliases within an annotation: Each attribute that makes up an aliased pair should be annotated with @AliasFor, and either #attribute or #value must reference the other attribute in the pair.

        2. Explicit alias for attribute in meta-annotation: The attribute that is an alias for an attribute in a meta-annotation must be annotated with @AliasFor, and #attribute must reference the attribute in the meta-annotation.

        3. Implicit aliases within an annotation: Each attribute that belongs to a set of implicit aliases must be annotated with @AliasFor, and #attribute must reference the same attribute in the same meta-annotation (either directly or transitively via other explicit meta-annotation attribute overrides within the annotation hierarchy).

    Notes:

    Explicit aliases within an annotation

        Aliased attributes must declare the same return type.

        Aliased attributes must declare a default value.

        Aliased attributes must declare the same default value.

        {@like #annotation} should not be declared.

    Explicit alias for attribute in meta-annotation

        Aliased attributes must declare the same return type.

        {@link #annotation} must reference the meta-annotation.

        The referenced meta-annotation must be meta-present on the annotation class that declares {@code @AliasFor}.

    Implicit aliases within an annotation

        Aliased attributes must declare the same return type.

        Aliased attributes must declare a default value.

        Aliased attributes must declare the same default value.

        {@link #annotation} must reference an appropriate meta-annotation.

        The referenced meta-annotation must be meta-present on the annotation class that declares {@code @AliasFor}.

**@Id** 实体主键的类型为整数类型

**@GeneratedValue** Provides for the specification of generation strategies for the values of primary keys.

    GenerationType strategy(): (Optional) The primary key generation strategy that the persistence provider must use to generate the annotated entity primary key

    String generator(): (Optional) The name of the primary key generator to use as specified in the {@link SequenceGenerator} or {@link TableGenerator} annotation. <p> Defaults to the id generator supplied by persistence provider.

> trategy有四种类型可选，分别是：TABLE SEQUENCE IDENTITY AUTO  
> TABLE: 使用一个特定的数据库表格来保存主键  
> SEQUENCE: 根据底层数据库的序列来生成主键，条件是数据库支持序列  
> IDENTITY: 主键由数据库自动生成（主要是自动增长型）  
> AUTO: 主键由程序控制

**@Column** 对列加上限制

    name
    unique
    nullable
    length
    columnDefinition: 列的定义，比如列的类型
    insertable: 在使用 insert 插入数据时，需不需要插入该字段
    updateable: 在使用 update 更新数据时，需不需要更新该字段
    table: 包含当前字段的表名
    precision & scale: 表示精度，当字段类型为Double时，precision 表示数值的总长度，scale 表示小数点所占的位数

**@NotEmpty** The annotated element must not be {@code null} nor empty. String, Collection, Map, arrays不能为null并且长度必须大于0

**@Digits**

**@OneToMany**

**@ManyToOne**

**@Transient**

**@JoinColumn**

**@DateTimeFormat**

**@ModelAttribute**

**@InitBinder**

**@Autowired**
