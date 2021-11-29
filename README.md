# SoftiCAR Platform Example Project

This repository provides an exemplary project, based upon the [SoftiCAR Platform](https://github.com/softicar/platform) for business web applications.

It showcases the fundamental _SoftiCAR Platform_ concepts, and the project setup itself. Beyond that, it serves no practical purpose.

Note that this is not, by any means, an exhaustive documentation of the _SoftiCAR Platform_ and its capabilities.

## 1 Overview

This repository provides the project "Platform Example". Its anatomy is described in the following:

1. Applications based upon the _SoftiCAR Platform_ are **modular**.
   - Each module resides in a **dedicated sub-project** (aka. _"module project"_). There is a common top-level project above all _module projects_.
   - In this example, the stub of a _Delivery module_ (i.e. functionality to handle real-world deliveries) is defined.
   - Any _module project_ may depend on one or several other _module projects_. Cycles are forbidden.
   - Any given _module project_ defines a corresponding **module package** as follows:
     ```
     com.mydomain.example.delivery.module
     \__________________/ \______/ \____/
          same for           |        must always be "module", by convention
         all modules    corresponds to
                        the module name;
                        may contain dots
     ```
   - In all source folders of the respective _module project_, all code and resource files must reside in this package, or in its sub-packages.
   - A typical _module package_ contains at least:
     - The **module class**, which serves as a handle for any given module.
       - E.g. `com.mydomain.example.delivery.module.DeliveryModule.java`
     - The **module instance table** which provides data scopes for one or several instances of the corresponding module.
       - E.g. `com.mydomain.example.delivery.module.AGDeliveryModuleInstance.sqml`
   - The top-level project does not contain Java code.
   - Database tables are defined in `.sqml` files. From those, corresponding Java code is generated via the [SQML Eclipse Plugin](https://github.com/softicar/sqml).
   - A typical directory tree is structured as follows:
     ```
     platform-example                                    // top-level project
     ├─ gradle/                                          // gradle-wrapper home
     │  └─ wrapper
     │     ├─ gradle-wrapper.jar
     │     └─ gradle-wrapper.properties
     ├─ platform-example-delivery-module                 // sub-project of Delivery module
     │  ├─ src/main/java                                 // java source folder of the module
     │  │  └─ com.mydomain.example.delivery.module       // the module-specific package
     │  │     ├─ delivery
     │  │     │  ├─ AGDeliveryGenerated.java
     │  │     │  ├─ AGDelivery.java
     │  │     │  ├─ AGDeliveryLog.java
     │  │     │  ├─ AGDeliveryLog.sqml
     │  │     │  ├─ AGDelivery.sqml                      // DB table definition in SQML
     │  │     │  ├─ AGDeliveryTable.java
     │  │     │  └─ DeliveryManagementPage.java
     │  │     ├─ AGDeliveryModuleInstanceGenerated.java
     │  │     ├─ AGDeliveryModuleInstance.java
     │  │     ├─ AGDeliveryModuleInstance.sqml
     │  │     ├─ AGDeliveryModuleInstanceTable.java
     │  │     ├─ DeliveryI18n.java                       // enumerates labels & translations
     │  │     ├─ DeliveryImages.java                     // enumerates image resources
     │  │     └─ DeliveryModule.java                     // the primary class of the module
     │  ├─ src/main/resources
     │  │  └─ com.mydomain.example.delivery.module       // the module-specific package
     │  │     └─ delivery-module.svg
     │  ├─ src/test/java
     │  │  └─ com.mydomain.example.delivery.module       // the module-specific package
     │  │     └─ delivery
     │  │        └─ AGDeliveryTest.java
     │  └─ build.gradle                                  // build script of the module
     ├─ build.gradle                                     // main build script
     ├─ gradlew                                          // gradle-wrapper executable
     ├─ gradlew.bat                                      // gradle-wrapper executable
     ├─ settings.gradle                                  // build settings
     └─ web.xml                                          // web app deployment descriptor
     ```
1. [Gradle](https://gradle.org/) is used as a build system, and to manage **dependencies**.
   - The [SoftiCAR Platform](https://github.com/softicar/platform) version is defined in `platform-example-delivery-module/build.gradle`.
   - The [SoftiCAR Gradle Plugins](https://github.com/softicar/gradle-plugins) version is defined in `platform-example/build.gradle`.

### 1.1 Caveats

- The above project structure only defines a single module. While this is sufficient to get started, it might be overly simplistic for a real-world web application.
- Please create a [GitHub Issue](../../issues) if you need an example for a project with several modules.

## 2 Building and Development

To build and develop the code in this repository, an **Ubuntu 20.04 (Focal)** based workstation is recommended, with the following software installed:

1. [AdoptOpenJDK 15 with HotSpot JVM](https://adoptopenjdk.net/archive.html?variant=openjdk15&jvmVariant=hotspot), with `java` in the `PATH`
2. [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/packages/), e.g. [2020-09 (4.17)](https://www.eclipse.org/downloads/packages/release/2020-09/r)
3. [SQML Eclipse Plugin](https://github.com/softicar/sqml)

In _Eclipse_, the code shall be imported via _File / Import / Gradle / Existing Gradle Project_.

For prototyping purposes, an integrated [Jetty Server](https://www.eclipse.org/jetty/) and an integrated ephemeral [H2-Database](https://www.h2database.com/html/main.html) can be used:
- To start such a server, create a Java class like this:
  ```java
  public class DevelopmentServlet extends HotDeploymentWebServiceServlet {

      public DevelopmentServlet() {

          database.applyFixture(() -> {
              TestFixtureRegistry registry = new TestFixtureRegistry(new CoreModuleTestFixture());
              registry.registerIfMissing(WorkflowModuleTestFixture::new);
              return registry;
          });
      }

      public static void main(String[] args) {

          new HotDeploymentWebServiceServer(DevelopmentServlet.class)//
                  .setRequestString("service?id=" + EmfSourceCodeReferencePoints.getUuidOrThrow(PageService.class))
                  .setPort(8000).startAndJoin();
      }
  }
  ```
- When executed, it will print something like this:
  ```
  Server started at http://localhost:8000
  Full URL:
  http://localhost:8000/portal/service?id=95cf1a1b-c12e-4594-9d20-783988fe32b9
  ```
- Open a web browser and enter the URL.
- To log in, use one of the default users: `admin.user`, `normal.user` or `view.user`. The password is `test` for each of those.

### 2.1 Caveats

- In recent Eclipse versions, including `2021-09 (4.21)`, XML validation appears to be broken (particularly: XSD downloads).
- This leads to false-positive errors and warnings being displayed in `platform-example/web.xml`.
- The only known workarounds are to either disable XML validation in Eclipse, or to use an older release of the IDE, e.g. `2020-09 (4.17)`.

## 3 Operations

### 3.1 Runtime Requirements

Operating a _SoftiCAR Platform_ based web application requires:

- [Apache Tomcat 9.x](http://tomcat.apache.org/)
- [MariaDB 10.x](https://mariadb.org/) or [MySQL-Server 8.x](https://dev.mysql.com/downloads/mysql/)

### 3.2 Web Application Deployment

- To create a deployable web application in `.war` format, run:

      ./gradlew clean check war

- Deploy the application on an _Apache Tomcat_ server.

### 3.3 Database

The web application can be operated using either a _MariaDB_ or a _MySQL_ database server.

#### 3.3.1 Setup

- Install a database server or container as usual.
- Create a database user with the following permissions:
  ```sql
  GRANT
  CREATE TEMPORARY TABLES, SHOW DATABASES, SHOW VIEW, DELETE, INSERT, SELECT, UPDATE 
  ON *.*
  TO '<database-username>'@<tomcat-server-ip>
  IDENTIFIED BY '<database-password>';
  ```
  - Define and replace `<database-username>` and `<database-password>`.
  - Replace `<tomcat-server-ip>` as well.
- On the _Apache Tomcat_ server, create `/home/<tomcat-user>/.softicar/config.properties` with the following content:
  ```
  com.softicar.db.username = <database-username>
  com.softicar.db.password = <database-password>
  com.softicar.db.server.address = <tomcat-server-ip>
  ```

#### 3.3.2 Initialization

- Our current approach to initialize the database content is highly manual, quirky, and hard to even describe.
- A proper database initialization subsystem of [SoftiCAR Platform](https://github.com/softicar/platform) is currently in the works. This documentation will be updated _when it's done_.
- Please create a [GitHub Issue](../../issues) if you cannot wait, and you need instructions on how to initialize a database, right away.

## 4 Contributing

Please read the [contribution guidelines](CONTRIBUTING.md) for this repository and keep our [code of conduct](CODE_OF_CONDUCT.md) in mind.
