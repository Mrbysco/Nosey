package com.mrbysco.nosey.client.layer;

import com.mrbysco.nosey.Constants;
import com.mrbysco.nosey.client.ClientHandler;
import com.mrbysco.nosey.client.model.FrogNoseModel;
import com.mrbysco.nosey.platform.Services;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.FrogModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.FrogRenderState;
import net.minecraft.resources.ResourceLocation;

public class FrogNoseLayer<S extends FrogRenderState> extends NoseLayer<S, FrogModel> {
	private final FrogNoseModel model;

	public FrogNoseLayer(RenderLayerParent<S, FrogModel> renderLayerParent, EntityModelSet modelSet) {
		super(renderLayerParent);
		this.model = new FrogNoseModel(modelSet.bakeLayer(ClientHandler.FROG_NOSE));
	}

	@Override
	public EntityModel<? super S> getNoseModel() {
		return model;
	}

	@Override
	public ResourceLocation noseTextureLocation(S renderState) {
		ResourceLocation frogTexture = renderState.texture;
		String path = frogTexture.getPath();
		String nosePath = path.replace(".png", "_nose.png");
		return Constants.modLoc(nosePath);
	}

	@Override
	public boolean canRender() {
		return Services.PLATFORM.enableFrogNose();
	}
}
