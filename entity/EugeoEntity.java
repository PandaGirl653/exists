// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.entity;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.PotionEntity;
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
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraft.network.IPacket;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.MobEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import java.util.function.BiFunction;
import net.minecraft.entity.EntityClassification;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.mcreator.swordcraftonline.entity.renderer.EugeoRenderer;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.entity.EntityType;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements.ModElement;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements;

@Tag
public class EugeoEntity extends SwordcraftonlineModElements.ModElement
{
    public static EntityType entity;
    
    public EugeoEntity(final SwordcraftonlineModElements instance) {
        super(instance, 241);
        FMLJavaModLoadingContext.get().getModEventBus().register((Object)new EugeoRenderer.ModelRegisterHandler());
        FMLJavaModLoadingContext.get().getModEventBus().register((Object)new EntityAttributesRegisterHandler());
    }
    
    @Override
    public void initElements() {
        this.elements.entities.add(() -> EugeoEntity.entity);
        final SpawnEggItem spawnEggItem;
        this.elements.items.add(() -> {
            new SpawnEggItem(EugeoEntity.entity, -11094273, -13934194, new Item.Properties().func_200916_a(ItemGroup.field_78026_f));
            return (Item)spawnEggItem.setRegistryName("eugeo_spawn_egg");
        });
    }
    
    @Override
    public void init(final FMLCommonSetupEvent event) {
    }
    
    static {
        EugeoEntity.entity = (EntityType)EntityType.Builder.func_220322_a(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3).setCustomClientFactory((BiFunction)CustomEntity::new).func_220320_c().func_220321_a(0.6f, 1.8f).func_206830_a("eugeo").setRegistryName("eugeo");
    }
    
    private static class EntityAttributesRegisterHandler
    {
        @SubscribeEvent
        public void onEntityAttributeCreation(final EntityAttributeCreationEvent event) {
            AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
            ammma = ammma.func_233815_a_(Attributes.field_233821_d_, 0.3);
            ammma = ammma.func_233815_a_(Attributes.field_233818_a_, 400.0);
            ammma = ammma.func_233815_a_(Attributes.field_233826_i_, 30.0);
            ammma = ammma.func_233815_a_(Attributes.field_233823_f_, 15.0);
            ammma = ammma.func_233815_a_(Attributes.field_233820_c_, 0.5);
            ammma = ammma.func_233815_a_(Attributes.field_233824_g_, 0.7);
            event.put(EugeoEntity.entity, ammma.func_233813_a_());
        }
    }
    
    public static class CustomEntity extends MonsterEntity
    {
        private final ServerBossInfo bossInfo;
        
        public CustomEntity(final FMLPlayMessages.SpawnEntity packet, final World world) {
            this((EntityType<CustomEntity>)EugeoEntity.entity, world);
        }
        
        public CustomEntity(final EntityType<CustomEntity> type, final World world) {
            super((EntityType)type, world);
            this.bossInfo = new ServerBossInfo(this.func_145748_c_(), BossInfo.Color.YELLOW, BossInfo.Overlay.PROGRESS);
            this.field_70728_aV = 1395;
            this.func_94061_f(false);
            this.func_200203_b((ITextComponent)new StringTextComponent("Eugeo"));
            this.func_174805_g(true);
            this.func_110163_bv();
        }
        
        public IPacket<?> func_213297_N() {
            return (IPacket<?>)NetworkHooks.getEntitySpawningPacket((Entity)this);
        }
        
        protected void func_184651_r() {
            super.func_184651_r();
            this.field_70715_bh.func_75776_a(1, (Goal)new NearestAttackableTargetGoal((MobEntity)this, (Class)PlayerEntity.class, true, false));
            this.field_70714_bg.func_75776_a(2, (Goal)new MeleeAttackGoal((CreatureEntity)this, 1.2, false));
            this.field_70715_bh.func_75776_a(3, (Goal)new HurtByTargetGoal((CreatureEntity)this, new Class[0]));
            this.field_70714_bg.func_75776_a(4, (Goal)new RandomWalkingGoal((CreatureEntity)this, 1.0));
            this.field_70714_bg.func_75776_a(5, (Goal)new LookRandomlyGoal((MobEntity)this));
            this.field_70714_bg.func_75776_a(6, (Goal)new SwimGoal((MobEntity)this));
        }
        
        public CreatureAttribute func_70668_bt() {
            return CreatureAttribute.field_223222_a_;
        }
        
        public boolean func_213397_c(final double distanceToClosestPlayer) {
            return false;
        }
        
        public SoundEvent func_184601_bQ(final DamageSource ds) {
            return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
        }
        
        public SoundEvent func_184615_bR() {
            return (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("swordcraftonline:break_sound"));
        }
        
        public boolean func_70097_a(final DamageSource source, final float amount) {
            return !(source.func_76364_f() instanceof PotionEntity) && source != DamageSource.field_76379_h && source != DamageSource.field_76367_g && source != DamageSource.field_76369_e && source != DamageSource.field_180137_b && !source.func_94541_c() && source != DamageSource.field_82728_o && source != DamageSource.field_188407_q && source != DamageSource.field_82727_n && !source.func_76355_l().equals("witherSkull") && super.func_70097_a(source, amount);
        }
        
        public boolean func_184222_aU() {
            return false;
        }
        
        public void func_184178_b(final ServerPlayerEntity player) {
            super.func_184178_b(player);
            this.bossInfo.func_186760_a(player);
        }
        
        public void func_184203_c(final ServerPlayerEntity player) {
            super.func_184203_c(player);
            this.bossInfo.func_186761_b(player);
        }
        
        public void func_70619_bc() {
            super.func_70619_bc();
            this.bossInfo.func_186735_a(this.func_110143_aJ() / this.func_110138_aP());
        }
    }
}
