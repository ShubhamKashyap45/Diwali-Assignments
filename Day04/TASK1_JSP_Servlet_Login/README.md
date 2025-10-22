TASK 1 - JSP + Servlet + JDBC Login Validation
------------------------------------------------
Files included (sample & minimal):
- webapp/WEB-INF/web.xml
- webapp/login.jsp
- src/com/example/servlets/LoginServlet.java
- src/com/example/utils/DBUtil.java

Steps to run (Tomcat):
1. Build .war including compiled classes and webapp folder.
2. Configure MySQL and create DB using SQL/task1_create_db.sql
3. Update DBUtil.java JDBC URL, user, password if needed.
4. Deploy on Tomcat and open /login.jsp
