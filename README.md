# Facebook-SignUp-Login
Automation testing for Sign-up and Login processes on Facebook. Using of XML Data Driven Testing with Selenium-Java,
instead of using hard-coded values each time the test runs. The test should do the following steps:
1) Open website.
2) Signup and send the following registration test data: First Name, Last Name, Email, Password, Birth Date, Gender, etc.
3) Login using the email and password generated from the first step using TestNG Data Provider annotation with Excel data sheet.
4) Deactivate account.
# Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 
See deployment for notes on how to deploy the project on a live system.
# Tools
* Selenium WebDriver
* Selenium Standalone Server
* poi-excel-utils 
# Requirements 
* Selenium chrom driver 3.3
* Selenium standalone driver 3.14
* Chrome and Chromedriver
* Java 1.8
* poi-excel-utils 2 beta
* poi-ooxml 3.12
* poi-ooxml-schemas 3.12
# Installing
1) Install Java on your computer
         Download and install the Java Software Development Kit (JDK).
2) Install Eclipse IDE
         Download "Eclipse IDE for Java Developers". Be sure to choose correctly between Windows 32 Bit and 64 Bit versions. 
3) Download the Selenium Java Client Driver
         You will find client drivers for other languages there, but only choose the one for Java. 
4) Configure Eclipse IDE with WebDriver
* Launch the "eclipse.exe" file inside the "eclipse" folder, the executable should be located on C:\eclipse\eclipse.exe.
* When asked to select for a workspace, just accept the default location.
* Create a new project through File > New > Java Project. Name the project as "FacebookSignUp&Login".
* Enter the needed details "Project Name, Location to save project, Select an execution JRE, Select layout project option,
   and Click on Finish button".
5) In this step,
* Right-click on the newly created project and
* Select New > Package, and name that package as "test"
* Click on Finish button
6) Create a new Java class under newpackage by right-clicking on it and then selecting- New > Class, 
then name it as "SignUp_Login" and click on Finish button.
7) In this step,     
* Right-click on the created project and select Properties.
* On the Properties dialog, click on "Java Build Path".
* Click on the Libraries tab, and then Click on "Add External JARs.."
When you click on "Add External JARs.." It will open a pop-up window. Select the JAR files you want to add. 
After selecting jar files, click on OK button.
8) Select all files inside the lib folder and files outside the lib folder. Once done, click "Apply and Close" button.
9) Finally, click OK and we are done importing Selenium libraries into our project. 
    
    
    
    
