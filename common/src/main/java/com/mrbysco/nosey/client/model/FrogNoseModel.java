package com.mrbysco.nosey.client.model;

import net.minecraft.client.animation.definitions.FrogAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.FrogRenderState;

public class FrogNoseModel extends EntityModel<FrogRenderState> {
	private final ModelPart root;
	private final ModelPart nose;

	public FrogNoseModel(ModelPart root) {
		super(root);
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
	public void setupAnim(FrogRenderState renderState) {
		super.setupAnim(renderState);
		this.animate(renderState.jumpAnimationState, FrogAnimation.FROG_JUMP, renderState.ageInTicks);
		this.animate(renderState.croakAnimationState, FrogAnimation.FROG_CROAK, renderState.ageInTicks);
		this.animate(renderState.tongueAnimationState, FrogAnimation.FROG_TONGUE, renderState.ageInTicks);
		if (renderState.isSwimming) {
			this.animateWalk(FrogAnimation.FROG_SWIM, renderState.walkAnimationPos, renderState.walkAnimationSpeed, 1.0F, 2.5F);
		} else {
			this.animateWalk(FrogAnimation.FROG_WALK, renderState.walkAnimationPos, renderState.walkAnimationSpeed, 1.5F, 2.5F);
		}

		this.animate(renderState.swimIdleAnimationState, FrogAnimation.FROG_IDLE_WATER, renderState.ageInTicks);
	}
}