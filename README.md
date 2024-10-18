1. What is JDBC? How does it connect with the DB providers? 2. What is DAO?

JDBC (Java Database Connectivity) is an API that allows java developers to access, query, and modify data within a database. The JDBC uses a driver to establish a connection to a database, and then can run statements to execute SQL queries and retrieve the results in a results set. The DAO (Data Access Object) is a design pattern that separates the data access logic from the business logic, meaning that it separates the connecting and querying to a database, and the operations done with the retrieved data.

3. Why do we need a service layer in terms of DAO classes?

The service layer also separates the data access logic, and the business logic. The DAO classes handle the CRUD operations to formulate the queries and store/manipulate the data. The service layer is a way to manage the transactions performed by the DAO classes.

4. What is transaction? How is it realized in JDBC?

Transactions are essentially groups of CRUD operations done all at once in an all or nothing format. This means that if just one operation fails, then the entire transaction fails. This is useful to ensure data integrity well dealing with connecting data and data relations. In JDBC, using the connection object, transactions can be managed by disabling auto-commit, and using rollback in case of a transaction failure.

5. What are the differences between Statement and PrepareStatement?

The main differences between them are the statements are useful for simple SQL queries that do not require parameters, and statements are not precompiled. The prepared statement is more flexible, efficient, and scalable to execute dynamic, precompiled queries with parameters.

 6. What is ResultSet?

ResultSet is a java object that is returned after the execution of a JDBC statement or prepared statement. It represents the results of the SQL query and stores the data retrieved, allowing you to navigate and access the data.
