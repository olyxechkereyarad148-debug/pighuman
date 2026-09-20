package com.pighuman.client;

import com.pighuman.PigHumanEntity;
import com.pighuman.PigHumanMod;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PigHumanModel extends GeoModel<PigHumanEntity> {
	private static final ResourceLocation MODEL =
			ResourceLocation.fromNamespaceAndPath(PigHumanMod.MOD_ID, "geo/pighuman.geo.json");
	private static final ResourceLocation TEXTURE =
			ResourceLocation.fromNamespaceAndPath(PigHumanMod.MOD_ID, "textures/entity/pig_human.png");
	private static final ResourceLocation ANIMATION =
			ResourceLocation.fromNamespaceAndPath(PigHumanMod.MOD_ID, "animations/pighuman.animation.json");

	@Override
	public ResourceLocation getModelResource(PigHumanEntity animatable) {
		return MODEL;
	}

	@Override
	public ResourceLocation getTextureResource(PigHumanEntity animatable) {
		return TEXTURE;
	}

	@Override
	public ResourceLocation getAnimationResource(PigHumanEntity animatable) {
		return ANIMATION;
	}
}