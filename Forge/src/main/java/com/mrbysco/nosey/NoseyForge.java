package com.mrbysco.nosey;

import com.mrbysco.nosey.client.ModelLayerHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.IExtensionPoint.DisplayTest;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class NoseyForge {

	public NoseyForge() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		CommonClass.init();

		//Make sure the mod being absent on the other network side does not cause the client to display the server as incompatible
		ModLoadingContext.get().registerExtensionPoint(DisplayTest.class, () ->
				new IExtensionPoint.DisplayTest(() -> "Trans Rights Are Human Rights",
						(remoteVersionString, networkBool) -> networkBool));

		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
			eventBus.addListener(ModelLayerHelper::registerLayerDefinitions);
			eventBus.addListener(ModelLayerHelper::registerAdditionalLayers);
		});
	}
}