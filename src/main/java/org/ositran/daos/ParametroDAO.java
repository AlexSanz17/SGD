/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.daos;

import java.util.List;

import com.btg.ositran.siged.domain.Parametro;

/**
 *
 * @author Himizu
 */
public interface ParametroDAO {

	public List<Parametro> findAll() ;	
	public List<Parametro> findAllWithoutStor() ;	
        public Parametro findObjById(Integer iIdParametro);
	public List<Parametro> findByTipo(String tipo);
        public List<Parametro> findByTipoActivo(String tipo);
	public Parametro guardarObj(Parametro objParametro);
	public Parametro findByTipoUnico(String tipo);
	public Parametro findByTipoAndValue(String tipo, String value) ;
	
	public List<Parametro> getEstados() ;
	public List<Parametro> getProceso();
	public List<Parametro> getGrupoProceso(); 
	public List<Parametro> getTipoExpediente();
	public List<Parametro> getSalaAYQ();
	public List<Parametro> getResponsableAYQ();
	public List<Parametro> getAnalistaAYQ();
	public List<Parametro> getPrioridades();
}   
