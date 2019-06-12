# 2019-06-12-如何建立 Maven Project

## 如何建立 Maven Project

1. Eclipse 建立 Maven Project

    ```sh
    # 1. 開始建立
    空白處右鍵 > other > Maven > Maven Project

    # 2. 建立 Simple Project
    勾選「Create a simple project(skip archetype selection)」
    勾選「Use default Workspace location」

    # 3. New Maven Project
    # Group Id 為公司組織網域名稱/ Artifact Id 為專案名稱皆為小寫, 且以 - 間隔
    Group Id: com.edu
    Artifact Id: hello-world
    Version: 0.0.1-SNAPSHOT
    ```

## pom.xml 架構

1. 預設 pom.xml 架構

    ```xml
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
        <modelVersion>4.0.0</modelVersion>
        <groupId>com.edu</groupId>
        <artifactId>hello-world</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </project>

    <!-- Maven plugins -->
    <build>
        <plugins>
            <!-- 使用的 java 版本 -->
            <!-- source 為 java8 語法 -->
            <!-- target 可向下相容 java8 版本 -->
            <!-- compilerVersion 為 java8 編譯 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.5</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <compilerVersion>1.8</compilerVersion>
                </configuration>
            </plugin>
            <!-- Maven 打包產生 .jar -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>2.4.3</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <transformers>
                                <transformer
                                    implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <mainClass>com.example.helloworld.App</mainClass>
                                </transformer>
                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
    ```

1. 如何更新 pom.xml

    ```sh
    # 每次異動 pom.xml 需要更新 Maven Project
    右鍵 Artifact Id > Maven > Update Project
    ```

## Maven 如何建立 helloworld package

1. 建立 helloworld package

    ```sh
    右鍵 /src/main/java > New > Project

    # Java Package 設定
    Name: com.edu.helloWorld
    ```

1. 建立 HelloWorld Class

    ```sh
    右鍵 package > New > Class

    # Java Class 設定
    Name: HelloWorld
    ```