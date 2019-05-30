# SDRB

## 启动注意事项:

1.JDK版本为1.8版本，且JDK的name需要命名为1.8。  
&ensp;&ensp;详情参照.idea/libraries/misc.xml 文件中第三行languageLevel和project-jdk-name两个属性

2.手动在本地创建数据库，然后将database下的几个sql文件依次导入即可创建好本地数据  
&ensp;&ensp;连接数据库，然后将src/admin/DBadmin.java文件中的几个固定参数修改即可