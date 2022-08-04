package org.ositran.daos;

import com.btg.ositran.siged.domain.InformeObra;

public interface InformeObraDAO {
	public void create(InformeObra informeObra);
	public InformeObra read(Integer idInformeObra);
	public void update(InformeObra informeObra);
	public void delete(Integer idInformeObra);

}
