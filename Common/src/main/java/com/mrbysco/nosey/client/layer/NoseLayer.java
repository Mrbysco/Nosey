package com.mrbysco.nosey.client.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mrbysco.nosey.platform.Services;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public abstract class NoseLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
	public NoseLayer(RenderLayerParent<T, M> renderLayerParent) {
		super(renderLayerParent);
	}

	@Override
	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLightIn, T livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (canRender()) {
			this.getParentModel().copyPropertiesTo(getNoseModel());
			getNoseModel().prepareMobModel(livingEntity, limbSwing, limbSwingAmount, partialTicks);
			getNoseModel().setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			VertexConsumer vertexconsumer = getConsumer(bufferSource, livingEntity);
			getNoseModel().renderToBuffer(poseStack, vertexconsumer, packedLightIn, LivingEntityRenderer.getOverlayCoords(livingEntity, 0), 1.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	public VertexConsumer getConsumer(MultiBufferSource bufferSource, T livingEntity) {
		return bufferSource.getBuffer(RenderType.entityCutoutNoCull(noseTextureLocation(livingEntity)));
	}

	public abstract EntityModel<T> getNoseModel();

	public abstract ResourceLocation noseTextureLocation(T entityIn);

	public abstract boolean canRender();
}
