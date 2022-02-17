//package org.ositran.services;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.ositran.daos.DocumentoDAO;
//
//import com.btg.ositran.siged.domain.Documento;
//import com.opensymphony.xwork2.ActionProxy;
//import com.opensymphony.xwork2.ActionSupport;
//
//@RunWith(MockitoJUnitRunner.class)
//public class DocumentoTest {
//	@InjectMocks
//	DocumentoServiceImpl documentoService;
//	   
//	  @Mock
//	  DocumentoDAO documentoDAO;
//	  
//	  Documento documento;
//	   
//	  @Test
//	  public void saveTest() {
////		  documento = new Documento();
////			documento.setIdDocumento(1);
////			System.out.println("documento");
////			System.out.println(documento);
////			System.out.println(documentoService);
////			Documento resultado = documentoService.findByIdDocumento(1);
////			System.out.println("resultado");
////			System.out.println(resultado);
////	    Documento saved = documentoService.saveDocumento(documento);
////	    assertEquals(true, saved);
////	     
////	    verify(documentoDAO, times(1)).save("temp.txt");
//	  }
//	  
//	@Test
//	public void testExecuteValidationPasses() throws Exception {
////		Assert.assertEquals(documento, resultado);
//	   
////	    request.setParameter("personBean.firstName", "Bruce");
////	    request.setParameter("personBean.lastName", "Phillips");
////	    request.setParameter("personBean.email", "bphillips@ku.edu");
////	    request.setParameter("personBean.age", "19");
////
////	    ActionProxy actionProxy = getActionProxy("/register.action");
////	    Register action = (Register) actionProxy.getAction() ;
////
////	    assertNotNull("The action is null but should not be.", action);
////
////	    String result = actionProxy.execute();
////
////	    Assert.assertEquals("The execute method did not return " + ActionSupport.SUCCESS + " but should have.", ActionSupport.SUCCESS, result);
////	}
//	}
//}
