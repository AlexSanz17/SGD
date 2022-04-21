package org.ositran.common.util;

import org.ositran.common.service.GenericService;
import org.ositran.services.AuditoriaService;
import org.ositran.services.ClienteService;
import org.ositran.services.ConcesionarioService;
import org.ositran.services.DepartamentoService;
import org.ositran.services.DocumentoService;
import org.ositran.services.MensajeriaService;
import org.ositran.services.MotivoService;
import org.ositran.services.NumeracionService;
import org.ositran.services.ParametroService;
import org.ositran.services.ProcesoService;
import org.ositran.services.SedeService;
import org.ositran.services.SupervisorService;
import org.ositran.services.TipodocumentoService;
import org.ositran.services.TipoprocesoService;
import org.ositran.services.TrazabilidaddocumentoService;
import org.ositran.services.UnidadService;
import org.ositran.services.UsuarioService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ServiceFactory implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    
	public ServiceFactory(ApplicationContext applicationContext) {
		setApplicationContext(applicationContext);
	}

	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.applicationContext = context;
	}

    public Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
    
    public GenericService getGenericService(){
    	return (GenericService)getBean("GenericService");
    }
    
    public ProcesoService getProcesoService(){
    	return (ProcesoService)getBean("procesoService");
    }
    
    public UsuarioService getUsuarioService(){
    	return (UsuarioService)getBean("usuarioService");
    }
    
    public DocumentoService getDocumentoService(){
    	return (DocumentoService)getBean("documentoService");
    }
    
    public TipodocumentoService getTipoDocumentoService(){
    	return (TipodocumentoService)getBean("tipodocumentoService");
    }
    
    public ConcesionarioService getConcesionarioService(){
    	return (ConcesionarioService)getBean("concesionarioService");
    }
    
    public ClienteService getClienteService(){
    	return (ClienteService)getBean("clienteService");
    }
    
    public DepartamentoService getDepartamentoService(){
    	return (DepartamentoService)getBean("departamentoService");
    }
    public MotivoService getMotivoService(){
    	return (MotivoService)getBean("motivoService");
    }
    public AuditoriaService getAuditoriaService(){
    	return (AuditoriaService)getBean("auditoriaService");
    }
    public MensajeriaService getMensajeriaService() {
    	return (MensajeriaService)getBean("mensajeriaService");
    }
    public NumeracionService getNumeracionService() {
    	return (NumeracionService)getBean("numeracionService");
    }
    public ParametroService getParametroService(){
    	return (ParametroService)getBean("parametroService");
    }
    public SupervisorService getSupervisorService(){
    	return (SupervisorService)getBean("supervisorService");
    }
    public SedeService getSedeService(){
    	return (SedeService)getBean("sedeService");
    }
    public UnidadService getUnidadService(){ 
    	return (UnidadService)getBean("unidadService");
    }
    
    public TipoprocesoService getTipoprocesoService(){
    	return (TipoprocesoService)getBean("tipoprocesoService");
    } 
    
    public TrazabilidaddocumentoService getTrazalidadDocumentoService(){     
    	return (TrazabilidaddocumentoService)getBean("trazabilidaddocumentoService");
    }
}