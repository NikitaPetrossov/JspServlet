<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <link href="CssFileOld.css" rel="stylesheet" type="text/css">
    <title>Main page</title>
</head>
<body>
<h1>Main page</h1>

<form method="get" action="/table">

<table >

    <thead>
    <th >Id</th>
    <th >Name</th>
    <th>Laminat</th>
    <th>Mdf</th>
    <th>TableTop</th>
    <th>Arm</th>
    <th>Leg</th>
    <th>Extension system</th>
    <th>Loop</th>
    <th>Sink</th>
    <th>Fastener</th>
    <th>Additional</th>
    <th>Product price</th>
    </thead>

    <tbody>
        <c:forEach var="product" items="${productsFromServer}">
    <tr>
        <td> ${product.id}   </td>
        <td> ${product.name}   </td>
        <td> ${product.laminat}   </td>
        <td>${product.mdf}   </td>
        <td> ${product.tableTop}    </td>
        <td> ${product.arm}    </td>
        <td> ${product.leg}    </td>
        <td> ${product.extensionSystem}    </td>
        <td> ${product.loop}    </td>
        <td> ${product.sink}    </td>
        <td> ${product.fastener}    </td>
        <td> ${product.additional}    </td>
        <td> ${product.productPrice}    </td>

    </tr>
    </c:forEach>
    </tbody>

</table>
</form>
<form method="post" action="table">

              <input class="radius" type="number" id="id" name="id">
              <label class="id">Write Id for delete</label>

    <p>
        <input TYPE="submit" value="delete">
    </p>
</form>
<form method="get" action="update">

    <input class="radius" type="number" id="idUpdate" name="idUpdate">
    <label class="idUpdate">Write Id for update</label>

    <p>
        <input TYPE="submit" value="update">
    </p>
</form>

</form>
<form method="get" action="product">


    <p>
        <input TYPE="submit" value="add product">
    </p>
</form>

</body>
</html>
