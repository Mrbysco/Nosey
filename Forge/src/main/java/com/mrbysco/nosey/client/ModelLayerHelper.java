package com.mrbysco.nosey.client;

import com.mrbysco.nosey.client.layer.CreeperNoseLayer;
import com.mrbysco.nosey.client.layer.GhastNoseLayer;
import com.mrbysco.nosey.client.model.CreeperNoseModel;
import com.mrbysco.nosey.client.model.GhastNoseModel;
import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.client.renderer.entity.GhastRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class ModelLayerHelper {

	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ClientHandler.GHAST_NOSE, GhastNoseModel::createBodyLayer);
		event.registerLayerDefinition(ClientHandler.CREEPER_NOSE, CreeperNoseModel::createBodyLayer);
	}

	public static void registerAdditionalLayers(EntityRenderersEvent.AddLayers event) {
		if (event.getRenderer(EntityType.GHAST) instanceof GhastRenderer ghastRenderer) {
			ghastRenderer.addLayer(new GhastNoseLayer(ghastRenderer, event.getEntityModels()));
		}
		if (event.getRenderer(EntityType.CREEPER) instanceof CreeperRenderer creeperRenderer) {
			creeperRenderer.addLayer(new CreeperNoseLayer(creeperRenderer, event.getEntityModels()));
		}
	}
}
