package com.mrbysco.nosey.client.layer;

import com.mrbysco.nosey.Constants;
import com.mrbysco.nosey.client.ClientHandler;
import com.mrbysco.nosey.client.model.FrogNoseModel;
import com.mrbysco.nosey.platform.Services;
import net.minecraft.client.model.FrogModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.FrogVariant;
import net.minecraft.world.entity.animal.frog.Frog;

import java.util.HashMap;
import java.util.Map;

public class FrogNoseLayer<T extends Frog> extends NoseLayer<T, FrogModel<T>> {
	public static final Map<FrogVariant, ResourceLocation> NOSE_LOCATIONS = generateMap();

	private static Map<FrogVariant, ResourceLocation> generateMap() {
		Map<FrogVariant, ResourceLocation> map = new HashMap<>();
		map.put(FrogVariant.COLD, new ResourceLocation(Constants.MOD_ID, "textures/entity/frog/cold_nose.png"));
		map.put(FrogVariant.TEMPERATE, new ResourceLocation(Constants.MOD_ID, "textures/entity/frog/temperate_nose.png"));
		map.put(FrogVariant.WARM, new ResourceLocation(Constants.MOD_ID, "textures/entity/frog/warm_nose.png"));

		return map;
	}

	private final FrogNoseModel<T> model;

	public FrogNoseLayer(RenderLayerParent<T, FrogModel<T>> renderLayerParent, EntityModelSet modelSet) {
		super(renderLayerParent);
		this.model = new FrogNoseModel<>(modelSet.bakeLayer(ClientHandler.FROG_NOSE));
	}

	@Override
	public HierarchicalModel<T> getNoseModel() {
		return model;
	}

	@Override
	public ResourceLocation noseTextureLocation(T entityIn) {
		if (NOSE_LOCATIONS.containsKey(entityIn.getVariant())) {
			return NOSE_LOCATIONS.get(entityIn.getVariant());
		} else {
			FrogVariant variant = entityIn.getVariant();
			ResourceLocation location = new ResourceLocation("textures/entity/frog/" + Registry.FROG_VARIANT.getKey(variant).getPath() + "_nose.png");
			return NOSE_LOCATIONS.put(variant, location);
		}
	}

	@Override
	public boolean canRender() {
		return Services.PLATFORM.enableFrogNose();
	}
}
