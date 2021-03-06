package xilef11.mc.runesofwizardry_classics.managers;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xilef11.mc.runesofwizardry_classics.Refs;
import xilef11.mc.runesofwizardry_classics.RunesofWizardry_Classics;
public class VoidStorageCapability{
	@CapabilityInject(IVoidStorageCapability.class)
	public static Capability<IVoidStorageCapability> VOID_STORAGE_CAPABILITY=null;
	public static final ResourceLocation capabilityKey = new ResourceLocation(Refs.MODID,"voidstoragecapability");
	@SubscribeEvent
	public void onAttachCapability(AttachCapabilitiesEvent<Entity> event){
		if(event.getObject() instanceof EntityPlayer){
			event.addCapability(capabilityKey, new Provider());
		}
	}
	@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event){
		if(event.isWasDeath()){
			IVoidStorageCapability oldCap = event.getOriginal().getCapability(VOID_STORAGE_CAPABILITY, null);
			IVoidStorageCapability newCap = event.getEntityPlayer().getCapability(VOID_STORAGE_CAPABILITY, null);
			for(ItemStack i:oldCap.getVoidInventory()){
				newCap.addStackToVoid(i);
			}
		}
	}
	public static void register(){
		CapabilityManager.INSTANCE.register(IVoidStorageCapability.class, new Storage(), new Factory());
		MinecraftForge.EVENT_BUS.register(new VoidStorageCapability());
	}
	private static class Storage implements IStorage<IVoidStorageCapability> {
		@Override
		public NBTBase writeNBT(Capability<IVoidStorageCapability> capability,IVoidStorageCapability instance, EnumFacing side) {
			NBTTagList stacks = new NBTTagList();
			for(ItemStack i:instance.getVoidInventory()){
				if(!i.isEmpty()){
					NBTTagCompound comp = new NBTTagCompound();
					i.writeToNBT(comp);
					stacks.appendTag(comp);
				}
			}
			return stacks;
		}
		@Override
		public void readNBT(Capability<IVoidStorageCapability> capability,IVoidStorageCapability instance, EnumFacing side, NBTBase nbt) {
			if(nbt instanceof NBTTagList){
				NBTTagList list = (NBTTagList)nbt;
				for(int i=0;i<list.tagCount();i++){
					NBTTagCompound comp = list.getCompoundTagAt(i);
					if(comp!=null){
						instance.addStackToVoid(new ItemStack(comp));
					}
				}
			}else{
				RunesofWizardry_Classics.log().error("VoidStorageCapability storage attempted to read from wrong NBT tag type");
			}
		}
	}
	private static class Factory implements Callable<IVoidStorageCapability>{
		@Override
		public IVoidStorageCapability call() throws Exception {
			return new Implementation();
		}
	}
	private static class Implementation implements IVoidStorageCapability{
		private List<ItemStack> inv = new LinkedList<>();
		@Override
		public Collection<ItemStack> getVoidInventory() {
			return inv;
		}
		@Override
		public void addStackToVoid(ItemStack stack) {
			inv.add(stack);
		}
	}
	private static class Provider implements ICapabilityProvider, ICapabilitySerializable<NBTBase>{
		//Not sure what to do with this
		//http://mcforge.readthedocs.org/en/latest/datastorage/capabilities/
		private IVoidStorageCapability storage;
		public Provider() {
			storage = VOID_STORAGE_CAPABILITY.getDefaultInstance();
		}
		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
			if(capability == VOID_STORAGE_CAPABILITY)return true;
			return false;
			//return super.hasCapability(capability,facing);
		}
		//fry> if you're on 1.9, do CAPABILITY_INSTANCE.cast(cap)
		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
			if(capability==VOID_STORAGE_CAPABILITY){
				return VOID_STORAGE_CAPABILITY.cast(storage);
			}
			return null;
		}
		@Override
		public NBTBase serializeNBT() {
			return VOID_STORAGE_CAPABILITY.getStorage().writeNBT(VOID_STORAGE_CAPABILITY, storage, null);
		}
		@Override
		public void deserializeNBT(NBTBase nbt) {
			VOID_STORAGE_CAPABILITY.getStorage().readNBT(VOID_STORAGE_CAPABILITY, storage, null, nbt);
		}
	}
}
