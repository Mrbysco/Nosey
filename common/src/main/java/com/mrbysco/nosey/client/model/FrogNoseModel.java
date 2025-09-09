package com.mrbysco.nosey.client.model;

import com.mrbysco.nosey.client.model.animation.FrogNoseAnimation;
import net.minecraft.client.animation.KeyframeAnimation;
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
	private final KeyframeAnimation jumpAnimation;
	private final KeyframeAnimation tongueAnimation;
	private final KeyframeAnimation swimAnimation;
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation idleWaterAnimation;

	public FrogNoseModel(ModelPart root) {
		super(root.getChild("root"));
		this.root = root.getChild("root");
		this.nose = this.root.getChild("body").getChild("head");
		this.jumpAnimation = FrogNoseAnimation.FROG_JUMP.bake(root);
		this.tongueAnimation = FrogNoseAnimation.FROG_TONGUE.bake(root);
		this.swimAnimation = FrogNoseAnimation.FROG_SWIM.bake(root);
		this.walkAnimation = FrogNoseAnimation.FROG_WALK.bake(root);
		this.idleWaterAnimation = FrogNoseAnimation.FROG_IDLE_WATER.bake(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 4.0F));

		body.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-1.0F, -2.0F, -9.0F, 2.0F, 4.0F, 2.0F), PartPose.offset(0.0F, -2.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(FrogRenderState renderState) {
		super.setupAnim(renderState);
		this.jumpAnimation.apply(renderState.jumpAnimationState, renderState.ageInTicks);
		this.tongueAnimation.apply(renderState.tongueAnimationState, renderState.ageInTicks);
		if (renderState.isSwimming) {
			this.swimAnimation.applyWalk(renderState.walkAnimationPos, renderState.walkAnimationSpeed, 1.0F, 2.5F);
		} else {
			this.walkAnimation.applyWalk(renderState.walkAnimationPos, renderState.walkAnimationSpeed, 1.5F, 2.5F);
		}

		this.idleWaterAnimation.apply(renderState.swimIdleAnimationState, renderState.ageInTicks);
	}
}