Step-by-Step to Run Automation Script in Eclipse

1. Install Prerequisites

* Install Java JDK and set JAVA_HOME.
* Install *Eclipse IDE for Java Developers.
* Download Selenium WebDriver JAR files from [selenium.dev](https://www.selenium.dev/downloads/).

2. Create a New Java Project

* Open Eclipse.
* Go to File > New > Maven Project.
* Enter a name (e.g., TestProject) and click Finish.

3. Add Dependencies

* in pom.xml file 
* Create a tag <dependencies> and place the {selenium,testng,junit} like this 
* for updating just we change the version tag only .

copy and paste in pom.xml

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>test</groupId>
  <artifactId>Demo</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <dependencies><!--
		https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>4.22.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>5.3.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.16.1</version>
		</dependency>

              <!-- https://mvnrepository.com/artifact/org.testng/testng -->
              <dependency>
                  <groupId>org.testng</groupId>
                  <artifactId>testng</artifactId>
                    <version>7.11.0</version>
                    <scope>test</scope>
               </dependency>

	</dependencies>
</project>

4. Create a New Test Class

* Right-click src/test/java > New >package> Class.
* Name it (e.g., LoginTest), check public static void main(String\[] args), then click **Finish.

5. Write Your Test Script

Example code:

java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        // Add your test steps here

        driver.quit();
    }
}

6. Run the Test

* Right-click on the test class > Run As > Java Application.
* The browser should open and execute your script.

7. View Results

* Check Eclipse's Console tab for output and logs.
* Use logs or screenshots (if implemented) to verify behavior.

step-by-step guide including both TestNG and JUnit integration in Eclipse for Selenium automation.


1. Install TestNG in Eclipse*

* Open Eclipse.
* Go to Help > Eclipse Marketplace.
* Search for TestNG for Eclipse.
* Click Install, accept the license, and restart Eclipse.

3. Add Dependencies

* in pom.xml file 
* Create a tag <dependencies> and place the {selenium,testng,junit} like this 
* for updating just we change the version tag only .

copy and paste in pom.xml

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>test</groupId>
  <artifactId>Demo</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <dependencies><!--
		https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>4.22.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>5.3.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.16.1</version>
		</dependency>

              <!-- https://mvnrepository.com/artifact/org.testng/testng -->
              <dependency>
                  <groupId>org.testng</groupId>
                  <artifactId>testng</artifactId>
                    <version>7.11.0</version>
                    <scope>test</scope>
               </dependency>

	</dependencies>
</project>

3. Create a TestNG Test Class*

* Right-click src/test/java > New >package>class 
* Enter a name (e.g., LoginTestNG).
* Click Finish.

4. Write TestNG Test Code

java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTestNG {

    WebDriver driver;

    @BeforeClass      //( keep browser launching setups)
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test             //(keep the script what we going to automate
    public void openWebsite() {
        driver.get("https://example.com");
        // Add assertions or interactions here
    }

    @AfterClass           //(keep the closing browser and report at this)
    public void tearDown() {
        driver.quit();
    }
}


5. Run the TestNG Test*

* Right-click the test file > Run As > TestNG Test.
