package com.mrbysco.nosey.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.animation.definitions.FrogAnimation;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.animal.frog.Frog;

public class FrogNoseModel<T extends Frog> extends HierarchicalModel<T> {
	private final ModelPart root;
	private final ModelPart nose;

	public FrogNoseModel(ModelPart root) {
		this.root = root.getChild("root");
		this.nose = this.root.getChild("body").getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 4.0F));

		body.addOrReplaceChild("head", CubeListBuilder.create().create()
				.texOffs(0, 0).addBox(-1.0F, -2.0F, -9.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(0.0F, -2.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animate(entity.jumpAnimationState, FrogAnimation.FROG_JUMP, ageInTicks);
		this.animate(entity.croakAnimationState, FrogAnimation.FROG_CROAK, ageInTicks);
		this.animate(entity.tongueAnimationState, FrogAnimation.FROG_TONGUE, ageInTicks);
		if (entity.isInWaterOrBubble()) {
			this.animateWalk(FrogAnimation.FROG_SWIM, limbSwing, limbSwingAmount, 1.0F, 2.5F);
		} else {
			this.animateWalk(FrogAnimation.FROG_WALK, limbSwing, limbSwingAmount, 1.5F, 2.5F);
		}
		this.animate(entity.swimIdleAnimationState, FrogAnimation.FROG_IDLE_WATER, ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}