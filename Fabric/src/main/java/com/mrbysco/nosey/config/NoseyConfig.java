package com.mrbysco.nosey.config;

import com.mrbysco.nosey.Constants;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.CollapsibleObject;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = Constants.MOD_ID)
public class NoseyConfig implements ConfigData {

	@CollapsibleObject
	public Client client = new Client();

	public static class Client {
		//General
		@Comment("When enabled Ghast's grow a nose [default: true]")
		public boolean showGhastNose = true;

		@Comment("When enabled Creeper's grow a nose [default: true]")
		public boolean showCreeperNose = true;

		@Comment("When enabled Bee's grow a nose [default: true]")
		public boolean showBeeNose = true;

		@Comment("When enabled Frog's grow a nose [default: true]")
		public boolean showFrogNose = true;
	}
}
