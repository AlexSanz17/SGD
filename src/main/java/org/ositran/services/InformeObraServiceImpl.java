//package org.ositran.services;
//
//import org.ositran.daos.InformeObraDAO;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.btg.ositran.siged.domain.InformeObra;
//
//@Service
//public class InformeObraServiceImpl implements InformeObraService {
//	@Autowired(required=false)
//	private InformeObraDAO informeObraDAO;
//	
//	public InformeObraDAO getInformeObraDAO() {
//		return informeObraDAO;
//	}
//
//	public void setInformeObraDAO(InformeObraDAO informeObraDAO) {
//		this.informeObraDAO = informeObraDAO;
//	}
//	
//    @Override
//    @Transactional
//    public void create(InformeObra informeObra) {
//    	informeObraDAO.create(informeObra);
//    }
//
//    @Override
//    @Transactional
//    public InformeObra read(Long idInformeObra) {
//    	return informeObraDAO.read(idInformeObra);
//    }
//    
//	@Override
//	@Transactional
//    public void update(InformeObra informeObra) {
//    	informeObraDAO.update(informeObra);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Long idInformeObra) {
//    	informeObraDAO.delete(idInformeObra);
//    }
//}