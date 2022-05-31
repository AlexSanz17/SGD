<?xml version="1.0" encoding="UTF-8" ?>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es">
   <head>
   	  <title>Notificar Documento</title>
   	  
      <meta http-equiv="Content-Type" content="text/html; utf-8" />
      <link type="text/css" rel="stylesheet" href="css/styleSiged.css" />
<link type="text/css" rel="stylesheet" href="js/dojo/css/styleDojo.css" />
      <link rel="stylesheet" type="text/css" href="css/estilo.css" />
      <link rel="stylesheet" type="text/css" href="js/dojo/dijit/themes/soria/soria.css" />
      <script type="text/javascript" src="js/dojo/dojo/dojo.js"></script>
      <script type="text/javascript" src="js/jquery.js"></script>
      <script type="text/javascript" src="js/siged/siged.js"></script>
		<script type="text/javascript" src="js/siged/siged.forms.js"></script>
		<script type="text/javascript" src="js/siged/siged.string.js"></script>
      <script type="text/javascript">
         var USUARIO_ROL = "<s:property value='#session._USUARIO.rol' />";

         dojo.require("dijit.Editor");
         dojo.require("dijit._editor.plugins.FontChoice");  // 'fontName','fontSize','formatBlock'
         dojo.require("dijit._editor.plugins.TextColor");
         dojo.require("dijit._editor.plugins.LinkDialog");
         dojo.require("dojo.io.iframe");
         dojo.require("dojo.rpc.JsonService");
         dojo.require("dijit.form.FilteringSelect" );
         dojo.require("dojo.data.ItemFileReadStore");
         dojo.require("dijit.form.TextBox");
         dojo.require("dijit.form.DateTextBox");
         dojo.require("dijit.Dialog");
         dojo.require("dijit.form.Button");
	 dojo.require("dojox.grid.DataGrid");
         dojo.require("dijit.form.NumberTextBox");

         function rechazar() {
             if (confirm("Desea rechazar el documento " + "<s:property value='documento.numeroDocumento' /> ?")) {
            	 dojo.xhrPost({
	                url: "rechazarDocumento.action",
	                content: {
	                	tipoArchivar : 'rechazar'
	                 },
	                form: dojo.byId("frmRechazar"),
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
               window.opener.parent.location.href ='goRechazar.action?sTipoFrame=grid' ;
            }

            window.close();
         }
      </script>
   </head>
   
   <body  class="soria"
      <s:if test="cerrar!=null">
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
                           		<img onclick="javascript:rechazar()"  src="images/derivar.bmp" border="0" alt="Derivar"/>
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
								<td> <input type="hidden" name="FK_eIdCasilla" id="FK_eIdCasilla"/></td>
							</tr>
							<tr>
								<td> <input type="hidden" name="FK_eIdAplicacion" id="FK_eIdAplicacion"/></td>
							</tr>
							<tr>
								<td align="left" style="padding-left: 25px">Tipo de Notificación: </td>
								<td colspan="4"> 
									<select dojoType="dijit.form.FilteringSelect"
                                            id="FK_eIdTipoNotificacion"
                                            name="FK_eIdTipoNotificacion"
                                            idAttr="id"
                                            labelAttr="label"
                                            style="width:190px;"
                                            required="true"
                                            hasDownArrow="true"
                                            searchAttr="label"
                                            store="storeProveidos">
                                    </select> 
								</td>
							</tr>
                              <tr>
                                 <td align="left" style="padding-left: 25px">Observación: </td>
                                 <td >
                                    <s:textarea id="uObservacion" name="uObservacion" cols="60" rows="5" cssClass="cajaMontoTotal" />
                                 </td>
                              </tr>
                               <tr>
                                 <td> <input type="hidden" name="FK_eIdTipoDocNotificacion" id="FK_eIdTipoDocNotificacion"/></td>
                              </tr>
                               <tr>
                                 <td align="left" style="padding-left: 25px">Número de Documento: </td>
                                 <td >
                                     <div dojoType="dijit.form.ValidationTextBox"
                                      id="uNumDocNotificacion"
                                      jsId="uNumDocNotificacion"
                                      name="uNumDocNotificacion"
                                      invalidMessage="Ingrese un Nro de Documento" regExp=".{1,40}"
                                      required="true" trim="true" />
                                 </td>
                              </tr>
                              <tr>
                              	<td><input type="hidden" name="eIdDocumentoSTD" id="eIdDocumentoSTD"/></td>
                              </tr>
                                <tr>
                                 <td align="left" style="padding-left: 25px">Número de Expediente: </td>
                                 <td >
                                     <div dojoType="dijit.form.ValidationTextBox"
                                     type="text"
                                      id="eIdExpedienteSTD"
                                      jsId="eIdExpedienteSTD"
                                      name="eIdExpedienteSTD"
                                      invalidMessage="Ingrese un Nro de Expediente" regExp=".{1,40}"
                                      required="true" trim="true" />
                                 </td>
                              </tr>
                               <tr>
                              	<td><input type="hidden" name="uCodExpedienteSTD" id="uCodExpedienteSTD"/></td>
                              </tr>
                               <tr>
                              	<td><input type="hidden" name="eOrden" id="eOrden"/></td>
                              </tr>
                          	<tr>
                          		    <td colspan="5"  class="normal"><s:hidden
										id="eUsuarioRegistro" name="eUsuarioRegistro" /> 
                                       <script
											type="text/javascript">

									   var cadena  = document.getElementById("ta").value;
									   //document.getElementById("contenid").innerHTML = cadena;
									   //cadena  =document.getElementById("contenid").innerHTML;
									   //alert("cadena1:"+cadena);
									   cadena = cadena.replace(/<P><\/P>/g,"");
									   //alert("cadena2:"+cadena);
									   document.getElementById("contenid").innerHTML = cadena.substring(0,3999);
									    //cadena=document.getElementById("contenid").innerHTML;
									   //alert(cadena);


									</script>
								</td>
                          	</tr>
							  <tr>
                                                           
                                   <td  colspan="5">
                                          <input    style="font-weight: bold;font-size:14px;width:765px"type="text" name="ta" id="ta"  value="<s:property value='ta'  />"> </input>
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