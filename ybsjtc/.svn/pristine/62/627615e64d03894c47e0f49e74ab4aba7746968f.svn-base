一.编码规范
 1.方法命名
  a.新增 ，save*、insert* 
  b.修改， update*、modify*
  c.删除：delete*、remove*
  d.取单条记录： get* ,记录数： get*Count
  e.分页查询：query* , 不分页查询：list*
  f.导出：export*
  g.打印：print*
  

二.系统支持三种dao持久层操作方式：  1.jdbcTemplate   2.sqlSessionTemplate 
  3.@MapperScan (以后所有都用这个方式)
 

   @Service用于标注业务层组件（我们通常定义的service层就用这个）
   @Controller用于标注控制层组件（如struts中的action）
   @Repository用于标注数据访问组件，即DAO组件
   @Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。
   @Resource、@Autowired、@Qualifier

三.mybatis generator 生成实体类和map.xml 
  java -jar mybatis-generator-core-1.3.2.jar -configfile generatorConfig.xml -overwrite
  
 


五.<cw:permission   code="USER_ADD">  </cw:permission> 自定义标签是否要显示按钮
  
六.当Ajax以application/x-www-form-urlencoded格式上传即使用JSON对象，后台使用@RequestParam 或者Servlet.getparameter可以获取。

        当Ajax以application/json格式上传即使用JSON字符串，后台使用@RquestBody可以获取。

七.通用日志记录方法 aop ，OperateLog  iswritelog seq_busilog
  
八. js要写到jsp上，不要每个jsp对应写一个js，除非公共js方法。

九. service层的exception一定抛出,不能捕获，否则事务不能统一回滚处理。

十. service、dao层方法传参数，要么是map、要么是vo
十一.业务vo类要加个 getLogywlsh方法。


就医管理

零报管理

审核结算

基金财务

账户管理

系统管理

查询统计

城乡居民审核管理










十.行政区划组合下拉框 MultiCombobox.java 

 
 ---迭代查询
 select * from uaas_uams_org     start with org_id ='2' connect by prior org_id = parentid; 

    二.findbugs ---http://findbugs.cs.umd.edu/eclipse

三. maven build dependency:copy-dependencies

四. exp ybpt/ybpt@172.16.11.72:1521/inyydb file=c:/ybpt.dmp INDEXES=n STATISTICS=none
 
 

  native2ascii  e:\b.txt e:\c.txt   用户未登录或登录已超时   \u7528\u6237\u672a\u767b\u5f55\u6216\u767b\u5f55\u5df2\u8d85\u65f6 
   native2ascii -reverse e:\b.txt e:\c.txt    \u7528\u6237\u672a\u767b\u5f55\u6216\u767b\u5f55\u5df2\u8d85\u65f6  用户未登录或登录已超时
