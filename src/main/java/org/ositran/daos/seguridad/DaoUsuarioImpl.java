/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.daos.seguridad;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import com.btg.ositran.siged.domain.seguridad.UsuarioSeguridad;

public class DaoUsuarioImpl extends JpaDaoSupport implements DaoUsuario{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioSeguridad> getTodos(){		
		/*return getJpaTemplate().executeFind(new JpaCallback(){
			@Override
			public Object doInJpa(EntityManager em) throws PersistenceException{
				//return em.createNamedQuery("UsuarioSeguridad.getTodos").getResultList();
				String sql="SELECT u.usrio_id,u.cod_dep,u.usrio_correo,u.usrio_nombre,u.usrio_login,u.usrio_estado,u.usrio_cntrsnha FROM seg_m_usrio u WHERE usrio_id in (" +
							"  SELECT usrio_id FROM seg_t_usrio_rol WHERE rol_id in(" +
							"    SELECT rol_id FROM seg_m_rol WHERE rol_nombre like 'Siged -%'))" +
							"AND u.usrio_estado='AC' AND u.cod_dep IS NOT NULL";
				return em.createNativeQuery(sql,UsuarioSeguridad.class).getResultList();
			}
		});*/
		return null;
	}	
	
}
