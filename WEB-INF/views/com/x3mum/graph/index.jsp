<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>x3mum</title>
  <script type="text/javascript" src="<c:url value="/js/jqplot/jquery.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/js/jqplot/jquery.jqplot.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/js/jqplot/plugins/jqplot.canvasAxisLabelRenderer.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/js/jqplot/plugins/jqplot.canvasTextRenderer.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/js/jqplot/plugins/jqplot.cursor.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/js/main.js"/>"></script>
  <link rel="stylesheet" type="text/css" href="<c:url value="/js/jqplot/jquery.jqplot.css"/>" />
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>" />
</head>

<body>

<div id="chartdiv" style="height:400px; width:700px; margin-left: 265px;" >function graphic...</div>

<table border="1" id="table_properties" style="margin-top: -370">
  <tr>
    <th>Name</th>
    <th>Values</th>
  </tr>
  <tr>
    <td>up</td>
    <td><input id="up" type="text" value="12" /></td>
  </tr>
  <tr>
    <td>down</td>
    <td><input id="down" type="text" value="-12" /></td>
  </tr>
  <tr>
    <td>left</td>
    <td><input id="left" type="text" value="-12" /></td>
  </tr>
  <tr>
    <td>right</td>
    <td><input id="right" type="text" value="12" /></td>
  </tr>
</table>

<table border="1" id="table_function" style="margin-top: -370">
  <tr>
    <th>Properties name</th>
    <th>Values</th>
  </tr>
  <tr>
    <td>function</td>
    <td><input id="function" type="text" value="" /></td>
  </tr>
</table>

<input id="findMin" type="button" value="Find min" />
<input id="step" type="button" value="step" />
<input id="test" type="button" value="test" />
<input id="test1" type="button" value="test1" onclick=setResultValue(true) />

<script type="text/javascript">
  function setResultValue(tmp)
  {
    if(tmp)
    {
      resultValueLeft = "${resultValue.left}";
      resultValueRight = "${resultValue.right}";
      alert(resultValueLeft);
    }
    else
    {
      resultValueLeft = $("#left").val();
      resultValueRight = $("#right").val();
    }
  }

  $(document).ready(function(){
    setResultValue(false);
  });
</script>

</body>

</html>