package org.ositran.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.ositran.utils.Constantes;
import org.springframework.stereotype.Repository;

import com.btg.ositran.siged.domain.Archivo;
import com.btg.ositran.siged.domain.Usuario;
import java.util.ArrayList;
import javax.persistence.Query;

@Repository
public class ArchivoDAOImpl implements ArchivoDAO {

	private static Logger _log = Logger.getLogger(ArchivoDAOImpl.class);
	private EntityManager em;

	@PersistenceContext(unitName = "sigedPU")
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<Archivo> findArchivosxFirmar(Integer idDocumento, Usuario usuario) {
		String sql = "SELECT c FROM Archivo c where c.documento.idDocumento=:idDocumento and c.estado in ('A','V') and upper(substring(c.rutaAlfresco, len(c.rutaAlfresco)-2,3)) = 'PDF' and "
				+ " c.idArchivo not in (select a.idArchivo from FirmaArchivo a, Archivo aa where aa.documento.idDocumento = :idDocumento "
				+ " and aa.idArchivo = a.idArchivo and a.estado = 'F' and a.idUsuario= :idUsuario and a.unidadPropietario= :unidadPropietario and a.cargoPropietario= :cargoPropietario) order by c.documento.idDocumento desc , c.principal desc ";
		Query q = em.createQuery(sql);

		q.setParameter("idDocumento", idDocumento).setParameter("idUsuario", usuario.getIdUsuarioPerfil())
				.setParameter("unidadPropietario", usuario.getIdUnidadPerfil())
				.setParameter("cargoPropietario", usuario.getIdFuncionPerfil());
		return q.getResultList();
	}
	
	public List<Archivo> findArchivosxVisar(Integer idDocumento, Usuario usuario) {
		String sql = "SELECT c FROM Archivo c where c.documento.idDocumento=:idDocumento and c.estado in ('A','F') and upper(substring(c.rutaAlfresco, len(c.rutaAlfresco)-2,3)) = 'PDF' and "
				+ " c.idArchivo not in (select a.idArchivo from FirmaArchivo a, Archivo aa where aa.documento.idDocumento = :idDocumento "
				+ " and aa.idArchivo = a.idArchivo and a.estado = 'V' and a.idUsuario= :idUsuario and a.unidadPropietario= :unidadPropietario and a.cargoPropietario= :cargoPropietario) order by c.documento.idDocumento desc , c.principal desc ";
		Query q = em.createQuery(sql);

		q.setParameter("idDocumento", idDocumento).setParameter("idUsuario", usuario.getIdUsuarioPerfil())
				.setParameter("unidadPropietario", usuario.getIdUnidadPerfil())
				.setParameter("cargoPropietario", usuario.getIdFuncionPerfil());
		return q.getResultList();
	}

	public List<Archivo> findArchivoTipoFirmardo(Integer idDocumento, char tipoArchivo, String tipoFirma) {
		String sql = "SELECT c FROM Archivo c, FirmaArchivo a where c.documento.idDocumento= :idDocumento and c.estado = 'A' and c.principal = :tipoArchivo and upper(substring(c.rutaAlfresco, len(c.rutaAlfresco)-2,3)) = 'PDF' and "
				+ " c.idArchivo = a.idArchivo and a.accion = :tipoFirma ";
		Query q = em.createQuery(sql);

		q.setParameter("idDocumento", idDocumento).setParameter("tipoFirma", tipoFirma).setParameter("tipoArchivo",
				tipoArchivo);
		return q.getResultList();
	}

	public List<Archivo> findArchivoPrincipalFirmardo(Integer idDocumento, Usuario usuario) {
		String sql = "SELECT c FROM Archivo c, FirmaArchivo a where c.documento.idDocumento=:idDocumento and c.estado = 'A' and c.principal = 'S'  and upper(substring(c.rutaAlfresco, len(c.rutaAlfresco)-2,3)) = 'PDF' and "
				+ " c.idArchivo = a.idArchivo and a.estado = 'F' and a.idUsuario= :idUsuario and a.unidadPropietario= :unidadPropietario and a.cargoPropietario= :cargoPropietario ";
		Query q = em.createQuery(sql);

		q.setParameter("idDocumento", idDocumento).setParameter("idUsuario", usuario.getIdUsuarioPerfil())
				.setParameter("unidadPropietario", usuario.getIdUnidadPerfil())
				.setParameter("cargoPropietario", usuario.getIdFuncionPerfil());
		return q.getResultList();
	}

	public List<String> contarArchivosxFirmar(Integer idDocumento, Usuario usuario) {
		String sql = " SELECT a.c1, b.c2 from "
			+ "(SELECT count(1) c1 FROM Archivo c where c.documento =:idDocumento and c.estado = 'A' and upper(substring(c.rutaAlfresco, len(c.rutaAlfresco)-2,3)) = 'PDF') a ,  "
			+ "(SELECT count(1) c2 from FirmaArchivo a, Archivo aa where aa.documento = :idDocumento and aa.estado = 'A' "
			+ " and aa.idArchivo = a.idArchivo and a.estado in ('F', 'V') and a.idUsuario= :idUsuario and a.unidadPropietario= :unidadPropietario and a.cargoPropietario= :cargoPropietario) b ";
		
		Query q = em.createNativeQuery(sql.toString());
		q.setParameter("idDocumento", idDocumento).setParameter("idUsuario", usuario.getIdUsuarioPerfil())
				.setParameter("unidadPropietario", usuario.getIdUnidadPerfil())
				.setParameter("cargoPropietario", usuario.getIdFuncionPerfil());
		List<Object> res = (List<Object>) q.getResultList();
		List<String> resultado = new ArrayList<String>();

		for (Object obj : res) {
			Object[] objectArray = (Object[]) obj;
			resultado.add(objectArray[0].toString());
			resultado.add(objectArray[1].toString());
		}

		return resultado;
	}

	public Archivo buscarObjPor(Integer iIdDocumento, String sNombre) {
		Archivo objArchivo = null;
		try {
			objArchivo = (Archivo) em.createNamedQuery("Archivo.findByCriteria").setParameter("iddoc", iIdDocumento)
					.setParameter("nombre", sNombre).getSingleResult();
		} catch (NoResultException e) {
			_log.error(e.getMessage());
		}
		return objArchivo;
	}

	public Archivo buscarObjPorId(Integer iIdArchivo) {
		Archivo objArchivo = null;
		try {
			objArchivo = em.find(Archivo.class, iIdArchivo);
			em.refresh(objArchivo);
		} catch (EntityNotFoundException e) {
			_log.error(e.getMessage(), e);
		}
		return objArchivo;
	}

	@SuppressWarnings("unchecked")
	public List<Archivo> buscarArchivoExterno(String objectId, Integer nroTramite, String clave) {
		return em.createNamedQuery("Archivo.buscarArchivoExterno").setParameter("objectId", objectId)
				.setParameter("nroTramite", nroTramite).setParameter("clave", clave).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Archivo> buscarArchivosObjectId(String objectId, Integer nroTramite) {
		return em.createNamedQuery("Archivo.buscarArchivosObjectId").setParameter("objectId", objectId)
				.setParameter("nroTramite", nroTramite).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Archivo> findByIdNombreEstado(Integer idDocumento, String nombre) {
		return em.createNamedQuery("Archivo.findByIdNombreEstado").setParameter("idDocumento", idDocumento)
				.setParameter("nombre", nombre).setParameter("estado", Constantes.ESTADO_ACTIVO).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Archivo> buscarPorAutor(Integer idAutor, Integer idDocumento) {
		return em.createNamedQuery("Archivo.buscarActivosPorAutor").setParameter("idUsuario", idAutor)
				.setParameter("idDocumento", idDocumento).setParameter("estado", Constantes.ESTADO_ACTIVO)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Archivo> buscarPorAutor(Usuario usuario, Integer idDocumento) {
		return em.createNamedQuery("Archivo.buscarActivosPorAutorPorArea")
				.setParameter("idUsuario", usuario.getIdUsuarioPerfil()).setParameter("idDocumento", idDocumento)
				.setParameter("estado", Constantes.ESTADO_ACTIVO).setParameter("idUnidad", usuario.getIdUnidadPerfil())
				.getResultList();
	}

	public List<Archivo> buscarDocumentosPublicar(String nroTramite) {
		String sql = "SELECT IDARCHIVO, OBJECTID, upper(SUBSTRING(nombre, CHARINDEX(nombre,']')  + 1, LEN(nombre))) AS NOMBRE, ORDEN, PRINCIPAL FROM (  "
				+ "        SELECT A.IDARCHIVO, A.OBJECTID ,  A.NOMBRE, 1 as orden, A.PRINCIPAL   "
				+ "          FROM DOCUMENTO D, ARCHIVO A LEFT JOIN REFERENCIAARCHIVO R "
				+ "   		ON  A.DOCUMENTO =  R.IDDOCUMENTO AND  "
				+ "              A.DOCUMENTO =  R.IDDOCUMENTOREFERENCIA  AND "
				+ "              A.IDARCHIVO = R.IDARCHIVO WHERE"
				+ "		 	D.id_codigo =   " + nroTramite + " AND "
				+ " 		D.ESTADO NOT IN ('I','N') AND  " + "  D.IDDOCUMENTO = A.DOCUMENTO AND "
				+ "              A.ESTADO = 'A' AND " + " A.PRINCIPAL = 'S' UNION "
				+ "  SELECT A.IDARCHIVO, A.OBJECTID ,  A.NOMBRE,2 as orden, A.PRINCIPAL   " 
				+ " FROM DOCUMENTO D, ARCHIVO A LEFT JOIN REFERENCIAARCHIVO R " 
				+ " ON A.DOCUMENTO =  R.IDDOCUMENTO " 
				+ "  AND A.DOCUMENTO = R.IDDOCUMENTOREFERENCIA " + " AND A.IDARCHIVO = R.IDARCHIVO "
				+ " WHERE D.id_codigo =  "  + nroTramite + " AND D.ESTADO NOT IN ('I','N') "
				+ " AND D.IDDOCUMENTO = A.DOCUMENTO " + " AND A.ESTADO = 'A' " 
				+ "  AND A.PRINCIPAL = 'N' " + " AND LOWER(SUBSTRING(A.nombre,LEN(A.nombre) - 2,3)) = 'pdf' UNION"
				+ "  SELECT A.IDARCHIVO, A.OBJECTID ,  A.NOMBRE,3 as orden, 'X' AS PRINCIPAL " 
				+ " FROM DOCUMENTOREFERENCIA R, REFERENCIAARCHIVO F, ARCHIVO A, DOCUMENTO D " 
				+ "  WHERE R.IDDOCUMENTO  IN   (	SELECT  IDDOCUMENTO  FROM DOCUMENTO WHERE ID_CODIGO = " + nroTramite + " ) "
				+ "  AND  R.IDDOCUMENTO  = F.IDDOCUMENTO AND  R.IDDOCUMENTOREFERENCIA = F.IDDOCUMENTOREFERENCIA " + 
				" AND  A.DOCUMENTO = (SELECT CASE C.DOCUMENTOREFERENCIA WHEN NULL THEN C.IDDOCUMENTO ELSE C.DOCUMENTOREFERENCIA END "
				+ " FROM DOCUMENTO C  WHERE C.IDDOCUMENTO = R.IDDOCUMENTOREFERENCIA) AND " 
				+ " A.DOCUMENTO = D.IDDOCUMENTO AND D.ESTADO NOT IN ('I','N')  AND R.ESTADO = 'A' " +
				"  AND A.ESTADO = 'A' AND A.IDARCHIVO = F.IDARCHIVO AND F.ESTADO = 'A' AND LOWER(SUBSTRING(A.nombre,LEN(A.nombre) - 2,3)) = 'pdf' ) Z "
				+ "  ORDER BY ORDEN ASC "
				;

		Query q = em.createNativeQuery(sql.toString());
		List<Object> res = (List<Object>) q.getResultList();
		List<Archivo> lst = new ArrayList<Archivo>();

		for (Object obj : res) {
			Object[] objectArray = (Object[]) obj;
			Archivo archivo = new Archivo();
			archivo.setNombre(objectArray[2] == null ? "" : objectArray[2].toString());
			archivo.setObjectId(objectArray[1] == null ? "" : objectArray[1].toString());
			archivo.setPrincipal(objectArray[4].toString().charAt(0));
			lst.add(archivo);
		}

		return lst;

	}

	public List<Archivo> buscarArchivosPorRutaDocumento(Integer idDocumento, String nombre) {
		List<Archivo> archivos = new ArrayList<Archivo>();

		try {
			_log.info("buscarArchivosPorRutaDocumento: idDocumento:" + idDocumento + ",nombre:" + nombre);
			String sql = "SELECT a.* FROM Archivo a inner join documento d on a.documento = d.iddocumento WHERE  d.idDocumento = :idDocumento and a.estado = :estado and LOWER(SUBSTRING(a.NOMBRE, CHARINDEX(a.nombre,']') +1, LEN(a.NOMBRE))) = :nombre";
			Query q = em.createNativeQuery(sql).setParameter("nombre", nombre) // .getRutaAlfresco().toLowerCase())
					.setParameter("idDocumento", idDocumento).setParameter("estado", Constantes.ESTADO_ACTIVO);

			List<Object> res = (List<Object>) q.getResultList();
			for (Object obj : res) {
				Object[] objectArray = (Object[]) obj;
				// Archivo archivo = new Archivo();
				_log.info("idArchivo:" + objectArray[0].toString());

				/*
				 * archivo.setIdArchivo(Integer.parseInt(objectArray[0].toString
				 * ()));
				 * archivo.setClave(objectArray[1]==null?"":objectArray[1].
				 * toString());
				 * archivo.setDescripcion(objectArray[2]==null?"":objectArray[2]
				 * .toString());
				 * archivo.setEstado(objectArray[3]==null?Character.valueOf("".
				 * charAt(0)):Character.valueOf(objectArray[3].toString().charAt
				 * (0)));
				 * archivo.setEstadoDigitalizacion(objectArray[4]==null?"".
				 * charAt(0):objectArray[4].toString().charAt(0));
				 * archivo.setNombre(objectArray[7]==null?"":objectArray[7].
				 * toString());
				 * archivo.setObjectId(objectArray[8]==null?"":objectArray[8].
				 * toString());
				 * archivo.setPrincipal(objectArray[9].toString().charAt(0));
				 * archivo.setRutaAlfresco(objectArray[10]==null?"":objectArray[
				 * 10].toString());
				 * archivo.setRutaArchivoPdf(objectArray[11]==null?"":
				 * objectArray[11].toString());
				 * archivo.setTamano(objectArray[12]==null?0:Integer.parseInt(
				 * objectArray[12].toString()));
				 * archivo.setUnidadAutor(objectArray[13]==null?0:Integer.
				 * parseInt(objectArray[13].toString()));
				 * //archivo.setAutor(objectArray[16]==null?0:Integer.parseInt(
				 * objectArray[13].toString()));
				 * //archivo.setDocumento(objectArray[17]==null?0:Integer.
				 * parseInt(objectArray[17].toString()));
				 */
				Archivo archivo = (Archivo) em.createQuery("select a from Archivo a where idArchivo = :idArchivo")
						.setParameter("idArchivo", Integer.parseInt(objectArray[0].toString())).getSingleResult();

				archivos.add(archivo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return archivos;
	}

	public Archivo guardarObj(Archivo objArchivo) {
		try {
			_log.info("guardarObj:objArchivo.getRutaAlfresco:" + objArchivo.getRutaAlfresco());
			if (objArchivo.getRutaAlfresco() != null) {
				String sql = "SELECT COUNT(a.idArchivo) FROM Archivo a inner join documento d on a.documento = d.iddocumento WHERE  d.idDocumento = :idDocumento and LOWER(SUBSTRING(a.NOMBRE, CHARINDEX(a.nombre,']') +1, LEN(a.NOMBRE))) = :nombre and a.estado =  'A' ";
				Integer numero = (Integer) em.createNativeQuery(sql)
					.setParameter("nombre", objArchivo.getNombreArchivo().toLowerCase())
					.setParameter("idDocumento", objArchivo.getDocumento().getIdDocumento()).getSingleResult();

				_log.info("guardarObj:numero:" + numero);
				if (numero != null && numero > 0) {
					sql = "SELECT ar FROM Archivo ar WHERE LOWER(SUBSTRING(NOMBRE, CHARINDEX(nombre,'']'') +1, LEN(NOMBRE))) = :nombre AND ar.documento.idDocumento = :idDocumento and ar.estado =  'A'  ";
					Archivo archivo = (Archivo) em.createQuery(sql)
						.setParameter("nombre", objArchivo.getNombreArchivo().toLowerCase()) // .getRutaAlfresco().toLowerCase())
						.setParameter("idDocumento", objArchivo.getDocumento().getIdDocumento()).getResultList()
						.get(0);

					archivo.setEstado(objArchivo.getEstado());
					archivo.setAutor(objArchivo.getAutor());
					archivo.setPrincipal(objArchivo.getPrincipal());
					archivo.setFechaModificacion(objArchivo.getFechaCreacion());
					archivo.setUsuariomodificacion(objArchivo.getUsuariomodificacion());
					archivo.setRutaArchivoPdf(objArchivo.getRutaArchivoPdf());
					archivo.setNombre(objArchivo.getNombre());
					archivo.setRutaAlfresco(objArchivo.getRutaAlfresco());
					archivo.setObjectId(objArchivo.getObjectId());
					archivo.setCodProcesoFirma(objArchivo.getCodProcesoFirma());
					em.merge(archivo);
					em.flush();
					em.refresh(archivo);
					return archivo;
				}
			}

			if (objArchivo.getIdArchivo() == null) {
				em.persist(objArchivo);
			} else {
				em.merge(objArchivo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objArchivo;
	}

	@SuppressWarnings("unchecked")
	public List<Archivo> checkEstadoDigitalizacion(Integer iIdDoc) {
		return em.createNamedQuery("Archivo.checkEstadoDigitalizacion").setParameter("iddoc", iIdDoc).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Archivo> findByIdDocumentoOrderDesc(Integer iIdExpediente, Integer iIdDocumento, String sRol) {
		if (sRol != null && sRol.equals(Constantes.ROL_QAS)) {
			return em.createNamedQuery("Archivo.findByIdDocumentoOrderDescQAS")
					.setParameter("idexpediente", iIdExpediente).setParameter("iddocumento", iIdDocumento)
					.getResultList();
		}
		return em.createNamedQuery("Archivo.findByIdDocumentoOrderDesc").setParameter("idexpediente", iIdExpediente)
				.setParameter("iddocumento", iIdDocumento).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Archivo> findByCriteria(Integer iIdDoc, String strNombre, SearchMode sm) {
		List<Archivo> lstArchivo = null;
		switch (sm) {
		case LEFT_MATCH:
			strNombre = strNombre + '%';
			break;
		case ANYWHERE_MATCH:
			strNombre = '%' + strNombre + '%';
			break;
		case RIGHT_MATCH:
			strNombre = '%' + strNombre;
			break;
		default:
			break;
		}
		_log.debug(iIdDoc + "," + strNombre);
		lstArchivo = em.createNamedQuery("Archivo.findByCriteria2").setParameter("iddoc", iIdDoc)
				.setParameter("nombre", strNombre).getResultList();
		if (lstArchivo != null) {
			_log.debug("Archivos encontrados [" + lstArchivo.size() + "]");
		} else {
			_log.debug("No se encontraron archivos");
		}
		return lstArchivo;
	}

	@SuppressWarnings("unchecked")
	public List<Archivo> findByEstado(char estado) {
		return em.createNamedQuery("Archivo.findByEstadodigitalizacion").setParameter("estadodigitalizacion", estado)
				.getResultList();
	}

	public Long buscarArchivosPorRuta(String ruta, Usuario usuario) {
		return (Long) em.createNamedQuery("Archivo.buscarArchivosPorRuta")
				.setParameter("estado", Constantes.ESTADO_ACTIVO).setParameter("ruta", ruta)
				.setParameter("autor", usuario.getIdUsuarioPerfil()).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Archivo> findByIdDocumento(Integer iIdDoc) {
		return em.createNamedQuery("Archivo.findByIdDocumento").setParameter("estado", Constantes.ESTADO_ACTIVO)
				.setParameter("iddoc", iIdDoc).getResultList();
	}
	
//	@Override
//	public List<Archivo> findArchivoPrincipalByIdDocumento1(Integer idDocumento) {
//		String sql = "select a from Archivo a where a.documento.idDocumento = :idDocumento and a.principal = :principal and a.estado = :eatado";
//		Query q = em.createQuery(sql);
//		q.setParameter("idDocumento", idDocumento);
//		q.setParameter("principal", Constantes.ARCHIVO_PRINCIPAL);
//		q.setParameter("eatado", Constantes.ESTADO_ACTIVO);
//		
//		return q.getResultList();
//	}

	public int updateEstado(Integer iIdArchivo, Character cEstado) {
		return em.createNamedQuery("Archivo.updateEstado").setParameter("estado", cEstado)
				.setParameter("idarchivo", iIdArchivo).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Archivo> findlstByExpediente(Integer idExpediente) {
		try {
			return em.createNamedQuery("Archivo.findByExpediente").setParameter("idexpediente", idExpediente)
					.getResultList();
		} catch (NoResultException nre) {
			_log.warn("No se encontro ningun archivo");

			return null;
		}
	}

	@Override
	public Archivo buscarArchivoPrincipalPorDocumento(Integer idDocumento) {

		Archivo objArchivo = null;
		try {
			objArchivo = (Archivo) em.createNamedQuery("Archivo.buscarArchivoPrincipalPorDocumento")
					.setParameter("idDocumento", idDocumento)
					.setParameter("estado", Constantes.ESTADO_ACTIVO)
					.setParameter("estadoDigitalizacion", 'I')
					.setParameter("principal", Constantes.ARCHIVO_PRINCIPAL).getSingleResult();
		} catch (NoResultException e) {
			_log.error(e.getMessage());
		}
		return objArchivo;
	}

	@Override
	public int updatePrincipal(Integer iIdArchivo, Character principal) {

		Archivo objArchivo = null;
		try {
			objArchivo = this.buscarObjPorId(iIdArchivo);

			if (objArchivo != null) {
				objArchivo.setPrincipal(principal);
				updateArchivo(objArchivo);
			}
			return 1;
		} catch (NoResultException e) {
			_log.error(e.getMessage());
			return 0;
		}

		// return
		// em.createNamedQuery("Archivo.updatePrincipal").setParameter("principal",'S').setParameter("idarchivo",iIdArchivo).executeUpdate();
	}

	@Override
	public Archivo updateArchivo(Archivo objT) {
		_log.debug("-> [DAO] ArchivoDAO - updateArchivo():Archivo ");
		try {
			em.merge(objT);
			em.flush();
			em.refresh(objT);
			return objT;
		} catch (Exception e) {
			return null;
		}
	}
}