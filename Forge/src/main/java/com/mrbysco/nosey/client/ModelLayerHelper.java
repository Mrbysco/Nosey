package com.mrbysco.nosey.client;

import com.mrbysco.nosey.client.layer.GhastNoseLayer;
import com.mrbysco.nosey.client.model.GhastNoseModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.GhastRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class ModelLayerHelper {

	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ClientHandler.GHAST_NOSE, GhastNoseModel::createBodyLayer);
	}

	public static void registerAdditionalLayers(EntityRenderersEvent.AddLayers event) {
		EntityRenderer<?> renderer = event.getRenderer(EntityType.GHAST);
		if (renderer instanceof GhastRenderer ghastRenderer) {
			ghastRenderer.addLayer(new GhastNoseLayer(ghastRenderer, event.getEntityModels()));
		}
	}
}
