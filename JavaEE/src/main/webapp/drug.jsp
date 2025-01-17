<%@ page import="com.example.drugstore.entities.Drugstore" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.drugstore.entities.Drug" %>
<%@ page import="com.example.drugstore.entities.Drugstore" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Drugs</title></head>
<body>
<h1>Drug Management</h1>

<h2>Add Drug</h2>
<form action="drugs" method="post">
    <input type="text" name="title" placeholder="Drug Title" required>
    <input type="text" name="description" placeholder="Drug Description" required>
    <select name="drugstore_id">
        <option disabled selected>Select Drugstore</option>
        <%
            List<Drugstore> drugstoreList = (List<Drugstore>) request.getAttribute("drugstores");
            for (Drugstore drugstore : drugstoreList) {
                %>
        <option value="<%= drugstore.getId() %>"><%= drugstore.getName() %></option>
        <% } %>
    </select>
    <input type="hidden" name="action" value="add">
    <button type="submit">Add Drug</button>
</form>

<h2>All Drugs</h2>
<ul>
    <%
        List<Drug> drugList =  (List<Drug>) request.getAttribute("drugs");
        for (Drug drug : drugList) {
    %>
    <li>
        ID: <%= drug.getId() %>, Title: <%= drug.getTitle() %>, Description: <%= drug.getDescription() %>, Drugstore: <%= drug.getDrugstore().getName() %>
        <form action="drugs" method="post" style="display:inline;">
            <input type="hidden" name="id" value="<%= drug.getId() %>">
            <input type="hidden" name="action" value="delete">
            <button type="submit">Delete</button>
        </form>
    </li>
    <% } %>
</ul>

</body>
</html>
