# networks
Follow the example of socket programming in chapter 2 (java edition ppt), for implementing a clientserver simple program. Use the code for TCP and UDP.
Your program must implement a simple request-response example:
1) The client reads the line (request) from standard input, then sends it to the server.
2) Server reads the line from the socket and prints the incoming message from the client.
3) The server sends (response) back.
The response is taken from a file stored in the server side. Think of it as 
DataBase table.
For example: the client sends "B001", the server sends "Seat, Ibiza, 2009, 
Orange". In case there is no match request, send "Vehicle is not found".
Sample database is shown in the table below.
4) The client reads and prints the result from the socket.
5) The client can make more requests, before closing the app.
Submit a compressed folder that contains, the java code for client and server.
