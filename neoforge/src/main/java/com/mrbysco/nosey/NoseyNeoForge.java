package com.mrbysco.nosey;

import com.mrbysco.nosey.client.ModelLayerHelper;
import com.mrbysco.nosey.config.NoseyConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.IExtensionPoint;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(Constants.MOD_ID)
public class NoseyNeoForge {

	public NoseyNeoForge(IEventBus eventBus) {
		//Make sure the mod being absent on the other network side does not cause the client to display the server as incompatible
		ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () ->
				new IExtensionPoint.DisplayTest(() -> "Trans Rights Are Human Rights",
						(remoteVersionString, networkBool) -> networkBool));

		if (FMLEnvironment.dist.isClient()) {
			ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, NoseyConfig.clientSpec);
			eventBus.addListener(ModelLayerHelper::registerLayerDefinitions);
			eventBus.addListener(ModelLayerHelper::registerAdditionalLayers);
		}
	}
}