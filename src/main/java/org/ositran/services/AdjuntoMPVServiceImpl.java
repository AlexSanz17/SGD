package org.ositran.services;

import java.util.List;

import org.ositran.daos.AdjuntoMPVDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.btg.ositran.siged.domain.IotdtdAdjuntoMPV;

@Service
public class AdjuntoMPVServiceImpl implements AdjuntoMPVService {
	@Autowired(required = false)
	private AdjuntoMPVDAO adjuntoMPVDAO;
	
	public AdjuntoMPVDAO getAdjuntoMPVDAO() {
		return adjuntoMPVDAO;
	}
	public void setAdjuntoMPVDAO(AdjuntoMPVDAO adjuntoMPVDAO) {
		this.adjuntoMPVDAO = adjuntoMPVDAO;
	}
	
	@Override
	public List<IotdtdAdjuntoMPV> buscarTodos() {
		return adjuntoMPVDAO.buscarTodos();
	}
	
	@Override
	public IotdtdAdjuntoMPV buscarPorIdAdjunto(Integer idAdjunto) {
		return adjuntoMPVDAO.buscarPorIdAdjunto(idAdjunto);
	}
	
	@Override
	public Integer buscarNumFoliosPorIdRecepcion(Integer idRecepcion, Integer tipoArchivo) {
		return adjuntoMPVDAO.buscarNumFoliosPorIdRecepcion(idRecepcion, tipoArchivo);
	}
	@Override
	public List<IotdtdAdjuntoMPV> buscarAnexoPorIdRecepcion(Integer idRecepcion) {
		return adjuntoMPVDAO.buscarAnexoPorIdRecepcion(idRecepcion);
	}
	
	@Override
	public Integer buscarNumFoliosTotalesPorIdRecepcion(Integer idRecepcion) {
		return adjuntoMPVDAO.buscarNumFoliosTotalesPorIdRecepcion(idRecepcion);
	}
}