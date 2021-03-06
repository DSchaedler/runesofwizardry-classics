/**
 *
 */
package xilef11.mc.runesofwizardry_classics.items;
import net.minecraft.item.ItemStack;
import xilef11.mc.runesofwizardry_classics.RunesofWizardry_Classics;
/**
 * @author Xilef11
 *
 */
public enum EnumDustTypes {
	PLANT (0x629B26, 0x8AD041, 0xC2E300),
	GUNPOWDER(0x696969, 0x979797, 0x666464),
	LAPIS(0x345EC3, 0x5A82E2, 0x0087FF),
	BLAZE(0xEA8A00, 0xFFFE31, 0xFF6E1E);
	/*
	 * In order of least valuable to most valuable:
	   2xTall Grass or Saplings or Leaves or Seeds + 1xCoal = 8xPlant Runic Dust
       2xPlant Runic Dust + 1xGunpowder = 12xGunpowder Runic Dust
       3xLapis + 1xCoal = 8xLapis Runic Dust
       3xLapis Runic Dust + 1xBlaze Powder = 12xBlaze Runic Dust
	 */
	public final int primaryColor, secondaryColor,floorColor;
	//constructor for our dust types
	EnumDustTypes(int primaryColor, int secondaryColor,int floorColor){
		this.primaryColor=primaryColor;
		this.secondaryColor=secondaryColor;
		this.floorColor = floorColor;
	}
	/** returns the metadata value associated with a dust type **/
	public int meta(){
		return this.ordinal();
	}
	public ItemStack getStack(int amount){
		return new ItemStack(ClassicDusts.instance,amount,this.meta());
	}
	/** returns the dust type associated with the given meta **/
	public static EnumDustTypes getByMeta(int meta){
 		if(meta>=EnumDustTypes.values().length){
			IllegalArgumentException e = new IllegalArgumentException("meta: "+meta);
			RunesofWizardry_Classics.log().error("Invalid Classic Dusts metadata",e);
			return EnumDustTypes.PLANT;
		}
		return EnumDustTypes.values()[meta];
	}
}
