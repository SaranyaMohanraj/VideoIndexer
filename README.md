# VideoIndexer
VideoIndexer Application -Automation
Selenium-Java-TestNG Framework(POM)
A Maven framework in which to build Selenium tests written in Java with TestNG reports of test results.

**Getting Started**
Copy the repo into your local machine.
Copy the Test File that is used for testing from the resources folder to somewhere in local machine and mention that location in test data file in AddVideo sheet

**Run tests locally**
Right click the Test File and Run as TestNG Project

**Run tests through the commandline**
As this project uses Maven, we can invoke the tests using Maven goals.
To run the test, use your CI or point Maven to the project and use the goals:

clean install site

**Tests Definition**
Use case 1- >Adding Video
In this Test only one video is added indexed and all the tests corresponding to the one file upload is automated.
More Files adding could be automated in the future by modifying the test data and implementing the logic for the same.
**Use case 2- >Video Insights**
Insights at People has been focussed on this test. When the Timeline on the people insight is clicked,relevant movement of the video to that time is automated.. The same could be enhanced to other Insights as well.
**Use case 2- >Search Video**
After the search verification of the video in grid/List is performed. However this verification is done for first video that appears on the search and could be enhanced to other searched videos too.

