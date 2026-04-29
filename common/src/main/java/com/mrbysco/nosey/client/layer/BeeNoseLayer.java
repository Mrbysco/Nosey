package com.mrbysco.nosey.client.layer;

import com.mrbysco.nosey.Constants;
import com.mrbysco.nosey.client.ClientHandler;
import com.mrbysco.nosey.client.model.BeeNoseModel;
import com.mrbysco.nosey.config.NoseyConfig;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.animal.bee.BeeModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.BeeRenderState;
import net.minecraft.resources.Identifier;

public class BeeNoseLayer<T extends BeeRenderState> extends NoseLayer<T, BeeModel> {
	private static final Identifier NOSE_LOCATION = Constants.modLoc("textures/entity/bee/nose.png");
	private final BeeNoseModel model;

	public BeeNoseLayer(RenderLayerParent<T, BeeModel> renderLayerParent, EntityModelSet modelSet) {
		super(renderLayerParent);
		this.model = new BeeNoseModel(modelSet.bakeLayer(ClientHandler.BEE_NOSE));
	}

	@Override
	public EntityModel<? super T> getNoseModel() {
		return model;
	}

	@Override
	public Identifier noseTextureLocation(T renderState) {
		return NOSE_LOCATION;
	}

	@Override
	public boolean canRender() {
		return NoseyConfig.CLIENT.showBeeNose.get();
	}
}
