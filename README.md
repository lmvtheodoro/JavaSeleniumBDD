<h2 align="left"> Selenium/BDD - Login Scenarios</h2>
<h3 align="left">Lucas Magnani Vikar Theodoro</h3>

## Testing Automation Architecture(PageObjects):

📦src   
 ┣ 📂main   
 ┃ ┣ 📂java   
 ┃ ┗ 📂resources   
 ┗ 📂test   
 ┃ ┣ 📂java   
 ┃ ┃ ┗ 📂PageObjects   
 ┃ ┃ ┃ ┗📜LoginPage.java   
 ┃ ┃ ┗ 📂Steps   
 ┃ ┃ ┃ ┃📜LoginSteps.java  
 ┃ ┃ ┃ ┗📜TestsRunner.java   
 ┃ ┃ ┗ 📂Util   
 ┃ ┃ ┃ ┗ 📜Utils.java  
 ┃ ┃ ┃    
 ┃ ┗ 📂resources    
 ┃ ┃ ┗ 📂Features   
 ┃ ┃ ┃ ┗📜login.feature    
 ┃ ┃   
 ┃ ┗ README.md 
 ┗ .gitignore


## Attention!
```java
    Project is set up to run on Microsoft Edge browser. 
     -> If you wish to change the browser, it will be necessary to configure the driver in the LoginPage.java file.
     (Lines 27, 28 and 30)  
```
## How to execute:
```java
    Access the root directory (JavaSeleniumCucumber) through system terminal and run the command: ->>> mvn clean test <<<-
     -> OR Open the project through IDE and test using the login.feature and/or TestsRunner files.
```
## Test Execution Reports:
```java
    If you wish to view the report of your last test execution via TestsRunner.java, 
     -> You can check the directory: JavaSeleniumCucumber\target\Reports.
```

## Technologies:

- [Java-OpenJDK 19.0.2](https://www.java.com/pt-BR/)
- [Selenium](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.8.0)
- [Cucumber-Java](https://mvnrepository.com/artifact/io.cucumber/cucumber-java/7.10.0)
- [Cucumber-jUnit](https://mvnrepository.com/artifact/io.cucumber/cucumber-junit/7.10.0)
- [Webdrivermanager](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.3.2)