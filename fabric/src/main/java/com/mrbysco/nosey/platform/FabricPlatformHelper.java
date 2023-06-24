package com.mrbysco.nosey.platform;

import com.mrbysco.nosey.NoseyFabric;
import com.mrbysco.nosey.config.NoseyConfig;
import com.mrbysco.nosey.platform.services.IPlatformHelper;
import me.shedaniel.autoconfig.AutoConfig;

public class FabricPlatformHelper implements IPlatformHelper {

	@Override
	public boolean enableGhastNose() {
		if (NoseyFabric.config == null) NoseyFabric.config = AutoConfig.getConfigHolder(NoseyConfig.class).getConfig();
		return NoseyFabric.config.client.showGhastNose;
	}

	@Override
	public boolean enableCreeperNose() {
		if (NoseyFabric.config == null) NoseyFabric.config = AutoConfig.getConfigHolder(NoseyConfig.class).getConfig();
		return NoseyFabric.config.client.showCreeperNose;
	}

	@Override
	public boolean enableBeeNose() {
		if (NoseyFabric.config == null) NoseyFabric.config = AutoConfig.getConfigHolder(NoseyConfig.class).getConfig();
		return NoseyFabric.config.client.showBeeNose;
	}

	@Override
	public boolean enableFrogNose() {
		if (NoseyFabric.config == null) NoseyFabric.config = AutoConfig.getConfigHolder(NoseyConfig.class).getConfig();
		return NoseyFabric.config.client.showFrogNose;
	}
}
