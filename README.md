### PROJECT : LOCATION_AUTOMATION

## Description
The project comprises automating the geolocation emulation scenarios  using the selenium 4, Java and testng framework.

## Pre-requisites
Ensure installation of below softwares before proceeding with test execution,
  1. Install Eclipse IDE on your machine
       -[Eclipse IDE](https://www.eclipse.org/downloads/)
  2. Download and install the latest jdk version from the Oracle official website.
       - [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
       - Set "JAVA_HOME" environment variable to the path of jdk folder in the system.
  3. Install Apache Maven (Maven is tool to build automation and project development)
       -  [Apache Maven](https://maven.apache.org/download.cgi)
       -  Set "MAVEN_HOME" environment variable to the path of maven local folder, add new path variable to bin location.
  4. TestNG Installation (Testng is java testing framework, with features like creation and execution of test suites)
      - Open Eclipse -> Go to Help -> Open 'Eclipse MarketPlace' Option.
      - Search for "TESTNG" in the marketplace.
      - Install the Testng Plugin.
## Project Installation
    - Copy the github repository link.
    - Open Git bash, run the command "git clone <copied link>, project will be cloned to required location in local system.
    - Open eclipse, import the cloned project as "existing maven project".
    - Right click on the project -> update maven project (required dependencies will be downloaded).
## Required Dependencies of pom.xml
    - Selenium Java
    - Testng
    - WebDriver Manager
    - Json Simple
  note: all the dependencies are available in given pom.xml file, for more details and updated versions of mentioned dependencies please refer to [central maven repository](https://mvnrepository.com/)
## Instructions to execute project
    Execution can be done through 2 ways. 
    1. Execution through eclipse IDE
      - Open TestSuites folder -> LocateTests.xml 
      - right click on the file -> run as testng
      - All the tests will be executed as per the sequence mentioned.
      - Test report will be generated and stored in "reports" folder with name "Automation_Report.json"
    2. Execution through command line
      - Open command line at the project location.
      - Run command "mvn clean install", all the tests of project will be executed.
      
## TestData Reference Document
    - please refer to TestData folder to update required test data details, "data.json" file to be manipulated.
## Test Report Reference
    - please refer to reports folder for generated test report, "Automation_Report.json"
