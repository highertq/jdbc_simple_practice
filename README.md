# jdbc_simple_practice
more and more

## 准备
mysql-connect-java-5.x.bin.jar对应 mysql 5.x，新建java项目，新建lib文件夹，将jar包驱动移到lib中，右键lib添加为库

## JDBC_demo
+ 1.加载驱动
+ 2.获得连接对象
+ 3.获得发送SQL语句工具
+ 4.设置动态参数
+ 5.执行SQL，处理结果
+ 6.关闭资源

## 工具类的封装
DBUtils实现加载驱动、获得连接对象、关闭资源


## 跨平台方案
在src目录下新建db.properties配置文件
定义 `private static final Properties PROPERTIES = new Properties();` 读取配置文件Map
定义 
```
    static {
        // 首次使用工具类 加载驱动 
        InputStream is = DBUtils.class.getResourceAsStream("/db.properties");
        // 通过流将配置文件内容加载到properties集合 把Map配置信息分割成键值对
        PROPERTIES.load(is);
        //通过getProperty("xxx")获取对应的值 
        Class.forName(PROPERTIES.getProperty("driver"));
}
```
## ORM（Object Relational Mapping）
* 一行数据中，多个零散的数据进行整理
* 通过entity实体类的规则对表中的数据进行对象封装
* 表名=类名 属性名=列名
* 提供各个属性的get、set方法
## Dao（Date Access object）
```sql
CREATE TABLE Person(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	age INT NOT NULL,
	bornDate DATE,
	email VARCHAR(20),
	address VARCHAR(20)
	)CHARSET=utf8;
```
对同一张表的所有操作封装在XxxDaoImpl对象中

## 实体的重要性
![image](https://user-images.githubusercontent.com/44385387/142001918-a2a31c62-609c-47e6-8a91-3f03665f561f.png)

