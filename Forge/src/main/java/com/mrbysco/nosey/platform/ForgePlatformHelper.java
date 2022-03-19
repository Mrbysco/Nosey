package com.mrbysco.nosey.platform;

import com.mrbysco.nosey.config.NoseyConfig;
import com.mrbysco.nosey.platform.services.IPlatformHelper;

public class ForgePlatformHelper implements IPlatformHelper {

	@Override
	public boolean enableGhastNose() {
		return NoseyConfig.CLIENT.showGhastNose.get();
	}

	@Override
	public boolean enableCreeperNose() {
		return NoseyConfig.CLIENT.showCreeperNose.get();
	}
}
