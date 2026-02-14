package com.mrbysco.nosey.client.layer;

import com.mrbysco.nosey.Constants;
import com.mrbysco.nosey.client.ClientHandler;
import com.mrbysco.nosey.client.model.CreeperNoseModel;
import com.mrbysco.nosey.platform.Services;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.monster.creeper.CreeperModel;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.CreeperRenderState;
import net.minecraft.resources.Identifier;

public class CreeperNoseLayer<S extends CreeperRenderState> extends NoseLayer<S, CreeperModel> {
	private static final Identifier NOSE_LOCATION = Constants.modLoc("textures/entity/creeper/nose.png");
	private final CreeperNoseModel model;

	public CreeperNoseLayer(RenderLayerParent<S, CreeperModel> renderLayerParent, EntityModelSet modelSet) {
		super(renderLayerParent);
		this.model = new CreeperNoseModel(modelSet.bakeLayer(ClientHandler.CREEPER_NOSE));
	}

	@Override
	public EntityModel<? super S> getNoseModel() {
		return model;
	}

	@Override
	public Identifier noseTextureLocation(S renderState) {
		return NOSE_LOCATION;
	}

	@Override
	public boolean canRender() {
		return Services.PLATFORM.enableCreeperNose();
	}
}
