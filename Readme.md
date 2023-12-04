## OVERVIEW
As a consultant, you have been hired to build a small web application for a customer to track contacts. Provided the
solution meets the functional and technical requirements below, you are free to use any resources, libraries, and
technologies to implement the system. 

There is no right approach or deadline. The solution provided will be used as
the basis for your interview. Be prepared to discuss your approach.

## FUNCTIONAL REQUIREMENTS
There are four user stories associated with the customer requirement:
1. As a user I want to create a new contact by entering the first name, last name, email, and phone number
   so that I can track the people I know.
2. As a user I want to be able to search for a contact by first and/or last name so that I can find contact
   information quickly.
3. As a user I want to be able to update contacts when their last name, email, or phone number change so
   that I can keep my contact information up to date.
4. As a user I need to be able to delete a person I no longer associate with so that I can keep my contact list
   clean.
## TECHNICAL REQUIREMENTS
   The customer has some limitations on the technology set that can be used to implement the functional requirements
   and they are as follows:
   
* Java 11 for backend
* ✓ Maven (latest preferred, no older than 3.6.0)
   - groupId=com.victor
   - artifactId=victor
* ✓ SQLite (latest preferred, no older than 3.30.0)
* ✓ Application must be executable via Maven (e.g. mvn jetty:run-war or mvn spring-boot:run)
   If your name were Jane Smith, you would use the value smith_jane for naming purposes.

## DELIVERY
   When delivering the software, please ensure the following.
* The software must be delivered as a zip file of the complete Maven project without the target directories.
* Include the Maven command to run the project (e.g. mvn jetty:run-war) in a README.txt inside the zip file.
* The zip filename must conform to the naming convention specified in the technical requirements. 

## EVALUATION
   When we receive your submission, we will execute the following steps in an environment running the Java and
   Maven versions specified in the technical requirements:
1. ✓ Unzip the submitted zip file
2. ✓ Run mvn test
3. ✓ Run the command specified in README.txt (e.g. mvn jetty:run-war)
   
If the project does not meet the technical requirements or either of the Maven command executions fail, we will
   not evaluate the code and thus not proceed with the interview process.

We will perform the following actions once the project is up and running:
   * Test the live site to ensure it works per the functional requirements specified above
   * Perform a code review

## SOLUTION

1. How to run
    ```shell
    mvn spring-boot:run
    ```
    ```shell
    mvn jetty:run-war
    ```
2. How to test
    ```shell
    mvn test
    ```
