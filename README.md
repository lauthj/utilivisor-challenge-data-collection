# Code Challenge: Data Collection

The purpose of this challenge is to test your file processing and code organization skills utiliizing the Java + Spring Framework. This challenge is designed measure your technical skills but also to give you a glimpse into the real problems you will help solve being a technical resource at utiliVisor. In this case, a building is sending us a CSV file in an unique format that requires a new data collection method.

### Recommended Software

* Apache Maven 3.6.x
* Java JDK version 11
* IntelliJ IDEA

### Development Environment Setup

1.) Download and install Maven and Java JDK onto your machine. Double check the maven setup and associated Java version by running `mvn --version` via command line.

```
MacBook-Pro:utilivisor-challenge-data-collection$ mvn --version
Apache Maven 3.6.1 (d66c9c0b3152b2e69ee9bac180bb8fcc8e6af555; 2019-04-04T14:00:29-05:00)
Maven home: /usr/local/Cellar/maven/3.6.1/libexec
Java version: 11.0.9, vendor: Oracle Corporation, runtime: /usr/local/Cellar/openjdk@11/11.0.9/libexec/openjdk.jdk/Contents/Home
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.15.7", arch: "x86_64", family: "mac"
```

2.) Download the [utilivisor-challenge-data-collection](https://bitbucket.org/utilivisor/utilivisor-challenge-data-collection/downloads/) repository and place anywhere your heart desires.

3.) Via command line, change directories to the root of the project and run the following command `mvn spring-boot:run`. If this is the first time you run this command, you will be waiting a minute or so for Maven to download all project dependencies. When done correctly, the output on the command line should be similar to what's pasted below:

```
    .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.2)

2021-02-09 17:37:50.568  INFO 77087 --- [  restartedMain] ivisorChallengeDataCollectionApplication : Starting UtilivisorChallengeDataCollectionApplication using Java 11.0.9 on MacBook-Pro.local with PID 77087 (/User/me/Projects/utilivisor-challenge-data-collection/target/classes started by me in /User/me/Projects/utilivisor-challenge-data-collection)
2021-02-09 17:37:50.570  INFO 77087 --- [  restartedMain] ivisorChallengeDataCollectionApplication : No active profile set, falling back to default profiles: default
2021-02-09 17:37:50.608  INFO 77087 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2021-02-09 17:37:50.609  INFO 77087 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2021-02-09 17:37:51.201  INFO 77087 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2021-02-09 17:37:51.210  INFO 77087 --- [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2021-02-09 17:37:51.211  INFO 77087 --- [  restartedMain] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.41]
2021-02-09 17:37:51.372  INFO 77087 --- [  restartedMain] org.apache.jasper.servlet.TldScanner     : At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
2021-02-09 17:37:51.379  INFO 77087 --- [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2021-02-09 17:37:51.379  INFO 77087 --- [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 770 ms
2021-02-09 17:37:51.503  INFO 77087 --- [  restartedMain] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2021-02-09 17:37:51.614  INFO 77087 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2021-02-09 17:37:51.645  INFO 77087 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-02-09 17:37:51.655  INFO 77087 --- [  restartedMain] ivisorChallengeDataCollectionApplication : Started UtilivisorChallengeDataCollectionApplication in 6.371 seconds (JVM running for 6.716)
```

4.) Goto your favorite internet browser and navigate to [http://localhost:8080/data-collection](http://localhost:8080/data-collection). If you have a very simple and un-styled form that allows you to upload a file you are successfully setup!

### Overview

* In the utiliVisor world, time-series data that we gather is associated to an individual point. A point contains a series of timestamp/value entries known as point history.
* Open and observe the `wide-csv-example.csv` found at the root of the project. This is considered a "wide CSV" data collection method where the first column is the timestamp column, the remaining columns are point names, and each row is an individual timestamp containing the data for each point.
* The timestamps in the timestamp column are in the Eastern Timezone (EST). Data often comes in different time zones and need to be normalized to UTC.

### The Challenge

1. Parse through the `wide-csv-example.csv` file to create a list of point history objects. Associate the point key found in the CSV file with table below which is a point ID and a more user-friendly point name.
1. Convert the EST timestamp to the UTC (GMT +0) timezone.
1. Organize the codebase as you see fit. Just keep in mind that in the real world there are several dozen different data collection methods.
1. Return the list of point history objects as JSON back to the view.
1. Zip your final product and send your results for us to review.

### Point Table

| Point Key                             | Point ID | Point Name                   |
|---------------------------------------|----------|------------------------------|
| EV_01_15B_2331_SHERIDAN_CONDMT_value  | 55       | 01-15B 2331 SHERIDAN CONDMT  |
| EV_02_67B_RYAN_HALL_CHW_TON_HR_value  | 56       | 02-67B RYAN HALL CHW TON HR  |
| EV_01_19B_2347_SHERIDAN_CONDMT_value  | 57       | 01-19B 2347 SHERIDAN CONDMT  |
| EV_01_47B_717_UNIVERSITY_CONDMT_value | 58       | 01-47B 717 UNIVERSITY CONDMT |
| EV_02_62D_SLIVKA_CON_MT_KLBS_value    | 59       | 02-62D SLIVKA CON MT KLBS    |