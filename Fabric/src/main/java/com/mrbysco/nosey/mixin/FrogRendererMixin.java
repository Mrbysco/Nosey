package com.mrbysco.nosey.mixin;

import com.mrbysco.nosey.client.layer.FrogNoseLayer;
import net.minecraft.client.model.FrogModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.FrogRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.world.entity.animal.frog.Frog;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FrogRenderer.class)
public abstract class FrogRendererMixin extends MobRenderer<Frog, FrogModel<Frog>> {

	public FrogRendererMixin(Context context, FrogModel<Frog> model, float shadowSize) {
		super(context, model, shadowSize);
	}

	@Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V")
	private void noseyInit(Context context, CallbackInfo info) {
		FrogRenderer frogRenderer = (FrogRenderer) (Object) this;

		this.addLayer(new FrogNoseLayer<>(frogRenderer, context.getModelSet()));
	}
}