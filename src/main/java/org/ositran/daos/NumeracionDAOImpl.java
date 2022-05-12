package org.ositran.daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import org.ositran.utils.JDBCCallableStatement;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import com.btg.ositran.siged.domain.Numeracion;
import com.btg.ositran.siged.domain.Unidad;
import java.math.BigDecimal;

@Repository
public class NumeracionDAOImpl implements NumeracionDAO {

   private EntityManager em;
   private static Logger log=Logger.getLogger(NumeracionDAOImpl.class);


   public Numeracion findByIdNumeracion(Integer idUnidad, Integer IdTipoDocumento) {
	   try{
      return (Numeracion) em.createNamedQuery("Numeracion.findByIdnumeracion")
                            .setParameter("idunidad", idUnidad)
                            .setParameter("idtipodocumento", IdTipoDocumento)
                            .getSingleResult();
	   }catch(Exception e){
		   return null;
	   }
   }

   public Numeracion findByIdNumeracionbyUnidad(Unidad idUnidad, Integer IdTipoDocumento) {

	   Unidad unid = idUnidad ;
	   Numeracion num =null ;
	   Integer idtipodoc = IdTipoDocumento ;

	   log.info("unid=============" + unid);
		while(unid != null&&num==null){
			Integer idunidad=unid.getIdunidad();
			try{
				num=(Numeracion) em.createNamedQuery("Numeracion.findByIdnumeracion").setParameter("idunidad",idunidad).setParameter("idtipodocumento",idtipodoc).getSingleResult();
				log.warn("Result for numeration idtipodoc:" + idtipodoc + " idunidad:" + idunidad);
			}catch(Exception ex){
				log.warn("no result for numeration idtipodoc:" + idtipodoc + " idunidad:" + idunidad);
				unid=unid.getDependencia();
				num=null;
//				log.info("switching to unid :" + (unid != null ? unid.getNombre() : "null"));
			}

		}
	    return  num;

	   }
   public Numeracion findByIdNumeracionbyUnidad_1(Unidad idUnidad, Integer IdTipoDocumento) {

	   Unidad unid = idUnidad ;
	   Object num =null ;
	   Integer idtipodoc = IdTipoDocumento ;
	   Integer idunidad=unid.getIdunidad();
	   List<Numeracion> lisNum = null ;

	   try{
			log.warn("Result for numeration idtipodoc:" + idtipodoc + " idunidad:" + idunidad);
			num =  em.createNamedQuery("Numeracion.findByIdnumeracion").setParameter("idunidad",idunidad).setParameter("idtipodocumento",idtipodoc).getSingleResult();
			
			log.info("------------num---------"+num);
			
			
		}catch(Exception ex){
			ex.printStackTrace();
			num = null;
			log.info("------------num---------"+num);
			
//			log.info("switching to unid :" + (unid != null ? unid.getNombre() : "null"));
		}
	   return (Numeracion) num;
	   
	 

	   }


   public Numeracion actualizarObj(Numeracion objNumeracion) {
      em.merge(objNumeracion);
      em.flush();

      return objNumeracion;
   }


   public String guardarObjProcedure(Numeracion objNumeracion, int area_remitente, int idUsuario) throws Exception{
	   JDBCCallableStatement jdbc = new JDBCCallableStatement();
	   String getDBUSERByUserIdSql = "{call dbo.sp_generar_nro_documento(?,?,?,?,?)}";
           Connection dbConnection = null;
	   CallableStatement callableStatement = null;
           int anioFiscal=1;
           
       String numeracion = "";    
           
       try{

           if(objNumeracion.getAnioFiscal() != null)
           {
               anioFiscal = objNumeracion.getAnioFiscal();
           }
           
    	   dbConnection = jdbc.getDBConnection();
    	   callableStatement = dbConnection.prepareCall(getDBUSERByUserIdSql);
           
           callableStatement.setFloat(1, objNumeracion.getTipodocumento().getIdtipodocumento().intValue());
           callableStatement.setFloat(2, area_remitente);
           callableStatement.setFloat(3, idUsuario);
           callableStatement.setFloat(4, anioFiscal);
           callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
		
           callableStatement.executeUpdate();
           
           numeracion = callableStatement.getString(5);

           
       } catch (SQLException e) {
           e.printStackTrace();
    	   throw e;
       } catch (Exception e) {
 	   e.printStackTrace();
           throw e;
       }finally {
		   try{
			if (callableStatement != null)
			   callableStatement.close();
			}catch(Exception e){
			   e.printStackTrace();
			}

			try{
			   if (dbConnection != null)
			    dbConnection.close();
			}catch(Exception e){
			   e.printStackTrace();
			}
		}

       return numeracion;
   }
   

   public Numeracion guardarObj(Numeracion objNumeracion) {
	      em.persist(objNumeracion);
	      //em.flush();
	      //em.refresh(objNumeracion);

      return objNumeracion;
   }

   @SuppressWarnings("unchecked")
   public List<Numeracion> findAll() {
      return em.createNamedQuery("Numeracion.findAll").getResultList();
   }

   @PersistenceContext(unitName = "sigedPU")
   public void setEm(EntityManager em) {
      this.em = em;
   }

   public List<Numeracion> findAllUnidadAndTipoDoc(Integer idunidad,Integer idtipodoc){
	@SuppressWarnings("unchecked")
	List<Numeracion> listaNum =  em.createQuery("SELECT n FROM Numeracion n WHERE n.unidad.idunidad = :idunidad and n.tipodocumento.idtipodocumento = :idtipodocumento")
	       		.setParameter("idunidad", idunidad)
	       		.setParameter("idtipodocumento", idtipodoc)
	       		.getResultList();
	   return listaNum;
   }
   
   public Numeracion findByIdNumeracionbyUnidadbyAnioFiscal(Unidad idUnidad, Integer IdTipoDocumento, Integer AnioFiscal) {
       Unidad unid = idUnidad;
       Numeracion num = null;
       Integer idtipodoc = IdTipoDocumento;
       
       while(unid != null&&num==null){
           Integer idunidad=unid.getIdunidad();
           try{
               num=(Numeracion) em.createQuery("SELECT n FROM Numeracion n WHERE n.unidad.idunidad = :idunidad and n.tipodocumento.idtipodocumento = :idtipodocumento and n.anioFiscal = :aniofiscal")
                       .setParameter("idunidad", idunidad).setParameter("idtipodocumento", idtipodoc).setParameter("aniofiscal", AnioFiscal).getSingleResult();
           }catch(Exception ex){
               unid=unid.getDependencia();
           }
       }
       
       return num;
   }

   public List<Numeracion> findAllUnidadAndTipoDocAndAnioFiscal(Integer idunidad, Integer idtipodoc, Integer aniofiscal){
       @SuppressWarnings("unchecked")
        List<Numeracion> listaNum = em.createQuery("SELECT n FROM Numeracion n WHERE n.unidad.idunidad = :idunidad and n.tipodocumento.idtipodocumento = :idtipodocumento and n.anioFiscal = :aniofiscal")
               .setParameter("idunidad", idunidad)
               .setParameter("idtipodocumento", idtipodoc)
               .setParameter("aniofiscal", aniofiscal)
               .getResultList();
       return listaNum;
   }
}