package codeacademy.learnintermediatejava.streams;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Factura {
	
	private String concepto;
	private double importe;
	
	
	public Factura(String concepto, double importe) {
		this.concepto = concepto;
		this.importe = importe;
		
			
	}
	
	
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	

}
