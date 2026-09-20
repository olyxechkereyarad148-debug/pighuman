package com.pighuman.client;

import com.pighuman.PigHumanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PigHumanRenderer extends GeoEntityRenderer<PigHumanEntity> {
	public PigHumanRenderer(EntityRendererProvider.Context context) {
		super(context, new PigHumanModel());
		this.shadowRadius = 0.5f;
	}
}