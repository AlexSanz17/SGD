<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="org.ositran.utils.Constantes" %>
<%@ page import="java.text.SimpleDateFormat"%> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html>
    <head>
        <title>Detalle del Documento de Recepción Virtual</title>

        <meta http-equiv="cache-control" content="no-cache">
        
        <style type="text/css">
        	.div-adjunto {
        		padding: 5px 0px;
        	}
        	
        	.td-cliente {
        		width: 27%;
        		padding: 15px 10px;
        	}
        </style>
        
        <script type="text/javascript">
           function enviarCargo(idExterno, accion) {
               if (!confirm("¿Desea Enviar el Cargo del Documento a la Entidad Emisora?")){ 
                    return;
               }
               
               dijit.byId("dlgProgresBar").show();
               var service = new dojo.rpc.JsonService("SMDAction.action");
               var defered = service.enviarCargo(idExterno, "M", "FI", accion);
               
               defered.addCallback(function(respuesta){
                    dijit.byId("dlgProgresBar").hide();
                    
                    if (respuesta == "0"){ 
                      alert("El Cargo debe ser Firmado");
                      return;
                    }else{
                       if (respuesta == "2"){ 
                          alert("No se pudo procesar su solicitud. Vuelva a intentarlo.");   
                          return; 
                       }else{
                           if (respuesta == "1"){
                              alert("Su información se registro satisfactoriamente, pero hubo un error en la comunicación con la entidad emisora.");
                           }else{
                               alert(respuesta);
                           }
                        }       
                    }
                    showGridInbox(sTipoGridActual);
               })
          }
          
          function verArchivoPrincipalPIDE(codigo) {
              var fecha = new Date();              
              window.open("<%=request.getContextPath()%>/verDocumento.png?idCodigo=" + codigo + "&accion=abrirPrincipalVirtual&fecha=" + fecha);
          }    
          
          function verArchivoPrincipalMPV(url) {
              window.open(url);
          }    
          
          function verArchivoCargo(codigo) {
              var fecha = new Date();
              window.open("<%=request.getContextPath()%>/verDocumento.png?idCodigo=" +codigo + "&accion=abrirCargoRecepcionVirtual&fecha=" + fecha );
          }     
          
          function verArchivoAnexo(url) {
               window.open(url, "_blank"); 
          }     
          
          function recepcionar(codigoVirtual) {
              var service = new dojo.rpc.JsonService("SMDAction.action");
              var defered = service.validarExistRecepcion(codigoVirtual);
              
              defered.addCallback(function(respuesta){
                 if (respuesta == "0"){
                    if(dijit.byId("tabNuevoDocumento")){
                             dijit.byId("tabContainerInbox").removeChild(dijit.byId("tabNuevoDocumento"));
                             dijit.byId("tabNuevoDocumento").destroyDescendants();
                             dijit.byId("tabNuevoDocumento").destroy();
                     }

                     var dialog = dijit.byId("dlgProgresBar");
                     dialog.show();
                     
                     var newTab = new dojox.layout.ContentPane({
                        id : "tabNuevoDocumento",
                        jsId : "tabNuevoDocumento",
                        closable: true,
                        href : "NuevoDocumento_mostrarVistaRecepcion.action?codigoVirtual=" + codigoVirtual +"&tipoTransaccion=R",
                        title: "Recepcionar Documento",
                        onClose: function(){
                           showGridInbox(sTipoGridActual);
                           return true;
                        }
                     });
                     dijit.byId("tabContainerInbox").addChild(newTab);
                     dijit.byId("tabContainerInbox").selectChild(newTab);
                     dialog.hide();
                 }
                 
                 if (respuesta == "1"){
                   alert("El documento ya fue registrado en el Sistema SGD. Verificar");
                   return;
                 }
                 
                 if (respuesta == "-1"){
                   alert("Vuelva a procesar su solicitud de registro de recepcion.");    
                   return;
                 }
             }); 
          }
          
          function rechazar(codigoVirtual) {
              var opciones = "toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, width=750, height=440, top=20, left=70";
              var pagina = "RechazarDocumentoMPV_goRechazar.action?idDocumentoRechazar=" + codigoVirtual;
              window.open(pagina, "Rechazar Documento", opciones);
          }
        </script>
    </head>
    
    <body class="soria">
          <table width="100%">
            <tr>
                <td colspan="6" align="left">
                    <div dojoType="dijit.Toolbar"> 
                            <s:if test="objDD.flagCodigoVirtual == '0'"> 
                              <div dojoType="dijit.form.Button"  onClick="recepcionar('<s:property value="objDD.idCodigo" />')" iconClass="siged16 iconoOk">Recepcionar</div>
                              
                              <s:if test="objDD.cuo == null || objDD.cuo == ''">
                              	<div dojoType="dijit.form.Button"  onClick="rechazar('<s:property value="objDD.idCodigo" />')" iconClass="siged16 iconoAnular">Rechazar</div>
                              </s:if>
                            </s:if>
                            
                            <s:if test="objDD.flagCodigoVirtual == '1'"> 
                               <div dojoType="dijit.form.Button"  onClick="enviarCargo('<s:property value="objDD.idCodigo" />', 'T')" iconClass="siged16 iconoOk">Recepcionar - Enviar Cargo</div>    
                            </s:if>
                     </div>    
                </td>
            </tr>
              
            <tr>
                <td style="width: 1%;"></td>
                
                <td colspan="2" style="width: 35%;font-size:12px;" valign="top"> 
                    <br/><b>Asunto: </b><s:property value="objDD.strAsunto" />
                </td>
                
                <td colspan="2" style="width: 35%;" valign="top">
                   <table>
                       <tr>
                           <td></td>
                           <td height="16" colspan="5" align="left" class="plomo"><br/>Adjuntos:</td>
                       </tr>
                       
                        <tr>
                           <td height="16" colspan="5" align="left" class="plomo">
                               <s:if test="objDD.cuo != null && objDD.cuo != ''">
                               	  <div class="div-adjunto">
	                               	 <a onclick="verArchivoPrincipalPIDE('<s:property value='objDD.idCodigo' />');" alt="Ver Archivo Principal PIDE">
	                               	 	<b><font color="<s:property value="@org.ositran.utils.Constantes@COLOR_DOCUMENTO_PRINCIPAL_PIDE" />"><s:property value="objDD.archivoPrincipal"/></font></b> [<s:property value="objDD.tamanoPrincipal" />] 
	                               	 </a>
                               	  </div>
                               </s:if>
                               <s:else>
                               	  <div class="div-adjunto">
								     <a onclick="verArchivoPrincipalMPV('<s:property value='objDD.rutaArchivoPrincipal' />');" alt="Ver Archivo Principal MPV">
								    	<b><font color="<s:property value="@org.ositran.utils.Constantes@COLOR_DOCUMENTO_PRINCIPAL_MPV" />"><s:property value="objDD.archivoPrincipal" /></font></b> [<s:property value="objDD.tamanoPrincipal" />]
								     </a>
								  </div>
								</s:else>
                               
                               <s:if test="objDD.archivoCargo != null && objDD.archivoCargo != ''">
                               	  <div class="div-adjunto">
	                                  <a onclick="verArchivoCargo('<s:property value='objDD.idCodigo' />');" alt="Ver Archivo Cargo">
	                                  	 <b><font color="<s:property value="@org.ositran.utils.Constantes@COLOR_DOCUMENTO_CARGO_TV" />"><s:property value="objDD.archivoCargo" /></font></b> [<s:property value="objDD.tamanoCargo" />]
	                                  </a>
                                  </div>
                               </s:if>
                               
                               <s:if test="objDD.cantAnexos > 0">
                                  <div class="div-adjunto">
                                   	 Anexos:
                                  </div>
                                  <s:iterator value="objDD.listAnexos">
                                  	 <div class="div-adjunto">
                                   		<a onclick="verArchivoAnexo('<s:property value="rutaArchivo" /><s:property value="nombreArchivo" />');" alt="Ver Archivo Anexo"><s:property value="nombreArchivo" /> [<s:property value="tamanoArchivo" />]</a>
                                   	 </div>
                                  </s:iterator>
                               </s:if>
                           </td>
                        </tr>    
                   </table>
                </td>
                
                <td class="td-cliente" align="right" valign="top">
                   <table cellpadding="1" cellspacing="1" class="tableForm">
                      <tr style="height:20px;">
                           <td width="100px" style="font-size: 11px;font-weight:normal;background-color:#669BCD;color:#ffffff;vertical-align:center;text-align:center;border: 1px #000 solid;">
								Nro. Documento
                           </td>
                           <td style="background-color:#ffffff;border: 1px #000 solid;width: 250px;">
                               <s:property value="objDD.strNroDocumento" /> 
                           </td>
                       </tr>
		
					  <s:if test="objDD.iIdTipoIdentificacion == 1">
                        <tr style="height:20px;">
                                <td style="font-size: 11px;font-weight:normal;background-color:#669BCD;color:#ffffff;vertical-align:center;text-align:center;border: 1px #000 solid;">
									RUC
                                </td>
                                <td style="background-color:#ffffff;border: 1px #000 solid;width: 250px;">
                                    <s:property value="objDD.ruc" />
                                </td>
                          </tr>
                          
                          <tr style="height:20px;">
                             <td style="font-size: 11px;font-weight:normal;background-color:#669BCD;color:#ffffff;vertical-align:center;text-align:center;border: 1px #000 solid;">
						  		Cliente
                             </td>
                             <td style="background-color:#ffffff;border: 1px #000 solid;width: 250px;">
                                 <s:property value="objDD.strRazonSocial" />
                             </td>
                       	  </tr>
                        </s:if>
                        <s:else>
                        	<tr style="height:20px;">
                                <td style="font-size: 11px;font-weight:normal;background-color:#669BCD;color:#ffffff;vertical-align:center;text-align:center;border: 1px #000 solid;">
									DNI
                                </td>
                                <td style="background-color:#ffffff;border: 1px #000 solid;width: 250px;">
                                    <s:property value="objDD.strNroIdentificacion" />
                                </td>
                          </tr>
                          
                          <tr style="height:20px;">
                               <td style="font-size: 11px;font-weight:normal;background-color:#669BCD;color:#ffffff;vertical-align:center;text-align:center;border: 1px #000 solid;">
								  Cliente
                               </td>
                               <td style="background-color:#ffffff;border: 1px #000 solid;width: 250px;">
                                   <s:property value="objDD.strRemitente" />
                               </td>
                         	  </tr>
                          </s:else>
                         
                          <s:if test="objDD.cuo != null && objDD.cuo != ''">
                             <tr style="height:20px;">
                                <td style="font-size: 11px;font-weight:normal;background-color:#669BCD;color:#ffffff;vertical-align:center;text-align:center;border: 1px #000 solid;">
									CUO
                                </td>
                                <td style="background-color:#ffffff;border: 1px #000 solid;width: 250px;">
                                    <s:property value="objDD.cuo" />
                                </td>
                             </tr>
                          </s:if>
                   </table>
                </td>
            </tr>
                                    
             <tr>
                <td height="50" colspan="6">
                    <table width="100%"  border="1" align="center" bordercolor="#669BCD" bgcolor="#ffffff">
                        <tr>
                            <td>
                                <table width="100%" height="100" align="center" >
                                    <tr>
                                        <td width="2%"></td>
                                        <td width="1%" height="5"></td>
                                        <td width="1%"></td>
                                        <td width="4%"></td>
                                        <td width="1%"></td>
                                        <td width="91%"></td>
                                    </tr>
                                    
                                    <tr>
                                        <td width="1px"></td>
                                        <td colspan="5">
                                            <div>  
                                               <p>
                                                   Ud. ha recibido un Documento Virtual con
                                                   Nro. <font class="negrita"><s:property value="objDD.strNroDocumento" /></font>
                                                   el dia <font class="negrita"><s:date name="objDD.strFecha" format="dd/MM/yyyy" /></font>
                                                   a las <font class="negrita"><s:date name="objDD.strFecha" format="HH:mm" /></font>
                                               </p>
                                            </div>  
                                        </td>
                                    </tr>                
                                </table>
                            </td>
                        </tr>
                    </table>
                </td>
             </tr>
               
              <tr>
                <td height="14" colspan="6"></td>
            </tr>  
          </table>                          
    </body>
</html>