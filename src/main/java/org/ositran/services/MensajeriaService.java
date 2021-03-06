package org.ositran.services;

import java.util.List;
import org.ositran.dojo.grid.Item;

import com.btg.ositran.siged.domain.Mensajeria;
import com.btg.ositran.siged.domain.Usuario;

public interface MensajeriaService {

   public List<Mensajeria> ViewEstado(String Esta);

   public Mensajeria ViewMensaje(int Id);

   public Mensajeria guardarObj(Usuario objUsuario, Integer iIdDocumento, char documentoNoPrincipal, Integer tipoEnvio, Item cliente, Integer idMensajeriaPrincipal);

   public List<Mensajeria> FindusuarioMensajeria(String estado);

   public List<Mensajeria> findidusuario(int Idusuario);

   public void savemensajeria(String Striddoc, String Strfecha, String Stridusu, String Striasunto);

   public List<Mensajeria> filtrarCriterios(Usuario objUsuario, String fechaDesde, String fechaHasta, String horaDesde, String horaHasta);

   public void guardarTrazaEnvioMensajeria(Integer[] idsDocumentos, List<Item> listaClientes, Usuario remitente, String nombrePC);

   public void guardarTrazaRecepcionCargo(Integer idDocumento, Integer idCliente, String nombrePC);
}
