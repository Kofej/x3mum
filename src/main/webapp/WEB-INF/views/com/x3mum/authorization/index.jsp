<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>x3mum</title>
  <script type="text/javascript" src="<c:url value="/js/jquery/jquery.js" />"></script>
  <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />" />
</head>
<body>

<center>
  <p id="txt">Here will be an authorization in some time..</p>
  <p id="redirect">You will be redirect in</p>
  <p id="time">5</p>

  <script type="text/javascript">
    var tm = 4;
    <%
    response.setHeader("Refresh", "5 ; url=graph");
    %>
    id=setInterval(function() {
      $("#time").text(tm);
      tm--;
      if(tm == 0) clearInterval(id);
    }, 1000);
  </script>

</center>

</body>
</html>