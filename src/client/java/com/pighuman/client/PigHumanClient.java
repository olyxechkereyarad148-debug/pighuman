package com.pighuman.client;

import com.pighuman.ModEntities;
import com.pighuman.PigHumanEntity;
import com.pighuman.PigHumanMod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PigHumanClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(ModEntities.PIG_HUMAN, PigHumanRenderer::new);
	}

	/** Player-shaped model (64x64 skin layout) with a pig texture. */
	public static class PigHumanRenderer extends HumanoidMobRenderer<PigHumanEntity, HumanoidModel<PigHumanEntity>> {
		private static final ResourceLocation TEXTURE =
				ResourceLocation.fromNamespaceAndPath(PigHumanMod.MOD_ID, "textures/entity/pig_human.png");

		public PigHumanRenderer(EntityRendererProvider.Context context) {
			super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		}

		@Override
		public ResourceLocation getTextureLocation(PigHumanEntity entity) {
			return TEXTURE;
		}
	}
}
