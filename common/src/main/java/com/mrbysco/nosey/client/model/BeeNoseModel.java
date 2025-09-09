package com.mrbysco.nosey.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.BeeRenderState;
import net.minecraft.util.Mth;

public class BeeNoseModel extends EntityModel<BeeRenderState> {
	private final ModelPart root;
	private float rollAmount;

	public BeeNoseModel(ModelPart root) {
		super(root);
		this.root = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(),
				PartPose.offset(0.5F, 19.0F, 0.0F));

		bone.addOrReplaceChild("nose", CubeListBuilder.create()
						.texOffs(0, 0).addBox(-1.5F, 0.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.ZERO);

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(BeeRenderState state) {
		super.setupAnim(state);
		this.rollAmount = state.rollAmount;
		boolean flag = state.isOnGround;
		if (!flag) {
			this.root.xRot = 0.0F;
			this.root.yRot = 0.0F;
			this.root.zRot = 0.0F;
		}

		if (!state.isAngry) {
			this.root.xRot = 0.0F;
			this.root.yRot = 0.0F;
			this.root.zRot = 0.0F;
			if (!flag) {
				float f1 = Mth.cos(state.ageInTicks * 0.18F);
				this.root.xRot = 0.1F + f1 * (float) Math.PI * 0.025F;
				this.root.y = 19.0F - Mth.cos(state.ageInTicks * 0.18F) * 0.9F;
			}
		}

		if (this.rollAmount > 0.0F) {
			this.root.xRot = Mth.rotLerpRad(this.root.xRot, 3.0915928F, this.rollAmount);
		}
	}
}