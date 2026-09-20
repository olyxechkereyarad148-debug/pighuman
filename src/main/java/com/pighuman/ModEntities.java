package com.pighuman;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public final class ModEntities {
	public static final EntityType<PigHumanEntity> PIG_HUMAN = Registry.register(
			BuiltInRegistries.ENTITY_TYPE,
			ResourceLocation.fromNamespaceAndPath(PigHumanMod.MOD_ID, "pig_human"),
			EntityType.Builder.of(PigHumanEntity::new, MobCategory.CREATURE)
					.sized(0.6f, 1.8f)
					.build("pig_human")
	);

	private ModEntities() {
	}

	public static void init() {
		FabricDefaultAttributeRegistry.register(PIG_HUMAN, PigHumanEntity.createAttributes());
	}
}
