package com.mrbysco.nosey.client;

import com.mrbysco.nosey.client.model.CreeperNoseModel;
import com.mrbysco.nosey.client.model.GhastNoseModel;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;

public class ModelLayerHelper {

	public static void registerLayerDefinitions() {
		EntityModelLayerRegistry.registerModelLayer(ClientHandler.GHAST_NOSE, GhastNoseModel::createBodyLayer);
		EntityModelLayerRegistry.registerModelLayer(ClientHandler.CREEPER_NOSE, CreeperNoseModel::createBodyLayer);
	}
}
