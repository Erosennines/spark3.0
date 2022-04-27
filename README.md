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

