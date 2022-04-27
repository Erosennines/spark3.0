# spark3.0
这是一个自学课程，视频地址：https://www.bilibili.com/video/BV11A411L7CK?from=search&seid=9755988563865343821&spm_id_from=333.337.0.0
<hr>

## 一、快速上手
### 1. 创建Maven项目
#### 1.1 增加Scala插件
Spark由Scala语言开发的，所以接下来的开发所使用的语言也为Scala，默认采用的Scala编译版本为2.12。开发前请保证IDEA开发工具中含有Scala开发插件。

在IDEA中找到setting -> Plugins，下载Scala。
![img.png](picture/scala plugin.png)

#### 1.2 增加pom依赖
```xml
<dependencies>
    <dependency>
        <groupId>org.apache.spark</groupId>
        <artifactId>spark-core_2.12</artifactId>
        <version>3.0.0</version>
    </dependency>
</dependencies>
<build>
    <plugins>
        <!-- 该插件用于将Scala代码编译成class文件 -->
        <plugin>
            <groupId>net.alchim31.maven</groupId>
            <artifactId>scala-maven-plugin</artifactId>
            <version>3.2.2</version>
            <executions>
                <execution>
                    <!-- 声明绑定到maven的compile阶段 -->
                    <goals>
                        <goal>testCompile</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-assembly-plugin</artifactId>
            <version>3.0.0</version>
            <configuration>
                <descriptorRefs>
                    <descriptorRef>jar-with-dependencies</descriptorRef>
                </descriptorRefs>
            </configuration>
            <executions>
                <execution>
                    <id>make-assembly</id>
                    <phase>package</phase>
                    <goals>
                        <goal>single</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

#### 1.3 运行第一个Spark程序
在执行程序之前，你需要：
1. 在根目录下创建input文件夹，创建 words.txt 文本文件，并写入一些单词，单词与单词之间使用空格隔开；
2. 为了防止程序报错，你应该在windows环境提前准备好winutils.exe文件，并提前设置好HADOOP_HOME环境变量；
3. 为了更好能看到结果，最好将日志级别设置为ERROR；[设置日志级别](https://github.com/Erosennines/spark3.0/blob/master/src/main/resources/log4j.properties)

以上步骤准备好后，就可以尝试编写第一个Spark代码：[wordcount](https://github.com/Erosennines/spark3.0/blob/master/src/main/java/com/spark/day01/Day01_01_WordCount.scala)

