package org.ositran.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.btg.ositran.siged.domain.DocumentoRechazado;

@Repository
public class DocumentoRechazadoDAOImpl implements DocumentoRechazadoDAO {
	@PersistenceContext(unitName="sigedPU")
	EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public void registrar(DocumentoRechazado documentoRechazado) {
		entityManager.persist(documentoRechazado);
		
	}
	
	@Override
	public List<DocumentoRechazado> buscarTodos() {
		return entityManager.createNamedQuery("DocumentoRechazado.buscarTodos").getResultList();
	}
	
	@Override
	public DocumentoRechazado buscarPorIdDocumentoRechazado(Integer idDocumentoRechazado) {
		return (DocumentoRechazado) entityManager.createNamedQuery("DocumentoRechazado.buscarPorIdDocumentoRechazado")
			.setParameter("idDocumentoRechazado", idDocumentoRechazado).getSingleResult();
	}
}