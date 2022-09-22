# protobufs-and-grpc
This repository records all code written while learning protocol buffers and grpc


### Channel
- A channel is abstraction provided by GRPC over http2 connection.
- Hence, all the management for connection is done by channel
- It keeps persistant connection between client and server.
  - But connection may be stopped by server due to some reasons like server restart, crash etc.
  - If channel does not find any active connection, it creates new one.
  - Keeping connection open even when not communicating, still consumes some resources.
    - Hence server may close connection after some hours.
- Channel creates connection lazily i.e. when it needs for the first time.
- No need to close connection explicitly. You can close if you are damn sure that you won't need it in future. Else it could be costly to reconnect too frequently.
- Creating channel is expensive process.
- It is thread safe. Hence, can be reused for different services (on same server). Can handle multiple concurrent requests.
  - One channel is enough between a pair of client and server for any number of conurrent requests.
    - More channels could be created but is ideally not needed.
