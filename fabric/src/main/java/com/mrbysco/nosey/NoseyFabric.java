package com.mrbysco.nosey;

import com.mrbysco.nosey.client.ModelLayerHelper;
import com.mrbysco.nosey.config.NoseyConfig;
import fuzs.forgeconfigapiport.fabric.api.v5.ConfigRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.neoforged.fml.config.ModConfig;

public class NoseyFabric implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ConfigRegistry.INSTANCE.register(Constants.MOD_ID, ModConfig.Type.CLIENT, NoseyConfig.clientSpec);

		ModelLayerHelper.registerLayerDefinitions();
	}
}
