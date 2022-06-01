package org.ositran.services;

import java.util.List;

import com.btg.ositran.siged.domain.IotdtdAnexo;

public interface DocAnexoVirtualService {
     public IotdtdAnexo registrarAnexo(IotdtdAnexo anexo);
     public List<IotdtdAnexo> getAll();
}
