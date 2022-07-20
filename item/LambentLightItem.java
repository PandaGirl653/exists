// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.item;

import net.mcreator.swordcraftonline.procedures.LambentLightItemIsCraftedsmeltedProcedure;
import java.util.Map;
import java.util.stream.Stream;
import java.util.AbstractMap;
import java.util.HashMap;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.item.SwordItem;
import net.mcreator.swordcraftonline.itemgroup.SwordCraftOnlineItemGroup;
import net.minecraft.util.IItemProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.IItemTier;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.item.Item;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements.ModElement;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements;

@Tag
public class LambentLightItem extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:lambent_light")
    public static final Item block;
    
    public LambentLightItem(final SwordcraftonlineModElements instance) {
        super(instance, 119);
    }
    
    @Override
    public void initElements() {
        final SwordItem swordItem;
        this.elements.items.add(() -> {
            new SwordItem(new IItemTier() {
                public int func_200926_a() {
                    return 1850;
                }
                
                public float func_200928_b() {
                    return 4.0f;
                }
                
                public float func_200929_c() {
                    return 9.0f;
                }
                
                public int func_200925_d() {
                    return 1;
                }
                
                public int func_200927_e() {
                    return 20;
                }
                
                public Ingredient func_200924_f() {
                    return Ingredient.func_193369_a(new ItemStack[] { new ItemStack((IItemProvider)LightDiamondItem.block) });
                }
            }, 3, -2.0f, new Item.Properties().func_200916_a(SwordCraftOnlineItemGroup.tab).func_234689_a_()) {
                public void func_77622_d(final ItemStack itemstack, final World world, final PlayerEntity entity) {
                    super.func_77622_d(itemstack, world, entity);
                    final double x = entity.func_226277_ct_();
                    final double y = entity.func_226278_cu_();
                    final double z = entity.func_226281_cx_();
                    LambentLightItemIsCraftedsmeltedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<String, ItemStack>("itemstack", itemstack)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
                }
            };
            return (Item)swordItem.setRegistryName("lambent_light");
        });
    }
    
    static {
        block = null;
    }
}
