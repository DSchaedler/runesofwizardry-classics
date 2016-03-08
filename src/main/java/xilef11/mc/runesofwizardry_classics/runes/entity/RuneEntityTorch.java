/**
 * 
 */
package xilef11.mc.runesofwizardry_classics.runes.entity;

import java.util.Set;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import xilef11.mc.runesofwizardry_classics.ModLogger;

import com.zpig333.runesofwizardry.api.RuneEntity;
import com.zpig333.runesofwizardry.tileentity.TileEntityDustActive;

/**
 * @author Xilef11
 *
 */
public class RuneEntityTorch extends RuneEntity {
	public RuneEntityTorch(ItemStack[][] actualPattern, EnumFacing facing,Set<BlockPos> dusts, TileEntityDustActive entity) {
		super(actualPattern, facing, dusts, entity);
	}
	private boolean beacon=false;
	private int beaconColor=0xFFFFFF;
	/* (non-Javadoc)
	 * @see com.zpig333.runesofwizardry.api.RuneEntity#getRuneID()
	 */
	@Override
	public String getRuneID() {
		return "runeTorch";
	}

	/* (non-Javadoc)
	 * @see com.zpig333.runesofwizardry.api.RuneEntity#onRuneActivatedbyPlayer(net.minecraft.entity.player.EntityPlayer, net.minecraft.item.ItemStack[])
	 */
	@Override
	public void onRuneActivatedbyPlayer(EntityPlayer player,ItemStack[] sacrifice) {
		ModLogger.logDebug("Activated torch rune with sacrifice: "+sacrifice);
		if(sacrifice==null){
			World world = entity.getWorld();
			BlockPos pos = getPos();
			entity.clear();
			world.setBlockToAir(pos);
			world.setBlockState(pos, Blocks.torch.getDefaultState());
		}else{
			this.beacon=true;
			//TODO create beacon
		}
	}

	/* (non-Javadoc)
	 * @see com.zpig333.runesofwizardry.api.RuneEntity#update()
	 */
	@Override
	public void update() {
		if(beacon){
			//probably stuff to do here
		}
	}

	/* (non-Javadoc)
	 * @see com.zpig333.runesofwizardry.api.RuneEntity#readFromNBT(net.minecraft.nbt.NBTTagCompound)
	 */
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		beacon = compound.getBoolean("isBeacon");
		beaconColor = compound.getInteger("beaconColor");
	}

	/* (non-Javadoc)
	 * @see com.zpig333.runesofwizardry.api.RuneEntity#writeToNBT(net.minecraft.nbt.NBTTagCompound)
	 */
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setBoolean("isBeacon", beacon);
		compound.setInteger("beaconColor", beaconColor);
	}
	
}
