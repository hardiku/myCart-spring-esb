<<<<<<< HEAD
Application Description
=============================
A legacy shopping cart application, where users places their order via uploading a csv file describing order details.
A new system is needed to support web clients to place order using Http api interface.
Solution should support both old bulk ordering as well as new web interface to be integrated with ordering system.

Solution is:
----------------------
Old legacy system should upload a order file to a FTP directory 'placeorder'.
Form this directory order description files moves to jms queue (incommingorders).
Http web interface (REST) application should put order details to jms queue (incommingorders).
From jms queue (incommingorders) orders are being moved to jms queue orders for order processing system.
Order processing system reads orders from jms queue and moves processed orders to orders directory.
orders jms queue is a temporary storage of orders before they get moved to orders directory.

Following is the route for order processing
file:placeorder -> jms:incommingorders -> jms:order -> file:orders

--------------------------------------------------------------

=======
>>>>>>> origin/master
To run this example project build the project and execute the Camel routes 
according to the steps below. 

Setup
==============================

- Install Eclipse 3.6.2
    - Download distribution from http://www.eclipse.org. 
    - Unzip the downloaded Eclipse distribution to a location on your hard disk 
    that you find suitable.

- Install Apache Maven 3+
    - Download distribution from http://maven.apache.org. 
    - Unzip the downloaded Maven distribution to a location on your hard disk
    that you find suitable.
    - configure this location as the environment variable MAVEN_HOME
    - add MAVEN_HOME/bin to your PATH environment variable

Running the Camel application
============================

Try executing with:

  mvn exec:java

<<<<<<< HEAD
This will load up the Camel application. 
=======
This will load up the Camel application as described in the article. 
>>>>>>> origin/master

Running Tests
============================

You will probably find it much more useful to run the tests included with
this example though. The tests send messages to the endpoints and add 
mock endpoints for the detection of the messages on the orderQueue.

To run the tests, issue the following Maven command:

mvn test

The tests add the route defined in the file

./src/test/java/org/camel/mycart/TestRouter.java
./src/test/java/org/camel/mycart/PlaceOrderTest.java

This file basically adds from("jms:orders").to("mock:orders") so that
all messages passing through the normalizer into the orders JMS queue
will be sent to the "orders" mock endpoint. The MockEndpoint in Camel
contains methods helpful for expecting certain message contents (plus
other features that we won't touch on here).

The unit test is in this file

./src/test/java/org/camel/mycart/PlaceOrderTest.java

To place two file orders we copy the premade file orders to the directory 
where the file endpoint is listening on ("target/placeorder")

        IOHelper.copyFile(new File("src/data/message1.xml"), new File("target/placeorder/message1.xml"));
        IOHelper.copyFile(new File("src/data/message2.csv"), new File("target/placeorder/message2.csv")); 

The mock endpoint basically asserts that the two normalized messages make it to the mock endpoint.

To place an XML order over HTTP we use the camel-http component. Sending to an 
endpoint in Camel programatically is easy when the ProducerTemplate class is 
used. In our case, this is created automatically because we extend the test 
case from ContextTestSupport. We just have to reference the "template" field and 
use the requestBody method. This method will send the message content (a String 
with XML data) to the HTTP endpoint and will wait for the HTTP response. In 
our case, we have defined the response to be a simple "OUT" String.

        Object response = template.requestBody("http://localhost:8888/placeorder", body);

Loading into Eclipse
============================

Use m2eclipse to import the project(s). In Eclipse, 
  - Select File->Import...
  - Select Maven->Existing Maven Projects... and click Next
  - Browse to the directory where you extracted the example
  - You should now be able to select the project to import
============================

<<<<<<< HEAD
=======
Application Description
=============================
A legacy shopping cart application, where users places their order via uploading a csv file describing order details.
A new system is needed to support web clients to place order using Http api interface.
Solution should support both old bulk ordering as well as new web interface to be integrated with ordering system.

Solution is:
----------------------
Old legacy system should upload a order file to a FTP directory 'placeorder'.
Form this directory order description files moves to jms queue (incommingorders).
Http web interface (REST) application should put order details to jms queue (incommingorders).
From jms queue (incommingorders) orders are being moved to jms queue orders for order processing system.
Order processing system reads orders from jms queue and moves processed orders to orders directory.
orders jms queue is a temporary storage of orders before they get moved to orders directory.

Following is the route for order processing
file:placeorder -> jms:incommingorders -> jms:order -> file:orders

-----------------------------------------
>>>>>>> origin/master
You can also play with test files provided to experiment and understand the use case.
I hope this will help 
