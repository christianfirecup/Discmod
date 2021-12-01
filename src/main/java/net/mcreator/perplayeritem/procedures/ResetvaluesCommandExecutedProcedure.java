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
	}
}
