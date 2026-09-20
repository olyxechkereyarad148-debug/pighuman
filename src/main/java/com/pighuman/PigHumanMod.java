package com.pighuman;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PigHumanMod implements ModInitializer {
	public static final String MOD_ID = "pighuman";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModEntities.init();
		ModItems.init();
		LOGGER.info("Pig Human loaded");
	}
}
