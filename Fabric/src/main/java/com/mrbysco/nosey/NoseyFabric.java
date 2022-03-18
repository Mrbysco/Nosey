package com.mrbysco.nosey;

import com.mrbysco.nosey.client.ModelLayerHelper;
import net.fabricmc.api.ClientModInitializer;

public class NoseyFabric implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		CommonClass.init();

		ModelLayerHelper.registerLayerDefinitions();
	}
}
