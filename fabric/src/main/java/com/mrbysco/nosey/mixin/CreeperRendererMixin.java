package com.mrbysco.nosey.mixin;

import com.mrbysco.nosey.client.layer.CreeperNoseLayer;
import net.minecraft.client.model.monster.creeper.CreeperModel;
import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.CreeperRenderState;
import net.minecraft.world.entity.monster.Creeper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreeperRenderer.class)
public abstract class CreeperRendererMixin extends MobRenderer<Creeper, CreeperRenderState, CreeperModel> {

	public CreeperRendererMixin(Context context, CreeperModel entityModel, float f) {
		super(context, entityModel, f);
	}

	@Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V")
	private void noseyInit(Context context, CallbackInfo info) {
		CreeperRenderer creeperRenderer = (CreeperRenderer) (Object) this;

		this.addLayer(new CreeperNoseLayer<>(creeperRenderer, context.getModelSet()));
	}
}