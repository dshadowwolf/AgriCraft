package com.infinityraider.agricraft.items;

import net.minecraft.creativetab.CreativeTabs;

public class ItemNugget extends ItemBase {

    public ItemNugget(String name) {
        super("nugget"+name, false);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
	
}
