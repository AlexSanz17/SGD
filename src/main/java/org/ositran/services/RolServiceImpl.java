package org.ositran.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.ositran.daos.RolDAO;
import org.ositran.daos.UsuarioDAO;
import org.ositran.utils.Constantes;
import org.springframework.transaction.annotation.Transactional;

import com.btg.ositran.siged.domain.Rol;
import com.btg.ositran.siged.domain.Usuario;

public class RolServiceImpl implements RolService {

	private static Logger log = Logger.getLogger(RolServiceImpl.class);
	private RolDAO dao;
	private UsuarioDAO usuarioDao;


	private AuditoriaService srvAuditoria;

	//////////////////////////////////
	// Constructors                 //
	//////////////////////////////////
	public RolServiceImpl(RolDAO dao) {
		setDao(dao);
	}

	//////////////////////////////////
	// Methods                      //
	//////////////////////////////////
	public List<Rol> obtenerTodo() {
		log.debug("-> [Service] RolService - obtenerTodo():List<Rol> ");

		return getDao().findAll();
	}

	public Map<Integer,String> getRolMap() {
		log.debug("-> [Service] RolService - getRolMap():Map<Integer,String> ");
		
		List<Rol> lstR = getDao().findAll();
		Map<Integer,String> mapRol = new HashMap<Integer,String>();

		for (Rol objR : lstR) {
			mapRol.put(objR.getIdrol(), objR.getNombre());
		}

		return mapRol;
	}

	public Rol findByIdRol(Integer iIdR) {
		log.debug("-> [Service] RolService - findByIdRol():Rol ");
		
		return getDao().findByIdRol(iIdR);
	}

	public Rol findByNombre(String strN) {
		log.debug("-> [Service] RolService - findByNombre():Rol ");
		
		return getDao().encontrarPorNombre(strN);
	}

	@Transactional
	public void guardarObj(Rol objRolOld, Rol objRolNew, String sUsuarioSesion, String sTipoAuditoria) {
		log.debug("-> [Service] RolService - guardarObj():void ");
		
		try {
			srvAuditoria.aplicarAuditoria(objRolOld, objRolNew, sUsuarioSesion, Constantes.AUDITORIA_OPCION_GUARDAR, sTipoAuditoria);
		} catch (ClassNotFoundException e) {
			log.error(e.getMessage(), e);
		}

		objRolNew = dao.guardarObj(objRolNew);

		log.debug("Rol guardado con ID [" + objRolNew.getIdrol() + "] Nombre [" + objRolNew.getNombre() + "]");
	}

	//////////////////////////////////
	// Getters and Setters          //
	//////////////////////////////////
	public RolDAO getDao() {
		return dao;
	}

	public void setDao(RolDAO dao) {
		this.dao = dao;
	}

	public AuditoriaService getSrvAuditoria() {
		return srvAuditoria;
	}

	public void setSrvAuditoria(AuditoriaService srvAuditoria) {
		this.srvAuditoria = srvAuditoria;
	}

	@Override
	public List<Rol> getRolesMenosUsuario(List<Rol> delUsuario){
		log.debug("-> [Service] RolService - getRolesMenosUsuario():List<Rol> ");
		
		List<Rol> todos=dao.findAll();
		List<Rol> salida=new ArrayList<Rol>();

		if (delUsuario == null || delUsuario.size() <= 0) {
			return todos;
		}

		for(Rol rol : todos){
			if(!delUsuario.contains(rol)){
				salida.add(rol);
			}
		}
		return salida;
	}

	@Override
	public List<Rol> getRolesPorUsuario(String usuario){
		log.debug("-> [Service] RolService - getRolesPorUsuario():List<Rol> ");
		
		Usuario usu=usuarioDao.findByUsuario(usuario);
		if(usu!=null){
			return null;// usu.getRoles();
		}
		return null;
	}

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
