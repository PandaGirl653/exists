// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.block;

import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraft.block.Blocks;
import java.util.Random;
import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.template.RuleTest;
import java.util.Collections;
import net.minecraft.util.IItemProvider;
import net.mcreator.swordcraftonline.item.CrystalliteIngotItem;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.loot.LootContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.block.BlockState;
import net.minecraftforge.common.ToolType;
import net.minecraft.block.SoundType;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraft.world.gen.feature.template.IRuleTestType;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.block.Block;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements.ModElement;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements;

@Tag
public class CrystalliteOreBlock extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:crystallite_ore")
    public static final Block block;
    private static Feature<OreFeatureConfig> feature;
    private static ConfiguredFeature<?, ?> configuredFeature;
    private static IRuleTestType<CustomRuleTest> CUSTOM_MATCH;
    
    public CrystalliteOreBlock(final SwordcraftonlineModElements instance) {
        super(instance, 42);
        MinecraftForge.EVENT_BUS.register((Object)this);
        FMLJavaModLoadingContext.get().getModEventBus().register((Object)new FeatureRegisterHandler());
    }
    
    @Override
    public void initElements() {
        this.elements.blocks.add(() -> new CustomBlock());
        final BlockItem blockItem;
        this.elements.items.add(() -> {
            new BlockItem(CrystalliteOreBlock.block, new Item.Properties().func_200916_a(ItemGroup.field_78030_b));
            return (Item)blockItem.setRegistryName(CrystalliteOreBlock.block.getRegistryName());
        });
    }
    
    @SubscribeEvent
    public void addFeatureToBiomes(final BiomeLoadingEvent event) {
        event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> CrystalliteOreBlock.configuredFeature);
    }
    
    static {
        block = null;
        CrystalliteOreBlock.feature = null;
        CrystalliteOreBlock.configuredFeature = null;
        CrystalliteOreBlock.CUSTOM_MATCH = null;
    }
    
    public static class CustomBlock extends Block
    {
        public CustomBlock() {
            super(AbstractBlock.Properties.func_200945_a(Material.field_151576_e).func_200947_a(SoundType.field_185851_d).func_200948_a(40.0f, 30.0f).func_235838_a_(s -> 0).harvestLevel(3).harvestTool(ToolType.PICKAXE).func_235861_h_());
            this.setRegistryName("crystallite_ore");
        }
        
        public int func_200011_d(final BlockState state, final IBlockReader worldIn, final BlockPos pos) {
            return 15;
        }
        
        public List<ItemStack> func_220076_a(final BlockState state, final LootContext.Builder builder) {
            final List<ItemStack> dropsOriginal = (List<ItemStack>)super.func_220076_a(state, builder);
            if (!dropsOriginal.isEmpty()) {
                return dropsOriginal;
            }
            return Collections.singletonList(new ItemStack((IItemProvider)CrystalliteIngotItem.block));
        }
    }
    
    private static class CustomRuleTest extends RuleTest
    {
        static final CustomRuleTest INSTANCE;
        static final Codec<CustomRuleTest> codec;
        
        public boolean func_215181_a(final BlockState blockAt, final Random random) {
            boolean blockCriteria = false;
            if (blockAt.func_177230_c() == Blocks.field_150348_b) {
                blockCriteria = true;
            }
            return blockCriteria;
        }
        
        protected IRuleTestType<?> func_215180_a() {
            return CrystalliteOreBlock.CUSTOM_MATCH;
        }
        
        static {
            INSTANCE = new CustomRuleTest();
            codec = Codec.unit(() -> CustomRuleTest.INSTANCE);
        }
    }
    
    private static class FeatureRegisterHandler
    {
        @SubscribeEvent
        public void registerFeature(final RegistryEvent.Register<Feature<?>> event) {
            CrystalliteOreBlock.CUSTOM_MATCH = (IRuleTestType<CustomRuleTest>)Registry.func_218322_a(Registry.field_218363_D, new ResourceLocation("swordcraftonline:crystallite_ore_match"), (Object)(() -> CustomRuleTest.codec));
            CrystalliteOreBlock.feature = (Feature<OreFeatureConfig>)new OreFeature(OreFeatureConfig.field_236566_a_) {
                public boolean func_241855_a(final ISeedReader world, final ChunkGenerator generator, final Random rand, final BlockPos pos, final OreFeatureConfig config) {
                    final RegistryKey<World> dimensionType = (RegistryKey<World>)world.func_201672_e().func_234923_W_();
                    boolean dimensionCriteria = false;
                    if (dimensionType == World.field_234918_g_) {
                        dimensionCriteria = true;
                    }
                    return dimensionCriteria && super.func_241855_a(world, generator, rand, pos, config);
                }
            };
            CrystalliteOreBlock.configuredFeature = (ConfiguredFeature<?, ?>)((ConfiguredFeature)((ConfiguredFeature)CrystalliteOreBlock.feature.func_225566_b_((IFeatureConfig)new OreFeatureConfig((RuleTest)CustomRuleTest.INSTANCE, CrystalliteOreBlock.block.func_176223_P(), 3)).func_242733_d(11)).func_242728_a()).func_242731_b(1);
            event.getRegistry().register(CrystalliteOreBlock.feature.setRegistryName("crystallite_ore"));
            Registry.func_218322_a(WorldGenRegistries.field_243653_e, new ResourceLocation("swordcraftonline:crystallite_ore"), (Object)CrystalliteOreBlock.configuredFeature);
        }
    }
}
