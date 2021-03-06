package com.infinityraider.agricraft.init;

import com.infinityraider.agricraft.blocks.*;
import com.infinityraider.agricraft.compatibility.CompatibilityHandler;
import com.infinityraider.agricraft.handler.config.AgriCraftConfig;
import com.infinityraider.agricraft.handler.config.AgriCraftConfigurable;
import com.infinityraider.agricraft.handler.config.ConfigCategory;
import com.infinityraider.agricraft.handler.config.ConfigurationHandler;
import com.infinityraider.agricraft.reference.AgriCraftMods;
import com.infinityraider.agricraft.utility.LogHelper;
import net.minecraft.block.Block;

public class AgriCraftBlocks {
	
	@AgriCraftConfigurable(
			category = ConfigCategory.DECORATION,
			key = "Enable Fences",
			comment = "Set to false to disable the decorative custom wood fences."
	)
	public static boolean enableFences = true;
	@AgriCraftConfigurable(
			category = ConfigCategory.DECORATION,
			key = "Enable Grates",
			comment = "Set to false to disable the decorative custom wood grates."
	)
	public static boolean enableGrates = true;
	
	static {
		ConfigurationHandler.addConfigurable(AgriCraftBlocks.class);
	}

	public static Block blockCrop;
	public static Block blockSeedAnalyzer;
	public static Block blockWaterPad;
	public static Block blockWaterPadFull;
	public static Block blockWaterTank;
	public static Block blockWaterChannel;
	public static Block blockWaterChannelFull;
	public static Block blockChannelValve;
	public static Block blockSprinkler;
	public static Block blockSeedStorage;
	public static Block blockSeedStorageController;
	public static Block blockPeripheral;
	public static Block blockFence;
	public static Block blockFenceGate;
	public static Block blockGrate;

	public static void init() {
		blockCrop = new BlockCrop();
		blockSeedAnalyzer = new BlockSeedAnalyzer();
		blockWaterPad = new BlockWaterPad();
		blockWaterPadFull = new BlockWaterPadFull();
		if (!AgriCraftConfig.disableIrrigation) {
			blockWaterTank = new BlockWaterTank();
			blockWaterChannel = new BlockWaterChannel();
			blockWaterChannelFull = new BlockWaterChannelFull();
			blockChannelValve = new BlockChannelValve();
			blockSprinkler = new BlockSprinkler();
		}
		if (!AgriCraftConfig.disableSeedStorage) {
			blockSeedStorage = new BlockSeedStorage();
			if (!AgriCraftConfig.disableSeedWarehouse) {
				//blockSeedStorageController = new BlockSeedStorageController();
			}
		}
		if (CompatibilityHandler.getInstance().isCompatibilityEnabled(AgriCraftMods.computerCraft) || CompatibilityHandler.getInstance().isCompatibilityEnabled(AgriCraftMods.openComputers)) {
			blockPeripheral = new BlockPeripheral();
		}
		if (enableFences) {
			blockFence = new BlockFence();
			blockFenceGate = new BlockFenceGate();
		}
		if (enableGrates) {
			blockGrate = new BlockGrate();
		}
		LogHelper.debug("Blocks registered");
	}
}
