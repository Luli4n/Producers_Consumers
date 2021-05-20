# Producers
This is multithreaded app for producer-consumer implementation.
<br/>
It is a console app which solves the problem of producer-consumer by wait-notify mechanism. It was made for academic purposes.

There is a storage for merchandise (it has a capacity = 50). There are some producer threads and some consumer threads. Producers produce one of five items and try to put it into storage. Consumers are trying to get stuff from storage. Wait-notify mechanism prevents it from hazards.
