# 2019-10-08-Spring對Web與Hibernate支援

## Spring 對 Web 設定步驟

1. 建立 Maven Web Project DataSource SQLServer 連線

    ```sh
    # 檔案位置: webapp > META-INF > context.xml
    <?xml version="1.0" encoding="UTF-8"?>
    <Context>
        <Resource
            name="spring/servdb" type="javax.sql.DataSource"
            auth="Container" username="sa" password="p@ssw0rd"
            driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver"
            url="jdbc:sqlserver://localhost:1433;databaseName=servdb">
        </Resource>
    </Context>
    ```

1. 建立 Maven Web Project `web.xml` resource-ref

    ```sh
    # 檔案位置: webapp > WEB-INF > web.xml
    <resource-ref>
        <description>JNDI DataSource </description>
        <res-ref-name>spring/servdb</res-ref-name>
        <res-type>javax.sql.DataSource</res-type>
        <res-auth>Container</res-auth>
    </resource-ref>
    ```

1. Maven `pom.xml` 需要加入 spring-web dependency

    ```sh
    # 檔案位置: pom.xml
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>5.1.9.RELEASE</version>
    </dependency>
    ```

1. 建立 Maven Web Project `web.xml` ContextLoaderListener

    ```sh
    # 檔案位置: webapp > WEB-INF > web.xml
    # Bean 元件組態檔預設名稱 applicationContext.xml 可以省略 <context-parm></context-parm>
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/beans.config.xml</param-value>
    </context-param>
    ```

1. 建立 Spring 所支援的 DataSource

    ```sh
    # 檔案位置: webapp > WEB-INF > beans.config.xml
    # 此為需掃瞄的 Annotation 設定
    <context:component-scan base-package="model"></context:component-scan>

    # Spring 提供 JndiObjectFactoryBean 工廠建立 dataSource 物件供開發者建立連線
    <bean id="dataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
        <property name="jndiName" value="java:/comp/env/spring/servdb"></property>
    </bean>
    ```

## Spring 對 Web/Hibernate 設定步驟

1. 建立 Maven Web Project DataSource SQLServer 連線

    ```sh
    # 檔案位置: webapp > META-INF > context.xml
    <?xml version="1.0" encoding="UTF-8"?>
    <Context>
        <Resource
            name="spring/servdb" type="javax.sql.DataSource"
            auth="Container" username="sa" password="p@ssw0rd"
            driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver"
            url="jdbc:sqlserver://localhost:1433;databaseName=servdb">
        </Resource>
    </Context>
    ```

1. 建立 Maven Web Project `web.xml` resource-ref

    ```sh
    # 檔案位置: webapp > WEB-INF > web.xml
    <resource-ref>
        <description>JNDI DataSource </description>
        <res-ref-name>spring/servdb</res-ref-name>
        <res-type>javax.sql.DataSource</res-type>
        <res-auth>Container</res-auth>
    </resource-ref>
    ```

1. Maven `pom.xml` 需要加入 spring-web/spring-orm dependency

    ```sh
    # 檔案位置: pom.xml
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>5.1.9.RELEASE</version>
    </dependency>

    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-orm</artifactId>
        <version>5.1.9.RELEASE</version>
    </dependency>
    ```

1. 建立 Maven Web Project `web.xml` ContextLoaderListener

    ```sh
    # 檔案位置: webapp > WEB-INF > web.xml
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    # Bean 元件組態檔預設名稱 applicationContext.xml 可以省略 <context-parm></context-parm>
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/beans.config.xml</param-value>
    </context-param>
    ```

1. 建立 Spring 所支援的 DataSource

    ```sh
    # 檔案位置: webapp > WEB-INF > beans.config.xml
    # 此為需掃瞄的 Annotation 設定
    <context:component-scan base-package="model"></context:component-scan>

    # Spring 提供 JndiObjectFactoryBean 工廠建立 dataSource 物件供開發者建立連線
    <bean id="dataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
        <property name="jndiName" value="java:/comp/env/spring/servdb"></property>
    </bean>
    ```

1. 建立 hibernate.cfg.xml 基本設定

    ```sh
    # 檔案位置: src > main > java > Hibernate.cfg.xml
    <property name="hibernate.show_sql">true</property>
    <property name="hibernate.format_sql">true</property>

    # 需要 mapping 的 ORM Class(所有 @Entity 都需要註冊)
    <mapping class="model.Employee"/>
    ```

1. 建立 Spring 所支援的 SessionFactory

    ```sh
    # 檔案位置: webapp > WEB-INF > beans.config.xml
    # 此為需掃瞄的 Annotation 設定
    <context:component-scan base-package="model"></context:component-scan>

    <bean id="dataSource"
        class="org.springframework.jndi.JndiObjectFactoryBean">
        <property name="jndiName"
            value="java:/comp/env/spring/servdb"></property>
    </bean>

    <bean id="sessionFactory"
        class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
        <property name="dataSource" ref="dataSource"></property>
        <property name="configLocation" value="classpath:hibernate.cfg.xml"></property>
    </bean>

    <bean id="transactionManager"
        class="org.springframework.orm.hibernate5.HibernateTransactionManager">
        <property name="sessionFactory" ref="sessionFactory"></property>
    </bean>

    <tx:annotation-driven/>
    ```
