package org.bimserver.plugins;

/******************************************************************************
 * Copyright (C) 2009-2017  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterfaceException;

public class ObjectAlreadyStoredException extends IfcModelInterfaceException {
	private static final long serialVersionUID = -6473300261709590353L;
	private IdEObject newToStore;
	private IdEObject alreadyStored;

	public ObjectAlreadyStoredException(String message, IdEObject alreadyStored, IdEObject newToStore) {
		super(message);
		this.alreadyStored = alreadyStored;
		this.newToStore = newToStore;
	}
	
	public IdEObject getNewToStore() {
		return newToStore;
	}
	
	public IdEObject getAlreadyStored() {
		return alreadyStored;
	}
}