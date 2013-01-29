package org.bimserver.ifc.step.serializer;

/******************************************************************************
 * Copyright (C) 2009-2013  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.models.store.ObjectDefinition;
import org.bimserver.models.store.ParameterDefinition;
import org.bimserver.models.store.PrimitiveDefinition;
import org.bimserver.models.store.PrimitiveEnum;
import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StringType;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.serializers.PluginConfiguration;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerPlugin;

public class IfcStepSerializerPlugin implements SerializerPlugin {

	private boolean initialized = false;

	@Override
	public Serializer createSerializer(PluginConfiguration pluginConfiguration) {
		return new IfcStepSerializer(pluginConfiguration);
	}

	@Override
	public String getDescription() {
		return "IfcStepSerializer";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public boolean needsGeometry() {
		return false;
	}
	
	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		pluginManager.requireSchemaDefinition();
		initialized = true;
	}

	@Override
	public String getDefaultName() {
		return "Ifc2x3";
	}

	@Override
	public String getDefaultContentType() {
		return "application/ifc";
	}

	@Override
	public String getDefaultExtension() {
		return "ifc";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public ObjectDefinition getSettingsDefinition() {
		ObjectDefinition objectDefinition = StoreFactory.eINSTANCE.createObjectDefinition();
		ParameterDefinition organizationParameter = StoreFactory.eINSTANCE.createParameterDefinition();
		organizationParameter.setName("organization");
		StringType defaultValue = StoreFactory.eINSTANCE.createStringType();
		defaultValue.setValue("BIMserver.org");
		organizationParameter.setDefaultValue(defaultValue);
		PrimitiveDefinition stringDefinition = StoreFactory.eINSTANCE.createPrimitiveDefinition();
		stringDefinition.setType(PrimitiveEnum.STRING);
		organizationParameter.setType(stringDefinition);
		objectDefinition.getParameters().add(organizationParameter);
		return objectDefinition;
	}
}