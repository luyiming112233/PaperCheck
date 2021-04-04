# PaperCheck
## 概述
本项目主要完成对论文格式中的目录进行检查,预期希望通过maven构建jar包,以命令行的形式进行调用.

## 开发说明

### 依赖环境
1. Java 8
2. maven

### 配置说明
该项目实现了基本的xml配置项读取,若要更新/添加配置项,请按以下三个步骤,修改内容请参考已有的代码:
1. 在`resources/config.xml`中添加所需的配置
2. 在`java/config/WordConfig`中添加对应类的字段以及`get`,`set`方法
3. 在`java/config/ConfigReader`中增加新配置的解析

### 格式检查开发说明
该项目添加了`apache poi`第三方库,可以通过maven进行依赖包拉取,相关的使用文档如下:
1. api文档:https://poi.apache.org/apidocs/4.0/index.html
2. docx文件使用说明:http://deepoove.com/poi-tl/apache-poi-guide.html

### 可参考的思路
本节给出一个可参考的实现思路,功能开发人员可以自行讨论决定最终的使用方案.
1. 用户通过调用jar包,输入待检查的文件路径`input`和结果输出路径`output`
2. PaperCheck进行论文格式检查,检查过程中,将`input`文件的内容拷贝到`output`中.
3. 如果坚持过程中发现错误,则将`output`中对应模块的末尾添加红色标识(如目录字体错误,应该为xxx)
4. 返回检查结果(success/fail)
