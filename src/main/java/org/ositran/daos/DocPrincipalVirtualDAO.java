package org.ositran.daos;

import com.btg.ositran.siged.domain.IotdtdDocPrincipal;
import java.util.List;

public interface DocPrincipalVirtualDAO {
    public List<IotdtdDocPrincipal> buscarPrincipalVirtualId(Integer idDocExterno);
    public IotdtdDocPrincipal registrarPrincipal(IotdtdDocPrincipal principal);
    public IotdtdDocPrincipal buscarPrincipaByDocExterno(Integer idDocExterno);
}
