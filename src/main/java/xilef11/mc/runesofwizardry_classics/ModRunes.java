/**
 *
 */
package xilef11.mc.runesofwizardry_classics;
import java.util.LinkedList;
import java.util.List;

import com.zpig333.runesofwizardry.api.DustRegistry;

import xilef11.mc.runesofwizardry_classics.runes.ClassicRune;
import xilef11.mc.runesofwizardry_classics.runes.RuneBarrier;
import xilef11.mc.runesofwizardry_classics.runes.RuneBouncing;
import xilef11.mc.runesofwizardry_classics.runes.RuneCompression;
import xilef11.mc.runesofwizardry_classics.runes.RuneDawn;
import xilef11.mc.runesofwizardry_classics.runes.RuneDepths;
import xilef11.mc.runesofwizardry_classics.runes.RuneDetonation;
import xilef11.mc.runesofwizardry_classics.runes.RuneDusk;
import xilef11.mc.runesofwizardry_classics.runes.RuneEnchantingFireBow;
import xilef11.mc.runesofwizardry_classics.runes.RuneEnchantingFortune;
import xilef11.mc.runesofwizardry_classics.runes.RuneEnchantingSilkTouch;
import xilef11.mc.runesofwizardry_classics.runes.RuneFarm;
import xilef11.mc.runesofwizardry_classics.runes.RuneFire;
import xilef11.mc.runesofwizardry_classics.runes.RuneHealing;
import xilef11.mc.runesofwizardry_classics.runes.RuneHeights;
import xilef11.mc.runesofwizardry_classics.runes.RuneHellstorm;
import xilef11.mc.runesofwizardry_classics.runes.RuneInscriptionEnchant;
import xilef11.mc.runesofwizardry_classics.runes.RuneLeapingFrog;
import xilef11.mc.runesofwizardry_classics.runes.RuneLevelEarth;
import xilef11.mc.runesofwizardry_classics.runes.RuneLockedTime;
import xilef11.mc.runesofwizardry_classics.runes.RuneLumber;
import xilef11.mc.runesofwizardry_classics.runes.RuneMountain;
import xilef11.mc.runesofwizardry_classics.runes.RuneMusic;
import xilef11.mc.runesofwizardry_classics.runes.RunePowerDistribution;
import xilef11.mc.runesofwizardry_classics.runes.RuneProtection;
import xilef11.mc.runesofwizardry_classics.runes.RuneRabbitHole;
import xilef11.mc.runesofwizardry_classics.runes.RuneRebirth;
import xilef11.mc.runesofwizardry_classics.runes.RuneResurrection;
import xilef11.mc.runesofwizardry_classics.runes.RuneSarlacc;
import xilef11.mc.runesofwizardry_classics.runes.RuneSpawnerCollection;
import xilef11.mc.runesofwizardry_classics.runes.RuneSpawnerReassignment;
import xilef11.mc.runesofwizardry_classics.runes.RuneSpeed;
import xilef11.mc.runesofwizardry_classics.runes.RuneSpiritTools;
import xilef11.mc.runesofwizardry_classics.runes.RuneSpriteEarth;
import xilef11.mc.runesofwizardry_classics.runes.RuneSpriteFire;
import xilef11.mc.runesofwizardry_classics.runes.RuneTeleportation;
import xilef11.mc.runesofwizardry_classics.runes.RuneTorch;
import xilef11.mc.runesofwizardry_classics.runes.RuneTransport;
import xilef11.mc.runesofwizardry_classics.runes.RuneTrapCage;
import xilef11.mc.runesofwizardry_classics.runes.RuneTrapFire;
import xilef11.mc.runesofwizardry_classics.runes.RuneTrapLightning;
import xilef11.mc.runesofwizardry_classics.runes.RuneTrapPoison;
import xilef11.mc.runesofwizardry_classics.runes.RuneVoid;
import xilef11.mc.runesofwizardry_classics.runes.RuneWisdom;
/** Registers all the runes in the mod
 * @author Xilef11
 *
 */
public class ModRunes {
	private static List<ClassicRune> runes;
	public static List<ClassicRune> getRunes(){
		return runes;
	}
	public static void registerRunes(){
		for(ClassicRune rune:runes){
			DustRegistry.registerRune(rune,rune.getID());
		}
		if(Config.oldInscriptionEnchant)DustRegistry.registerRune(new RuneInscriptionEnchant(), "classicinscriptionenchant");
	}
	public static void initRunes(){
		runes = new LinkedList<>();
		runes.add(new RuneTorch());
		runes.add(new RuneRabbitHole());
		runes.add(new RuneHealing());
		runes.add(new RuneLumber());
		runes.add(new RuneFire());
		runes.add(new RuneDepths());
		runes.add(new RuneHeights());
		runes.add(new RuneFarm());
		runes.add(new RuneLeapingFrog());
		runes.add(new RuneDawn());
		//auto-inserted
		runes.add(new RuneDusk());
		runes.add(new RuneTrapFire());
		runes.add(new RuneTrapLightning());
		runes.add(new RuneTrapPoison());
		runes.add(new RuneDetonation());
		runes.add(new RuneTrapCage());
		runes.add(new RuneLockedTime());
		runes.add(new RuneVoid());
		runes.add(new RuneBarrier());
		runes.add(new RuneWisdom());
		runes.add(new RuneSpeed());
		runes.add(new RuneCompression());
		runes.add(new RuneHellstorm());
		runes.add(new RuneRebirth());
		//workaround for crash
		if(!Config.disableResurrection)runes.add(new RuneResurrection());
		runes.add(new RunePowerDistribution());
		runes.add(new RuneSpawnerCollection());
		if(!Config.disableWIP)runes.add(new RuneSpawnerReassignment());
		runes.add(new RuneTeleportation());
		runes.add(new RuneTransport());
		runes.add(new RuneSpriteFire());
		runes.add(new RuneSpriteEarth());
		runes.add(new RuneBouncing());
		runes.add(new RuneMusic());
		runes.add(new RuneSpiritTools());
		runes.add(new RuneEnchantingFireBow());
		runes.add(new RuneEnchantingSilkTouch());
		runes.add(new RuneEnchantingFortune());
		runes.add(new RuneProtection());
		runes.add(new RuneLevelEarth());
		runes.add(new RuneMountain());
		runes.add(new RuneSarlacc());
	}
}