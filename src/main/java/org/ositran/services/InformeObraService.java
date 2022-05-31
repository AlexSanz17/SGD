package org.ositran.services;

import com.btg.ositran.siged.domain.InformeObra;

public interface InformeObraService {
	public void create(InformeObra informeObra);
	public InformeObra read(Long idInformeObra);
	public void update(InformeObra informeObra);
	public void delete(Long idInformeObra);
}