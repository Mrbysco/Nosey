package com.mrbysco.nosey.client.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;

public abstract class NoseLayer<S extends LivingEntityRenderState, M extends EntityModel<? super S>> extends RenderLayer<S, M> {
	public NoseLayer(RenderLayerParent<S, M> renderLayerParent) {
		super(renderLayerParent);
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, S renderState,
	                   float yRot, float xRot) {
		if (canRender()) {
			VertexConsumer vertexconsumer = getConsumer(bufferSource, renderState);
			this.getNoseModel().setupAnim(renderState);
			this.getNoseModel().renderToBuffer(poseStack, vertexconsumer, packedLight, LivingEntityRenderer.getOverlayCoords(renderState, 0.0F));
		}
	}

	public VertexConsumer getConsumer(MultiBufferSource bufferSource, S renderState) {
		return bufferSource.getBuffer(RenderType.entityCutoutNoCull(noseTextureLocation(renderState)));
	}

	public abstract EntityModel<? super S> getNoseModel();

	public abstract ResourceLocation noseTextureLocation(S renderState);

	public abstract boolean canRender();
}
