package com.mrbysco.nosey.mixin;

import com.mrbysco.nosey.client.layer.BeeNoseLayer;
import net.minecraft.client.model.animal.bee.BeeModel;
import net.minecraft.client.renderer.entity.AgeableMobRenderer;
import net.minecraft.client.renderer.entity.BeeRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.state.BeeRenderState;
import net.minecraft.world.entity.animal.bee.Bee;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeeRenderer.class)
public abstract class BeeRendererMixin extends AgeableMobRenderer<Bee, BeeRenderState, BeeModel> {

	public BeeRendererMixin(Context context, BeeModel entityModel, BeeModel entityModel2, float f) {
		super(context, entityModel, entityModel2, f);
	}

	@Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V")
	private void noseyInit(Context context, CallbackInfo info) {
		BeeRenderer beeRenderer = (BeeRenderer) (Object) this;

		this.addLayer(new BeeNoseLayer<>(beeRenderer, context.getModelSet()));
	}
}