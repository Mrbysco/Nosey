package com.mrbysco.nosey.client.layer;

import com.mrbysco.nosey.Constants;
import com.mrbysco.nosey.client.ClientHandler;
import com.mrbysco.nosey.client.model.BeeNoseModel;
import com.mrbysco.nosey.platform.Services;
import net.minecraft.client.model.BeeModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Bee;

public class BeeNoseLayer<T extends Bee> extends NoseLayer<T, BeeModel<T>> {
	private static final ResourceLocation NOSE_LOCATION = new ResourceLocation(Constants.MOD_ID, "textures/entity/bee/nose.png");
	private final BeeNoseModel<T> model;

	public BeeNoseLayer(RenderLayerParent<T, BeeModel<T>> renderLayerParent, EntityModelSet modelSet) {
		super(renderLayerParent);
		this.model = new BeeNoseModel<>(modelSet.bakeLayer(ClientHandler.BEE_NOSE));
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
		return Services.PLATFORM.enableBeeNose();
	}
}
