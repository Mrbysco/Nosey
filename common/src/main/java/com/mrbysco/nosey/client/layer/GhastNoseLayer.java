package com.mrbysco.nosey.client.layer;

import com.mrbysco.nosey.Constants;
import com.mrbysco.nosey.client.ClientHandler;
import com.mrbysco.nosey.client.model.GhastNoseModel;
import com.mrbysco.nosey.config.NoseyConfig;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.monster.ghast.GhastModel;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.GhastRenderState;
import net.minecraft.resources.Identifier;

public class GhastNoseLayer<S extends GhastRenderState> extends NoseLayer<S, GhastModel> {
	private static final Identifier NOSE_LOCATION = Constants.modLoc("textures/entity/ghast/nose.png");
	private final GhastNoseModel model;

	public GhastNoseLayer(RenderLayerParent<S, GhastModel> renderLayerParent, EntityModelSet modelSet) {
		super(renderLayerParent);
		this.model = new GhastNoseModel(modelSet.bakeLayer(ClientHandler.GHAST_NOSE));
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
		return NoseyConfig.CLIENT.showGhastNose.get();
	}
}
