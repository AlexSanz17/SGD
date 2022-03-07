package org.ositran.daos;

import com.btg.ositran.siged.domain.IotdtdAnexo;
import java.util.List;

public interface DocAnexoVirtualDAO {
     public List<IotdtdAnexo> buscarAnexoVirtualId(Integer idDocExterno);
     public IotdtdAnexo registrarAnexo(IotdtdAnexo anexo);
}
