package com.mrbysco.nosey.mixin;

import com.mrbysco.nosey.client.layer.GhastNoseLayer;
import net.minecraft.client.model.GhastModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.GhastRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.world.entity.monster.Ghast;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GhastRenderer.class)
public abstract class GhastRendererMixin extends MobRenderer<Ghast, GhastModel<Ghast>> {

	public GhastRendererMixin(Context context, GhastModel<Ghast> model, float shadowSize) {
		super(context, model, shadowSize);
	}

	@Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V")
	private void noseyInit(Context context, CallbackInfo info) {
		GhastRenderer ghastRenderer = (GhastRenderer) (Object) this;

		this.addLayer(new GhastNoseLayer(ghastRenderer, context.getModelSet()));
	}
}