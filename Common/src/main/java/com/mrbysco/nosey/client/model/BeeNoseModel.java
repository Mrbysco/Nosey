package com.mrbysco.nosey.client.model;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.ModelUtils;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.Bee;

public class BeeNoseModel<T extends Bee> extends HierarchicalModel<T> {
	private final ModelPart root;
	private float rollAmount;

	public BeeNoseModel(ModelPart root) {
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
	public ModelPart root() {
		return this.root;
	}

	public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(entityIn, limbSwing, limbSwingAmount, partialTick);
		this.rollAmount = entityIn.getRollAmount(partialTick);
	}
	
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root.xRot = 0.0F;
		boolean flag = entity.isOnGround() && entity.getDeltaMovement().lengthSqr() < 1.0E-7D;
		if (!flag) {
			this.root.xRot = 0.0F;
			this.root.yRot = 0.0F;
			this.root.zRot = 0.0F;
		}

		if (!entity.isAngry()) {
			this.root.xRot = 0.0F;
			this.root.yRot = 0.0F;
			this.root.zRot = 0.0F;
			if (!flag) {
				float f1 = Mth.cos(ageInTicks * 0.18F);
				this.root.xRot = 0.1F + f1 * (float)Math.PI * 0.025F;
				this.root.y = 19.0F - Mth.cos(ageInTicks * 0.18F) * 0.9F;
			}
		}

		if (this.rollAmount > 0.0F) {
			this.root.xRot = ModelUtils.rotlerpRad(this.root.xRot, 3.0915928F, this.rollAmount);
		}
	}
}