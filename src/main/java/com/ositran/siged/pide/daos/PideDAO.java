package com.ositran.siged.pide.daos;

import com.btg.ositran.pide.domain.PideIotdtcRecepcion;
import com.btg.ositran.pide.domain.PideIotdtdAnexo;
import com.btg.ositran.pide.domain.PideIotdtdDocPrincipal;
import com.btg.ositran.pide.domain.PideIotdtmDocExterno;

import java.util.List;

/**
 *
 * @author vcupe
 */

public interface PideDAO {
	
     public List<PideIotdtcRecepcion> findRecepcionByEstado(String estado); 
     
     public List<PideIotdtmDocExterno> findDocExternosByIdRecepcion(Integer sidrecext);
     
     public List<PideIotdtdDocPrincipal> findDocPrincipalByIdExterno(Integer siddocext);
     
     public List<PideIotdtdAnexo> findAnexoByIdExterno(Integer siddocext);
}
