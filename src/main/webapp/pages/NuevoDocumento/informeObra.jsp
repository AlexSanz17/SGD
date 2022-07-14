<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es">
<head>
<title>SIGED - Nuevo Documento Usuario Final</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="cache-control" content="no-cache" />
<META HTTP-EQUIV="Expires" CONTENT="-1">
<style type="text/css">
@import "js/dojo/dijit/themes/soria/soria.css";
@import "js/dojo/dojox/grid/resources/soriaGrid.css";
@import "css/grid.css";
@import "css/estilo.css";
body{
padding: 2px;
}
</style>
</head>
<body>
<form dojoType="dijit.form.Form" id="frmInformeObraTramite"
jsId="frmInformeObraTramite" 
method="post">
<table width="100%" border="0">
<tr>
<td>
<div class="marcoForm margen5PX">
<table width="100%" border="0">
<tr>
<td width="20%"
class="titulo">DATOS DE LA CARPETA</td>
<td width="80%" colspan="2"></td>
</tr>
<tr>
<td width="20%">Contrato</td>
<td class="label" colspan="2"
width="80%">
<input id="contrato"
class="cajaMontoTotal1" name="contrato" type="text" size="20px"
maxlength="25" />
</td>
</tr>
<tr>
<td width="20%">Razon
Social</td>
<td class="label" colspan="2"
width="80%">
<input id="razonSocial"
class="cajaMontoTotal1" name="razonSocial" type="text" size="20px"
maxlength="25" />
</td>
</tr>
<tr>
<td width="20%">RUC</td>
<td class="label" colspan="2"
width="80%">
<input id="ruc"
class="cajaMontoTotal1" name="ruc" type="text" size="20px" maxlength="25" />
</td>
</tr>
<tr>

<td width="20%">Tipo Obra</td>
<td class="label" colspan="2"
width="80%">
<input id="tipoObra"
class="cajaMontoTotal1" name="tipoObra" type="text" size="20px"
maxlength="25" />
</td>
</tr>
<tr>
<td width="20%">Fecha
Inicio</td>
<td class="label" colspan="2"
width="80%">
<input id="fechaInicio"
class="cajaMontoTotal1" name="fechaInicio" type="date" />
</td>
</tr>
<tr>
<td width="20%">Fecha
Termino</td>
<td class="label" colspan="2"
width="80%">
<input id="fechaTermino"
class="cajaMontoTotal1" name="fechaTermino" type="date" />
</td>
</tr>
<tr>
<td width="20%">Monto</td>
<td class="label" colspan="2"
width="80%">
<input id="monto"
class="cajaMontoTotal1" name="monto" type="text" size="20px" maxlength="25"
/>
</td>
</tr>
<tr>
<td
width="20%">Beneficiarios</td>
<td class="label" colspan="2"
width="80%">
<input id="beneficiarios"
class="cajaMontoTotal1" name="beneficiarios" type="text" size="20px"
maxlength="25" />
</td>
</tr>
<tr>
<td
width="20%">Descripcion</td>
<td class="label" colspan="2" width="80%">
<input id="descripcion"
class="cajaMontoTotal1" name="descripcion" type="text" size="20px"
maxlength="25" />
</td>
</tr>
</table>
</div>
</td>
</tr>
<tr>
<td align="left">
<div class="margen5PX">
<tr>
<td width="11%" height="55"></td>
<td width="25%" align="right"></td>

<td width="33%">
<!-- <input type="submit"  -->
<!-- class="button" value="Guardar" /> -->
<button class="button" onClick="enviarArchivo()">Guardar</button>
<input type="reset"
class="button" onclick="javascript:window.close()" value="Cancelar" />
</td>
<td width="31%" align="right"></td>
</tr>
</div>
</td>
</tr>
</table>
</form>
<script>
function enviarArchivo(){
	console.log("-----------ingreso al envio------------")
	      if(confirm("Esta seguro de realizar este registro ? ")){
	    	  dojo.xhrPost({
	 	    	 url:"doRegistrarInformeObra.action",
	 	         form: dojo.byId("frmInformeObraTramite"),
	 	         mimetype: "text/html",
	 	         load: function() {
	 	        	 alert("Se realizo el registro exitosamente");
	 	           	          
	 	        
	 	         }
	 	      });
	      }else{
	    	  return;
	      }
	 
	}
</script>
</body>
</html>