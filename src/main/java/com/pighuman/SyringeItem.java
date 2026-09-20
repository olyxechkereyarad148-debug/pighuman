package com.pighuman;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SyringeItem extends Item {
	public SyringeItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
		if (!(target instanceof Pig pig)) {
			return InteractionResult.PASS;
		}

		Level level = player.level();
		if (!(level instanceof ServerLevel serverLevel)) {
			// Client side: just play the swing animation, the server does the actual work.
			return InteractionResult.SUCCESS;
		}

		PigHumanEntity human = ModEntities.PIG_HUMAN.create(serverLevel);
		if (human == null) {
			return InteractionResult.FAIL;
		}

		human.moveTo(pig.getX(), pig.getY(), pig.getZ(), pig.getYRot(), pig.getXRot());
		human.yBodyRot = pig.yBodyRot;
		human.yHeadRot = pig.yHeadRot;
		if (pig.hasCustomName()) {
			human.setCustomName(pig.getCustomName());
			human.setCustomNameVisible(pig.isCustomNameVisible());
		}

		serverLevel.addFreshEntity(human);
		pig.discard();

		serverLevel.sendParticles(ParticleTypes.POOF, human.getX(), human.getY() + 0.9, human.getZ(), 20, 0.3, 0.5, 0.3, 0.02);
		serverLevel.playSound(null, human.getX(), human.getY(), human.getZ(), SoundEvents.PIG_AMBIENT, SoundSource.NEUTRAL, 1.0f, 0.8f);

		// consume() does nothing in creative mode
		stack.consume(1, player);
		return InteractionResult.CONSUME;
	}
}
