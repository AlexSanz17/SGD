<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <title>Sistema de Control de Asistencia</title>
      <link href="css/estilo.css" rel="stylesheet" type="text/css">
      <META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE" >
     
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <style type="text/css">
         <!--
         body {
            background-color: #ffffff;
         }
         -->
      </style>
      <script type="text/javascript">
         function jsRefrescarBandeja() {
            parent.frames["mainFrame"].location.href = "doBody.action";
         }
      </script>
   </head>
   <body onload="jsRefrescarBandeja()">
      <table width="100%" border="0">
         <tr>
            <td height="100" align="center" class="label">El expediente <s:property value='objDD.strReferencia'/> se aprob&oacute; satisfactoriamente</td>
         </tr>
      </table>
   </body>
</html>
