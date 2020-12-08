package de.stl.saar.prog3.exceptions.schichten;

import de.stl.saar.prog3.exceptions.ExceptionWrapper;

public class Dao {
	public Object nimmObjektAusDatenbank() {
		Object objektAusDatenbank = null;
		
		if (objektAusDatenbank == null) {
			throw new ExceptionWrapper(new DaoException());
		}
		
		return objektAusDatenbank;
	}
}
