// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.procedures;

import net.minecraft.inventory.IInventory;
import net.minecraft.world.IServerWorld;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.mcreator.swordcraftonline.entity.FanatioEntity;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.mcreator.swordcraftonline.item.FanatioSummonerItem;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.world.IWorld;
import net.mcreator.swordcraftonline.SwordcraftonlineMod;
import java.util.Map;

public class FanatioSummonerRightClickedInAirProcedure
{
    public static void executeProcedure(final Map<String, Object> dependencies) {
        if (dependencies.get("world") == null) {
            if (!dependencies.containsKey("world")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency world for procedure FanatioSummonerRightClickedInAir!");
            }
            return;
        }
        if (dependencies.get("x") == null) {
            if (!dependencies.containsKey("x")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency x for procedure FanatioSummonerRightClickedInAir!");
            }
            return;
        }
        if (dependencies.get("y") == null) {
            if (!dependencies.containsKey("y")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency y for procedure FanatioSummonerRightClickedInAir!");
            }
            return;
        }
        if (dependencies.get("z") == null) {
            if (!dependencies.containsKey("z")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency z for procedure FanatioSummonerRightClickedInAir!");
            }
            return;
        }
        if (dependencies.get("entity") == null) {
            if (!dependencies.containsKey("entity")) {
                SwordcraftonlineMod.LOGGER.warn("Failed to load dependency entity for procedure FanatioSummonerRightClickedInAir!");
            }
            return;
        }
        final IWorld world = dependencies.get("world");
        final double x = (dependencies.get("x") instanceof Integer) ? dependencies.get("x") : dependencies.get("x");
        final double y = (dependencies.get("y") instanceof Integer) ? dependencies.get("y") : dependencies.get("y");
        final double z = (dependencies.get("z") instanceof Integer) ? dependencies.get("z") : dependencies.get("z");
        final Entity entity = dependencies.get("entity");
        if (world.func_201670_d()) {
            Minecraft.func_71410_x().field_71460_t.func_190565_a(new ItemStack((IItemProvider)FanatioSummonerItem.block));
        }
        world.func_195594_a((IParticleData)ParticleTypes.field_197604_O, x * 1.0, y * 1.0, z * 1.0, 1.0, 1.0, 1.0);
        if (world instanceof World && !world.func_201670_d()) {
            ((World)world).func_184133_a((PlayerEntity)null, new BlockPos((int)x, (int)y, (int)z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundCategory.NEUTRAL, 1.0f, 1.0f);
        }
        else {
            ((World)world).func_184134_a(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundCategory.NEUTRAL, 1.0f, 1.0f, false);
        }
        if (world instanceof ServerWorld) {
            final Entity entityToSpawn = (Entity)new FanatioEntity.CustomEntity((EntityType<FanatioEntity.CustomEntity>)FanatioEntity.entity, (World)world);
            entityToSpawn.func_70012_b(x, y, z, 0.0f, 0.0f);
            entityToSpawn.func_181013_g(0.0f);
            entityToSpawn.func_70034_d(0.0f);
            if (entityToSpawn instanceof MobEntity) {
                ((MobEntity)entityToSpawn).func_213386_a((IServerWorld)world, world.func_175649_E(entityToSpawn.func_233580_cy_()), SpawnReason.MOB_SUMMONED, (ILivingEntityData)null, (CompoundNBT)null);
            }
            world.func_217376_c(entityToSpawn);
        }
        if (entity instanceof PlayerEntity) {
            final ItemStack _stktoremove = new ItemStack((IItemProvider)FanatioSummonerItem.block);
            ((PlayerEntity)entity).field_71071_by.func_234564_a_(p -> _stktoremove.func_77973_b() == p.func_77973_b(), 1, (IInventory)((PlayerEntity)entity).field_71069_bz.func_234641_j_());
        }
    }
}
