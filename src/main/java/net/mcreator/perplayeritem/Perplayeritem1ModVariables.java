package net.mcreator.perplayeritem;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.IServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class Perplayeritem1ModVariables {
	public Perplayeritem1ModVariables(Perplayeritem1ModElements elements) {
		elements.addNetworkMessage(WorldSavedDataSyncMessage.class, WorldSavedDataSyncMessage::buffer, WorldSavedDataSyncMessage::new,
				WorldSavedDataSyncMessage::handler);
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData mapdata = MapVariables.get(event.getPlayer().world);
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (mapdata != null)
				Perplayeritem1Mod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				Perplayeritem1Mod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (worlddata != null)
				Perplayeritem1Mod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "perplayeritem1_worldvars";

		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				Perplayeritem1Mod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(((World) world)::getDimensionKey),
						new WorldSavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(IWorld world) {
			if (world instanceof ServerWorld) {
				return ((ServerWorld) world).getSavedData().getOrCreate(WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends WorldSavedData {
		public static final String DATA_NAME = "perplayeritem1_mapvars";
		public double disk1 = 0;
		public double disk2 = 0;
		public double d3 = 0;
		public double d4 = 0;
		public double d5 = 0;
		public double d6 = 0.0;
		public double d7 = 0;
		public double d8 = 0;
		public double d9 = 0;
		public double d10 = 0;
		public double d11 = 0;
		public double d12 = 0;
		public double d13 = 0;
		public double d14 = 0;
		public double d15 = 0;
		public double d16 = 0;
		public double d17 = 0;
		public double d18 = 0;
		public double d19 = 0;
		public double d20 = 0;
		public double d21 = 0;
		public double d22 = 0;
		public double d23 = 0;
		public double d24 = 0;
		public double d25 = 0;
		public double d26 = 0;
		public double d27 = 0;
		public double d28 = 0;
		public double d29 = 0;
		public double d30 = 0;

		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			disk1 = nbt.getDouble("disk1");
			disk2 = nbt.getDouble("disk2");
			d3 = nbt.getDouble("d3");
			d4 = nbt.getDouble("d4");
			d5 = nbt.getDouble("d5");
			d6 = nbt.getDouble("d6");
			d7 = nbt.getDouble("d7");
			d8 = nbt.getDouble("d8");
			d9 = nbt.getDouble("d9");
			d10 = nbt.getDouble("d10");
			d11 = nbt.getDouble("d11");
			d12 = nbt.getDouble("d12");
			d13 = nbt.getDouble("d13");
			d14 = nbt.getDouble("d14");
			d15 = nbt.getDouble("d15");
			d16 = nbt.getDouble("d16");
			d17 = nbt.getDouble("d17");
			d18 = nbt.getDouble("d18");
			d19 = nbt.getDouble("d19");
			d20 = nbt.getDouble("d20");
			d21 = nbt.getDouble("d21");
			d22 = nbt.getDouble("d22");
			d23 = nbt.getDouble("d23");
			d24 = nbt.getDouble("d24");
			d25 = nbt.getDouble("d25");
			d26 = nbt.getDouble("d26");
			d27 = nbt.getDouble("d27");
			d28 = nbt.getDouble("d28");
			d29 = nbt.getDouble("d29");
			d30 = nbt.getDouble("d30");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putDouble("disk1", disk1);
			nbt.putDouble("disk2", disk2);
			nbt.putDouble("d3", d3);
			nbt.putDouble("d4", d4);
			nbt.putDouble("d5", d5);
			nbt.putDouble("d6", d6);
			nbt.putDouble("d7", d7);
			nbt.putDouble("d8", d8);
			nbt.putDouble("d9", d9);
			nbt.putDouble("d10", d10);
			nbt.putDouble("d11", d11);
			nbt.putDouble("d12", d12);
			nbt.putDouble("d13", d13);
			nbt.putDouble("d14", d14);
			nbt.putDouble("d15", d15);
			nbt.putDouble("d16", d16);
			nbt.putDouble("d17", d17);
			nbt.putDouble("d18", d18);
			nbt.putDouble("d19", d19);
			nbt.putDouble("d20", d20);
			nbt.putDouble("d21", d21);
			nbt.putDouble("d22", d22);
			nbt.putDouble("d23", d23);
			nbt.putDouble("d24", d24);
			nbt.putDouble("d25", d25);
			nbt.putDouble("d26", d26);
			nbt.putDouble("d27", d27);
			nbt.putDouble("d28", d28);
			nbt.putDouble("d29", d29);
			nbt.putDouble("d30", d30);
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				Perplayeritem1Mod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new WorldSavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(IWorld world) {
			if (world instanceof IServerWorld) {
				return ((IServerWorld) world).getWorld().getServer().getWorld(World.OVERWORLD).getSavedData().getOrCreate(MapVariables::new,
						DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class WorldSavedDataSyncMessage {
		public int type;
		public WorldSavedData data;

		public WorldSavedDataSyncMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			this.data.read(buffer.readCompoundTag());
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(WorldSavedDataSyncMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeCompoundTag(message.data.write(new CompoundNBT()));
		}

		public static void handler(WorldSavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;

	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("perplayeritem1", "player_variables"), new PlayerVariablesProvider());
	}

	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putDouble("disk1player", instance.disk1player);
			nbt.putDouble("disk2player", instance.disk2player);
			nbt.putDouble("d3p", instance.d3p);
			nbt.putDouble("d4p", instance.d4p);
			nbt.putDouble("d5p", instance.d5p);
			nbt.putDouble("d6p", instance.d6p);
			nbt.putDouble("d7p", instance.d7p);
			nbt.putDouble("d8p", instance.d8p);
			nbt.putDouble("d9p", instance.d9p);
			nbt.putDouble("d10p", instance.d10p);
			nbt.putDouble("d11p", instance.d11p);
			nbt.putDouble("d12p", instance.d12p);
			nbt.putDouble("d13p", instance.d13p);
			nbt.putDouble("d14p", instance.d14p);
			nbt.putDouble("d15p", instance.d15p);
			nbt.putDouble("d17p", instance.d17p);
			nbt.putDouble("d18p", instance.d18p);
			nbt.putDouble("d19p", instance.d19p);
			nbt.putDouble("d16p", instance.d16p);
			nbt.putDouble("d21p", instance.d21p);
			nbt.putDouble("d22p", instance.d22p);
			nbt.putDouble("d23p", instance.d23p);
			nbt.putDouble("d24p", instance.d24p);
			nbt.putDouble("d25p", instance.d25p);
			nbt.putDouble("d26p", instance.d26p);
			nbt.putDouble("d27p", instance.d27p);
			nbt.putDouble("d28p", instance.d28p);
			nbt.putDouble("d29p", instance.d29p);
			nbt.putDouble("d30p", instance.d30p);
			nbt.putDouble("d20p", instance.d20p);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.disk1player = nbt.getDouble("disk1player");
			instance.disk2player = nbt.getDouble("disk2player");
			instance.d3p = nbt.getDouble("d3p");
			instance.d4p = nbt.getDouble("d4p");
			instance.d5p = nbt.getDouble("d5p");
			instance.d6p = nbt.getDouble("d6p");
			instance.d7p = nbt.getDouble("d7p");
			instance.d8p = nbt.getDouble("d8p");
			instance.d9p = nbt.getDouble("d9p");
			instance.d10p = nbt.getDouble("d10p");
			instance.d11p = nbt.getDouble("d11p");
			instance.d12p = nbt.getDouble("d12p");
			instance.d13p = nbt.getDouble("d13p");
			instance.d14p = nbt.getDouble("d14p");
			instance.d15p = nbt.getDouble("d15p");
			instance.d17p = nbt.getDouble("d17p");
			instance.d18p = nbt.getDouble("d18p");
			instance.d19p = nbt.getDouble("d19p");
			instance.d16p = nbt.getDouble("d16p");
			instance.d21p = nbt.getDouble("d21p");
			instance.d22p = nbt.getDouble("d22p");
			instance.d23p = nbt.getDouble("d23p");
			instance.d24p = nbt.getDouble("d24p");
			instance.d25p = nbt.getDouble("d25p");
			instance.d26p = nbt.getDouble("d26p");
			instance.d27p = nbt.getDouble("d27p");
			instance.d28p = nbt.getDouble("d28p");
			instance.d29p = nbt.getDouble("d29p");
			instance.d30p = nbt.getDouble("d30p");
			instance.d20p = nbt.getDouble("d20p");
		}
	}

	public static class PlayerVariables {
		public double disk1player = 0;
		public double disk2player = 0;
		public double d3p = 0;
		public double d4p = 0;
		public double d5p = 0;
		public double d6p = 0;
		public double d7p = 0;
		public double d8p = 0;
		public double d9p = 0;
		public double d10p = 0;
		public double d11p = 0;
		public double d12p = 0;
		public double d13p = 0;
		public double d14p = 0;
		public double d15p = 0;
		public double d17p = 0;
		public double d18p = 0;
		public double d19p = 0;
		public double d16p = 0;
		public double d21p = 0;
		public double d22p = 0;
		public double d23p = 0;
		public double d24p = 0;
		public double d25p = 0;
		public double d26p = 0;
		public double d27p = 0;
		public double d28p = 0;
		public double d29p = 0;
		public double d30p = 0;
		public double d20p = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				Perplayeritem1Mod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
		if (!event.isWasDeath()) {
			clone.disk1player = original.disk1player;
			clone.disk2player = original.disk2player;
			clone.d3p = original.d3p;
			clone.d4p = original.d4p;
			clone.d5p = original.d5p;
			clone.d6p = original.d6p;
			clone.d7p = original.d7p;
			clone.d8p = original.d8p;
			clone.d9p = original.d9p;
			clone.d10p = original.d10p;
			clone.d11p = original.d11p;
			clone.d12p = original.d12p;
			clone.d13p = original.d13p;
			clone.d14p = original.d14p;
			clone.d15p = original.d15p;
			clone.d17p = original.d17p;
			clone.d18p = original.d18p;
			clone.d19p = original.d19p;
			clone.d16p = original.d16p;
			clone.d21p = original.d21p;
			clone.d22p = original.d22p;
			clone.d23p = original.d23p;
			clone.d24p = original.d24p;
			clone.d25p = original.d25p;
			clone.d26p = original.d26p;
			clone.d27p = original.d27p;
			clone.d28p = original.d28p;
			clone.d29p = original.d29p;
			clone.d30p = original.d30p;
			clone.d20p = original.d20p;
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.disk1player = message.data.disk1player;
					variables.disk2player = message.data.disk2player;
					variables.d3p = message.data.d3p;
					variables.d4p = message.data.d4p;
					variables.d5p = message.data.d5p;
					variables.d6p = message.data.d6p;
					variables.d7p = message.data.d7p;
					variables.d8p = message.data.d8p;
					variables.d9p = message.data.d9p;
					variables.d10p = message.data.d10p;
					variables.d11p = message.data.d11p;
					variables.d12p = message.data.d12p;
					variables.d13p = message.data.d13p;
					variables.d14p = message.data.d14p;
					variables.d15p = message.data.d15p;
					variables.d17p = message.data.d17p;
					variables.d18p = message.data.d18p;
					variables.d19p = message.data.d19p;
					variables.d16p = message.data.d16p;
					variables.d21p = message.data.d21p;
					variables.d22p = message.data.d22p;
					variables.d23p = message.data.d23p;
					variables.d24p = message.data.d24p;
					variables.d25p = message.data.d25p;
					variables.d26p = message.data.d26p;
					variables.d27p = message.data.d27p;
					variables.d28p = message.data.d28p;
					variables.d29p = message.data.d29p;
					variables.d30p = message.data.d30p;
					variables.d20p = message.data.d20p;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
