/**
 *
 */
package xilef11.mc.runesofwizardry_classics.runes;
import java.io.IOException;
import java.util.Set;

import com.zpig333.runesofwizardry.api.RuneEntity;
import com.zpig333.runesofwizardry.core.rune.PatternUtils;
import com.zpig333.runesofwizardry.tileentity.TileEntityDustActive;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import xilef11.mc.runesofwizardry_classics.Refs;
import xilef11.mc.runesofwizardry_classics.runes.entity.RuneEntityFire;
/**
 * @author Xilef11
 *
 */
public class RuneFire extends ClassicRune {
	/* (non-Javadoc)
	 * @see xilef11.mc.runesofwizardry_classics.runes.ClassicRune#setupPattern()
	 */
	@Override
	protected ItemStack[][] setupPattern() throws IOException {
		return PatternUtils.importFromJson(Refs.PATTERN_PATH+"runefire.json");
	}
	@Override
	public String getID() {
		return "runeFire";
	}
	/* (non-Javadoc)
	 * @see xilef11.mc.runesofwizardry_classics.runes.ClassicRune#setupEntityPos()
	 */
	@Override
	protected Vec3i setupEntityPos() {
		return new Vec3i(1,2,0);
	}
	/* (non-Javadoc)
	 * @see xilef11.mc.runesofwizardry_classics.runes.ClassicRune#setupSacrifice()
	 */
	@Override
	protected ItemStack[][] setupSacrifice() {
		return new ItemStack[][]{
				{new ItemStack(Blocks.LOG,8),new ItemStack(Items.ROTTEN_FLESH)}
		};
	}
	/* (non-Javadoc)
	 * @see com.zpig333.runesofwizardry.api.IRune#getName()
	 */
	@Override
	public String getName() {
		return Refs.Lang.RUNE+".fire";
	}
	/* (non-Javadoc)
	 * @see com.zpig333.runesofwizardry.api.IRune#createRune(net.minecraft.item.ItemStack[][], net.minecraft.util.EnumFacing, java.util.Set, com.zpig333.runesofwizardry.tileentity.TileEntityDustActive)
	 */
	@Override
	public RuneEntity createRune(ItemStack[][] actualPattern, EnumFacing front,
			Set<BlockPos> dusts, TileEntityDustActive entity) {
		return new RuneEntityFire(actualPattern, front, dusts, entity, this);
	}
	/* (non-Javadoc)
	 * @see xilef11.mc.runesofwizardry_classics.runes.ClassicRune#hasExtraSacrifice()
	 */
	@Override
	protected boolean hasExtraSacrifice() {
		return true;
	}
}
