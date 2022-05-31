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
	
	public IotdtcRecepcionPIDE updateIotdtcRecepcionPIDE(IotdtcRecepcionPIDE objIotdtcRecepcionPIDE) {
	      if (objIotdtcRecepcionPIDE.getVcuo() == null) {
	    	  entityManager.persist(objIotdtcRecepcionPIDE);
	    	  entityManager.flush();
	    	  entityManager.refresh(objIotdtcRecepcionPIDE);
	      } else {
	    	  entityManager.merge(objIotdtcRecepcionPIDE);
	    	  entityManager.flush();
	      }

	      return objIotdtcRecepcionPIDE;
	   }
	
	@Override
	public List<IotdtcDespachoPIDE> findAllDespacho() {
		Query query = entityManager.createNamedQuery("IotdtcDespachoPIDE.findAll");
		return query.getResultList();
	}
	
	public IotdtcDespachoPIDE getDespachoByVcuo(String vcuo) {
		System.out.println("el valor del cuo es : " +vcuo);
		Query query = entityManager.createNamedQuery("IotdtcDespachoPIDE.findByVcuo");
		query.setParameter("vcuo", vcuo);
		return (IotdtcDespachoPIDE) query.getSingleResult();
	}
	public List<IotdtcDespachoPIDE> getDespachoByVcuo1(String vcuo) {
		System.out.println("el valor del cuo es : " +vcuo);
		Query query = entityManager.createNamedQuery("IotdtcDespachoPIDE.findByVcuo");
		query.setParameter("vcuo", vcuo);
		return query.getResultList();
	}
	@Transactional
	public IotdtcDespachoPIDE updateIotdtcDespachoPIDE(IotdtcDespachoPIDE objIotdtcDespachoPIDE) {
	      try {
	    	  if (objIotdtcDespachoPIDE.getVcuo() == null) {
		    	  entityManager.persist(objIotdtcDespachoPIDE);
		    	  entityManager.flush();
		    	  entityManager.refresh(objIotdtcDespachoPIDE);
		      } else {
		    	  entityManager.merge(objIotdtcDespachoPIDE);
		    	  entityManager.flush();
		      }
		} catch (Exception e) {
			e.printStackTrace();
		}

	      return objIotdtcDespachoPIDE;
   }

	@Override
	public List<IotdtmDocExternoPIDE> findAllDocExterno() {
		Query query = entityManager.createNamedQuery("IotdtmDocExternoPIDE.findAllRecepcion");
		return query.getResultList();
	}
	
	public IotdtmDocExternoPIDE getDocExternoByCuo(String vcuo) {
			String sql = " SELECT B.* "
					+ "FROM [IDOSGD].[IOTDTC_DESPACHO] A , [IDOSGD].[IOTDTM_DOC_EXTERNO] B "
					+ "WHERE A.SIDEMIEXT = B.SIDEMIEXT "
					+ " AND VCUO =  '" + vcuo + "' " ;
			Query query = entityManager.createNativeQuery(sql.toString());
			return (IotdtmDocExternoPIDE) query.getSingleResult();

	}
	public IotdtmDocExternoPIDE updateIotdtmDocExternoPIDE(IotdtmDocExternoPIDE objIotdtmDocExternoPIDE) {
	     try {
	    	 if (objIotdtmDocExternoPIDE.getSiddocext() == null) {
		    	  entityManager.persist(objIotdtmDocExternoPIDE);
		    	  entityManager.flush();
		    	  entityManager.refresh(objIotdtmDocExternoPIDE);
		      } else {
		    	  entityManager.merge(objIotdtmDocExternoPIDE);
		    	  entityManager.flush();
		      }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

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
	      if (objIotdtdDocPrincipalPIDE.getSiddocext() == null) {
	    	  entityManager.persist(objIotdtdDocPrincipalPIDE);
	    	  entityManager.flush();
	    	  entityManager.refresh(objIotdtdDocPrincipalPIDE);
	      } else {
	    	  entityManager.merge(objIotdtdDocPrincipalPIDE);
	    	  entityManager.flush();
	      }

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
