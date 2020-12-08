package de.stl.saar.prog3.exceptions.schichten;

public class Service {
	public Object gibMirObjektAusDatenbank() {
		return (new Dao()).nimmObjektAusDatenbank();
	}
}
