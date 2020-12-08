package de.stl.saar.prog3.exceptions.schichten;

import de.stl.saar.prog3.exceptions.ExceptionWrapper;

public class Dialog {
	private static final int STUNDEN_PRO_TAG = 8;
	private static final int TAGE_PRO_WOCHE = 5;
	private static final int WOCHEN_PRO_PROJEKT = 25;
	private static final int MITARBEITER_PRO_PROJEKT = 10;
	private static final int NULL = 0;
	
	public static void main(String[] args) {
		try {
			Service service = new Service();
			service.gibMirObjektAusDatenbank();
		} catch(ExceptionWrapper ex) {
			try {
				ex.rethrow();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			double stundensatz = 0.0;
			
			
			double projektKosten = STUNDEN_PRO_TAG * 
					TAGE_PRO_WOCHE * 
					WOCHEN_PRO_PROJEKT * 
					MITARBEITER_PRO_PROJEKT * stundensatz;
			
			int bestand = 0;
			
			if (bestand < NULL) {
				
			}
		}   
	}
}
