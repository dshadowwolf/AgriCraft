package com.infinityraider.agricraft.items.blocks;

import com.infinityraider.agricraft.tileentity.decoration.TileEntityGrate;
import com.infinityraider.agricraft.utility.AgriForgeDirection;
import com.infinityraider.agricraft.utility.PlayerHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * The item form of the Grate block.
 */
public class ItemBlockGrate extends ItemBlockCustomWood {
	
    /**
     * The default constructor for the Grate Item.
     * 
     * @param block the block that the item is associated with.
     */
    public ItemBlockGrate(Block block) {
        super(block);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean flag) {
        super.addInformation(stack, player, list, flag);
        list.add(I18n.translateToLocal("agricraft_tooltip.grate"));
    }

    @Override
    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, IBlockState newState) {
        if (super.placeBlockAt(stack, player, world, pos, side, hitX, hitY, hitZ, newState)) {
            TileEntityGrate grate = (TileEntityGrate) world.getTileEntity(pos);
            if (side == EnumFacing.UP || side == EnumFacing.DOWN) {
                AgriForgeDirection dir = PlayerHelper.getPlayerFacing(player);
                if (dir == AgriForgeDirection.NORTH || dir == AgriForgeDirection.SOUTH) {
                    setOffsetAndOrientation(grate, hitZ, AgriForgeDirection.NORTH);
                } else {
                    setOffsetAndOrientation(grate, hitX, AgriForgeDirection.EAST);
                }
            } else {
                setOffsetAndOrientation(grate, hitY, AgriForgeDirection.DOWN);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets the freshly placed TileEntityGrate's orientation.
     * 
     * @param grate the grate in question.
     * @param hit the hit location, on the axis matching the orientation.
     * @param orientation the orientation.
     */
    private static void setOffsetAndOrientation(TileEntityGrate grate, float hit, AgriForgeDirection orientation) {
        grate.setOrientation(orientation);
        if (hit <= 0.3333F) {
            grate.setOffSet((short) 0);
        } else if (hit <= 0.6666F) {
            grate.setOffSet((short) 1);
        } else {
            grate.setOffSet((short) 2);
        }
        grate.calculateBounds();
    }

}
