<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ page import="java.util.*" %>
<%@ page import="org.ositran.dojo.grid.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
		<style>
			.aTable {
				width: 300px;
				border-spacing: 2px;
				border: 1px solid black;
				background-color: #A1B5D8;
			}
			.aTable tr {
				background-color: #A1B5D8;
			}
		</style>
		
		<script type="text/javascript">

		var activo = 0;
		var archivo = "";
		var objectid = "";
		var idcodigo = "";
		var idfirmar = "";
		var tid = setTimeout(validarFirmado, 5000);
		
		
		function validarFirmado() {
		  console.log("Validando firmado(activo):",activo);
		  if(activo == 1){	  
			console.log("Validando firmado(archivo):",archivo);
			document.getElementById(idFirmar).disabled = true;
									
			service.validarFirmado(archivo, objectid, idcodigo).addCallback(function (respuesta) {
				console.log("Recibiendo respuesta:",respuesta);
				
				if(respuesta == "1"){
					  abortTimer();		
					  dijit.byId("dlgProgresBar").hide();
					  alert("El documento "+archivo+" ha sido firmado");
					  
					  return;
				}
				 						   
	        });
							
		  }
		  
		  tid = setTimeout(validarFirmado, 5000);
		}
		
		function abortTimer() { 
		  activo = 0;
		  archivo = "";
		  objectid = "";
		  idcodigo = "";
		  idFirmar = "";
		  clearTimeout(tid);
		}

		
		function enviarFirma(archivoFirma, objectidFirma, idcodigoFirma, idBtnFirmar){
			activo = 1;
			archivo = archivoFirma;
			objectid = objectidFirma;
			idcodigo = idcodigoFirma;
			idFirmar = idBtnFirmar;
			//dijit.byId("dlgProgresBar").show();
		}
		
		
		</script>
	
      
    </head>
    <body>
        
		<table id="tblDocumentos"  class="aTable">
		<tr>
			<th>N°</th>	
			<th>DOCUMENTO</th>
		</tr>
		
		<%!
		int cont = 0;		
		%>
		
		<script type="text/javascript">	
			var nombre = "";	
			dojo.addOnLoad(function () {
                service.getArchivosFirmar("<s:property value='arrFileFirmar' />").addCallback(function (objJSON) {
                	console.log(objJSON.items);
				   for(i=0; i<objJSON.items.length;i++){
					   
						
		</script>
		
		<%
		List<Item> listaDocumento = (List<Item>)request.getSession().getAttribute("listaDocumentos");
// <<<<<<< HEAD
// // 		for(Item item : listaDocumento){
// // 			out.println(item.getArchivos());
		
// // 		}
// // 		Item item = listaDocumento.get(cont);
// 		String archivo= "";
// 		out.println(archivo);
// 		String alias = "";
// 		String objectId = "";
// 		String idCodigo = "";
// =======
		Item item = listaDocumento.get(cont);
		String archivo= item.getArchivos();	
		String alias = item.getNrodocumento();
		String objectId = item.getObjectId();
		String idCodigo = item.getIdCodigo();
		String rutaOrigen = item.getRutaOrigen();
		String rutaDestino = item.getRutaDestino();
		String rutaImagen = item.getRutaImagen();
		String imagen = item.getImagen();
		String usarPersonalizado = item.getUsarPersonalizado();
		String tipoFirma = item.getTipoFirma();
		String invisible = item.getInvisible();
		String posicionFirma = item.getPosicionFirma();
		String ubicacionPagina = item.getUbicacionPagina();
		String numeroPagina = item.getNumeroPagina();
		String estiloFirma = item.getEstiloFirma();
		String aplicarImagen = item.getAplicarImagen();
		
// >>>>>>> bf7f4f4c441a4fe19a5088eadba2014ef24b4aec
		
		String idFirmar="id-firmar"+cont;
		
		int contador = 1;
 		for(Item item1 : listaDocumento){
			
		%>
		
		<tr>
			<td><%=contador%></td>
			<td><%=item1.getArchivos()%></td>
		</tr>
		<%
				contador ++;
		cont++;
			}
		%>
		
		
		
		<script type="text/javascript">			
				   }  
				   
                });
            });		
					
        </script>
			
		</table>
		
		<form method="POST" id="ssoForm" name="ssoForm" target="iframeFirma" action="https://wsfirmadigital.pvn.gob.pe:8443/SignnetSignature/Servicio"> 
				<input type="hidden" name="urlConfigService" value="https://wsfirmadigital.pvn.gob.pe:8443/SignnetSignature/configuracion"/> 
				<input type="hidden" name="webService" value="https://wsfirmadigital.pvn.gob.pe:8443/SignnetSignature/FirmaDigitalWs?wsdl"/> 
				<input type="hidden" name="rutaOrigen" value="<%=rutaOrigen%>"/> 
				<input type="hidden" name="rutaDestino" value="<%=rutaDestino%>"/> 
				<input type="hidden" name="rutaImagen" value="<%=rutaImagen%>"/>
				<input type="hidden" name="imagen" value="<%=imagen%>"/>
				<input type="hidden" name="nombreArchivos" value="<%=archivo%>"/> 
				<input type="hidden" name="alias" value="<%=alias%>"/>
				<input type="hidden" name="usarPersonalizado" value="<%=usarPersonalizado%>"/> 
				<input type="hidden" name="tipoFirma" value="<%=tipoFirma%>"/> 
				<input type="hidden" name="invisible" value="<%=invisible%>"/>
				<input type="hidden" name="posicionFirma" value="<%=posicionFirma%>"/> 
				<input type="hidden" name="ubicacionPagina" value="<%=ubicacionPagina%>"/> 
				<input type="hidden" name="numeroPagina" value="<%=numeroPagina%>"/> 
				<input type="hidden" name="estiloFirma" value="<%=estiloFirma%>"/> 
				<input type="hidden" name="aplicarImagen" value="<%=aplicarImagen%>"/>
				<input type="hidden" name="ubicacion" value=""/>

				<input id="<%=idFirmar%>" type="submit" name="submit" value="Firmar" 
				onclick="enviarFirma('<%=archivo%>','<%=objectId%>','<%=idCodigo%>','<%=idFirmar%>');" />
				
				<iframe frameborder="0" name="iframeFirma" id="iframeFirma" width="400px" height="220px"></iframe>
			</form>	
		
    </body>
	
	
		
</html>
