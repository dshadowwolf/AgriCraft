package com.infinityraider.agricraft.items;

import com.infinityraider.agricraft.AgriCraft;
import com.infinityraider.agricraft.api.v1.IJournal;
import com.infinityraider.agricraft.farming.CropPlantHandler;
import com.infinityraider.agricraft.handler.GuiHandler;
import com.infinityraider.agricraft.reference.AgriCraftNBT;
import com.infinityraider.agricraft.utility.NBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class ItemJournal extends ItemBase implements IJournal {
	
    public ItemJournal() {
        super("journal", true);
        this.setMaxStackSize(1);
    }

    //this has to return true to make it so the getContainerItem method gets called when this item is used in a recipe
	@Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    //when this item is used in a crafting recipe it is replaced by the item return by this method
    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return itemStack.copy();
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        ItemStack journal = player.getHeldItem(hand);
        if(journal.hasTagCompound()) {
            NBTTagCompound tag = journal.getTagCompound();
            if(tag.hasKey(AgriCraftNBT.DISCOVERED_SEEDS)) {
                NBTTagList list = tag.getTagList(AgriCraftNBT.DISCOVERED_SEEDS, 10);
                NBTHelper.clearEmptyStacksFromNBT(list);
                tag.setTag(AgriCraftNBT.DISCOVERED_SEEDS, list);
            }
        }
        if(world.isRemote) {
            player.openGui(AgriCraft.instance, GuiHandler.journalID, world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
        }
        return new ActionResult<>(EnumActionResult.PASS, stack);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean flag) {
        int nr = 0;
        if(stack.hasTagCompound() && stack.getTagCompound().hasKey(AgriCraftNBT.DISCOVERED_SEEDS)) {
            nr = stack.getTagCompound().getTagList(AgriCraftNBT.DISCOVERED_SEEDS, 10).tagCount();
        }
        list.add(I18n.translateToLocal("agricraft_tooltip.discoveredSeeds")+": "+nr);
    }

    private NBTTagList getDiscoveredSeedsTaglist(ItemStack journal) {
        //check if the journal has AgriCraftNBT and if it doesn't, create a new one
        if(!journal.hasTagCompound()) {
            journal.setTagCompound(new NBTTagCompound());
        }
        NBTTagCompound tag = journal.getTagCompound();
        //check if the AgriCraftNBT TAG has a list of discovered seeds and if it doesn't, create a new one
        NBTTagList list;
        if(tag.hasKey(AgriCraftNBT.DISCOVERED_SEEDS)) {
            list = tag.getTagList(AgriCraftNBT.DISCOVERED_SEEDS, 10);
            NBTHelper.clearEmptyStacksFromNBT(list);
        }
        else {
            list = new NBTTagList();
        }
        return list;
    }

	@Override
    public void addEntry(ItemStack journal, ItemStack newEntry) {
        if(journal==null || journal.getItem()==null || !CropPlantHandler.isValidSeed(newEntry)) {
            return;
        }
        NBTTagList list = getDiscoveredSeedsTaglist(journal);
        NBTTagCompound tag = journal.getTagCompound();
        //add the ANALYZED SEED to the AgriCraftNBT TAG list if it doesn't already have it
        if(!isSeedDiscovered(journal, newEntry)) {
            NBTTagCompound seedTag = new NBTTagCompound();
            ItemStack write = newEntry.copy();
            write.stackSize = 1;
            write.setTagCompound(null);
            write.writeToNBT(seedTag);
            list.appendTag(seedTag);
        }
        NBTHelper.sortStacks(list);
        //add the AgriCraftNBT TAG to the journal
        tag.setTag(AgriCraftNBT.DISCOVERED_SEEDS, list);
    }

	@Override
    public boolean isSeedDiscovered(ItemStack journal, ItemStack seed) {
        if(journal==null || journal.getItem()==null || !CropPlantHandler.isValidSeed(seed)) {
            return false;
        }
        return NBTHelper.listContainsStack(getDiscoveredSeedsTaglist(journal), seed);
    }

	@Override
    public ArrayList<ItemStack> getDiscoveredSeeds(ItemStack journal) {
        ArrayList<ItemStack> seeds = new ArrayList<>();
        NBTTagCompound tag = null;
        if (journal != null && journal.stackSize > 0 && journal.getItem() instanceof ItemJournal && journal.hasTagCompound()) {
            tag = journal.getTagCompound();
        }
        if(tag != null) {
            if (tag.hasKey(AgriCraftNBT.DISCOVERED_SEEDS)) {
                NBTTagList tagList = tag.getTagList(AgriCraftNBT.DISCOVERED_SEEDS, 10);      //10 for tagCompound
                for (int i = 0; i < tagList.tagCount(); i++) {
                    ItemStack seed = ItemStack.loadItemStackFromNBT(tagList.getCompoundTagAt(i));
                    if(CropPlantHandler.isValidSeed(seed)) {
                        seeds.add(seed);
                    }
                }
            }
        }
        return seeds;
    }
	
}
