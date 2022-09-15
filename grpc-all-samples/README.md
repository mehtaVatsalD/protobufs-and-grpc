# Grpc Learnings

We know that there are four different variants for grpc

- Unary
- Server streaming
- Client streaming
- Bidirectional streaming

So as part of this project we are trying to create scenarios
and implement them using above grpc variations.

### App details
We are dealing with prime numbers as part of this app.
Client needs to know things or few about prime numbers, and we have server, our prime number SME to help us.
So in several scenarios, client will ask different things related to prime numbers.
Following are different scenarios.

### Unary Scenario
In this scenario client <strong>wants to know nth prime number</strong>.
Hence, client will send list of numbers. And server will give respective prime number.
Client will send list of numbers at once [blocking] and server will calculate all prime numbers and once all work is done it will send response back [blocking]

### Server streaming
In this scenario client <strong>wants to know first n prime number</strong>.
So client will send simple request[all at once] (n) and server will stream first n prime numbers one by one.

### Client streaming
In this scenario client has some list of numbers. It wants to know whether they are prime or not.
To do so, client will stream all this numbers one after the other to server and 
then server will send complete response all at once[blocking].

### Bidirectional streaming
This scenario will be almost similar to client streaming where client has list of numbers which it streams to server to know whether it is prime or not,
and server instead of sending complete response all at once, will stream response back to client.






