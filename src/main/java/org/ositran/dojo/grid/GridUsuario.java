/*LICENCIA DE USO DEL SGD .TXT*/package org.ositran.dojo.grid;

public class GridUsuario{
	
	private int idGridXGridColumna;
	
	private String field;
	
	private String width;
	
	private int hidden;
	
	private int position;
	
	private char ordenado;
	

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public int getHidden() {
		return hidden;
	}

	public void setHidden(int hidden) {
		this.hidden = hidden;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getIdGridXGridColumna(){
		return idGridXGridColumna;
	}

	public void setIdGridXGridColumna(int idGridXGridColumna){
		this.idGridXGridColumna=idGridXGridColumna;
	}

	public char getOrdenado(){
		return ordenado;
	}

	public void setOrdenado(char ordenado){
		this.ordenado=ordenado;
	}

}
