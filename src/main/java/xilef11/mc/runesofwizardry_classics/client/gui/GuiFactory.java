/** * */package xilef11.mc.runesofwizardry_classics.client.gui;import java.util.Set;import com.zpig333.runesofwizardry.client.gui.ModGuiConfig;import net.minecraft.client.Minecraft;import net.minecraft.client.gui.GuiScreen;import net.minecraftforge.fml.client.IModGuiFactory;/** * @author Xilef11 * */public class GuiFactory implements IModGuiFactory {	/* (non-Javadoc)	 * @see cpw.mods.fml.client.IModGuiFactory#initialize(net.minecraft.client.Minecraft)	 */	@Override	public void initialize(Minecraft minecraftInstance) {		//might not be used	}	/* (non-Javadoc)	 * @see cpw.mods.fml.client.IModGuiFactory#runtimeGuiCategories()	 */	@Override	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {		//Might not be used		return null;	}	@Override	public boolean hasConfigGui() {		return true;	}	@Override	public GuiScreen createConfigGui(GuiScreen parentScreen) {		return new ModGuiConfig(parentScreen);	}}