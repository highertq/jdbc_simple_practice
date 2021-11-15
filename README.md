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
1、2、6


## 跨平台方案
在src目录下新建db.properties
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




