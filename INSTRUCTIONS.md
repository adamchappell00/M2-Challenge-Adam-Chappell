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

####Grading Requirements
General Setup and Format Requirements: 10%
Your solution must reside in an IntelliJ project called M2-Challenge-Lastname-Firstname. 5%
The REST API must be documented with Swagger. Save the .yaml file in the root of your project directory. 5%
Month Endpoint Code: 15%
Code is clean (follows general patterns as presented in class). 3%

Month endpoint: 3%

URI: /month/{monthNumber}
HTTP Method: `GET
Request Body: None`
Response Body: A Month object containing the name and number of the requested month (1—January, 2—February, etc.)
Error: 422, if the input is out of range
Month object members: 3%

number
name
MockMVC test for successful response. 3%

MockMVC test for input out of range. 3%

Random Month Endpoint Code: 15%
Code is clean (follows general patterns as presented in class). 3%

Random Month endpoint: 3%

URI: /randomMonth
HTTP Method: GET
Request Body: None
Response Body: A Month Object containing a randomly selected month
Month object members: 3%

number
name
MockMVC test for successful response. 3%

Months are served at random. 3%

Add Endpoint Code: 15%
Code is clean (follows general patterns as presented in class). 3%

Add endpoint: 3%

URI: /add
HTTP Method: POST
Request Body: JSON object with operand1 and operand2
Response Body: MathSolution, where answer is sum of operand1 and operand2
Error: 422, if missing operand or if operands are not both numbers
MathSolution object members: 3%

operand1: same value as operand1 input
operand2: same value as operand2 input
operation: add
answer: sum of operand1 and operand2
MockMVC test for successful response. 3%

MockMVC test for invalid request. 3%

Subtract Endpoint Code: 15%
Code is clean (follows general patterns as presented in class). 3%

Subtract endpoint: 3%

URI: /subtract
HTTP Method: POST
Request Body: JSON object with operand1 and operand2
Response Body: MathSolution, where answer is result of operand1 minus operand2
Error: 422, if missing operand or if operands are not both numbers
MathSolution object members: 3%

operand1: same value as operand1 input
operand2: same value as operand2 input
operation: subtract
answer: result of operand1 minus operand2
MockMVC test for successful request. 3%

MockMVC test for invalid request. 3%

Multiply Endpoint Code: 15%
Code is clean (follows general patterns as presented in class). 3%

Multiply endpoint: 3%

URI: /multiply
HTTP Method: POST
Request Body: JSON object with operand1 and operand2
Response Body: MathSolution, where answer is product of operand1 and operand2
Error: 422, if missing operand or if operands are not both numbers
MathSolution object members: 3%

operand1: same value as operand1 input
operand2: same value as operand2 input
operation: multiply
answer: product of operand1 and operand2
MockMVC test for successful response. 3%

MockMVC test for invalid request. 3%

Divide Endpoint Code: 15%
Code is clean (follows general patterns as presented in class). 2%

Divide endpoint: 3%

URI: /divide
HTTP Method: POST
Request Body: JSON object with operand1 and operand2
Response Body: MathSolution, where answer is result of operand1 divided by operand2
Error: 422, if missing operand or if operands are not both numbers
MathSolution object members: - 2%

operand1: same value is operand1 input
operand2: same value as operand2 input
operation: divide
answer: integer result of operand1 divided by operand2
MockMVC test for successful response. 2%

MockMVC test for invalid request. 3%

MockMVC test for divide-by-zero request. 3%

Rubric
Module 2 Challenge Rubric
Module 2 Challenge Rubric
Criteria	Ratings	Pts
This criterion is linked to a learning outcomeGeneral Requirements: Solution must be in an IntelliJ project called M2-Challenge-Lastname-Firstname.
5 to >0.0 Pts
Full Marks
0 Pts
No Marks
5 pts
This criterion is linked to a learning outcomeGeneral Requirements: REST API must be documented with Swagger. Save the .yaml file in the root of your project directory.
5 to >0.0 Pts
Full Marks
0 Pts
No Marks
5 pts
This criterion is linked to a learning outcomeMonth Endpoint: Code is clean (follows general patterns as presented in class)
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeMonth Endpoint: URI: /month/{monthNumber}, Method: GET, Request Body: None, Response Body: Month
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeMonth Endpoint: Month Object: number, name
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeMonth Endpoint: MockMVC test for successful response
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeMonth Endpoint: MockMVC test for input out of range
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeRandom Month Endpoint: Code is clean (follows general patterns as presented in class)
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeRandom Month Endpoint: URI: /randomMonth, Method: GET, Request Body: None, Response Body: Month
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeRandom Month Endpoint: Month Object: number, name
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeRandom Month Endpoint: MockMVC test for successful response.
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeRandom Month Endpoint: Months are served at random
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeAdd Endpoint: Code is clean (follows general patterns as presented in class)
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeAdd Endpoint: URI: /add, Method: POST, Request Body: JSON containing operand1 and operand2, Response Body: MathSolution
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeAdd Endpoint: MathSolution object: operand1, operand2, operation, (correct) answer
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeAdd Endpoint: MockMVC test for successful response
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeAdd Endpoint: MockMVC test for invalid request
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeSubtract Endpoint: Code is clean (follows general patterns as presented in class)
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeSubtract Endpoint: URI: /subtract, Method: POST, Request Body: JSON containing operand1 and operand2, Response Body: MathSolution
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeSubtract Endpoint: MathSolution object: operand1, operand2, operation, (correct) answer
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeSubtract Endpoint: MockMVC test for successful response.
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeSubtract Endpoint: MockMVC test for invalid request
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeMultiply Endpoint: Code is clean (follows general patterns as presented in class)
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeMultiply Endpoint: URI: /multiply, Method: POST, Request Body: JSON containing operand1 and operand2, Response Body: MathSolution
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeMultiply Endpoint: MathSolution object: operand1, operand2, operation, (correct) answer
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeMultiply Endpoint: MockMVC test for successful response.
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeMultiply Endpoint: MockMVC test for invalid request
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeDivide Endpoint: Code is clean (follows general patterns as presented in class)
2 to >0.0 Pts
Full Marks
0 Pts
No Marks
2 pts
This criterion is linked to a learning outcomeDivide Endpoint: URI: /divide, Method: POST, Request Body: JSON containing operand1 and operand2, Response Body: MathSolution
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeDivide Endpoint: MathSolution object: operand1, operand2, operation, (correct) answer
2 to >0.0 Pts
Full Marks
0 Pts
No Marks
2 pts
This criterion is linked to a learning outcomeDivide Endpoint: MockMVC test for successful response.
2 to >0.0 Pts
Full Marks
0 Pts
No Marks
2 pts
This criterion is linked to a learning outcomeDivide Endpoint: MockMVC test for invalid request
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
This criterion is linked to a learning outcomeDivide Endpoint: MockMVC test for divide-by-zero
3 to >0.0 Pts
Full Marks
0 Pts
No Marks
3 pts
Total points: 100
