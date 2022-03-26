package org.ositran.daos;

import java.util.List;

import com.btg.ositran.siged.domain.IotdtdAdjuntoMPV;

public interface AdjuntoMPVDAO {
	public List<IotdtdAdjuntoMPV> buscarTodos();
	public IotdtdAdjuntoMPV buscarPorIdAdjunto(Integer idAdjunto);
	public Integer buscarNumFoliosPorIdRecepcion(Integer idRecepcion, Integer tipoArchivo);
	public Integer buscarNumFoliosTotalesPorIdRecepcion(Integer idRecepcion);
}