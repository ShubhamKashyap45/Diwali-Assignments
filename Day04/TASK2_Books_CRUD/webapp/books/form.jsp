<%@ page import="com.example.books.Book" %>
<!DOCTYPE html>
<html><head><title>Book Form</title></head><body>
<h2>Book Form</h2>
<form action="books" method="post">
  <input type="hidden" name="id" value="${book.id}"/>
  <label>Title: <input name="title" value="${book.title}" required></label><br>
  <label>Author: <input name="author" value="${book.author}" required></label><br>
  <label>Price: <input name="price" value="${book.price}" required></label><br>
  <button type="submit">Save</button>
</form>
</body></html>
