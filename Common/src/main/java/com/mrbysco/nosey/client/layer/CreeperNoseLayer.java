package com.mrbysco.nosey.client.layer;

import com.mrbysco.nosey.Constants;
import com.mrbysco.nosey.client.ClientHandler;
import com.mrbysco.nosey.client.model.CreeperNoseModel;
import com.mrbysco.nosey.platform.Services;
import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Creeper;

public class CreeperNoseLayer<T extends Creeper> extends NoseLayer<T, CreeperModel<T>> {
	private static final ResourceLocation NOSE_LOCATION = new ResourceLocation(Constants.MOD_ID, "textures/entity/creeper/nose.png");
	private final CreeperNoseModel<T> model;

	public CreeperNoseLayer(RenderLayerParent<T, CreeperModel<T>> renderLayerParent, EntityModelSet modelSet) {
		super(renderLayerParent);
		this.model = new CreeperNoseModel<>(modelSet.bakeLayer(ClientHandler.CREEPER_NOSE));
	}

	@Override
	public EntityModel<T> getNoseModel() {
		return model;
	}

	@Override
	public ResourceLocation noseTextureLocation() {
		return NOSE_LOCATION;
	}

	@Override
	public boolean canRender() {
		return Services.PLATFORM.enableCreeperNose();
	}
}
