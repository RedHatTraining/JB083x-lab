# JB125 Java EE 7 Hello World web App

##This app is composed of the following architecture:

* Maven Project - builds a WAR
* Using JSF 2.2 for web interface, HTML5 facelets page, JSF backing beans, CDI scopes on beans, @Named
* Statelss EJB for services - uses JPA entity beans - exposes appropriate method as REST API using JAX-RS annotations
* JAX-RS Application class
* JPA entity bean to store names - uses H2 in-memory database
* Use EJB Singleton to lookup messaging connection and queue destination and inject into stateless EJB - lookup should only occur once on startup
* Servlet that returns "OK" - this is a health check - path should be [context]/health
* H2 (embedded in-memory DB) backend
