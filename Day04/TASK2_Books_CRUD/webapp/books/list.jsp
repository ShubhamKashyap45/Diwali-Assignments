<%@ page import="java.util.List" %>
<%@ page import="com.example.books.Book" %>
<!DOCTYPE html>
<html><head><title>Books</title></head><body>
<h2>Books</h2>
<a href="books?action=create">Add new book</a>
<table border="1">
  <tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Actions</th></tr>
  <c:forEach var="b" items="${books}">
    <tr>
      <td>${b.id}</td><td>${b.title}</td><td>${b.author}</td><td>${b.price}</td>
      <td>
        <a href="books?action=edit&id=${b.id}">Edit</a>
        <a href="books?action=delete&id=${b.id}">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body></html>
