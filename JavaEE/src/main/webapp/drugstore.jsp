<%@ page import="com.example.drugstore.entities.Drugstore" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.drugstore.entities.Drugstore" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Drugstores</title></head>
<body>
<h1>Drugstore Management</h1>

<h2>Add Drugstore</h2>
<form action="drugstores" method="post">
    <input type="text" name="name" placeholder="Drugstore Name" required>
    <input type="text" name="address" placeholder="Drugstore Address" required>
    <input type="hidden" name="action" value="add">
    <button type="submit">Add Drugstore</button>
</form>

<h2>All Drugstores</h2>
<ul>
    <%  List<Drugstore> drugstoreList = (List<Drugstore>) request.getAttribute("drugstores");
        for (Drugstore drugstore : drugstoreList) {
    %>
    <li>
        <form action="drugstores" method="post" style="display:inline;">
            ID: <%= drugstore.getId() %>, Name: <%= drugstore.getName() %>, Address: <%= drugstore.getAddress() %>
            <input type="hidden" name="id" value="<%= drugstore.getId() %>">
            <input type="hidden" name="action" value="delete">
            <button type="submit">Delete</button>
        </form>
    </li>
    <% } %>
</ul>

</body>
</html>
