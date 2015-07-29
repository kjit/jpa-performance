# jpa-performance
JPA Performance debug and improvement demo

# Required server and database:
1. Wildfly 9.0.1
2. Postgresql 9.4.

#Setup server and database:
1. Install Database.
2. Install server
3. Modify JDBC postgres driver as described: https://docs.jboss.org/author/display/WFLY8/DataSource+configuration?_sscc=t
4. Deploy JDBC driver as regular server resource (application).
5. Setup datasource:
   - run \bin\jboss-cli.bat
   - add ds with command:
   [standalone@localhost:9990 /] data-source add --name=flightDS --jndi-name=java:/flightDS --connection-url=jdbc:postgresql://localhost/ff --driver-name=postgresql-9.4-1200.jdbc41-wf.jar --user-name=ff --password=ff 
     More info: http://blog.sentilabs.com/postgresql-module-on-wildfly-8-1-0/
     
6. Setup database:
   - as postgres run /sql/0_ddl.sql
   - as ff run next scripts in order
   

   



