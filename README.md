# BookStoreWebServices
Spring RESTful Webservices for bookstore management

This is a Spring based RESTful api's for Book Store Mgmt. A user can retrieve, update and delete existing books and add new books.
MySql is used in the backend for persisting the Data.
HATEOAS is been used for generating metadata.
Hibernate for Object Mappings.
JPA for DB operations.
Maven as Build tool.
Jackson for Serialization and Desrialization of Java Objects.

Project setup: 

This is a native Spring app and hence it need to have a server to deploy on. Tomcat can be used for deployment. 

Notice MySql is being used as Database and the connection properties can be easly tweeked in spring-dispatcher-servlet.xml.(Will provide SQL script)

Exposed endpoints:

/books(GET) - Retrieves list of available books 
/books(POST) - Add a new book
/books/{id}(GET) - Retrieve a specific book
/books/{id}(PUT) - Update a specific book
/books/{id}(DELETE) - Delete a specific book

