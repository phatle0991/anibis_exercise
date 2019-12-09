selenium-serenity-cucumber-java-maven
=================
Download a Framework
--------------
* Maven - https://github.com/phatle0991/anibis_exercise.git

Prerequisite
--------------
- Install JDK 1.8
- Install Cucumber for Java plugin for your Idea (intellij or eclipse) - https://www.hindsightsoftware.com/blog/cucumber-jvm-intellij#:~:targetText=Install%20and%20conFIgure%20cucumber%20plugin&targetText=Head%20to%20Preferences%20%3E%20Plugins%20and,to%20restart%20IntelliJ%20once%20complete.
- Install maven - https://www.mkyong.com/maven/how-to-install-maven-in-windows/

Framework Architecture
--------------
	anibis_exercise
		|
		|_src/main/java
		|	|_config
		|	|   |_config.properties
		|	|   |_serenity.properties
		|	|_pages
		|	|   |_HomePage.class
		|	|	|_LoginPage.class
		|	|	|_SearchPage.class
		|	|_util
		|       |_Config.class
		|       |_ElementUtils.class
		|       |_SetUp.class
		|       |_Util.class
		|       
		|_src/test/java
		|   |_stepdefs
		|   |   |_HomeStepDefs.class
		|   |   |_LoginStepDefs.class
		|   |   |_SearchStepDefs.class
		|   |_testrunner
		|       |_browsers
		|       |   |_chrome
		|       |   |_edge
		|       |   |_firefox
		|       |   |_ie
		|       |_hook
		|       |    |_Hooks
		|       |
		|       |_TestRunnerSearch.class
		|   
		|_src/test/resources
		|	|_features
		|	|   |_Home.feature
		|	|   |_Login.feature
		|	|   |_Search.feature

* **src/main/java/config** - config.properties is storing CONSTANT for testing. serenity.properties is using for serenity report setting
* **src/main/java/pages** - all the Pages in POM goes here.

* **src/main/java/util** - Utilize functions
> Try to click/fill/getText/waitPageLoad/waitElementPresent..... Web Element Facade to prevent timed out issue, stop to try after maxTries times.
> Select option/link/item from List<WebElementFacde>

* **src/test/java/stepdefs** - you can define step defintion under this package for your feature steps.

* **src/test/java/testrunner** - This package contains JUnit Cucumber runner where you can 
configure your glue code location (step defintions). 
> **This test framework support cross browser test**, just config which browser you want to run in glue. SetUp hook will be run to initilize WebDriver Depend on which browser you had selected
**i.e I want to run Test with Chrome browser**: glue = {"stepdefs","testrunner.hook","testrunner.browsers.**chrome**"}

> **Hooks.class** where you can configure all before and after Test with @After/@Before annotation. It will be run after each scenario.

* **src/test/resources/features** - all the cucumber features files (files .feature ext) goes here.

Writing a test
--------------

The cucumber features goes in the **src/test/resources/features** library and should have the ".feature" extension.

Predefined steps
-----------------
By using predefined steps you can automate your test cases more quickly, more efficiently and without much coding.

The predefined steps are located **src/test/resources/stepdefs**


Setting Browser from TestRunner
-----------------
You can define to run with which browser from TestRunner: **src/test/java/testrunner**  

**i.e: I want to run Test with Chrome browser**: glue = {"stepdefs","testrunner.hook","testrunner.browsers.**chrome**"}

Running test
--------------

**Run by Command Line:**
Go to your project directory from terminal and hit following commands
* `mvn verify`
* `mvn verify -Dcucumber.options="classpath:features/Home.feature"` to run specific feature.

**Run by JUnit**
1. Right click the Project
2. Click on Maven
3. Click on Reimport
4. Right click on src/test/java/testrunner/TestRunner.class
5. Click on Run 'TestRunner'

Test Report
--------------
Serenity test report will be generate in: $project.dir/target/site/serenity/index.html
i.e /Users/macair/IdeaProjects/anibis_exercise/target/site/serenity/index.html