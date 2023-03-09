# demo
SpringBoot Implementation

There are 4 classes not each is design with Single Functionality principle.
Book :- It will have getter and setter methods for all the values fields.
csvreader: It will parse the CSV files into list and so that it can be print with the help of printer
PrintBooks: cSVReader is injected as external dependency into this class and it will print the values which are fetched from Csvreader class.
Runner: it is the controller class where the DemoApplication class point for data. It will invoke data from printBooks class and publish it localhost:8080/prabhakar
once the code it running you can see the data published on the localhost:8080/prabhakar.

Please let me know if somemore information can be added.
