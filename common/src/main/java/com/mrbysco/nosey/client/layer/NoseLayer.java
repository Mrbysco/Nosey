package com.mrbysco.nosey.client.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;

public abstract class NoseLayer<S extends LivingEntityRenderState, M extends EntityModel<? super S>> extends RenderLayer<S, M> {
	public NoseLayer(RenderLayerParent<S, M> renderLayerParent) {
		super(renderLayerParent);
	}

	@Override
	public void submit(PoseStack poseStack, SubmitNodeCollector nodeCollector, int packedLight, S renderState, float yRot, float xRot) {
		if (canRender()) {
			this.getNoseModel().setupAnim(renderState);
			nodeCollector.submitModel(
					this.getNoseModel(),
					renderState,
					poseStack,
					RenderTypes.entityCutout(noseTextureLocation(renderState)),
					packedLight,
					OverlayTexture.NO_OVERLAY,
					renderState.outlineColor,
					null
			);
		}
	}

	public abstract EntityModel<? super S> getNoseModel();

	public abstract Identifier noseTextureLocation(S renderState);

	public abstract boolean canRender();
}
