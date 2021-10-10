package org.ositran.utils;

import java.util.ArrayList;
import java.util.List;


public class utilReporte {


	private String expediente;
	private List<usuariosReporte> usuarios;
	
	public utilReporte (String expediente){
		this.expediente = expediente;
		usuarios = new ArrayList<usuariosReporte>();
	}
	
	public String getExpediente() {
		return expediente;
	}
	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}
	public List<usuariosReporte> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<usuariosReporte> usuarios) {
		this.usuarios = usuarios;
	}
	public void addUsuarios(String usuario, long tiempo){
		boolean existe = false;
		for (usuariosReporte usuarioActual : usuarios){
			if(usuarioActual.getUsuario().equals(usuario)){
				usuarioActual.incTiempo(tiempo);
				usuarioActual.incVeces();
				existe = true;
			} 
		}
		if(!existe){
			usuarios.add(new usuariosReporte (usuario, tiempo));
		}
	}
	//PNSU
	public void incTiempoUsuario(String usuario, long tiempo){
		for (usuariosReporte actual : usuarios){
			if(actual.getUsuario().equals(usuario)){
				actual.incTiempo(tiempo);
				actual.incVeces();
			}
		}
	}
	
	public String getTiempoTotal (){
		Long total = 0l;
		for (usuariosReporte actual : usuarios){
			total+=actual.getTiempo();
		}
		if(total<0){
			return "-";
		}else{
			String tmp="";
			int d, h, m;
			Long milisegundos = total;
			h=(int)(milisegundos/3600000);
			m = (int)((milisegundos%3600000)/60000);
			if(h>24){
				d = h/24;
				h=h%24;
				tmp = Integer.toString(d)+"d ";
			}
			tmp += Integer.toString(h)+":";
			if(m==0){
				tmp+="00";
			}else{
				if(m<10){
					tmp+="0"+Integer.toString(m);
				}else{
					tmp+=Integer.toString(m);
				}
			}
			if(tmp.equals("0:00")){
				tmp = Long.toString((milisegundos%60000)/1000)+"s";
			}
			return tmp;
		}
	}
}
