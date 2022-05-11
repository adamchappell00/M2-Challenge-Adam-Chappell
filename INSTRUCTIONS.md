##Application Overview

In this assessment, you will build a simple REST web service.
*** 

###  Goals
Your solution must have the following structural elements:

- Your solution must be in an IntelliJ project called M2-Challenge-Lastname-Firstname.
- Your project must be built using Spring Boot. Initialize your project using start.spring.io.
- Your REST API must accept and return data in JSON format where appropriate.
- Every endpoint must have at least one MockMVC test. Endpoints that have error conditions must also contain a MockMVC test for each kind of error.
- Your REST API must be documented with Swagger. Save the .yaml file in the root of your project directory.
***
### Instructions
Complete the following instructions for this Challenge.

#### Requirements/Features
This web service is a month-and-math service. You must implement and document the following REST API endpoints:

##### Month Converter:
- URI: /month/{monthNumber}
- HTTP Method: GET
- Request Body: None
- Response Body: A Month object containing the name and number of the requested month (1—January, 2—February, etc.)
- Error: 422, if the input is out of range

##### Random Month:
- URI: /randomMonth
- HTTP Method: GET
- Request Body: None
- Response Body: A Month object containing a randomly selected month

##### Add:
- URI: /add
- HTTP Method: POST
- Request Body: JSON object with operand1 and operand2
- Response Body: MathSolution, where answer is sum of operand1 and operand2
- Error: 422, if missing operand or if operands are not both numbers
##### Subtract:
- URI: /subtract
- HTTP Method: POST
- Request Body: JSON object with operand1 and operand2
- Response Body: MathSolution, where answer is difference of operand1 and operand2 (operand1 – operand2)
- Error: 422, if missing operand or if operands are not both numbers
#####Multiply:
- URI: /multiply
- HTTP Method: POST
- Request Body: JSON object with operand1 and operand2
- Response Body: MathSolution, where answer is product of operand1 and operand2
- Error: 422, if missing operand or if operands are not both numbers
##### Divide:
- URI: /divide
- HTTP Method: POST
- Request Body: JSON object with operand1 and operand2
- Response Body: MathSolution, where answer is quotient of operand1 and operand2 (operand1/operand2)
- Error: 422, if missing operand or if operands are not both numbers, or if operand2 is zero
***
#####A Month has the following fields:

- number
- name

For example:

`
{
"number": 9,
"name": "September"
}`

#####A MathSolution has the following fields:

- operand1
- operand2
- operation (one of add, subtract, multiply, and divide)
- answer

For example:

`{
"operand1": 10,
"operand2": 20,
"operation": "add",
"answer": 30
}`

All numeric fields for all endpoints (request and response) are integers.

***
###User Stories
Your application must complete the following user stories:

- As an API user, I would like to convert the number of any month to its corresponding text, e.g. "1" = "January".

- As an API user, I would like to be able to request a randomly selected month.

- As an API user, I would like to be able to add two numbers and receive back the result.

- As an API user, I would like to be able to subtract two numbers and receive back the result.

- As an API user, I would like to be able to multiply two numbers and receive back the result.

- As an API user, I would like to be able to divide two numbers and receive back the result.

#### Submission

Great job completing your second Challenge! It’s time to submit. Follow the steps from your first Challenge submission, but customize the naming conventions for this particular assignment. Make sure to double-check that your submission is completed.

