package org.ositran.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.btg.ositran.siged.domain.IotdtcDespachoPIDE;
import com.btg.ositran.siged.domain.IotdtcRecepcionPIDE;
import com.btg.ositran.siged.domain.IotdtdAnexoPIDE;
import com.btg.ositran.siged.domain.IotdtdDocPrincipalPIDE;
import com.btg.ositran.siged.domain.IotdtmDocExternoPIDE;
@Repository
public class DocumentoPIDEDAOImpl implements DocumentoPIDEDAO {
	@PersistenceContext(unitName="pidePU")
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<IotdtcRecepcionPIDE> findAllRecepcion() {
		Query query = entityManager.createNamedQuery("IotdtcRecepcionPIDE.findAll");
		return query.getResultList();
	}
	public IotdtcRecepcionPIDE findRecepcionByVcuo(String vcuo) {
		Query query = entityManager.createNamedQuery("IotdtcRecepcionPIDE.findByVcuo");
		query.setParameter("vcuo", vcuo);
		return (IotdtcRecepcionPIDE) query.getSingleResult();
	}
	@Transactional
	public IotdtcRecepcionPIDE updateIotdtcRecepcionPIDE(IotdtcRecepcionPIDE objIotdtcRecepcionPIDE) {
//	      if (objIotdtcRecepcionPIDE.getVcuo() == null) {
	    	  entityManager.persist(objIotdtcRecepcionPIDE);
	    	  entityManager.flush();
	    	  entityManager.refresh(objIotdtcRecepcionPIDE);
//	      } else {
//	    	  entityManager.merge(objIotdtcRecepcionPIDE);
//	    	  entityManager.flush();
//	      }

	      return objIotdtcRecepcionPIDE;
	   }
	
	@Override
	public List<IotdtcDespachoPIDE> findAllDespacho() {
		Query query = entityManager.createNamedQuery("IotdtcDespachoPIDE.findAll");
		return query.getResultList();
	}
	
	public IotdtcDespachoPIDE getDespachoByVcuo(String vcuo) {
		Query query = entityManager.createNamedQuery("IotdtcDespachoPIDE.findByVcuo");
		query.setParameter("vcuo", vcuo);
		return (IotdtcDespachoPIDE) query.getSingleResult();
	}
	@Override
	@Transactional
	public IotdtcDespachoPIDE updateIotdtcDespachoPIDE(IotdtcDespachoPIDE objIotdtcDespachoPIDE) {
	    try {
//	    	String sql = "INSERT INTO [IDOSGD].[IOTDTC_DESPACHO] ( Bcarstdrec, Cflgest, Ctipdociderem ,Vcuo,Vusuregstdrec) VALUES (?,?,?,?,?) ";
//	    	
//	    	entityManager.createNativeQuery(sql).setParameter(1, objIotdtcDespachoPIDE.getBcarstdrec())
//	    	.setParameter(2, objIotdtcDespachoPIDE.getCflgest()).setParameter(3, objIotdtcDespachoPIDE.getCtipdociderem()).setParameter(4, objIotdtcDespachoPIDE.getVcuo()).setParameter(5, objIotdtcDespachoPIDE.getVusuregstdrec()).executeUpdate();
//	    	 entityManager.flush();
//	    	entityManager.getTransaction().commit();
//		   entityManager.persist(objIotdtcDespachoPIDE);
	    	  entityManager.persist(objIotdtcDespachoPIDE);
	    	  entityManager.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	      return objIotdtcDespachoPIDE;
   }

	@Override
	public List<IotdtmDocExternoPIDE> findAllDocExterno() {
		Query query = null;
		try {
			query = entityManager.createNamedQuery("IotdtmDocExternoPIDE.findAll");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return query.getResultList();
	}
	public IotdtmDocExternoPIDE getDocExternoBySidemext(Integer sidemiext) {
		IotdtmDocExternoPIDE iotdtmDocExternoPIDE = null;
		try {
			 Query query = entityManager.createNamedQuery("IotdtmDocExternoPIDE.findBySidemiext");
			query.setParameter("sidemiext", sidemiext);
			iotdtmDocExternoPIDE =  (IotdtmDocExternoPIDE) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return iotdtmDocExternoPIDE ;
	}
	
	public IotdtmDocExternoPIDE getDocExternoByCuo(String vcuo) {
			String sql = " SELECT B.* "
					+ "FROM [IDOSGD].[IOTDTC_DESPACHO] A , [IDOSGD].[IOTDTM_DOC_EXTERNO] B "
					+ "WHERE A.SIDEMIEXT = B.SIDEMIEXT "
					+ " AND VCUO =  '" + vcuo + "' " ;
			Query query = entityManager.createNativeQuery(sql.toString());
			return (IotdtmDocExternoPIDE) query.getSingleResult();

	}
	@Transactional
	public IotdtmDocExternoPIDE updateIotdtmDocExternoPIDE(IotdtmDocExternoPIDE objIotdtmDocExternoPIDE) {
//	      if (objIotdtmDocExternoPIDE.getSiddocext() == null) {
	    	  entityManager.persist(objIotdtmDocExternoPIDE);
	    	  entityManager.flush();
	    	  entityManager.refresh(objIotdtmDocExternoPIDE);
//	      } else {
//	    	  entityManager.merge(objIotdtmDocExternoPIDE);
//	    	  entityManager.flush();
//	      }

	      return objIotdtmDocExternoPIDE;
 }

	@Override
	public List<IotdtdDocPrincipalPIDE> findAllDocPrincipal() {
		Query query = entityManager.createNamedQuery("IotdtdDocPrincipalPIDE.findAllRecepcion");
		return query.getResultList();
	}
	
	public IotdtdDocPrincipalPIDE getDocPrincipalByCuo(String vcuo) {
		String sql = " SELECT C.* "
				+ "FROM [IDOSGD].[IOTDTC_DESPACHO] A , [IDOSGD].[IOTDTM_DOC_EXTERNO] B , [IDOSGD].[IOTDTD_DOC_PRINCIPAL] C "
				+ "WHERE A.SIDEMIEXT = B.SIDEMIEXT "
				+ "AND B.SIDDOCEXT = C.SIDDOCEXT "
				+ "AND VCUO = '" +vcuo +"' ";
		Query query = entityManager.createNativeQuery(sql.toString());
		return (IotdtdDocPrincipalPIDE) query.getSingleResult();

}
	public IotdtdDocPrincipalPIDE updateIotdtdDocPrincipalPIDE(IotdtdDocPrincipalPIDE objIotdtdDocPrincipalPIDE) {
//	      if (objIotdtdDocPrincipalPIDE.getSiddocext() == null) {
	    	  entityManager.persist(objIotdtdDocPrincipalPIDE);
	    	  entityManager.flush();
	    	  entityManager.refresh(objIotdtdDocPrincipalPIDE);
//	      } else {
//	    	  entityManager.merge(objIotdtdDocPrincipalPIDE);
//	    	  entityManager.flush();
//	      }

	      return objIotdtdDocPrincipalPIDE;
	}

	@Override
	public List<IotdtdAnexoPIDE> findAllAnexo() {
		Query query = entityManager.createNamedQuery("IotdtdAnexoPIDE.findAllRecepcion");
		return query.getResultList();
	}
	public IotdtdAnexoPIDE getAnexoByCuo(String vcuo) {
		String sql = " SELECT C.* "
				+ "FROM [IDOSGD].[IOTDTC_DESPACHO] A , [IDOSGD].[IOTDTM_DOC_EXTERNO] B , [IDOSGD].[IOTDTD_ANEXO] C "
				+ "WHERE A.SIDEMIEXT = B.SIDEMIEXT "
				+ "AND B.SIDDOCEXT = C.SIDDOCEXT "
				+ "AND VCUO = '" +vcuo +"' ";
		Query query = entityManager.createNativeQuery(sql.toString());
		return (IotdtdAnexoPIDE) query.getSingleResult();

}
	
	public IotdtdAnexoPIDE updateIotdtdAnexoPIDE(IotdtdAnexoPIDE objIotdtdAnexoPIDE) {
	      if (objIotdtdAnexoPIDE.getSiddocext() == null) {
	    	  entityManager.persist(objIotdtdAnexoPIDE);
	    	  entityManager.flush();
	    	  entityManager.refresh(objIotdtdAnexoPIDE);
	      } else {
	    	  entityManager.merge(objIotdtdAnexoPIDE);
	    	  entityManager.flush();
	      }

	      return objIotdtdAnexoPIDE;
	}

}
