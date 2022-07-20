// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.entity;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraft.network.IPacket;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.MobEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import java.util.function.BiFunction;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.entity.EntityClassification;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.common.MinecraftForge;
import net.mcreator.swordcraftonline.entity.renderer.SlayerRenderer;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.entity.EntityType;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements.ModElement;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements;

@Tag
public class SlayerEntity extends SwordcraftonlineModElements.ModElement
{
    public static EntityType entity;
    
    public SlayerEntity(final SwordcraftonlineModElements instance) {
        super(instance, 310);
        FMLJavaModLoadingContext.get().getModEventBus().register((Object)new SlayerRenderer.ModelRegisterHandler());
        FMLJavaModLoadingContext.get().getModEventBus().register((Object)new EntityAttributesRegisterHandler());
        MinecraftForge.EVENT_BUS.register((Object)this);
    }
    
    @Override
    public void initElements() {
        this.elements.entities.add(() -> SlayerEntity.entity);
        final SpawnEggItem spawnEggItem;
        this.elements.items.add(() -> {
            new SpawnEggItem(SlayerEntity.entity, -13691627, -15597568, new Item.Properties().func_200916_a(ItemGroup.field_78026_f));
            return (Item)spawnEggItem.setRegistryName("slayer_spawn_egg");
        });
    }
    
    @SubscribeEvent
    public void addFeatureToBiomes(final BiomeLoadingEvent event) {
        event.getSpawns().getSpawner(EntityClassification.MONSTER).add(new MobSpawnInfo.Spawners(SlayerEntity.entity, 20, 1, 4));
    }
    
    @Override
    public void init(final FMLCommonSetupEvent event) {
        EntitySpawnPlacementRegistry.func_209343_a(SlayerEntity.entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223324_d);
    }
    
    static {
        SlayerEntity.entity = (EntityType)EntityType.Builder.func_220322_a(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3).setCustomClientFactory((BiFunction)CustomEntity::new).func_220321_a(0.6f, 1.8f).func_206830_a("slayer").setRegistryName("slayer");
    }
    
    private static class EntityAttributesRegisterHandler
    {
        @SubscribeEvent
        public void onEntityAttributeCreation(final EntityAttributeCreationEvent event) {
            AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
            ammma = ammma.func_233815_a_(Attributes.field_233821_d_, 0.3);
            ammma = ammma.func_233815_a_(Attributes.field_233818_a_, 100.0);
            ammma = ammma.func_233815_a_(Attributes.field_233826_i_, 20.0);
            ammma = ammma.func_233815_a_(Attributes.field_233823_f_, 4.0);
            ammma = ammma.func_233815_a_(Attributes.field_233820_c_, 0.3);
            ammma = ammma.func_233815_a_(Attributes.field_233824_g_, 0.6);
            event.put(SlayerEntity.entity, ammma.func_233813_a_());
        }
    }
    
    public static class CustomEntity extends MonsterEntity
    {
        public CustomEntity(final FMLPlayMessages.SpawnEntity packet, final World world) {
            this((EntityType<CustomEntity>)SlayerEntity.entity, world);
        }
        
        public CustomEntity(final EntityType<CustomEntity> type, final World world) {
            super((EntityType)type, world);
            this.field_70728_aV = 15;
            this.func_94061_f(false);
            this.func_184201_a(EquipmentSlotType.MAINHAND, new ItemStack((IItemProvider)Items.field_151040_l));
        }
        
        public IPacket<?> func_213297_N() {
            return (IPacket<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
        }
        
        protected void func_184651_r() {
            super.func_184651_r();
            this.field_70715_bh.func_75776_a(1, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true, false));
            this.field_70715_bh.func_75776_a(2, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)VillagerEntity.class, true, false));
            this.field_70715_bh.func_75776_a(3, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)GolemEntity.class, true, false));
            this.field_70714_bg.func_75776_a(4, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.2, false));
            this.field_70715_bh.func_75776_a(5, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
            this.field_70714_bg.func_75776_a(6, (Goal)new RandomWalkingGoal((CreatureEntity)this, 1.0));
            this.field_70714_bg.func_75776_a(7, (Goal)new LookRandomlyGoal((MobEntity)this));
            this.field_70714_bg.func_75776_a(8, (Goal)new SwimGoal((MobEntity)this));
        }
        
        public CreatureAttribute func_70668_bt() {
            return CreatureAttribute.field_223222_a_;
        }
        
        public SoundEvent func_184601_bQ(final DamageSource ds) {
            return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
        }
        
        public SoundEvent func_184615_bR() {
            return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("swordcraftonline:break_sound"));
        }
    }
}
