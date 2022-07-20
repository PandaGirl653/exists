// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.item;

import net.mcreator.swordcraftonline.procedures.FragrantOliveSwordToolInHandTickProcedure;
import net.minecraft.entity.Entity;
import net.mcreator.swordcraftonline.procedures.FragrantOliveSwordLivingEntityIsHitWithToolProcedure;
import java.util.Map;
import java.util.stream.Stream;
import java.util.AbstractMap;
import java.util.HashMap;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.mcreator.swordcraftonline.itemgroup.SwordCraftOnlineItemGroup;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.IItemTier;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.item.Item;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements.ModElement;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements;

@Tag
public class FragrantOliveSwordItem extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:fragrant_olive_sword")
    public static final Item block;
    
    public FragrantOliveSwordItem(final SwordcraftonlineModElements instance) {
        super(instance, 131);
    }
    
    @Override
    public void initElements() {
        final SwordItem swordItem;
        this.elements.items.add(() -> {
            new SwordItem(new IItemTier() {
                public int func_200926_a() {
                    return 2500;
                }
                
                public float func_200928_b() {
                    return 4.0f;
                }
                
                public float func_200929_c() {
                    return 18.0f;
                }
                
                public int func_200925_d() {
                    return 1;
                }
                
                public int func_200927_e() {
                    return 30;
                }
                
                public Ingredient func_200924_f() {
                    return Ingredient.field_193370_a;
                }
            }, 3, -2.2f, new Item.Properties().func_200916_a(SwordCraftOnlineItemGroup.tab).func_234689_a_()) {
                public void func_77624_a(final ItemStack itemstack, final World world, final List<ITextComponent> list, final ITooltipFlag flag) {
                    super.func_77624_a(itemstack, world, (List)list, flag);
                    list.add((ITextComponent)new StringTextComponent("§5Epic Weapon"));
                    list.add((ITextComponent)new StringTextComponent("§eActive:"));
                    list.add((ITextComponent)new StringTextComponent("§fAt the moment of hitting lightning strikes."));
                    list.add((ITextComponent)new StringTextComponent("§ePassive:"));
                    list.add((ITextComponent)new StringTextComponent("§fBy carrying it in your hand it gives you Fire Resistance."));
                }
                
                public boolean func_77644_a(final ItemStack itemstack, final LivingEntity entity, final LivingEntity sourceentity) {
                    final boolean retval = super.func_77644_a(itemstack, entity, sourceentity);
                    final double x = entity.func_226277_ct_();
                    final double y = entity.func_226278_cu_();
                    final double z = entity.func_226281_cx_();
                    final World world = entity.field_70170_p;
                    FragrantOliveSwordLivingEntityIsHitWithToolProcedure.executeProcedure(Stream.of((AbstractMap.SimpleEntry[])new AbstractMap.SimpleEntry[] { new AbstractMap.SimpleEntry((K)"world", (V)world), new AbstractMap.SimpleEntry((K)"x", (V)x), new AbstractMap.SimpleEntry((K)"y", (V)y), new AbstractMap.SimpleEntry((K)"z", (V)z) }).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
                    return retval;
                }
                
                public void func_77663_a(final ItemStack itemstack, final World world, final Entity entity, final int slot, final boolean selected) {
                    super.func_77663_a(itemstack, world, entity, slot, selected);
                    final double x = entity.func_226277_ct_();
                    final double y = entity.func_226278_cu_();
                    final double z = entity.func_226281_cx_();
                    if (selected) {
                        FragrantOliveSwordToolInHandTickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<String, Entity>("entity", entity)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
                    }
                }
            };
            return (Item)swordItem.setRegistryName("fragrant_olive_sword");
        });
    }
    
    static {
        block = null;
    }
}
