/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.services;

import com.btg.ositran.siged.domain.Auditoria;
import com.btg.ositran.siged.domain.CarpetaBusqueda;
import com.btg.ositran.siged.domain.Documento;
import com.btg.ositran.siged.domain.Usuario;
import com.opensymphony.xwork2.ActionContext;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.ositran.daos.AuditoriaDAO;
import org.ositran.daos.CarpetabusquedaDAO;
import org.ositran.daos.DocumentoDAO;
import org.ositran.dojo.tree.Nodo;
import org.ositran.utils.Constantes;
import org.ositran.utils.Expedienfindadvance;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class CarpetabusquedaServiceImpl implements CarpetabusquedaService {

	private static Logger log = Logger.getLogger(CarpetabusquedaServiceImpl.class);
	private CarpetabusquedaDAO dao;
	private AuditoriaDAO daoauditoria;
	private DocumentoDAO documentoDAO;

	public CarpetabusquedaServiceImpl(CarpetabusquedaDAO dao) {
		setDao(dao);
	}

	public List<CarpetaBusqueda> ViewAll() {
		log.debug("-> [Service] CarpetabusquedaService - ViewAll():List<CarpetaBusqueda> ");

		List<CarpetaBusqueda> data = getDao().findAll();
		//List<Carpetabusqueda> data= new ArrayList<Carpetabusqueda>();
		return data;
	}

	public CarpetaBusqueda ViewbyId(int IdCarpetabusqueda) {
		System.out.println("ingresando..");
		log.debug("-> [Service] CarpetabusquedaService - ViewbyId():CarpetaBusqueda ");

		CarpetaBusqueda data = getDao().findByIdcarpetabusqueda(IdCarpetabusqueda);
		return data;
	}

	public List<Documento> findLstByFiltro(Integer iIdCarpetaBusqueda) {
		log.debug("-> [Service] CarpetabusquedaService - findLstByFiltro():List<Documento> ");

		CarpetaBusqueda objCB = null;

		objCB = this.ViewbyId(iIdCarpetaBusqueda.intValue());

		log.debug("Obteniendo datos de la carpeta de busqueda [" + objCB.getNombreCarpeta() + "]");

		String sNumeroDocumento = objCB.getNumeroDocumento() != null ? "%" + objCB.getNumeroDocumento().toLowerCase() + "%" : null;
		String sNumeroMesaPartes = objCB.getNumeroMesaPartes() != null ? "%" + objCB.getNumeroMesaPartes().toLowerCase() + "%" : null;
		String sAsuntoDocumento = objCB.getAsuntoDocumento() != null ? "%" + objCB.getAsuntoDocumento().toLowerCase() + "%" : null;
		String sNumeroExpediente = objCB.getNumeroExpediente() != null ? "%" + objCB.getNumeroExpediente().toLowerCase() + "%" : null;
		String sAsuntoExpediente = objCB.getAsuntoExpediente() != null ? "%" + objCB.getAsuntoExpediente().toLowerCase() + "%" : null;
		String sEstadoExpediente = objCB.getEstadoExpediente() != null ? "%" + objCB.getEstadoExpediente().toLowerCase() + "%" : null;
		String sConcesionario = objCB.getConsecionario() != null ? "%" + objCB.getConsecionario().toLowerCase() + "%" : null;
		String sCliente = objCB.getCliente() != null ? "%" + objCB.getCliente().toLowerCase() + "%" : null;
		String sPropietario = objCB.getPropietario() != null ? "%" + objCB.getPropietario().toLowerCase() + "%" : null;
		String remitente = objCB.getRemitente() != null ? "%" + objCB.getRemitente().toLowerCase() + "%" : null;
		//String remitente = objCB.getAreaOrigen() != null ? "%" + objCB.getAreaOrigen().toLowerCase() + "%" : null;
		/**Estos campos contienes Id's ------------------------------------------------------------------------------------------*/
		Integer proceso = objCB.getProceso() != null ? Integer.parseInt(objCB.getProceso()) : null;
		Integer tipoDocumento = objCB.getTipoDocumento() != null ? Integer.parseInt(objCB.getTipoDocumento()) : null;
		Integer areaDestino = objCB.getAreaDestino() != null ? Integer.parseInt(objCB.getAreaDestino()) : null;
		Integer areaOrigen = objCB.getAreaOrigen() != null ? Integer.parseInt(objCB.getAreaOrigen()) : null;
		String pendiente = objCB.getPendiente();
		Calendar fechaDocFin = null;
		Calendar fechaExpFin = null;

		java.util.Date fDocFin = null;
		java.util.Date fExpFin = null;

		if(objCB.getFechaDocumentoFinal() != null){
			fechaDocFin = Calendar.getInstance();
			fechaDocFin.setTime(objCB.getFechaDocumentoFinal());
			fechaDocFin.set(Calendar.HOUR_OF_DAY, 23);
			fechaDocFin.set(Calendar.MINUTE, 59);
			fechaDocFin.set(Calendar.SECOND, 59);
			fDocFin = fechaDocFin.getTime();
		}

		if(objCB.getFechaExpedienteFinal() != null){
			fechaExpFin = Calendar.getInstance();
			//fechaExpFin.setTime(objCB.getFechaDocumentoFinal());
                        fechaExpFin.setTime(objCB.getFechaExpedienteFinal());
			fechaExpFin.set(Calendar.HOUR_OF_DAY, 23);
			fechaExpFin.set(Calendar.MINUTE, 59);
			fechaExpFin.set(Calendar.SECOND, 59);
			fExpFin = fechaExpFin.getTime();
		}

		return documentoDAO.busquedaCarpeta(sNumeroDocumento,
				sNumeroMesaPartes,
				sAsuntoDocumento,
				sNumeroExpediente,
				sAsuntoExpediente,
				sEstadoExpediente,
				sConcesionario,
				sCliente,
				proceso,
				sPropietario,
				areaDestino,
				tipoDocumento,
				objCB.getFechaDocumentoInicio(),
				fDocFin,
				objCB.getFechaExpedienteInicio(),
				fExpFin,
				areaOrigen, remitente,
				pendiente);
	}

	public List<Expedienfindadvance> findbyAllid(int intid) {
		log.debug("-> [Service] CarpetabusquedaService - findbyAllid():List<Expedienfindadvance> ");

		String Condicion = "";
		String com = "0";
		String com2 = "1";

		List<Expedienfindadvance> buscs = new ArrayList<Expedienfindadvance>();


		CarpetaBusqueda data = this.ViewbyId(intid);
		String comp = null;
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		log.debug(" cbusqueda : " + data.getNumeroExpediente());
		log.debug(" nombre del proceso : " + data.getProceso());

		int bandera = 0;

		if (data.getNumeroExpediente() == null) {
		} else {
			Condicion = Condicion + ((bandera != 0) ? " AND " : " ") + " LOWER(ex.nroexpediente) Like '%" + data.getNumeroExpediente().toLowerCase() + "%'  ";
			bandera++;
		}

		if (data.getTipoDocumento() == null) {
		} else {
			Condicion = Condicion + ((bandera != 0) ? " AND " : " ") + " LOWER(d.tipoDocumento.nombre) LIKE  '%" + data.getTipoDocumento().toLowerCase() + "%' ";
			bandera++;
		}
		if (data.getNumeroDocumento() == null) {
		} else {
			Condicion = Condicion + ((bandera != 0) ? " AND " : " ") + " LOWER(d.numeroDocumento) Like '%" + data.getNumeroDocumento().toLowerCase() + "%'  ";
			bandera++;
		}
		if (data.getDocumentoIdentidad() == null) {
		} else {
			Condicion = Condicion + ((bandera != 0) ? " AND " : " ") + " ex.cliente.numeroIdentificacion Like '%" + data.getDocumentoIdentidad() + "%'  ";
			bandera++;
		}
		if (data.getNumeroMesaPartes() == null) {
		} else {
			Condicion = Condicion + ((bandera != 0) ? " AND " : " ") + "  d.numeroMesaPartes Like '%" + data.getNumeroMesaPartes() + "%'  ";
			bandera++;
		}
		if (data.getFechaDocumentoInicio() != null && data.getFechaDocumentoFinal() != null) {

			Condicion = Condicion + ((bandera != 0) ? " AND " : " ") + " d.fechaCreacion >= :fechainidoc AND d.fechaCreacion <= :fechafindoc  ";
			bandera++;
		} else {
		}
		if (data.getConsecionario() == null) {
		} else {
			Condicion = Condicion + ((bandera != 0) ? " AND " : " ") + " LOWER(c.razonSocial) Like '%" + data.getConsecionario().toLowerCase() + "%'  ";
			bandera++;
		}
		if (data.getFechaExpedienteInicio() != null && data.getFechaExpedienteFinal() != null) {
			Condicion = Condicion + ((bandera != 0) ? " AND " : " ") + " ex.fechacreacion>= :fechainiexp AND ex.fechacreacion<= :fechafinexp   ";
			bandera++;
		} else {
		}
		if (data.getCliente() == null) {
		} else {
			Condicion = Condicion + ((bandera != 0) ? " AND " : " ") + " LOWER(ex.cliente.razonSocial) Like '%" + data.getCliente().toLowerCase() + "%' ";
			bandera++;
		}
		if (data.getDireccionCliente() == null) {
		} else {
			Condicion = Condicion + ((bandera != 0) ? " AND " : " ") + " LOWER(ex.cliente.direccionPrincipal) Like '%" + data.getDireccionCliente().toLowerCase() + "%' ";
			bandera++;
		}
		/* */
		if (data.getAreaDestino() == null) {
		} else {
			Condicion = Condicion + ((bandera != 0) ? " AND " : " ") + " LOWER(un.nombre) Like '%" + data.getAreaDestino().toLowerCase() + "%' ";
			bandera++;
		}
		/* */

		if (data.getAreaOrigen() == null) {
		} else {
			Condicion = Condicion + ((bandera != 0) ? " AND " : " ") + " LOWER(uni.nombre) Like '%" + data.getAreaOrigen().toLowerCase() + "%' ";
			bandera++;
		}

		if (data.getPropietario() == null) {
		} else {
			Condicion = Condicion + ((bandera != 0) ? " AND " : " ") + "  (  LOWER(d.propietario.nombres) Like '%" + data.getPropietario().toLowerCase() + "%'  "+" OR "+ "  LOWER(d.propietario.apellidos)  Like '%" + data.getPropietario().toLowerCase() + "%' "+" OR "+"  LOWER( CONCAT(d.propietario.nombres,CONCAT(' ',d.propietario.apellidos)  ))  Like '%" + data.getPropietario().toLowerCase() + "%' ) ";
			bandera++;
		}

		if (data.getProceso() == null) {
		} else {
			Condicion = Condicion + ((bandera != 0) ? " AND " : " ") + " LOWER(p.nombre) Like '%" + data.getProceso().toLowerCase() + "%' ";
			bandera++;
		}

		if (data.getAsuntoExpediente() != null) {
			Condicion += ((bandera != 0) ? " AND " : " ") + " LOWER(ex.asunto) Like '%" + data.getAsuntoExpediente().toLowerCase() + "%' ";
			bandera++;
		}

		if (data.getEstadoExpediente() != null) {
			Condicion += ((bandera != 0) ? " AND " : " ") + " LOWER(ex.estado) = '" + data.getEstadoExpediente().toLowerCase() + "' ";
			bandera++;
		}

		if (data.getAsuntoDocumento() != null) {
			Condicion += ((bandera != 0) ? " AND " : " ") + " LOWER(d.asunto) Like '%" + data.getAsuntoDocumento().toLowerCase() + "%' ";
			bandera++;
		}

		int logcad = Condicion.length();

		String Condic = "";
		/*
      for (int j = 0; j < logcad - 3; j++) {
      Condic = Condic + Condicion.charAt(j);
      }
		 * */
		// if (Condicion!=""){


		try {
			String fechaTemp = null;

			if (data.getFechaDocumentoInicio() != null && data.getFechaDocumentoFinal() != null) {
				fechaTemp = data.getFechaDocumentoInicio().toString() + " 00:00:00";
				data.setFechaDocumentoInicio(fm.parse(fechaTemp));

				fechaTemp = data.getFechaDocumentoFinal().toString() + " 23:59:59";
				data.setFechaDocumentoFinal(fm.parse(fechaTemp));
			}

			if (data.getFechaExpedienteInicio() != null && data.getFechaExpedienteFinal() != null) {
				fechaTemp = data.getFechaExpedienteInicio().toString() + " 00:00:00";
				data.setFechaExpedienteInicio(fm.parse(fechaTemp));

				fechaTemp = data.getFechaExpedienteFinal().toString() + " 23:59:59";
				data.setFechaExpedienteFinal(fm.parse(fechaTemp));
			}
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}

		buscs = dao.findbycondicion(Condicion, data.getFechaDocumentoInicio(), data.getFechaDocumentoFinal(), data.getFechaExpedienteInicio(), data.getFechaExpedienteFinal());

		//}

		return buscs;

	}

	@Transactional
	public void saveCarpetaBusqueda(CarpetaBusqueda objCB) {
		log.debug("-> [Service] CarpetabusquedaService - saveCarpetaBusqueda():void ");

		try {
			/*if (objCB.getIdCarpetaBusqueda() == null) {
            registrarAuditoriaCarpetasBusqudaInsert(objCB, Constantes.TA_RegistrarCarpetaBusq, Constantes.TM_UserFinal, Constantes.TO_Registrar);
         } else {
            registrarAuditoriaCarpetasBusqudaUpdate(objCB, Constantes.TA_ActualizarCarpetaBusq, Constantes.TM_UserFinal, Constantes.TO_Modificar);
         }*/
		} catch (Exception ex) {

			log.error(ex.getMessage(), ex);
		}

		getDao().saveCarpetaBuqueda(objCB);
	}

	@Transactional
	public void eliminarCarpetabusqueda(CarpetaBusqueda objCB) {
		log.debug("-> [Service] CarpetabusquedaService - eliminarCarpetabusqueda():void ");

		getDao().deleteCarpetabusqueda(objCB);

		registrarEliminacionDeCarpetaBusq(objCB, Constantes.TA_RegistrarCarpetaBusq, Constantes.TM_UserFinal, Constantes.TO_Eliminar);
	}

	public List<CarpetaBusqueda> buscarLstPor1(Integer iIdUsuario) {
		log.debug("-> [Service] CarpetabusquedaService - buscarLstPor1():List<CarpetaBusqueda> ");

		return dao.buscarLstPor(iIdUsuario);
	}

	////////////////////////
	// Getters and Setters
	////////////////////////
	public CarpetabusquedaDAO getDao() {
		return dao;
	}

	public void setDao(CarpetabusquedaDAO dao) {
		this.dao = dao;
	}

	public void setDaoauditoria(AuditoriaDAO daoauditoria) {
		this.daoauditoria = daoauditoria;
	}

	public AuditoriaDAO getDaoauditoria() {
		return daoauditoria;
	}

	@Transactional
	private void registrarAuditoriaCarpetasBusqudaInsert(CarpetaBusqueda carpetaBusq, String tipoauditoria, String modulo, String opcion) {
		/*******************************************************/
		//		Registrando la auditoria
		/*******************************************************/
		Map session = ActionContext.getContext().getSession();
		AuditoriaDAO daoauditoria = (AuditoriaDAO) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getRequest().getSession().getServletContext()).getBean("auditoriaDAO");
		Usuario usuario = (Usuario) session.get(Constantes.SESSION_USUARIO);

		/*******************************************************/
		//		Registrando la auditoria de la carpeta
		/*******************************************************/
		Auditoria ObjAuditoriaCarpBusq = new Auditoria();
		ObjAuditoriaCarpBusq.setTipoAuditoria(tipoauditoria);
		ObjAuditoriaCarpBusq.setModulo(modulo);
		ObjAuditoriaCarpBusq.setOpcion(opcion);
		ObjAuditoriaCarpBusq.setFechaAudioria(new Date());
		ObjAuditoriaCarpBusq.setUsuario(usuario.getUsuario());
		ObjAuditoriaCarpBusq.setCampo("Nombre Carpeta Busqueda");
		ObjAuditoriaCarpBusq.setNuevoValor(carpetaBusq.getNombreCarpeta());
		daoauditoria.SaveAuditoria(ObjAuditoriaCarpBusq);


		/*******************************************************/
		//		Registrando NroExpediente
		/*******************************************************/
		if (carpetaBusq.getNumeroExpediente().equals("") == false) {
			Auditoria ObjAuditoriaNroExp = new Auditoria();
			ObjAuditoriaNroExp.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaNroExp.setModulo(modulo);
			ObjAuditoriaNroExp.setOpcion(opcion);
			ObjAuditoriaNroExp.setFechaAudioria(new Date());
			ObjAuditoriaNroExp.setUsuario(usuario.getUsuario());
			ObjAuditoriaNroExp.setCampo("Nro Expediente");
			ObjAuditoriaNroExp.setNuevoValor(carpetaBusq.getNumeroExpediente());
			daoauditoria.SaveAuditoria(ObjAuditoriaNroExp);
		}

		/*******************************************************/
		//		Registrando NroDocumento
		/*******************************************************/
		if (carpetaBusq.getNumeroDocumento().equals("") == false) {
			Auditoria ObjAuditoriaNroDoc = new Auditoria();
			ObjAuditoriaNroDoc.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaNroDoc.setModulo(modulo);
			ObjAuditoriaNroDoc.setOpcion(opcion);
			ObjAuditoriaNroDoc.setFechaAudioria(new Date());
			ObjAuditoriaNroDoc.setUsuario(usuario.getUsuario());
			ObjAuditoriaNroDoc.setCampo("Nro Documento");
			ObjAuditoriaNroDoc.setNuevoValor(carpetaBusq.getNumeroExpediente());
			daoauditoria.SaveAuditoria(ObjAuditoriaNroDoc);
		}

		/*******************************************************/
		//		Registrando Nro Mesa Partes
		/*******************************************************/
		if (carpetaBusq.getNumeroMesaPartes().equals("") == false) {
			Auditoria ObjAuditoriaNromesapartes = new Auditoria();
			ObjAuditoriaNromesapartes.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaNromesapartes.setModulo(modulo);
			ObjAuditoriaNromesapartes.setOpcion(opcion);
			ObjAuditoriaNromesapartes.setFechaAudioria(new Date());
			ObjAuditoriaNromesapartes.setUsuario(usuario.getUsuario());
			ObjAuditoriaNromesapartes.setCampo("Nro Mesa Partes");
			ObjAuditoriaNromesapartes.setNuevoValor(carpetaBusq.getNumeroMesaPartes());
			daoauditoria.SaveAuditoria(ObjAuditoriaNromesapartes);
		}

		/*******************************************************/
		//		Registrando Consecionario
		/*******************************************************/
		if (carpetaBusq.getConsecionario().equals("") == false) {
			Auditoria ObjAuditoriaConsecionario = new Auditoria();
			ObjAuditoriaConsecionario.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaConsecionario.setModulo(modulo);
			ObjAuditoriaConsecionario.setOpcion(opcion);
			ObjAuditoriaConsecionario.setFechaAudioria(new Date());
			ObjAuditoriaConsecionario.setUsuario(usuario.getUsuario());
			ObjAuditoriaConsecionario.setCampo("Nro Documento");
			ObjAuditoriaConsecionario.setNuevoValor(carpetaBusq.getConsecionario());
			daoauditoria.SaveAuditoria(ObjAuditoriaConsecionario);
		}

		/*******************************************************/
		//		Registrando Cliente
		/*******************************************************/
		if (carpetaBusq.getCliente().equals("") == false) {
			Auditoria ObjAuditoriaCliente = new Auditoria();
			ObjAuditoriaCliente.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaCliente.setModulo(modulo);
			ObjAuditoriaCliente.setOpcion(opcion);
			ObjAuditoriaCliente.setFechaAudioria(new Date());
			ObjAuditoriaCliente.setUsuario(usuario.getUsuario());
			ObjAuditoriaCliente.setCampo("Cliente");
			ObjAuditoriaCliente.setNuevoValor(carpetaBusq.getCliente());
			daoauditoria.SaveAuditoria(ObjAuditoriaCliente);
		}

		/*******************************************************/
		//		Registrando Area Destino
		/*******************************************************/
		if (carpetaBusq.getAreaDestino().equals("") == false) {
			Auditoria ObjAuditoriaAreadestino = new Auditoria();
			ObjAuditoriaAreadestino.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaAreadestino.setModulo(modulo);
			ObjAuditoriaAreadestino.setOpcion(opcion);
			ObjAuditoriaAreadestino.setFechaAudioria(new Date());
			ObjAuditoriaAreadestino.setUsuario(usuario.getUsuario());
			ObjAuditoriaAreadestino.setCampo("Area Destino");
			ObjAuditoriaAreadestino.setNuevoValor(carpetaBusq.getAreaDestino());
			daoauditoria.SaveAuditoria(ObjAuditoriaAreadestino);
		}

		/*******************************************************/
		//		Registrando Tipo Documento
		/*******************************************************/
		if (carpetaBusq.getTipoDocumento().equals("") == false) {
			Auditoria ObjAuditoriaTipodocumento = new Auditoria();
			ObjAuditoriaTipodocumento.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaTipodocumento.setModulo(modulo);
			ObjAuditoriaTipodocumento.setOpcion(opcion);
			ObjAuditoriaTipodocumento.setFechaAudioria(new Date());
			ObjAuditoriaTipodocumento.setUsuario(usuario.getUsuario());
			ObjAuditoriaTipodocumento.setCampo("Tipo Documento");
			ObjAuditoriaTipodocumento.setNuevoValor(carpetaBusq.getTipoDocumento());
			daoauditoria.SaveAuditoria(ObjAuditoriaTipodocumento);
		}

		/*******************************************************/
		//		Registrando Doc Ident
		/*******************************************************/
		if (carpetaBusq.getDocumentoIdentidad().equals("") == false) {
			Auditoria ObjAuditoriaDocIdent = new Auditoria();
			ObjAuditoriaDocIdent.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaDocIdent.setModulo(modulo);
			ObjAuditoriaDocIdent.setOpcion(opcion);
			ObjAuditoriaDocIdent.setFechaAudioria(new Date());
			ObjAuditoriaDocIdent.setUsuario(usuario.getUsuario());
			ObjAuditoriaDocIdent.setCampo("Doc. Ident. Corrientista");
			ObjAuditoriaDocIdent.setNuevoValor(carpetaBusq.getDocumentoIdentidad());
			daoauditoria.SaveAuditoria(ObjAuditoriaDocIdent);
		}

		/*******************************************************/
		//		Registrando Fecha de Creacion desde
		/*******************************************************/
		if (carpetaBusq.getFechaDocumentoInicio() != null) {
			Auditoria ObjAuditoriaFechaDesde = new Auditoria();
			ObjAuditoriaFechaDesde.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaFechaDesde.setModulo(modulo);
			ObjAuditoriaFechaDesde.setOpcion(opcion);
			ObjAuditoriaFechaDesde.setFechaAudioria(new Date());
			ObjAuditoriaFechaDesde.setUsuario(usuario.getUsuario());
			ObjAuditoriaFechaDesde.setCampo("Fecha Doc Desde");
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			ObjAuditoriaFechaDesde.setNuevoValor(formatter.format(carpetaBusq.getFechaDocumentoInicio()));
			daoauditoria.SaveAuditoria(ObjAuditoriaFechaDesde);
		}

		/*******************************************************/
		//		Registrando Fecha Doc Creacion hasta
		/*******************************************************/
		if (carpetaBusq.getFechaDocumentoFinal() != null) {
			Auditoria ObjAuditoriaFechaHasta = new Auditoria();
			ObjAuditoriaFechaHasta.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaFechaHasta.setModulo(modulo);
			ObjAuditoriaFechaHasta.setOpcion(opcion);
			ObjAuditoriaFechaHasta.setFechaAudioria(new Date());
			ObjAuditoriaFechaHasta.setUsuario(usuario.getUsuario());
			ObjAuditoriaFechaHasta.setCampo("Fecha Doc Hasta");
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			ObjAuditoriaFechaHasta.setNuevoValor(formatter.format(carpetaBusq.getFechaDocumentoFinal()));
			daoauditoria.SaveAuditoria(ObjAuditoriaFechaHasta);
		}

		/*******************************************************/
		//		Registrando Fecha Exp Creacion desde
		/*******************************************************/
		if (carpetaBusq.getFechaExpedienteInicio() != null) {
			Auditoria ObjAuditoriaexpedienteinicio = new Auditoria();
			ObjAuditoriaexpedienteinicio.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaexpedienteinicio.setModulo(modulo);
			ObjAuditoriaexpedienteinicio.setOpcion(opcion);
			ObjAuditoriaexpedienteinicio.setFechaAudioria(new Date());
			ObjAuditoriaexpedienteinicio.setUsuario(usuario.getUsuario());
			ObjAuditoriaexpedienteinicio.setCampo("Fecha Exp Desde");
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			ObjAuditoriaexpedienteinicio.setNuevoValor(formatter.format(carpetaBusq.getFechaExpedienteInicio()));
			daoauditoria.SaveAuditoria(ObjAuditoriaexpedienteinicio);
		}

		/*******************************************************/
		//		Registrando Fecha Exp Creacion hasta
		/*******************************************************/
		if (carpetaBusq.getFechaExpedienteFinal() != null) {
			Auditoria ObjAuditoriaexpedientefinal = new Auditoria();
			ObjAuditoriaexpedientefinal.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaexpedientefinal.setModulo(modulo);
			ObjAuditoriaexpedientefinal.setOpcion(opcion);
			ObjAuditoriaexpedientefinal.setFechaAudioria(new Date());
			ObjAuditoriaexpedientefinal.setUsuario(usuario.getUsuario());
			ObjAuditoriaexpedientefinal.setCampo("Fecha Exp Hasta");
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			ObjAuditoriaexpedientefinal.setNuevoValor(formatter.format(carpetaBusq.getFechaExpedienteInicio()));
			daoauditoria.SaveAuditoria(ObjAuditoriaexpedientefinal);
		}

		/*******************************************************/
		//		Registrando direccion principal
		/*******************************************************/
		if (carpetaBusq.getFechaExpedienteFinal() != null) {
			Auditoria ObjAuditoriaexpedientefinal = new Auditoria();
			ObjAuditoriaexpedientefinal.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaexpedientefinal.setModulo(modulo);
			ObjAuditoriaexpedientefinal.setOpcion(opcion);
			ObjAuditoriaexpedientefinal.setFechaAudioria(new Date());
			ObjAuditoriaexpedientefinal.setUsuario(usuario.getUsuario());
			ObjAuditoriaexpedientefinal.setCampo("Direccion Principal");
			ObjAuditoriaexpedientefinal.setNuevoValor(carpetaBusq.getDireccionCliente());
			daoauditoria.SaveAuditoria(ObjAuditoriaexpedientefinal);
		}

		/*******************************************************/
		//		Registrando Proceso
		/*******************************************************/
		if (carpetaBusq.getProceso().equals("") == false) {
			Auditoria ObjAuditoriaProceso = new Auditoria();
			ObjAuditoriaProceso.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaProceso.setModulo(modulo);
			ObjAuditoriaProceso.setOpcion(opcion);
			ObjAuditoriaProceso.setFechaAudioria(new Date());
			ObjAuditoriaProceso.setUsuario(usuario.getUsuario());
			ObjAuditoriaProceso.setCampo("Proceso");
			ObjAuditoriaProceso.setNuevoValor(carpetaBusq.getProceso());
			daoauditoria.SaveAuditoria(ObjAuditoriaProceso);
		}
	}

	@Transactional
	private void registrarEliminacionDeCarpetaBusq(CarpetaBusqueda carpetaBusq, String tipoauditoria, String modulo, String opcion) {
		/*******************************************************/
		//		Registrando la auditoria
		/*******************************************************/
		Map session = ActionContext.getContext().getSession();
		AuditoriaDAO daoauditoria = (AuditoriaDAO) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getRequest().getSession().getServletContext()).getBean("auditoriaDAO");
		Usuario usuario = (Usuario) session.get(Constantes.SESSION_USUARIO);

		/*******************************************************/
		//		Registrando la auditoria de la eliminacion de la carpeta
		/*******************************************************/
		Auditoria ObjAuditoriaCarpBusq = new Auditoria();
		ObjAuditoriaCarpBusq.setTipoAuditoria(tipoauditoria);
		ObjAuditoriaCarpBusq.setModulo(modulo);
		ObjAuditoriaCarpBusq.setOpcion(opcion);
		ObjAuditoriaCarpBusq.setFechaAudioria(new Date());
		ObjAuditoriaCarpBusq.setUsuario(usuario.getUsuario());
		ObjAuditoriaCarpBusq.setCampo("Eliminacion de Carpeta Busqueda");
		ObjAuditoriaCarpBusq.setNuevoValor(carpetaBusq.getNombreCarpeta());
		daoauditoria.SaveAuditoria(ObjAuditoriaCarpBusq);



	}

	@Transactional
	private void registrarAuditoriaCarpetasBusqudaUpdate(CarpetaBusqueda carpetaBusq, String tipoauditoria, String modulo, String opcion) {
		/*******************************************************/
		//		Registrando la auditoria
		/*******************************************************/
		Map session = ActionContext.getContext().getSession();
		AuditoriaDAO daoauditoria = (AuditoriaDAO) WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getRequest().getSession().getServletContext()).getBean("auditoriaDAO");
		Usuario usuario = (Usuario) session.get(Constantes.SESSION_USUARIO);

		CarpetaBusqueda datosAnt = (CarpetaBusqueda) ServletActionContext.getRequest().getSession().getAttribute("carpetaBusq");

		/*******************************************************/
		//		Registrando la auditoria de la carpeta
		/*******************************************************/
		if (carpetaBusq.getNombreCarpeta().equals(datosAnt.getNombreCarpeta()) == false) {
			Auditoria ObjAuditoriaCarpBusq = new Auditoria();
			ObjAuditoriaCarpBusq.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaCarpBusq.setModulo(modulo);
			ObjAuditoriaCarpBusq.setOpcion(opcion);
			ObjAuditoriaCarpBusq.setFechaAudioria(new Date());
			ObjAuditoriaCarpBusq.setUsuario(usuario.getUsuario());
			ObjAuditoriaCarpBusq.setCampo("Nombre Carpeta Busqueda");
			ObjAuditoriaCarpBusq.setAntiguoValor(datosAnt.getNombreCarpeta());
			ObjAuditoriaCarpBusq.setNuevoValor(carpetaBusq.getNombreCarpeta());
			daoauditoria.SaveAuditoria(ObjAuditoriaCarpBusq);
		}

		/*******************************************************/
		//		Registrando NroExpediente
		/*******************************************************/
		if (carpetaBusq.getNumeroExpediente().equals(datosAnt.getNumeroExpediente()) == false) {
			Auditoria ObjAuditoriaNroExp = new Auditoria();
			ObjAuditoriaNroExp.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaNroExp.setModulo(modulo);
			ObjAuditoriaNroExp.setOpcion(opcion);
			ObjAuditoriaNroExp.setFechaAudioria(new Date());
			ObjAuditoriaNroExp.setUsuario(usuario.getUsuario());
			ObjAuditoriaNroExp.setCampo("Nro Expediente");
			ObjAuditoriaNroExp.setAntiguoValor(datosAnt.getNumeroExpediente());
			ObjAuditoriaNroExp.setNuevoValor(carpetaBusq.getNumeroExpediente());
			daoauditoria.SaveAuditoria(ObjAuditoriaNroExp);
		}

		/*******************************************************/
		//		Registrando NroDocumento
		/*******************************************************/
		if (carpetaBusq.getNumeroDocumento().equals(datosAnt.getNumeroDocumento()) == false) {
			Auditoria ObjAuditoriaNroDoc = new Auditoria();
			ObjAuditoriaNroDoc.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaNroDoc.setModulo(modulo);
			ObjAuditoriaNroDoc.setOpcion(opcion);
			ObjAuditoriaNroDoc.setFechaAudioria(new Date());
			ObjAuditoriaNroDoc.setUsuario(usuario.getUsuario());
			ObjAuditoriaNroDoc.setCampo("Nro Documento");
			ObjAuditoriaNroDoc.setAntiguoValor(datosAnt.getNumeroDocumento());
			ObjAuditoriaNroDoc.setNuevoValor(carpetaBusq.getNumeroExpediente());
			daoauditoria.SaveAuditoria(ObjAuditoriaNroDoc);
		}

		/*******************************************************/
		//		Registrando Nro Mesa Partes
		/*******************************************************/
		if (carpetaBusq.getNumeroMesaPartes().equals(datosAnt.getNumeroMesaPartes()) == false) {
			Auditoria ObjAuditoriaNromesapartes = new Auditoria();
			ObjAuditoriaNromesapartes.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaNromesapartes.setModulo(modulo);
			ObjAuditoriaNromesapartes.setOpcion(opcion);
			ObjAuditoriaNromesapartes.setFechaAudioria(new Date());
			ObjAuditoriaNromesapartes.setUsuario(usuario.getUsuario());
			ObjAuditoriaNromesapartes.setCampo("Nro Mesa Partes");
			ObjAuditoriaNromesapartes.setAntiguoValor(datosAnt.getNumeroMesaPartes());
			ObjAuditoriaNromesapartes.setNuevoValor(carpetaBusq.getNumeroMesaPartes());
			daoauditoria.SaveAuditoria(ObjAuditoriaNromesapartes);
		}

		/*******************************************************/
		//		Registrando Consecionario
		/*******************************************************/
		if (carpetaBusq.getConsecionario().equals(datosAnt.getConsecionario()) == false) {
			Auditoria ObjAuditoriaConsecionario = new Auditoria();
			ObjAuditoriaConsecionario.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaConsecionario.setModulo(modulo);
			ObjAuditoriaConsecionario.setOpcion(opcion);
			ObjAuditoriaConsecionario.setFechaAudioria(new Date());
			ObjAuditoriaConsecionario.setUsuario(usuario.getUsuario());
			ObjAuditoriaConsecionario.setCampo("Nro Documento");
			ObjAuditoriaConsecionario.setAntiguoValor(datosAnt.getConsecionario());
			ObjAuditoriaConsecionario.setNuevoValor(carpetaBusq.getConsecionario());
			daoauditoria.SaveAuditoria(ObjAuditoriaConsecionario);
		}

		/*******************************************************/
		//		Registrando Cliente
		/*******************************************************/
		if (carpetaBusq.getCliente().equals(datosAnt.getCliente()) == false) {
			Auditoria ObjAuditoriaCliente = new Auditoria();
			ObjAuditoriaCliente.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaCliente.setModulo(modulo);
			ObjAuditoriaCliente.setOpcion(opcion);
			ObjAuditoriaCliente.setFechaAudioria(new Date());
			ObjAuditoriaCliente.setUsuario(usuario.getUsuario());
			ObjAuditoriaCliente.setCampo("Cliente");
			ObjAuditoriaCliente.setAntiguoValor(datosAnt.getCliente());
			ObjAuditoriaCliente.setNuevoValor(carpetaBusq.getCliente());
			daoauditoria.SaveAuditoria(ObjAuditoriaCliente);
		}

		/*******************************************************/
		//		Registrando Area Destino
		/*******************************************************/
		if (carpetaBusq.getAreaDestino().equals(datosAnt.getAreaDestino()) == false) {
			Auditoria ObjAuditoriaAreadestino = new Auditoria();
			ObjAuditoriaAreadestino.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaAreadestino.setModulo(modulo);
			ObjAuditoriaAreadestino.setOpcion(opcion);
			ObjAuditoriaAreadestino.setFechaAudioria(new Date());
			ObjAuditoriaAreadestino.setUsuario(usuario.getUsuario());
			ObjAuditoriaAreadestino.setCampo("Area Destino");
			ObjAuditoriaAreadestino.setAntiguoValor(datosAnt.getAreaDestino());
			ObjAuditoriaAreadestino.setNuevoValor(carpetaBusq.getAreaDestino());
			daoauditoria.SaveAuditoria(ObjAuditoriaAreadestino);
		}

		/*******************************************************/
		//		Registrando Tipo Documento
		/*******************************************************/
		if (carpetaBusq.getTipoDocumento().equals(datosAnt.getTipoDocumento()) == false) {
			Auditoria ObjAuditoriaTipodocumento = new Auditoria();
			ObjAuditoriaTipodocumento.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaTipodocumento.setModulo(modulo);
			ObjAuditoriaTipodocumento.setOpcion(opcion);
			ObjAuditoriaTipodocumento.setFechaAudioria(new Date());
			ObjAuditoriaTipodocumento.setUsuario(usuario.getUsuario());
			ObjAuditoriaTipodocumento.setCampo("Tipo Documento");
			ObjAuditoriaTipodocumento.setAntiguoValor(datosAnt.getTipoDocumento());
			ObjAuditoriaTipodocumento.setNuevoValor(carpetaBusq.getTipoDocumento());
			daoauditoria.SaveAuditoria(ObjAuditoriaTipodocumento);
		}

		/*******************************************************/
		//		Registrando Doc Ident
		/*******************************************************/
		if (carpetaBusq.getDocumentoIdentidad().equals(carpetaBusq.getDocumentoIdentidad()) == false) {
			Auditoria ObjAuditoriaDocIdent = new Auditoria();
			ObjAuditoriaDocIdent.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaDocIdent.setModulo(modulo);
			ObjAuditoriaDocIdent.setOpcion(opcion);
			ObjAuditoriaDocIdent.setFechaAudioria(new Date());
			ObjAuditoriaDocIdent.setUsuario(usuario.getUsuario());
			ObjAuditoriaDocIdent.setCampo("Doc. Ident. Corrientista");
			ObjAuditoriaDocIdent.setAntiguoValor(datosAnt.getDocumentoIdentidad());
			ObjAuditoriaDocIdent.setNuevoValor(carpetaBusq.getDocumentoIdentidad());
			daoauditoria.SaveAuditoria(ObjAuditoriaDocIdent);
		}

		/*******************************************************/
		//		Registrando Fecha de Creacion desde
		/*******************************************************/
		if (carpetaBusq.getFechaDocumentoInicio() != null) {
			if (carpetaBusq.getFechaDocumentoInicio().equals(datosAnt.getFechaDocumentoInicio()) == false) {
				Auditoria ObjAuditoriaFechaDesde = new Auditoria();
				ObjAuditoriaFechaDesde.setTipoAuditoria(tipoauditoria);
				ObjAuditoriaFechaDesde.setModulo(modulo);
				ObjAuditoriaFechaDesde.setOpcion(opcion);
				ObjAuditoriaFechaDesde.setFechaAudioria(new Date());
				ObjAuditoriaFechaDesde.setUsuario(usuario.getUsuario());
				ObjAuditoriaFechaDesde.setCampo("Fecha Doc Desde");
				DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				String Fechadocumentoinicio = "";
				if (datosAnt.getFechaDocumentoInicio() != null) {
					Fechadocumentoinicio = formatter.format(datosAnt.getFechaDocumentoInicio());
				}
				ObjAuditoriaFechaDesde.setAntiguoValor(Fechadocumentoinicio);
				ObjAuditoriaFechaDesde.setNuevoValor(formatter.format(carpetaBusq.getFechaDocumentoInicio()));
				daoauditoria.SaveAuditoria(ObjAuditoriaFechaDesde);
			}
		}

		/*******************************************************/
		//		Registrando Fecha Doc Creacion hasta
		/*******************************************************/
		if (carpetaBusq.getFechaDocumentoFinal() != null) {
			if (carpetaBusq.getFechaDocumentoFinal().equals(datosAnt.getFechaDocumentoFinal()) == false) {
				Auditoria ObjAuditoriaFechaHasta = new Auditoria();
				ObjAuditoriaFechaHasta.setTipoAuditoria(tipoauditoria);
				ObjAuditoriaFechaHasta.setModulo(modulo);
				ObjAuditoriaFechaHasta.setOpcion(opcion);
				ObjAuditoriaFechaHasta.setFechaAudioria(new Date());
				ObjAuditoriaFechaHasta.setUsuario(usuario.getUsuario());
				ObjAuditoriaFechaHasta.setCampo("Fecha Doc Hasta");

				DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				String Fechadocumentofinal = "";
				if (datosAnt.getFechaDocumentoFinal() != null) {
					Fechadocumentofinal = formatter.format(datosAnt.getFechaDocumentoFinal());

				}
				ObjAuditoriaFechaHasta.setAntiguoValor(Fechadocumentofinal);
				ObjAuditoriaFechaHasta.setNuevoValor(formatter.format(carpetaBusq.getFechaDocumentoFinal()));
				daoauditoria.SaveAuditoria(ObjAuditoriaFechaHasta);
			}
		}

		/*******************************************************/
		//		Registrando Fecha Exp Creacion desde
		/*******************************************************/
		if (carpetaBusq.getFechaExpedienteInicio() != null) {
			if (carpetaBusq.getFechaExpedienteInicio().equals(datosAnt.getFechaExpedienteInicio()) == false) {
				Auditoria ObjAuditoriaexpedienteinicio = new Auditoria();
				ObjAuditoriaexpedienteinicio.setTipoAuditoria(tipoauditoria);
				ObjAuditoriaexpedienteinicio.setModulo(modulo);
				ObjAuditoriaexpedienteinicio.setOpcion(opcion);
				ObjAuditoriaexpedienteinicio.setFechaAudioria(new Date());
				ObjAuditoriaexpedienteinicio.setUsuario(usuario.getUsuario());
				ObjAuditoriaexpedienteinicio.setCampo("Fecha Exp Desde");

				DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				String Fechadocumentoinicio = "";
				if (datosAnt.getFechaExpedienteInicio() != null) {
					ObjAuditoriaexpedienteinicio.setAntiguoValor(formatter.format(datosAnt.getFechaExpedienteInicio()));
					ObjAuditoriaexpedienteinicio.setNuevoValor(formatter.format(carpetaBusq.getFechaExpedienteInicio()));
				}
				daoauditoria.SaveAuditoria(ObjAuditoriaexpedienteinicio);
			}
		}

		/*******************************************************/
		//		Registrando Fecha Exp Creacion hasta
		/*******************************************************/
		if (carpetaBusq.getFechaExpedienteFinal() != null) {
			if (carpetaBusq.getFechaExpedienteFinal().equals(datosAnt.getFechaExpedienteFinal()) == false) {
				Auditoria ObjAuditoriaexpedientefinal = new Auditoria();
				ObjAuditoriaexpedientefinal.setTipoAuditoria(tipoauditoria);
				ObjAuditoriaexpedientefinal.setModulo(modulo);
				ObjAuditoriaexpedientefinal.setOpcion(opcion);
				ObjAuditoriaexpedientefinal.setFechaAudioria(new Date());
				ObjAuditoriaexpedientefinal.setUsuario(usuario.getUsuario());
				ObjAuditoriaexpedientefinal.setCampo("Fecha Exp Hasta");
				DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				String Fechaexpdientefinal = "";
				if (datosAnt.getFechaExpedienteFinal() != null) {
					ObjAuditoriaexpedientefinal.setAntiguoValor(formatter.format(datosAnt.getFechaExpedienteFinal()));
					ObjAuditoriaexpedientefinal.setNuevoValor(formatter.format(carpetaBusq.getFechaExpedienteFinal()));
				}
				daoauditoria.SaveAuditoria(ObjAuditoriaexpedientefinal);
			}
		}

		/*******************************************************/
		//		Registrando direccion principal
		/*******************************************************/
		if (carpetaBusq.getDireccionCliente().equals(datosAnt.getDireccionCliente()) == false) {
			Auditoria ObjAuditoriaDireccioncliente = new Auditoria();
			ObjAuditoriaDireccioncliente.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaDireccioncliente.setModulo(modulo);
			ObjAuditoriaDireccioncliente.setOpcion(opcion);
			ObjAuditoriaDireccioncliente.setFechaAudioria(new Date());
			ObjAuditoriaDireccioncliente.setUsuario(usuario.getUsuario());
			ObjAuditoriaDireccioncliente.setCampo("Direccion Principal");
			ObjAuditoriaDireccioncliente.setAntiguoValor(datosAnt.getDireccionCliente());
			ObjAuditoriaDireccioncliente.setNuevoValor(carpetaBusq.getDireccionCliente());
			daoauditoria.SaveAuditoria(ObjAuditoriaDireccioncliente);
		}

		/*******************************************************/
		//		Registrando Proceso
		/*******************************************************/
		if (carpetaBusq.getProceso().equals(datosAnt.getProceso()) == false) {
			Auditoria ObjAuditoriaProceso = new Auditoria();
			ObjAuditoriaProceso.setTipoAuditoria(tipoauditoria);
			ObjAuditoriaProceso.setModulo(modulo);
			ObjAuditoriaProceso.setOpcion(opcion);
			ObjAuditoriaProceso.setFechaAudioria(new Date());
			ObjAuditoriaProceso.setUsuario(usuario.getUsuario());
			ObjAuditoriaProceso.setCampo("Proceso");
			ObjAuditoriaProceso.setAntiguoValor(datosAnt.getProceso());
			ObjAuditoriaProceso.setNuevoValor(carpetaBusq.getProceso());
			daoauditoria.SaveAuditoria(ObjAuditoriaProceso);
		}
	}

	public List<CarpetaBusqueda> buscarLstPor(Integer iIdUsuario) {
		log.debug("-> [Service] CarpetabusquedaService - buscarLstPor():List<CarpetaBusqueda> ");

		return dao.buscarLstPor(iIdUsuario);
	}

	public List<Nodo> getTreeCarpetaBusqueda(Integer iIdUsuario) {
		log.debug("-> [Service] CarpetabusquedaService - getTreeCarpetaBusqueda():List<Nodo> ");

		List<Nodo> lstArbol = null;
		List<CarpetaBusqueda> lstCarpetaBusqueda = this.buscarLstPor(iIdUsuario);

		if (lstCarpetaBusqueda != null) {
			log.debug("Numero de carpetas de busqueda encontradas [" + lstCarpetaBusqueda.size() + "]");

			lstArbol = new ArrayList<Nodo>();

			for (CarpetaBusqueda objCarpetaBusqueda : lstCarpetaBusqueda) {
				Nodo objNodo = new Nodo(Boolean.TRUE, objCarpetaBusqueda.getIdCarpetaBusqueda(), objCarpetaBusqueda.getNombreCarpeta(), null);

				log.debug("Nodo con ID [" + objCarpetaBusqueda.getIdCarpetaBusqueda() + "] carpeta [" + objCarpetaBusqueda.getNombreCarpeta() + "]");

				lstArbol.add(objNodo);
			}
		}

		return lstArbol;
	}

	public DocumentoDAO getDocumentoDAO() {
		return documentoDAO;
	}

	public void setDocumentoDAO(DocumentoDAO documentoDAO) {
		this.documentoDAO = documentoDAO;
	}
}
