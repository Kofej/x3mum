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
    <div class="main-board">
      <table border="1">
        <tr>
          <th colspan="3">Graphic properties</th>
        </tr>
        <tr>
          <td>upper limit</td>
          <td><input id="up" type="text" value="6" /></td>
        </tr>
        <tr>
          <td>lower limit</td>
          <td><input id="down" type="text" value="-2" /></td>
        </tr>
        <tr>
          <td>left bound</td>
          <td><input id="left" type="text" value="-2" /></td>
        </tr>
        <tr>
          <td>right bound</td>
          <td><input id="right" type="text" value="5" /></td>
        </tr>
        <tr>
          <td>accuracy</td>
          <td><input id="accuracy" type="text" value="0.001" /></td>
        </tr>
        <tr class="aqua">
          <td>function</td>
          <td><input id="function" type="text" value="" /></td>
        </tr>
      </table>

      <div id="chartdiv" class="graphic"> function graphic...</div>
    </div>

    <input id="findMin" type="button" value="Find min" />
    <input id="step" type="button" value="step" />

    <script type="text/javascript">
      $(document).ready(function() {
        currentLeft = $("#left").val();
        currentRight = $("#right").val();
      });
    </script>

  </body>
</html>