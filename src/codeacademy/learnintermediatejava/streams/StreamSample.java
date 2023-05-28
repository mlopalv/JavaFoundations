package codeacademy.learnintermediatejava.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamSample {
	public int a [];
	static int [] ab;
	
	public void setUpFacturasList() {
		
		Factura f= new Factura("ordenador",1000);
		Factura f2= new Factura("movil",300);
		Factura f3= new Factura("impresora",200);
		Factura f4= new Factura("imac",1500);
		List<Factura> lista= new ArrayList<Factura>();
		lista.add(f);
		lista.add(f2);
		lista.add(f3);
		lista.add(f4);
		
		Factura facturaFiltro =
		lista.stream()
		 .filter(factura -> factura.getImporte() > 300)
		 .findFirst()
		 .get();
		
		System.out.println("Primera factura con valor mayor a 300: " + facturaFiltro.getImporte());
		
		Stream<Factura> stream = lista.stream()
		 .filter(factura -> factura.getImporte() > 300);
		
		//Print all Facturas with the applied filter
		stream.forEach(factura -> System.out.println("Este es el concepto: " + factura.getConcepto() +
				 " y el monto de la factura: $ " + factura.getImporte()));		
	
	}
	
	/**
	 * Shows how to configure a Stream based on an array
	 * 
	 * 
	 */
	public void setUpFacturasArray() {
		
		Factura f  = new Factura("ordenador",1000);
		Factura f2 = new Factura("movil",300);
		Factura f3 = new Factura("impresora",200);
		Factura f4 = new Factura("imac",1500);
		
		Factura[] facturasArray = new Factura[4];
		
		facturasArray[0] = f;
		facturasArray[1] = f2;
		facturasArray[2] = f3;
		facturasArray[3] = f4;
				
		
		Factura facturaFiltro =
		 Stream.of(facturasArray)
		 .filter(factura -> factura.getImporte() > 300)
		 .findFirst()
		 .get();
		
		System.out.println("Primera factura con valor mayor a 300: " + facturaFiltro.getImporte());
		
		Stream<Factura> stream = 
				Stream.of(facturasArray)
				.filter(factura -> factura.getImporte() > 300);
		
		//Print all Facturas with the applied filter
		stream.forEach(factura -> System.out.println("Este es el concepto: " + factura.getConcepto() +
				 " y el monto de la factura: $ " + factura.getImporte()));		
		
		 
		        int x;
		        String[] argh = new String[] {"1","2","3"};
		        x = argh.length;
		        for (int y = 1; y <= x; y++) 
		        {
		            System.out.print(" " + argh[y]);
		        }
		        
		        
		    
	
	}
	
	


	public static void main(String[] args) {
		StreamSample streamSample = new StreamSample();
		//Stream configured based on a List
		streamSample.setUpFacturasList();
		//Stream configured based on an Array
		streamSample.setUpFacturasArray();
		

	}	
	
	
	
}
