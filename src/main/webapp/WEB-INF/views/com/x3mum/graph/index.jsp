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
        <tr class="green">
          <td>up</td>
          <td><input id="up" type="text" value="12" /></td>
        </tr>
        <tr class="green">
          <td>down</td>
          <td><input id="down" type="text" value="-12" /></td>
        </tr>
        <tr class="green">
          <td>left</td>
          <td><input id="left" type="text" value="-12" /></td>
        </tr>
        <tr class="green">
          <td>right</td>
          <td><input id="right" type="text" value="12" /></td>
        </tr>
        <tr class="yellow">
          <td>function</td>
          <td><input id="function" type="text" value="" /></td>
        </tr>
      </table>

      <div id="chartdiv" class="graphic"> function graphic...</div>
    </div>

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