package com.mrbysco.nosey.client;

import com.mrbysco.nosey.client.model.GhastNoseModel;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class ModelLayerHelper {

	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ClientHandler.GHAST_NOSE, GhastNoseModel::createBodyLayer);
	}
}
