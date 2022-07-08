package org.ositran.services;

import java.util.List;

import com.btg.ositran.siged.domain.IotdtdAdjuntoMPV;

public interface AdjuntoMPVService {
	public List<IotdtdAdjuntoMPV> buscarTodos();
	public IotdtdAdjuntoMPV buscarPorIdAdjunto(Integer idAdjunto);
	public Integer buscarNumFoliosPorIdRecepcion(Integer idRecepcion, Integer tipoArchivo);
	public Integer buscarNumFoliosTotalesPorIdRecepcion(Integer idRecepcion);
	public List<IotdtdAdjuntoMPV> buscarAnexoPorIdRecepcion(Integer idRecepcion);
}