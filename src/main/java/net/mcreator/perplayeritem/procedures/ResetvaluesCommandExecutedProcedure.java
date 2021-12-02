package net.mcreator.perplayeritem.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.perplayeritem.Perplayeritem1ModVariables;
import net.mcreator.perplayeritem.Perplayeritem1Mod;

import java.util.Map;

public class ResetvaluesCommandExecutedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				Perplayeritem1Mod.LOGGER.warn("Failed to load dependency world for procedure ResetvaluesCommandExecuted!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Perplayeritem1Mod.LOGGER.warn("Failed to load dependency entity for procedure ResetvaluesCommandExecuted!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		Perplayeritem1ModVariables.MapVariables.get(world).disk1 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.disk1player = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).disk2 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.disk2player = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).d3 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.d3p = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).d4 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.d4p = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).d5 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.d5p = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).d6 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.d6p = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).d7 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.d7p = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).d8 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.d8p = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).d9 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.d9p = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).d10 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.d10p = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).d11 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.d11p = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).d12 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.d12p = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.d13p = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).d13 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		Perplayeritem1ModVariables.MapVariables.get(world).d14 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.d14p = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).d15 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.d15p = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).d16 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.d16p = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).d17 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.d17p = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).d18 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.d18p = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).d19 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
		{
			double _setval = (double) 0;
			entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.d19p = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		Perplayeritem1ModVariables.MapVariables.get(world).d20 = (double) 0;
		Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
	}
}
