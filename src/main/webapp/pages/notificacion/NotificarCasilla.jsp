<?xml version="1.0" encoding="UTF-8" ?>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es">
   <head>
   	  <title>Notificar Documento</title>
   	  
      <meta http-equiv="Content-Type" content="text/html; utf-8" />
      <link rel="stylesheet" type="text/css" href="css/estilo.css" />
      <link rel="stylesheet" type="text/css" href="js/dojo/dijit/themes/soria/soria.css" />
      <script type="text/javascript" src="js/dojo/dojo/dojo.js"></script>
      <script type="text/javascript" src="js/jquery.js"></script>
      <script type="text/javascript">
         var USUARIO_ROL = "<s:property value='#session._USUARIO.rol' />";

         dojo.require("dijit.form.FilteringSelect");
         dojo.require("dijit.form.Button");
         dojo.require("dijit.form.Form");
         dojo.require("dojo.data.ItemFileReadStore");
         dojo.require("dijit.form.DateTextBox");
         dojo.require("dijit.form.ValidationTextBox");

         function enviarNotificacion() {
             if (confirm("Desea notificar el documento " + "<s:property value='documento.numeroDocumento' /> ?")) {
            	 dojo.xhrPost({
	                url: "enviarNotificacion.action",
	                content: {
	                	tipoArchivar : 'notificar'
	                 },
	                form: dojo.byId("frmNotificar"),
	                load: function() {
		            	window.close();
		            	window.opener.showGridInbox();
		            	window.opener.refreshTabDXE();
		            }
	             });
              }
         }

         function refrescar() {
        	alert("refrescar...");
            if (USUARIO_ROL=="") {
               console.debug("Intentando refrescar grid [%s]", window.opener.sTipoGridActual);
               window.opener.showGridInbox(window.opener.sTipoGridActual);
            } else {
               window.opener.parent.location.href ='goNotificar.action?sTipoFrame=grid' ;
            }

            window.close();
         }
      </script>
   </head>
   
   <body  class="soria"
      <s:if test="cerrar != null">
         onload="refrescar()"
      </s:if>>
      
      <form id="frmNotificar" name="frmNotificar" action="" method="post">
      	 <s:hidden name="idDocumentoNotificar" />
      	 
         <table width="100%">
            <tr>
               <td></td>
            </tr>
            <tr>
               <td height="20"colspan="6" class="titulo" width="99%">
                  <table width="37%" border="0" height="20" align="left">
                     <tr>
                        <td width="2%" align="center">
                           		<img onclick="enviarNotificacion()"  src="images/rechazar.bmp" border="0" alt="Notificar"/>
                        </td>
                        <td width="55%" align="center" class="tituloRojo"></td>
                     </tr>
                  </table>
               </td>
            </tr>
            <tr align="center">
               <td width="98%" colspan="6" align="left"></td>
            </tr>
            <tr>
               <td height="400" colspan="6" class="titulo" width="97%"  align="left">
               <s:hidden id="tipoArchivar" name="tipoArchivar" />
                  <table width="80%"  height="100%" align="center"  cellpadding="0" cellspacing="0" valing="top">
                     <tr>
                        <td width="65%" style="height:auto" border="3"  borderColor="#6487d4"  valign="top" >
                           <table width="103%">
                              <tr>
                                 <td height="13" colspan="2" class="header" >
                                    <div align="center">
										Notificar Documento <s:property value="documento.numeroDocumento" />
                                    </div>
                                 </td>
                              </tr>
                              <tr>
                                 <td height="13" colspan="2" class="header" ></td>
                              </tr>
                              <tr>
                                 <td colspan="2" align="center"></td>
                              </tr>
                              <tr>
                                 <td colspan="2" align="center"></td>
                              </tr>

                              <tr>
                                 <td align="left" style="padding-left: 25px">Observación: </td>
                                 <td >
                                    <s:textarea id="sObservacionNotificar" name="sObservacionNotificar" cols="50" rows="10" cssClass="cajaMontoTotal" />
                                 </td>
                              </tr>
                           </table>
                        </td>
                     </tr>
                  </table>
               </td>
            </tr>
         </table>
      </form>
   </body>
</html>