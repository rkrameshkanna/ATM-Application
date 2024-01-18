ATM - Application:

Developed an ATM application using Java with AWT (Abstract Window Toolkit) for the graphical user interface and MySQL database for data storage.

Functionalities:

Implemented features such as cash withdrawal, cash deposit, balance inquiry, and PIN and mobile number change.

Supported different account types (Savings and Current).

Utilized SQL queries to interact with the MySQL database for user authentication and data retrieval.

Ensured user security by using parameterized queries and preventing SQL injection vulnerabilities.

Graphical User Interface (GUI):

Designed a user-friendly GUI with buttons and panels for various functionalities.
Utilized Java's AWT and Swing libraries to create interactive and responsive components.

Database Interaction:

Established a connection to the MySQL database using JDBC (Java Database Connectivity).

Implemented methods to perform user authentication, retrieve user data, and update user information in the database.

Error Handling:

Implemented error handling to provide informative messages to the user in case of invalid inputs or database errors.

Code Organization:

Structured the code into classes and methods, promoting modularity and readability.

Separated the SQL-related functionalities into a dedicated class (sqlclass.java) for better organization.

Technology Stack:

Java (AWT, Swing) for the frontend development.

MySQL for the backend database.
JDBC for Java-MySQL database connectivity.

Version Control:

The application version has been tracked, and the code has been organized to facilitate future updates and maintenance.

Database creativity:  

1.Download MySQL from offical website.

2.After downling the MySQL create a database that has been shown in MySql-database folder.

Steps to compile and run the program:

1.This Command Will Give Us a Class File

     javac -classpath ..\lib\mysql-connector-j-8.2.0.jar;. sqlclass.java 

2.So This Command Will Create a New Folder Called sqlpack

     javac -classpath ..\lib\mysql-connector-j-8.2.0.jar;. -d . sqlclass.java 


Note: In sqlpack sqlclass.java & sqlclass.class File should be present

3.After That To Run The Application Execute The Below Command

    java atm_awt.java

This project demonstrates skills in Java programming, GUI development, database interaction, and error handling. It showcases the ability to design and implement a functional and user-friendly application for handling basic ATM operations.
