<?xml version="1.0" encoding="UTF-8" ?>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
   <head>
      <s:head/>
      <title>Tramite Documentario</title>
      <link rel="stylesheet" type="text/css" href="css/estilo.css" />
      <script language="javascript" src="js/form.js"> </script>
      <script language="Javascript" src="js/general.js"></script>
      <link rel="stylesheet" type="text/css" media="all" href="css/calendar-green.css" />
      <script type="text/javascript" src="js/calendar.js"></script>
      <script type="text/javascript" src="js/calendar-es.js"></script>
      <script type="text/javascript" src="js/calendar-setup.js"></script>
	  <script type="text/javascript" src="js/jquery.js"></script>
      <script language="JavaScript">
      $(document).ready(function(){
			$("#der").click(function(){
				$("#recursoIzquierda option:selected").each(function(){
					$("#recursoDerecha").append($(this).clone(true));
					$(this).remove();
				});
			});

			$("#izq").click(function(){
				$("#recursoDerecha option:selected").each(function(){
					$("#recursoIzquierda").append($(this).clone(true));
					$(this).remove();
				});
			});

			$("form").submit(function(){
				$("#recursoDerecha option").attr("selected","selected");
				//alert($("#rolDerecha option:selected").length);
				//return false;
			});
		});
      
         function Abrir_ventanaBuscar (pagina) {
            var opciones="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, width=760, height=530, top=50, left=200";
            window.open(pagina,"",opciones);
         }

         function Abrir_ventanaCargo (pagina) {
            var opciones="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, width=760, height=380, top=50, left=200";
            window.open(pagina,"",opciones);
         }

         function Abrir_ventanaObservacion (i) {
            var opciones="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, width=500, height=290, top=50, left=200";
            var pagina = "/siged/goRechazarQAS.action?iIdDoc="+i
            window.open(pagina,"",opciones);
         }

         function Abrir_pagina (pagina) {
            var opciones="location=mainFrame";
            window.open(pagina,"",opciones);
         }

         function putTextOnTextBox(textToPut){
            document.all.reciveTheText.value = textToPut;
         }
         function regresar(){
            history.back();
         }

         function ejecRech(i,docu){
            if (confirm("Desea rechazar el documento "+docu))
               location.href="/siged/doRechazarQAS.action?iIdDoc="+i
         }
      </script>

      <script type="text/javascript">

         function poorman_toggle(id)
         {
            var tr = document.getElementById(id);
            if (tr==null) { return; }
            var bExpand = tr.style.display == '';
            tr.style.display = (bExpand ? 'none' : '');
         }
         function poorman_changeimage(id, sMinus, sPlus)
         {
            var img = document.getElementById(id);
            if (img!=null)
            {
               var bExpand = img.src.indexOf(sPlus) >= 0;
               if (!bExpand)
                  img.src = sPlus;
               else
                  img.src = sMinus;
            }
         }

         function validarForm(){
             var idNombre=document.getElementById("doSavePerfil_objPerfil_nombre");
             if(idNombre.value==""){
            	 alert("Debe ingresar el nombre del Perfil.");
            	 idNombre.focus();
            	 return false;    
             }
             return true;
             }

         function Toggle_repHeader2()
         {
            poorman_changeimage('repHeader2_Img', 'images/signo_menos.gif', 'images/signo_mas.gif');
            poorman_toggle('row1');
            poorman_toggle('row2');
            poorman_toggle('row3');
         }

         function Toggle_repHeader1()
         {
            poorman_changeimage('repHeader1_Img', 'images/signo_menos.gif', 'images/signo_mas.gif');
            poorman_toggle('trRow1');
         }
         function Toggle_repHeader3()
         {
            poorman_changeimage('repHeader3_Img', 'images/signo_menos.gif', 'images/signo_mas.gif');
            poorman_toggle('row1');
            poorman_toggle('row2');
            poorman_toggle('row3');
         }

         function Toggle_repHeader3()
         {
            poorman_changeimage('repHeader3_Img', 'images/signo_menos.gif', 'images/signo_mas.gif');
            poorman_toggle('trRow3');
         }
         function Toggle_repHeader4()
         {
            poorman_changeimage('repHeader4_Img', 'images/signo_menos.gif', 'images/signo_mas.gif');
            poorman_toggle('row1');
            poorman_toggle('row2');
            poorman_toggle('row3');
         }

         function Toggle_repHeader4()
         {
            poorman_changeimage('repHeader4_Img', 'images/signo_menos.gif', 'images/signo_mas.gif');
            poorman_toggle('trRow4');
         }
         function Toggle_repHeader5()
         {
            poorman_changeimage('repHeader5_Img', 'images/signo_menos.gif', 'images/signo_mas.gif');
            poorman_toggle('row1');
            poorman_toggle('row2');
            poorman_toggle('row3');
         }

         function Toggle_repHeader5()
         {
            poorman_changeimage('repHeader5_Img', 'images/signo_menos.gif', 'images/signo_mas.gif');
            poorman_toggle('trRow5');
         }
         function Toggle_repHeader6()
         {
            poorman_changeimage('repHeader6_Img', 'images/signo_menos.gif', 'images/signo_mas.gif');
            poorman_toggle('row1');
            poorman_toggle('row2');
            poorman_toggle('row3');
         }

         function Toggle_repHeader6()
         {
            poorman_changeimage('repHeader6_Img', 'images/signo_menos.gif', 'images/signo_mas.gif');
            poorman_toggle('trRow6');
         }
      </script>


      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
      <style type="text/css">
         <!--
         body {
            background-color: #ffffff;
         }

         .barra {
            scrollbar-3dlight-color:#CCCCCC;
            scrollbar-arrow-color:#568BBF;
            scrollbar-base-color:#C3D5E9;
            scrollbar-darkshadow-color:#666666;
            scrollbar-face-color:;
            scrollbar-highlight-color:#669BCD;
            scrollbar-shadow-color:#999999;
         }
         -->
      </style>

   </head>

   <body class="barra">
      <s:form name="frmPerfil" action="doSavePerfil" method="POST">
         <table width="100%">
            <tr>
               <td></td>
               <td height="16" colspan="4" align="left" class="plomo"></td>
            </tr>
            <tr align="center">
               <td width="1%" align="center">&nbsp;</td>
               <td width="99%" colspan="2" align="left">
                  <s:submit src="images/guardar.bmp" type="image" onclick="return validarForm()" value="Guardar Perfil" />
               </td>
            </tr>
            <tr>
               <td></td>
               <td height="16" colspan="4" align="left" class="plomo"></td>
            </tr>
            <tr>
               <td height="14" colspan="3">
                  <table width="95%" border="1" align="center" bordercolor="#669BCD" bgcolor="#BFD9F1">
                     <tr>
                        <td height="75">
                           <table width="98%" align="center" >
                              <tr>
                                 <td></td>
                                 <td colspan="5" height="16" align="left" class="label">
                                    <s:textfield name="objPerfil.idperfil" cssStyle="display:none" />
                                 </td>
                              </tr>
                              <tr>
                                 <td></td>
                                 <td height="16" align="left">Nombre</td>
                                 <td colspan="3" align="left" class="label"><s:textfield name="objPerfil.nombre" id="doSavePerfil_objPerfil_nombre" cssClass="cajaMontoTotal" size="25" /></td>
                                 <td></td>
                              </tr>
                              <tr>
                                 <td></td>
                                 <td height="16" align="left">Descripción</td>
                                 <td colspan="3" align="left" class="label"><s:textarea cssClass="cajaMontoTotal" name="objPerfil.descripcion" rows="10" cols="70"/></td>
                                 <td align="left"></td>
                              </tr>
                              <tr>
                                 <td></td>
                                 <td height="16" align="left">Recursos</td>
                                 <td colspan="3" align="left" class="label">
                                 	<s:select id="recursoIzquierda" list="mapRecursoLeft" multiple="true" size="15"></s:select>
									<div id="botones">
										<input type="button" id="der" value="-&gt;" />
										<input type="button" id="izq" value="&lt;-" />
									</div>
									<s:select id="recursoDerecha" name="lstRecursoRight" list="mapRecursoRight" multiple="true" size="15"></s:select>
                                    <%--<s:optiontransferselect
                                     allowUpDownOnLeft="false"
                                     allowUpDownOnRight="false"
                                     doubleHeaderKey="0"
                                     doubleList="mapRecursoRight"
                                     doubleName="lstRecursoRight"
                                     leftTitle="Recursos Disponibles"
                                     headerKey="0"
                                     list="mapRecursoLeft"
                                     rightTitle="Recursos Asignados" />--%>
                                 </td>
                                 <td align="left">
                                 </td>
                              </tr>
                              <tr>
                                 <td></td>
                                 <td class="titulo">&nbsp;</td>
                                 <td colspan="4"></td>
                              </tr>
                           </table>
                        </td>
                     </tr>
                  </table>
               </td>
            </tr>
            <tr>
               <td height="14"  colspan="3"></td>
            </tr>
         </table>
      </s:form>
   </body>
</html>
