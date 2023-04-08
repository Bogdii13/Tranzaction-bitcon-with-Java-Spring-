# future-up-java

# 1. Prerequisites
Make sure you installed the following programs:

- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
- [JDK 11 ](https://adoptium.net/?variant=openjdk11&jvmVariant=hotspot)
- [Postman](https://www.postman.com/downloads/)
- [git command line tool](https://help.github.com/articles/set-up-git)

Optional (if you want to use PostgreSQL database engine):
- [PostgreSQL 11](https://www.postgresql.org/download/) 
- [PgAdmin](https://www.pgadmin.org/) (should get automatically installed when installing PostgreSQL)

# 2. How to start

1. After you installed everything clone this project and open IntelliJ IDEA. If prompted with a `Trust and Open Project` alert, click `Trust Project`
2. Switch the branch to `iteration/3`
3. In IntelliJ go to project structure (`File` -> `Project Structure`).
4. In the project tab -> `Project SDK` select `JDK 11`. If it is not in the list, press on `Add` -> `SDK...` and select the path where you installed JDK 11. Should be a folder that contains `bin`, `lib` and other folders.
5. After choosing `JDK 11`, wait for the application to get indexed.
6. Right-click the `pom.xml` file and click `Add as Maven project` **OR** click `Load Maven Project` in the floating window in the bottom right.
7. Right-click the `FutureUpApplication` file in the `Project` pane and click `Run 'FutureUp..`. After this the configuration should appear in the top right of the IDE.


# 3. Database configuration

We offer two configuration options for the database engine: H2 is lightweight and easy to set up while PostgresSQL is more powerful but a also a bit more complicated. For the scope of this project both options are perfectly fine but we decided to offer both of the options for the sake of diversity.

## 3.1 For H2 database

The [H2 database](https://www.h2database.com/html/main.html) database engine has the advantage of being fast, small and in-memory thus making it great for quick development without prerequisites.

In order to use this database engine there is no need to download any additional software, the only thing needed for the file `resources/application.properties` file to look like this:

    #FOR H2
    spring.datasource.url=jdbc:h2:mem:futureup
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=password
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    spring.jpa.defer-datasource-initialization=true
    spring.h2.console.enabled=true
    
    #FOR POSTGRESSQL
    #spring.datasource.url=jdbc:postgresql://localhost:5432/futureup
    #spring.datasource.username=postgres
    #spring.datasource.password=root
    #spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    #spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL9Dialect
    #spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false
    #spring.jpa.hibernate.ddl-auto=update
    #spring.main.allow-bean-definition-overriding=true
    #spring.jackson.default-property-inclusion=non_null


There is no need to download any additional software in order for this config to work

To access H2 database console application go to: http://localhost:8080/h2-console while the Spring server is running

The `JDBC URL` should be like the field `spring.datasource.url` in `application.properties` (in our case `jdbc:h2:mem:futureup`)

The `User Name` field should be like the field `spring.datasource.username` in `application.properties` (in our case `sa`)

The `Password` field should be like the field `spring.datasource.password` in `application.properties` (in our case `password`)

Further optional reading:

[Spring Boot With H2 Database via Baeldung](https://www.baeldung.com/spring-boot-h2-database)

## 3.2 For PostgreSQL

[PostgreSQL](https://www.postgresql.org/) is an open source database engine and is one of the most powerful database engines available at the moment.

The use of this database requires an few extra steps:
1. Install PostgreSQL and PgAdmin
2. Create a database called `futureup` in PgAdmin

In order to use this database engine there is no need to download any additional software, the only thing needed for the file `resources/application.properties` file to look like this:

    #FOR H2
    #spring.datasource.url=jdbc:h2:mem:futureup
    #spring.datasource.driverClassName=org.h2.Driver
    #spring.datasource.username=sa
    #spring.datasource.password=password
    #spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    #spring.jpa.defer-datasource-initialization=true
    #spring.h2.console.enabled=true
    
    #FOR POSTGRESSQL
    spring.datasource.url=jdbc:postgresql://localhost:5432/futureup
    spring.datasource.username=postgres
    spring.datasource.password=root
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL9Dialect
    spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false
    spring.jpa.hibernate.ddl-auto=update
    spring.main.allow-bean-definition-overriding=true
    spring.jackson.default-property-inclusion=non_null

The fields `spring.datasource.username` and  `spring.datasource.password` correspond to the username and password you set during the PostgreSQL installation process. The default user is `postgres`

# 4. Postman

1. Open `Postman`
2. Go to `Import`, `File` tab and click `Upload Files`
3. Go to `other_files/FutureUp.postman_collection.json` (on branch `iteration/3`) and click `Open`
4. In `Postman`, go to `Collections` and select `FutureUp`
