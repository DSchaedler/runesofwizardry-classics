/**
 *
 */
package xilef11.mc.runesofwizardry_classics.client.gui;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import xilef11.mc.runesofwizardry_classics.Config;
import xilef11.mc.runesofwizardry_classics.Refs;
/**
 * @author Xilef11
 *
 */
public class ModGuiConfig extends GuiConfig {
	public ModGuiConfig(GuiScreen screen) {
		super(screen, getConfigElements(),
				Refs.MODID, false, false,
				GuiConfig.getAbridgedConfigPath(Config.config.toString()));
	}
	private static List<IConfigElement> getConfigElements() {
		List<IConfigElement> res = new LinkedList<>();
		for(String cat:Config.config.getCategoryNames()){
			res.add(new ConfigElement(Config.config.getCategory(cat)));
		}
		return res;
	}
}