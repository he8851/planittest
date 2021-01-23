Tester: Joseph He

ASSUMPTION: 

1.	The chrome browser was the default browser
2.	The default setting for Chrome Option was “start-maximized” and “disable-notifications”
3.	All the product Names(Such as "Funny Cow") were made up by two words with space in between 
4.	Invalid field only applied to the email field in the “Contact Page”
5.  As for the “forename” and “Message”, the fields allowed any String or special character, no rules around that
6.  Java SDK 15.0.1 was used for this project and language level was set to 8
7.  Maven was used for this project (POM.xml is included) 
8.  TestNG was used for the TestRunner
9.  Tests were executed in sequence (Test Case 1, 2, 3, 4)

README
1. Config.properties was to point to the location of Chromedriver.exe and also define the URL
2. Use testng.xml to run all the tests together or Run individual test from the "ContactPageTest" or "CheckoutPageTest"
3. The code structure is as below: 
a. src/main/java/config/ApplicationConfiguration - used for read the configurations
b. src/main/java/models/Product - Used to define the model for the product
c. src/main/java/pages          - Include all the pages
d. src/main/java/resources/config.properties - configuration file
e. src/test/java/tests           - Include all the tests
f pom.xml 
g testng.xml  

