package net.mcreator.perplayeritem.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.perplayeritem.item.Disc42Item;
import net.mcreator.perplayeritem.Perplayeritem1ModVariables;
import net.mcreator.perplayeritem.Perplayeritem1Mod;

import java.util.Map;

public class Disc42pickupProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				Perplayeritem1Mod.LOGGER.warn("Failed to load dependency world for procedure Disc42pickup!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Perplayeritem1Mod.LOGGER.warn("Failed to load dependency entity for procedure Disc42pickup!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (Perplayeritem1ModVariables.MapVariables.get(world).d42 == 0) {
			if ((entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new Perplayeritem1ModVariables.PlayerVariables())).d42p == 0) {
				if ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Disc42Item.block)) : false) {
					Perplayeritem1ModVariables.MapVariables.get(world).d42 = (double) 1;
					Perplayeritem1ModVariables.MapVariables.get(world).syncData(world);
					{
						double _setval = (double) 1;
						entity.getCapability(Perplayeritem1ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.d42p = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
