package com.mrbysco.nosey;

import com.mrbysco.nosey.client.ModelLayerHelper;
import com.mrbysco.nosey.config.NoseyConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(Constants.MOD_ID)
public class NoseyNeoForge {

	public NoseyNeoForge(IEventBus eventBus, ModContainer container, Dist dist) {
		if (dist.isClient()) {
			container.registerConfig(ModConfig.Type.CLIENT, NoseyConfig.clientSpec);
			container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
			eventBus.addListener(ModelLayerHelper::registerLayerDefinitions);
			eventBus.addListener(ModelLayerHelper::registerAdditionalLayers);
		}
	}
}