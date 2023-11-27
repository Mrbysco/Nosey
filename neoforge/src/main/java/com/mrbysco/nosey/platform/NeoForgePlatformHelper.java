package com.mrbysco.nosey.platform;

import com.mrbysco.nosey.config.NoseyConfig;
import com.mrbysco.nosey.platform.services.IPlatformHelper;

public class NeoForgePlatformHelper implements IPlatformHelper {

	@Override
	public boolean enableGhastNose() {
		return NoseyConfig.CLIENT.showGhastNose.get();
	}

	@Override
	public boolean enableCreeperNose() {
		return NoseyConfig.CLIENT.showCreeperNose.get();
	}

	@Override
	public boolean enableBeeNose() {
		return NoseyConfig.CLIENT.showBeeNose.get();
	}

	@Override
	public boolean enableFrogNose() {
		return NoseyConfig.CLIENT.showFrogNose.get();
	}
}
