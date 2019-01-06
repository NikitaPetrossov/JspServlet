
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<html>
<head>
    <title>Product calculation</title>
    <link href="CssFile2.css" rel="stylesheet" type="text/css">
</head>
<body>
<script>
   function calculate() {
            var laminatPrice = $("#laminat").val() * 10000;
            var mdfPrice = $("#mdf").val() * 10000;
            var tableTopPrice = $("#tableTop").val() * 15000;
            var armPrice = $("#arm").val() * 500;
            var legPrice = $("#leg").val() * 500;
            var extensionSystemPrice = $("#extensionSystem").val() * 800;
            var loopPrice = $("#loop").val() * 100;
            var sinkPrice = $("#sink").val() * 5000;
            var fastenerPrice = $("#fastener").val() * 5000;
            var additionalPrice = $("#additional").val() * 5000;

            var productPrice = (laminatPrice+mdfPrice+tableTopPrice
                +armPrice+legPrice+extensionSystemPrice+loopPrice+sinkPrice
                +fastenerPrice+additionalPrice)*2 ;

            $("#productPrice").val(productPrice);
   }
</script>
<h1>Product calculation</h1>

<form action="/product" method="post">

    <table>
        <thead>
        <th></th>
        <th></th>
        </thead>
        <tbody >
        <tr >
            <td>  <input class="radius" type="text" id="name" name="name">  </td>
            <td >  <label class="name">Name</label> </td>
        </tr>
        <tr >
            <td> <input class="radius" type="number" id="laminat" name="laminat">   </td>
            <td > <label class="laminat">Laminat</label>  </td>
        </tr>
        <tr >
            <td>   <input class="radius"  type="number" id="mdf" name="mdf">   </td>
            <td >  <label class="mdf">Mdf</label>  </td>
        </tr>
        <tr >
            <td>   <input class="radius"  type="number" id="tableTop" name="tableTop">   </td>
            <td >  <label class="tableTop">TableTop</label>  </td>
        </tr>
        <tr >
            <td>   <input class="radius"  type="number" id="arm" name="arm">   </td>
            <td >  <label class="arm">Arm</label>  </td>
        </tr>
        <tr >
            <td>   <input class="radius"  type="number" id="leg" name="leg">   </td>
            <td >  <label class="leg">Leg</label>  </td>
        </tr>
        <tr >
            <td>   <input class="radius"  type="number" id="extensionSystem" name="extensionSystem">   </td>
            <td >  <label class="extensionSystem">Extension system</label>  </td>
        </tr>
        <tr >
            <td>   <input class="radius"  type="number" id="loop" name="loop">   </td>
            <td >  <label class="loop">Loop</label>  </td>
        </tr>
        <tr >
            <td>   <input class="radius"  type="number" id="sink" name="sink">   </td>
            <td >  <label class="sink">Sink</label>  </td>
        </tr>
        <tr >
            <td>   <input class="radius"  type="number" id="fastener" name="fastener">   </td>
            <td >  <label class="fastener">Fastener</label>  </td>
        </tr>
        <tr >
            <td>   <input class="radius"  type="number" id="additional" name="additional">   </td>
            <td >  <label class="additional">Additional</label>  </td>
        </tr>
        <tr >
            <td>   <input class="radius"  type="number" id="productPrice" name="productPrice">   </td>
            <td >  <label class="productPrice">Product price</label>  </td>
        </tr>
        </tbody>
    </table>
    <p>
        <input TYPE="submit" value="confirm">
    </p>
</form>
<input  id="calculate" type="submit" name="calculate" value="calculate price " onclick="calculate()">
</body>
</html>
