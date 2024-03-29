package com.mrbysco.nosey.client.layer;

import com.mrbysco.nosey.Constants;
import com.mrbysco.nosey.client.ClientHandler;
import com.mrbysco.nosey.client.model.GhastNoseModel;
import com.mrbysco.nosey.platform.Services;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.GhastModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Ghast;

public class GhastNoseLayer<T extends Ghast> extends NoseLayer<T, GhastModel<T>> {
	private static final ResourceLocation NOSE_LOCATION = new ResourceLocation(Constants.MOD_ID, "textures/entity/ghast/nose.png");
	private final GhastNoseModel<T> model;

	public GhastNoseLayer(RenderLayerParent<T, GhastModel<T>> renderLayerParent, EntityModelSet modelSet) {
		super(renderLayerParent);
		this.model = new GhastNoseModel<>(modelSet.bakeLayer(ClientHandler.GHAST_NOSE));
	}

	@Override
	public EntityModel<T> getNoseModel() {
		return model;
	}

	@Override
	public ResourceLocation noseTextureLocation(T entityIn) {
		return NOSE_LOCATION;
	}

	@Override
	public boolean canRender() {
		return Services.PLATFORM.enableGhastNose();
	}
}
