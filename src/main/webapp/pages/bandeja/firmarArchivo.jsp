<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<%@ page import="org.ositran.dojo.grid.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style type="text/css" href="css/libraries/sweetalert.min.css"></style>
	<style>
		.aTable {
			width: 678px;
			border-spacing: 2px;
			border: 1px solid black;
			background-color: #A1B5D8;
		}
		
		.aTable tr {
			background-color: #A1B5D8;
		}
	</style>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<script type="text/javascript" src="js/libraries/sweetalert.js"></script>
	
	<script type="text/javascript">
		var activo = 0;
			var archivo = "";
			var archivosFirma = [];
			var archivosFirmaTemp = [];
			var archivosFirmaArray = [];
			var objectid = "";
			var idcodigo = "";
			var idfirmar = "";
			var tieneQr = false;
			var enviadoAlfresco = false;
	// 		var tid = setTimeout(validarFirmado, 5000);
			document.getElementById("iframeFirma").style.display = "none";
			var accionEjecutar = document.getElementById("estado").value;
			var procesoFirmado = 0;
			var btnFirmar = document.querySelector(".btnFirmarInput")
			var vcuoPide = "";
			function enviarArchivosAlfresco(resultado, sujeto){
				if(archivosFirmaTemp.length>0){
					archivosFirmaArray = archivosFirmaTemp;
				}
				service.uploadFilesToAlfrescoPostSignet(archivosFirmaArray,accionEjecutar, resultado, sujeto).addCallback(function (respuesta) {
					console.log("Recibiendo respuesta: length",archivosFirmaArray.length);
					btnFirmar.disabled=false;
					if(respuesta == "1"){
						dijit.byId("dlgProgresBar").hide();
						
						alert("Los documentos han sido firmados");
						
						dijit.byId("dlgFirmar").hide();
						 showGridInbox(sTipoGridActual);
	       	              	window.close();
			            	window.opener.showGridInbox();
			            	window.opener.refreshTabDXE();
					} else if (respuesta == "2"){
						dijit.byId("dlgProgresBar").hide();
						dijit.byId("dlgFirmar").hide();
					}else{
						alert("Ocurrió un error al subir a alfresco");
					}
		        });
				
				setTimeout(myFunction, 3000);
				
				function myFunction() {
					if(archivosFirmaTemp.length>0){
						archivosFirmaArray = archivosFirmaTemp;
					}
					service.deleteFirmaArchivo(archivosFirmaArray).addCallback(function (respuesta) {
						console.log("deleteFirmaArchivo:",respuesta);
			        })
				}
	// 			} else {
	// 				for (var i = 0; i < archivosFirmaArray.length; i++) {
	// 					var ESTADO_FIRMA = "<s:property value='@org.ositran.utils.Constantes@ESTADO_FIRMA'/>";
	// 					console.log("ESTADO_FIRMA...." + ESTADO_FIRMA);
	// 					var estadoFirma = ESTADO_FIRMA.get(archivosFirmaArray[i].getObjectId());
	// 					if (estadoFirma != null) {
	// 						// Libera para proxima firma
	// 						ESTADO_FIRMA.put(archivosFirmaArray[i].getObjectId(), "0");
	// 					}
	// 				}
	// 			}
			}
			function firmarDoumento(){
				if(vcuoPide != null){
					console.log("-----------------------Firmar para PIDE---------------");
					generateQrPreFirmadoRecepcionPIDE();
				}else{
					console.log("-----------------------Firmar normal---------------");
					generateQrPreFirmado();
				}
			}
			function generateQrPreFirmado() {
				
					btnFirmar.disabled = true;
					dijit.byId("dlgProgresBar").show();
					
					if(archivosFirmaTemp.length>0){
						archivosFirmaArray = archivosFirmaTemp;
					}
							
	// 				Primero Paso: Validar que tenga el software de Firma
					axios.get('https://localhost:9997/SignnetFirmaServicio/Test/https%3A%2F%2Fwsfirmadigital.pvn.gob.pe%3A8443%2FSignnetSignature%2Fcfg%2F')
					  .then(function (response) {
					    // handle success
					    console.log(response);
					    service.generateQrPreSignet(archivosFirmaArray, accionEjecutar).addCallback(function (respuesta) {
							for (var i = 0; i < archivosFirmaArray.length; i++) {
								console.log("generateQrPreSignet archivosFirmaArray.........." + archivosFirmaArray.length);
							}
							if(respuesta == "1"){		
								document.getElementById("ssoForm").submit();
	// 							dijit.byId("dlgProgresBar").hide();
					    		
								
							} else if (respuesta == "2"){
								alert("Firma en proceso, vuelva a intentarlo en unos minutos");
								dijit.byId("dlgProgresBar").hide();
								dijit.byId("dlgFirmar").hide();
							} else {
								alert("Ocurrió un error al subir a alfresco");
							}
				        });
					    // ejecutar funcion
					  })
					  .catch(function (error) {
					    // handle error
					    alert("Debe de instalar el software de Firma");
	// 				    Swal.fire({
	// 				    	  position: 'center',
	// 				    	  icon: 'warning',
	// 				    	  title: 'Debe de instalar el software de Firma',
	// 				    	  showConfirmButton: false,
	// 				    	  timer: 1500
	// 				    	})
					    dijit.byId("dlgProgresBar").hide();
						dijit.byId("dlgFirmar").hide();
					    console.log(error);
					  });
				
				
			}
			
			function generateQrPreFirmadoRecepcionPIDE() {
				btnFirmar.disabled = true;
				dijit.byId("dlgProgresBar").show();
				
				if(archivosFirmaTemp.length>0){
					archivosFirmaArray = archivosFirmaTemp;
				}
						
// 				Primero Paso: Validar que tenga el software de Firma
				axios.get('https://localhost:9997/SignnetFirmaServicio/Test/https%3A%2F%2Fwsfirmadigital.pvn.gob.pe%3A8443%2FSignnetSignature%2Fcfg%2F')
				  .then(function (response) {
				    // handle success
				    console.log(response);
				    service.generateQrPreSignetOnlyFirma(archivosFirmaArray, accionEjecutar).addCallback(function (respuesta) {
				    	console.log("respuesta : " +respuesta);
						if(respuesta == "1"){		
							document.getElementById("ssoForm").submit();
// 							dijit.byId("dlgProgresBar").hide();
				    		
							
						} else if (respuesta == "2"){
							alert("Firma en proceso, vuelva a intentarlo en unos minutos");
							dijit.byId("dlgProgresBar").hide();
							dijit.byId("dlgFirmar").hide();
						} else {
							alert("Ocurrió un error al subir a alfresco");
						}
			        });
				    // ejecutar funcion
				  })
				  .catch(function (error) {
				    // handle error
				    alert("Debe de instalar el software de Firma");
// 				    Swal.fire({
// 				    	  position: 'center',
// 				    	  icon: 'warning',
// 				    	  title: 'Debe de instalar el software de Firma',
// 				    	  showConfirmButton: false,
// 				    	  timer: 1500
// 				    	})
				    dijit.byId("dlgProgresBar").hide();
					dijit.byId("dlgFirmar").hide();
					console.log("error");
				    console.log(error);
				  });
				
			}
			window.addEventListener("message", function (e) {
				var rptJSON = JSON.parse(e.data);
				console.log("----------respuesta JSON---");
				console.log(rptJSON);
	// 			if(rptJSON.resultado == "0"){
					if(!enviadoAlfresco){
						enviarArchivosAlfresco(rptJSON.resultado, rptJSON.sujeto);
					}
	// 			}			
			},{once : true});
		
	// 		function validarFirmado() {
	// 		  if(activo == 1){	  
				
	// 			document.getElementById(idFirmar).disabled = true;
	// 			var contValidar = 1;
	// 			if(archivosFirmaTemp.length>0){
	// 				archivosFirmaArray = archivosFirmaTemp;
	// 			}
	// 			for (var i = 0; i < archivosFirmaArray.length; i++) {
	// 				service.validarFirmado(archivosFirmaArray[i].archivo, archivosFirmaArray[i].objectId, idcodigo,accionEjecutar).addCallback(function (respuesta) {
	// 					console.log("Recibiendo respuesta:",respuesta);
	// 					if(respuesta == "1"){
	// 						  if(parseInt(contValidar) === parseInt(archivosFirmaArray.length)){
	// 							  abortTimer();
	// 							  procesoFirmado = 1;		        
	// 							  return;
	// 						  }
	// 						  else
	// 						  {							  
	// 						  	contValidar++;
	// 						  }
	// 					}
						 						   
	// 		        });
					
	// 				if(parseInt(contValidar) === parseInt(archivosFirmaArray.length)){
	// 					return;
	// 				}
	// 			}				
	// 		  }
	//  		  tid = setTimeout(validarFirmado, 5000);
	// 		}
		
			function abortTimer() { 
			  activo = 0;
			  archivo = "";
			  objectid = "";
			  idcodigo = "";
			  idFirmar = "";
			  clearTimeout(tid);
			}
			
			function validarProcesoFirma(){
				var existeProcesoFirma = false;
				existeProcesoFirma = !document.getElementById("ssoForm").action.toString().match("https://wsfirmadigital.pvn.gob.pe:8443/SignnetSignature/Servicio");
				
				if(existeProcesoFirma){
	                document.getElementById("ssoForm").action = "";
	                alert("No es posible firmar mientras exista un documento en proceso de firma");
	            }else{
	                document.getElementById("ssoForm").action = "https://wsfirmadigital.pvn.gob.pe:8443/SignnetSignature/Servicio";
	//                 activo = 1;
	//     			archivo = archivoFirma;
	//     			objectid = objectidFirma;
	//     			idcodigo = idcodigoFirma;
	//     			idFirmar = idBtnFirmar;
	    			dijit.byId("dlgProgresBar").show();
	            }
			}
			
			function checkItem(archivoFirma, objectidFirma , idCheck, codigoId){
				var esCheck = document.getElementById(idCheck).checked;
				if(esCheck){
					console.log("archivoFirma..........." + archivoFirma);
					archivosFirmaTemp.push({archivo:archivoFirma,objectId:objectidFirma,codigoId:codigoId});
				}else{
					var index = archivosFirmaTemp.map(function(e) { return e.objectId; }).indexOf(objectidFirma);
					if (index !== -1) {
						for (var i = 0; i < archivosFirmaTemp.length; i++) {
							console.log("checkItem archivosFirmaTemp splice.........." + archivosFirmaTemp[i]);
						}
						archivosFirmaTemp.splice(index, 1);
					}
				}
				this.generarNombresArchivo(archivosFirmaTemp);
			}
			
			function checkAll(){
				var esCheck = document.getElementById("selectAll").checked;
				var rows = document.getElementById("tblDocumentos").rows;
				
				for (var i = 1; i < rows.length; i++) {
	                rows[i].getElementsByTagName("INPUT")[0].checked = esCheck;
	            }
				
				if(esCheck){
					archivosFirmaTemp = archivosFirma;
				}else{
					archivosFirmaTemp = [];	
				}
				this.generarNombresArchivo(archivosFirmaTemp);
			}
			
			function initCheckAll(){
				archivosFirmaTemp = [];
				document.getElementById("selectAll").checked = true;
				var rows = document.getElementById("tblDocumentos").rows;
				for (var i = 1; i < rows.length; i++) {
	                rows[i].getElementsByTagName("INPUT")[0].checked = true;
	            }
				
				archivosFirmaTemp = archivosFirma;
				this.generarNombresArchivo(archivosFirmaTemp);
			}
			
			function generarNombresArchivo(archivosFirmaTemp){
				var nombresArchivo = "";
				
				for (var i = 0; i < archivosFirmaTemp.length; i++) {
					if(archivosFirmaTemp.length == 1){
						nombresArchivo = archivosFirmaTemp[i].archivo;
					}
					if(archivosFirmaTemp.length > 1){
						nombresArchivo = nombresArchivo + archivosFirmaTemp[i].archivo + "|"
					}
					
				}
				document.getElementById("nombreArchivos").value = nombresArchivo;
				
				if(archivosFirmaTemp.length > 0){
					document.getElementById("btnFirmar").disabled = false;
				}else{
					document.getElementById("btnFirmar").disabled = true;
				}
			}
			
			function cerrarModal() {
				dijit.byId("dlgFirmar").hide();
			}
		</script>
</head>

<body>
	<table id="tblDocumentos" class="aTable">
		<tr>
			<th>N°</th>
			<th>DOCUMENTO</th>
			<th>Todos <input type="checkbox" name="selectAll" id="selectAll"
				onclick="checkAll()"></th>
		</tr>

		<%
		int cont = 0;
		%>

		<script type="text/javascript">	
			var nombre = "";	
			
			dojo.addOnLoad(function () {
                service.getArchivosFirmar("<s:property value='arrFileFirmar' />","<s:property value='accion' />").addCallback(function (objJSON) {
                	vcuoPide = objJSON.items[0].vcuo == "nVcuo" ? null : objJSON.items[0].vcuo;
                	console.log(vcuoPide);
				   for(i=0; i<objJSON.items.length;i++){
					   archivosFirma.push({archivo:objJSON.items[i].archivos,objectId:objJSON.items[i].objectId,codigoId:objJSON.items[i].idCodigo});
					   archivosFirmaArray.push({ archivo:objJSON.items[i].archivos, objectId:objJSON.items[i].objectId,
						   codigoId:objJSON.items[i].idCodigo
				       });

		</script>

		<%
		List<Item> listaDocumento = (List<Item>) request.getSession().getAttribute("listaDocumentos");
		Item item = listaDocumento.get(cont);
		String archivo = item.getArchivos();
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
		String razon = item.getRazonsocial();
		String archivosFirmar = "";
		String altoRubrica = item.getAltoRubrica();
		String anchoRubrica = item.getAnchoRubrica();
		String chkTSA = item.getChkTSA();
		String rutasTSA = item.getRutasTSA();
		String estado = item.getEstado();

		boolean existenProcesoFirma = false;

		for (Item item2 : listaDocumento) {
			if (item2.getFlagFirma().equals(1)) {
				existenProcesoFirma = true;
				break;
			}
		}

		String idFirmar = "id-firmar" + cont;

		int contador = 1;
		for (Item item1 : listaDocumento) {
		%>

		<tr>
			<td><%=contador%></td>
			<td><%=item1.getArchivos()%></td>
			<td><input type="checkbox" id="select-<%=cont%>"
				name="select-<%=cont%>"
				onclick="checkItem('<%=item1.getArchivos()%>','<%=item1.getObjectId()%>','select-<%=cont%>','<%=item1.getIdCodigo()%>')"></td>
		</tr>
		<%
		contador++;
		cont++;
		if (cont <= listaDocumento.size()) {
			archivosFirmar = archivosFirmar + item1.getArchivos() + "|";
		}
		}
		%>

		<script type="text/javascript">			
				   }  
				   initCheckAll();
                });
            });			
        </script>
	</table>

	<form method="POST" id="ssoForm" name="ssoForm" target="iframeFirma"
		action="https://wsfirmadigital.pvn.gob.pe:8443/SignnetSignature/Servicio">
		<input type="hidden" name="urlConfigService"
			value="https://wsfirmadigital.pvn.gob.pe:8443/SignnetSignature/configuracion" />
		<input type="hidden" name="webService"
			value="https://wsfirmadigital.pvn.gob.pe:8443/SignnetSignature/FirmaDigitalWs?wsdl" />
		<input type="hidden" name="rutaOrigen" value="<%=rutaOrigen%>" /> <input
			type="hidden" name="rutaDestino" value="<%=rutaDestino%>" /> <input
			type="hidden" name="rutaImagen" value="<%=rutaImagen%>" /> <input
			type="hidden" name="imagen" value="<%=imagen%>" /> <input
			type="hidden" name="nombreArchivos" id="nombreArchivos"
			value="<%=archivosFirmar%>" /> <input type="hidden" name="alias"
			value="<%=alias%>" /> <input type="hidden" name="usarPersonalizado"
			value="<%=usarPersonalizado%>" /> <input type="hidden"
			name="tipoFirma" value="<%=tipoFirma%>" /> <input type="hidden"
			name="invisible" value="<%=invisible%>" /> <input type="hidden"
			name="posicionFirma" value="<%=posicionFirma%>" /> <input
			type="hidden" name="ubicacionPagina" value="<%=ubicacionPagina%>" />
		<input type="hidden" name="numeroPagina" value="<%=numeroPagina%>" />
		<input type="hidden" name="estiloFirma" value="<%=estiloFirma%>" /> <input
			type="hidden" name="aplicarImagen" value="<%=aplicarImagen%>" /> <input
			type="hidden" name="altoRubrica" value="<%=altoRubrica%>" /> <input
			type="hidden" name="anchoRubrica" value="<%=anchoRubrica%>" /> <input
			type="hidden" name="chkTSA" value="<%=chkTSA%>" /> <input
			type="hidden" name="rutasTSA" value="<%=rutasTSA%>" /> <input
			type="hidden" name="ubicacion" value="" /> <input type="hidden"
			name="razon" value="<%=razon%>" /> <input type="hidden" name="estado"
			id="estado" value="<%=estado%>" />
		<%-- 			<input id="<%=idFirmar%>" type="submit" id="btnFirmar" name="submit" value="Firmar"  --%>
		<%-- 			onclick="enviarFirma('<%=archivo%>','<%=objectId%>','<%=idCodigo%>','<%=idFirmar%>','<%=archivosFirmar%>');" /> --%>
		<input type="button" class="btn btn-primary btnFirmarInput"
			style="width: 100px !important; cursor: pointer; margin: 10px 0px;" id="btnFirmar" name="btnFirmar"
			value="Firmar" onclick="javascript:firmarDoumento()" />
		<iframe frameborder="0" name="iframeFirma" id="iframeFirma" width="700px" height="450px"></iframe>
	</form>
</body>
</html>