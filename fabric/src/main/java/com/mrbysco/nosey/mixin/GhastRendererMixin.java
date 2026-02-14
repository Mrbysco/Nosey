package com.mrbysco.nosey.mixin;

import com.mrbysco.nosey.client.layer.GhastNoseLayer;
import net.minecraft.client.model.monster.ghast.GhastModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.GhastRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.GhastRenderState;
import net.minecraft.world.entity.monster.Ghast;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GhastRenderer.class)
public abstract class GhastRendererMixin extends MobRenderer<Ghast, GhastRenderState, GhastModel> {

	public GhastRendererMixin(Context context, GhastModel entityModel, float f) {
		super(context, entityModel, f);
	}

	@Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V")
	private void noseyInit(Context context, CallbackInfo info) {
		GhastRenderer ghastRenderer = (GhastRenderer) (Object) this;

		this.addLayer(new GhastNoseLayer<>(ghastRenderer, context.getModelSet()));
	}
}