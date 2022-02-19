# Spring5

## spring_ioc_xml
-- IOC的xml配置用法
1. bean的使用
2. 基于setter方法的依赖注入
3. 基于构造函数依赖注入
4. 复杂数据类型注入
5. P命名空间
6. C命名空间
7. depends-on属性控制bean的加载顺序
8. lazy-init 懒加载
9. Scope 作用域
10. 使用静态工厂注入bean
11. 使用动态工厂注入bean
12. 根据类型自动注入
13. 根据set方法名字自动注入
14. 根据构造函数自动注入
15. 注入生命周期回调 
16. 注入第三方bean
17. 通过第三方配置文件注入bean属性

## spring_ioc_annotate
-- IOC的注解用法
1. @Controller //控制器，推荐给Controller层添加此注解
2. @Service    //业务逻辑，推荐给业务逻辑层添加此注解
3. @Repository //仓库管理，推荐给数据访问层添加此注解
4. @Component  //给不属于以上基层的类添加此注解
5. @Value
6. @Autowired  & @Resource
7. @DependsOn
8. @Lazy
9. @Scope
10. @PostConstruct 初始化   @PreDestroy  销毁

## spring_ioc_config
-- 通过 Java 类的方式提供 Bean 的定义信息
1. Config类代替xml启动Spring上下文
2. @Bean注解将一个实例注册为一个bean
3. 通过@PropertySource引入外部属性资源文件
4. @Import
5. 自动注入外部bean & 自动依赖内部bean

## spring_aop
-- AOP的简单应用
1. @Aspect
2. @Pointcut & execution表达式
3. @Before
4. @AfterReturning
5. @AfterThrowing
6. @After
7. @Around
8. 动态代理

## sptring_transaction
-- jdbcTemplate 和 声明式事务简单应用
