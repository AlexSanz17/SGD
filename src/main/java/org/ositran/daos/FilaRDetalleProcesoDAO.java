/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.daos;
/*DUMMY*/
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.btg.ositran.siged.domain.FilaRDetalleProceso;

public interface FilaRDetalleProcesoDAO {

	@PersistenceContext(unitName = "sigedPU")
	public abstract void setEm(EntityManager em);

	public abstract List<FilaRDetalleProceso> reporteInicialDetallado();

	public abstract List<FilaRDetalleProceso> generarReporteDetalle(
			String procesoClasif, String procesoElegido, String estado,
			String fechaDesde, String fechaHasta);

}