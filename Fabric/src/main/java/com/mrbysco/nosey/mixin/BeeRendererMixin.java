package com.mrbysco.nosey.mixin;

import com.mrbysco.nosey.client.layer.BeeNoseLayer;
import com.mrbysco.nosey.client.layer.CreeperNoseLayer;
import net.minecraft.client.model.BeeModel;
import net.minecraft.client.renderer.entity.BeeRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.world.entity.animal.Bee;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BeeRenderer.class)
public abstract class BeeRendererMixin extends MobRenderer<Bee, BeeModel<Bee>> {

	public BeeRendererMixin(Context context, BeeModel<Bee> model, float shadowSize) {
		super(context, model, shadowSize);
	}

	@Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V")
	private void noseyInit(Context context, CallbackInfo info) {
		BeeRenderer beeRenderer = (BeeRenderer) (Object) this;

		this.addLayer(new BeeNoseLayer(beeRenderer, context.getModelSet()));
	}
}