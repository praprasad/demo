# demo
SpringBoot Implementation

There are 4 classes not each is design with Single Functionality principle.
Book :- It will have getter and setter methods for all the values fields.
csvreader: It will parse the CSV files into list and so that it can be print with the help of printer
PrintBooks: cSVReader is injected as external dependency into this class and it will print the values which are fetched from Csvreader class.
Runner: it is the controller class where the DemoApplication class point for data. It will invoke data from printBooks class 
and publish it localhost:8080/prabhakar
once the code it running you can see the data published on the localhost:8080/prabhakar.

Test Coverage:
Created below mentioned classes to Junit testcases to test the code, which is running fine.
DemoApplicationTests.java: It will consist of 4 test cases, 
1 TC is for smoke testing where we are verifying the loading of the controller
2 TC is to validate response code and book title 
3 Tc is to validate writer name in the response body
4 TC is negative scenarios when we are hitting the wrong end point.

Please let me know if somemore information can be added.
