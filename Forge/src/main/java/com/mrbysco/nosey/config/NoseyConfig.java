package com.mrbysco.nosey.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import org.apache.commons.lang3.tuple.Pair;

public class NoseyConfig {
	public static class Client {
		public final BooleanValue showGhastNose;
		public final BooleanValue showCreeperNose;

		Client(ForgeConfigSpec.Builder builder) {
			builder.comment("Client settings")
					.push("client");

			showGhastNose = builder
					.comment("When enabled Ghast's grow a nose [default: true]")
					.define("showGhastNose", true);

			showCreeperNose = builder
					.comment("When enabled Creeper's grow a nose [default: true]")
					.define("showCreeperNose", true);

			builder.pop();
		}
	}

	public static final ForgeConfigSpec clientSpec;
	public static final Client CLIENT;

	static {
		final Pair<Client, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Client::new);
		clientSpec = specPair.getRight();
		CLIENT = specPair.getLeft();
	}
}
