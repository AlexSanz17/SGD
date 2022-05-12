package org.ositran.daos;

import com.btg.ositran.siged.domain.FirmaArchivo;
import com.btg.ositran.siged.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xalan.lib.sql.ObjectArray;
import org.ositran.actions.DojoAction;
import org.springframework.transaction.annotation.Transactional;

public class FirmaArchivoDAOImpl implements FirmaArchivoDAO{
     private EntityManager em;
     
     @PersistenceContext(unitName="sigedPU")
     public void setEm(EntityManager em){
    	 this.em=em;
     }
     
     public void saveFirmaArchivo(FirmaArchivo firmaArchivo){
		if(firmaArchivo.getIdFirmaArchivo()==null){
            em.persist(firmaArchivo);
            em.flush();
            em.refresh(firmaArchivo);
        }else{
		    em.merge(firmaArchivo);
            em.flush();
		}
     }
     
     public List<FirmaArchivo> findFirmas(Integer idDocumento , Usuario usuario){
         String sql = "select a from FirmaArchivo a, Archivo aa where aa.documento.idDocumento = :idDocumento " +
    		 " and aa.idArchivo = a.idArchivo and a.estado = 'F' and a.idUsuario= :idUsuario and a.unidadPropietario= :unidadPropietario and a.cargoPropietario= :cargoPropietario order by a.fechaCreacion desc ";
         Query q = em.createQuery(sql);
         q.setParameter("idDocumento", idDocumento).setParameter("idUsuario", usuario.getIdUsuarioPerfil()).setParameter("unidadPropietario", usuario.getIdUnidadPerfil()).
         setParameter("cargoPropietario", usuario.getIdFuncionPerfil());
         
         return q.getResultList();
     }
     
      public List<Usuario> findUltimaFirma(Integer idDocumento , String estado){
            List<Usuario> lista = new ArrayList<Usuario>();
            String  sql = "SELECT F.IDUSUARIO, F.UNIDADPROPIETARIO, F.CARGOPROPIETARIO, D.TIPODOCUMENTO " +
              "  FROM FIRMAARCHIVO F, ARCHIVO A, DOCUMENTO D " +
              "  WHERE " +
              "  A.DOCUMENTO = :idDocumento AND " +
              "  A.PRINCIPAL = 'S' AND " +
              "  A.ESTADO = 'A' AND " +
              "  A.IDARCHIVO = F.IDARCHIVO AND " + 
              "  A.DOCUMENTO = D.IDDOCUMENTO AND " + 
              "  F.ESTADO = :estado AND " +
              "  F.FECHACREACION = (SELECT MAX(X.FECHACREACION) FROM FIRMAARCHIVO X WHERE X.IDARCHIVO = F.IDARCHIVO AND X.ESTADO = :estado) ";
    
            Query q = em.createNativeQuery(sql.toString());
            q.setParameter("idDocumento", idDocumento).setParameter("estado", estado); 
            List<Object> res = (List<Object>) q.getResultList();
            Usuario f  = null;

            for (Object obj : res) {
                f = new Usuario();
                Object[] objectArray = (Object[]) obj;
                f.setIdUsuarioPerfil(Integer.parseInt(objectArray[0].toString()));
                f.setIdUnidadPerfil(Integer.parseInt(objectArray[1].toString()));
                f.setIdFuncionPerfil(Integer.parseInt(objectArray[2].toString()));
                f.setTipoDocumento(objectArray[3].toString());
                lista.add(f);
          }
            
          return lista;  
      }
     
     public List<FirmaArchivo> findFirmadoUsuario(Integer idUsuario){
          String sql = "select a from FirmaArchivo a where a.idUsuario=" + idUsuario;
          Query q = em.createQuery(sql);
          return q.getResultList();
      }
     
     public List<FirmaArchivo> findFirmado(Integer idArchivo){
         String sql = "select a from FirmaArchivo a, Archivo aa where aa.idArchivo = :idArchivo and aa.estado = 'A'" +
                      " and aa.idArchivo = a.idArchivo and a.estado = 'F' ";
         Query q = em.createQuery(sql);
         q.setParameter("idArchivo", idArchivo);
         return q.getResultList();
     }

	@Override
     public List<FirmaArchivo> findFirmaArchivo(Integer idArchivo, Integer idUsuario, String estado){
         String sql = "select a from FirmaArchivo a, Archivo aa where aa.idArchivo = :idArchivo and aa.estado = 'A'" +
          	" and aa.idArchivo = a.idArchivo and a.idUsuario= :idUsuario and a.estado = :estado";
         Query q = em.createQuery(sql);
         q.setParameter("idArchivo", idArchivo).setParameter("idUsuario", idUsuario).setParameter("estado", estado);;

         return q.getResultList();
     }
     
     @Override
     public void deleteFirmaArchivo(Integer idFirmaArchivo){
         String sql = "delete from FirmaArchivo where idFirmaArchivo = :idFirmaArchivo";
         Query q = em.createNativeQuery(sql);
         q.setParameter("idFirmaArchivo", idFirmaArchivo);
         q.executeUpdate();
     }
}