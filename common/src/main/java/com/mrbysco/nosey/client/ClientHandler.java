package com.mrbysco.nosey.client;

import com.mrbysco.nosey.Constants;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ClientHandler {
	public static final ModelLayerLocation GHAST_NOSE = new ModelLayerLocation(new ResourceLocation(Constants.MOD_ID, "ghast"), "nose");
	public static final ModelLayerLocation CREEPER_NOSE = new ModelLayerLocation(new ResourceLocation(Constants.MOD_ID, "creeper"), "nose");
	public static final ModelLayerLocation BEE_NOSE = new ModelLayerLocation(new ResourceLocation(Constants.MOD_ID, "bee"), "nose");
	public static final ModelLayerLocation FROG_NOSE = new ModelLayerLocation(new ResourceLocation(Constants.MOD_ID, "frog"), "nose");
}
