// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.mcreator.swordcraftonline.SwordcraftonlineMod;
import java.util.Map;

public class FragrantOliveSwordLivingEntityIsHitWithToolProcedure
{
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("world") == null) {
            if (!dependencies.containsKey("world")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency world for procedure FragrantOliveSwordLivingEntityIsHitWithTool!");
            }
            return;
        }
        if (dependencies.get("x") == null) {
            if (!dependencies.containsKey("x")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency x for procedure FragrantOliveSwordLivingEntityIsHitWithTool!");
            }
            return;
        }
        if (dependencies.get("y") == null) {
            if (!dependencies.containsKey("y")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency y for procedure FragrantOliveSwordLivingEntityIsHitWithTool!");
            }
            return;
        }
        if (dependencies.get("z") == null) {
            if (!dependencies.containsKey("z")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency z for procedure FragrantOliveSwordLivingEntityIsHitWithTool!");
            }
            return;
        }
        final IWorld world = dependencies.get("world");
        final double x = (dependencies.get("x") instanceof Integer) ? dependencies.get("x") : dependencies.get("x");
        final double y = (dependencies.get("y") instanceof Integer) ? dependencies.get("y") : dependencies.get("y");
        final double z = (dependencies.get("z") instanceof Integer) ? dependencies.get("z") : dependencies.get("z");
        if (world instanceof ServerWorld) {
            final LightningBoltEntity _ent = (LightningBoltEntity)EntityType.field_200728_aG.func_200721_a((World)world);
            _ent.func_233576_c_(Vector3d.func_237492_c_((Vector3i)new BlockPos((int)x, (int)y, (int)z)));
            _ent.func_233623_a_(true);
            ((World)world).func_217376_c((Entity)_ent);
        }
    }
}
