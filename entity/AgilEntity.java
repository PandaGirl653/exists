// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.SoundEvent;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.OpenDoorGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraft.network.IPacket;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.mcreator.swordcraftonline.item.MaceItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.MobEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import java.util.function.BiFunction;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.entity.EntityClassification;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.common.MinecraftForge;
import net.mcreator.swordcraftonline.entity.renderer.AgilRenderer;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.entity.EntityType;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements.ModElement;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements;

@Tag
public class AgilEntity extends SwordcraftonlineModElements.ModElement
{
    public static EntityType entity;
    
    public AgilEntity(final SwordcraftonlineModElements instance) {
        super(instance, 218);
        FMLJavaModLoadingContext.get().getModEventBus().register((Object)new AgilRenderer.ModelRegisterHandler());
        FMLJavaModLoadingContext.get().getModEventBus().register((Object)new EntityAttributesRegisterHandler());
        MinecraftForge.EVENT_BUS.register((Object)this);
    }
    
    @Override
    public void initElements() {
        this.elements.entities.add(() -> AgilEntity.entity);
        final SpawnEggItem spawnEggItem;
        this.elements.items.add(() -> {
            new SpawnEggItem(AgilEntity.entity, -13556458, -14936297, new Item.Properties().func_200916_a(ItemGroup.field_78026_f));
            return (Item)spawnEggItem.setRegistryName("agil_spawn_egg");
        });
    }
    
    @SubscribeEvent
    public void addFeatureToBiomes(final BiomeLoadingEvent event) {
        boolean biomeCriteria = false;
        if (new ResourceLocation("mountains").equals((Object)event.getName())) {
            biomeCriteria = true;
        }
        if (new ResourceLocation("gravelly_mountains").equals((Object)event.getName())) {
            biomeCriteria = true;
        }
        if (new ResourceLocation("modified_gravelly_mountains").equals((Object)event.getName())) {
            biomeCriteria = true;
        }
        if (new ResourceLocation("mountain_edge").equals((Object)event.getName())) {
            biomeCriteria = true;
        }
        if (new ResourceLocation("snowy_mountains").equals((Object)event.getName())) {
            biomeCriteria = true;
        }
        if (new ResourceLocation("snowy_taiga_mountains").equals((Object)event.getName())) {
            biomeCriteria = true;
        }
        if (new ResourceLocation("taiga_mountains").equals((Object)event.getName())) {
            biomeCriteria = true;
        }
        if (new ResourceLocation("wooded_mountains").equals((Object)event.getName())) {
            biomeCriteria = true;
        }
        if (!biomeCriteria) {
            return;
        }
        event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(AgilEntity.entity, 1, 1, 1));
    }
    
    @Override
    public void init(final FMLCommonSetupEvent event) {
        EntitySpawnPlacementRegistry.func_209343_a(AgilEntity.entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> world.func_180495_p(pos.func_177977_b()).func_185904_a() == Material.field_151577_b && world.func_226659_b_(pos, 0) > 8);
    }
    
    static {
        AgilEntity.entity = (EntityType)EntityType.Builder.func_220322_a(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3).setCustomClientFactory((BiFunction)CustomEntity::new).func_220321_a(0.6f, 1.8f).func_206830_a("agil").setRegistryName("agil");
    }
    
    private static class EntityAttributesRegisterHandler
    {
        @SubscribeEvent
        public void onEntityAttributeCreation(final EntityAttributeCreationEvent event) {
            AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
            ammma = ammma.func_233815_a_(Attributes.field_233821_d_, 0.3);
            ammma = ammma.func_233815_a_(Attributes.field_233818_a_, 200.0);
            ammma = ammma.func_233815_a_(Attributes.field_233826_i_, 20.0);
            ammma = ammma.func_233815_a_(Attributes.field_233823_f_, 8.0);
            ammma = ammma.func_233815_a_(Attributes.field_233824_g_, 0.5);
            event.put(AgilEntity.entity, ammma.func_233813_a_());
        }
    }
    
    public static class CustomEntity extends CreatureEntity
    {
        public CustomEntity(final FMLPlayMessages.SpawnEntity packet, final World world) {
            this((EntityType<CustomEntity>)AgilEntity.entity, world);
        }
        
        public CustomEntity(final EntityType<CustomEntity> type, final World world) {
            super((EntityType)type, world);
            this.field_70728_aV = 50;
            this.func_94061_f(false);
            this.func_200203_b((ITextComponent)new StringTextComponent("Agil"));
            this.func_174805_g(true);
            this.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)MaceItem.block));
        }
        
        public IPacket<?> func_213297_N() {
            return (IPacket<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
        }
        
        protected void func_184651_r() {
            super.func_184651_r();
            this.field_70714_bg.func_75776_a(1, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.2, false));
            this.field_70715_bh.func_75776_a(2, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
            this.field_70714_bg.func_75776_a(3, (Goal)new RandomWalkingGoal((CreatureEntity)this, 1.0));
            this.field_70714_bg.func_75776_a(4, (Goal)new OpenDoorGoal((MobEntity)this, true));
            this.field_70714_bg.func_75776_a(5, (Goal)new OpenDoorGoal((MobEntity)this, false));
            this.field_70714_bg.func_75776_a(6, (Goal)new LookRandomlyGoal((MobEntity)this));
            this.field_70714_bg.func_75776_a(7, (Goal)new SwimGoal((MobEntity)this));
        }
        
        public CreatureAttribute func_70668_bt() {
            return CreatureAttribute.field_223222_a_;
        }
        
        protected void func_213333_a(final DamageSource source, final int looting, final boolean recentlyHitIn) {
            super.func_213333_a(source, looting, recentlyHitIn);
            this.func_199701_a_(new ItemStack((IItemProvider)Items.field_151042_j));
        }
        
        public SoundEvent func_184601_bQ(final DamageSource ds) {
            return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
        }
        
        public SoundEvent func_184615_bR() {
            return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("swordcraftonline:break_sound"));
        }
    }
}
