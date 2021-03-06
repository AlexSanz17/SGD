package org.ositran.webservice.servicios;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ositran.daos.ExpedienteDAO;
import org.ositran.daos.UsuarioDAO;
import org.ositran.services.DocumentoService;

import com.btg.ositran.siged.domain.Documento;
import com.btg.ositran.siged.domain.Expediente;
import com.btg.ositran.siged.domain.Usuario;

public class ServicioDocumento{
	
	private static Log log=LogFactory.getLog(ServicioDocumento.class);

	private ExpedienteDAO expedienteDao;
	private UsuarioDAO usuarioDao;

	private DocumentoService documentoService;
	
	/*
	public String derivarDocumento(int idExpediente,String remitente,String destinatario, String nombrePC){
		int slash=remitente.indexOf("\\");
		if(slash >= 0){
			remitente=remitente.substring(slash + 1);
		}
		slash=destinatario.indexOf("\\");
		if(slash >= 0){
			destinatario=destinatario.substring(slash + 1);
		}
		Usuario elRemitente=usuarioDao.findByUsuario(remitente.toUpperCase());
		if(elRemitente != null){
			Usuario elDestinatario=usuarioDao.findByUsuario(destinatario.toUpperCase());
			if(elDestinatario != null){
				Expediente expediente=expedienteDao.findByIdExpediente(idExpediente);
				if(expediente!=null){
					Documento documento=expediente.getDocumentoPrincipal();
					if(documento!=null){
						
						Documento respuesta=documentoService.derivarDocumento(documento,elRemitente,elDestinatario, nombrePC);						
						
						if(respuesta!=null){
							log.info("Expediente derivado satisfactoriamente.");
							return "Expediente derivado satisfactoriamente.";
						}
						log.error("No se pudo derivar el expediente.");
						return "No se pudo derivar el expediente.";
					}
					log.error("El expediente especificado no tiene un documento principal");
					return "El expediente especificado no tiene un documento principal";
				}
				log.error("El expediente especificado no existe dentro de Siged");
				return "El expediente especificado no existe dentro de Siged";
			}
			log.error("El destinatario [" + destinatario + "] no pudo ser hallado en Siged.");
			return "El destinatario [" + destinatario + "] no pudo ser hallado en Siged.";
		}
		log.error("El remitente [" + remitente + "] no pudo ser hallado en Siged.");
		return "El remitente [" + remitente + "] no pudo ser hallado en Siged.";
	}
	*/
	/*
	//metodo agregado
	public String rechazarDocumentoOpcional(int idExpediente,String remitente,String destinatario, String nombrePC){
		int slash=remitente.indexOf("\\");
		if(slash >= 0){
			remitente=remitente.substring(slash + 1);
		}
		slash=destinatario.indexOf("\\");
		if(slash >= 0){
			destinatario=destinatario.substring(slash + 1);
		}
		Usuario elRemitente=usuarioDao.findByUsuario(remitente.toUpperCase());
		if(elRemitente != null){
			Usuario elDestinatario=usuarioDao.findByUsuario(destinatario.toUpperCase());
			if(elDestinatario != null){
				Expediente expediente=expedienteDao.findByIdExpediente(idExpediente);
				if(expediente!=null){
					Documento documento=expediente.getDocumentoPrincipal();
					if(documento!=null){
						
						Documento respuesta=documentoService.rechazarDocumentoOpcional(documento,elRemitente,elDestinatario, nombrePC);
						
							
						if(respuesta!=null){
							log.info("Expediente derivado satisfactoriamente.");
							return "OK";
						}
						log.error("No se pudo derivar el expediente.");
						return "No se pudo derivar el expediente.";
					}
					log.error("El expediente especificado no tiene un documento principal");
					return "El expediente especificado no tiene un documento principal";
				}
				log.error("El expediente especificado no existe dentro de Siged");
				return "El expediente especificado no existe dentro de Siged";
			}
			log.error("El destinatario [" + destinatario + "] no pudo ser hallado en Siged.");
			return "El destinatario [" + destinatario + "] no pudo ser hallado en Siged.";
		}
		log.error("El remitente [" + remitente + "] no pudo ser hallado en Siged.");
		return "El remitente [" + remitente + "] no pudo ser hallado en Siged.";
	}
	*/
	//metodo agregado
        /*
	public String derivarDocumentoRol(int idExpediente,String remitente,String rolDestinatario, String nombrePC){
		int slash=remitente.indexOf("\\");
		if(slash >= 0){
			remitente=remitente.substring(slash + 1);
		}
	
		/*slash=rolDestinatario.indexOf("\\");
		if(slash >= 0){
			rolDestinatario=rolDestinatario.substring(slash + 1);
		}*/
		
		/*
		Usuario elRemitente=usuarioDao.findByUsuario(remitente.toUpperCase());
		if(elRemitente != null){
			
			//Usuario elDestinatario=usuarioDao.findByUsuario(rolDestinatario.toUpperCase());
			Usuario elDestinatario = usuarioDao.findFirstByRol(rolDestinatario);
			if(elDestinatario != null){
				Expediente expediente=expedienteDao.findByIdExpediente(idExpediente);
				if(expediente!=null){
					Documento documento=expediente.getDocumentoPrincipal();
					if(documento!=null){
						Documento respuesta=documentoService.derivarDocumento(documento,elRemitente,elDestinatario, nombrePC);
						if(respuesta!=null){
							log.info("Expediente derivado satisfactoriamente.");
							//return elDestinatario.getUsuario();
							return "OK";
						}
						log.error("No se pudo derivar el expediente.");
						return "No se pudo derivar el expediente.";
						//return "fallo";
					}
					log.error("El expediente especificado no tiene un documento principal");
					return "El expediente especificado no tiene un documento principal";
					//return "fallo";
				}
				log.error("El expediente especificado no existe dentro de Siged");
				return "El expediente especificado no existe dentro de Siged";
				//return "fallo";
			}
			log.error("El destinatario [" + rolDestinatario + "] no pudo ser hallado en Siged.");
			return "El destinatario [" + rolDestinatario + "] no pudo ser hallado en Siged.";
			//return "fallo";
		}
		log.error("El remitente [" + remitente + "] no pudo ser hallado en Siged.");
		return "El remitente [" + remitente + "] no pudo ser hallado en Siged.";
		//return "fallo";
	}
	*/
	
	
	public String rechazarDocumento(int idExpediente, String nombrePC){
		Expediente expediente=expedienteDao.findByIdExpediente(idExpediente);
		if(expediente!=null){
			Documento documento=expediente.getDocumentoPrincipal();
			if(documento!=null){
				//documentoService.rechazarDocumento(documento, nombrePC);
				return "Todo salio bien.";
			}
			return "El expediente especificado no tiene un documento principal";
		}
		return "El expediente especificado no existe dentro de Siged";
	}

	public void setExpedienteDao(ExpedienteDAO expedienteDao){
		this.expedienteDao=expedienteDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao){
		this.usuarioDao=usuarioDao;
	}

	public void setDocumentoService(DocumentoService documentoService){
		this.documentoService=documentoService;
	}

}
