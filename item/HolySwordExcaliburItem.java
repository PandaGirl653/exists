// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.item;

import net.mcreator.swordcraftonline.procedures.HolySwordExcaliburToolInHandTickProcedure;
import net.minecraft.entity.Entity;
import net.mcreator.swordcraftonline.procedures.HolySwordExcaliburRightClickedInAirProcedure;
import java.util.Map;
import java.util.stream.Stream;
import java.util.AbstractMap;
import java.util.HashMap;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.player.PlayerEntity;
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
public class HolySwordExcaliburItem extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:holy_sword_excalibur")
    public static final Item block;
    
    public HolySwordExcaliburItem(final SwordcraftonlineModElements instance) {
        super(instance, 164);
    }
    
    @Override
    public void initElements() {
        final SwordItem swordItem;
        this.elements.items.add(() -> {
            new SwordItem(new IItemTier() {
                public int func_200926_a() {
                    return 4000;
                }
                
                public float func_200928_b() {
                    return 4.0f;
                }
                
                public float func_200929_c() {
                    return 56.0f;
                }
                
                public int func_200925_d() {
                    return 1;
                }
                
                public int func_200927_e() {
                    return 60;
                }
                
                public Ingredient func_200924_f() {
                    return Ingredient.field_193370_a;
                }
            }, 3, -2.1f, new Item.Properties().func_200916_a(SwordCraftOnlineItemGroup.tab).func_234689_a_()) {
                public void func_77624_a(final ItemStack itemstack, final World world, final List<ITextComponent> list, final ITooltipFlag flag) {
                    super.func_77624_a(itemstack, world, (List)list, flag);
                    list.add((ITextComponent)new StringTextComponent("§6Legendary Weapon"));
                    list.add((ITextComponent)new StringTextComponent("§5Active:"));
                    list.add((ITextComponent)new StringTextComponent("§f- Gain increased life and stamina by 2 for 5 minutes. (Has a 10 minute cooldown) (Right Click)."));
                    list.add((ITextComponent)new StringTextComponent("§5Passive:"));
                    list.add((ITextComponent)new StringTextComponent("§fWhen Excalibur is wielded you gain Regeneration 2 and Saturation."));
                }
                
                public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity entity, final Hand hand) {
                    final ActionResult retval = super.func_77659_a(world, entity, hand);
                    final ItemStack itemstack = (ItemStack)retval.func_188398_b();
                    final double x = entity.func_226277_ct_();
                    final double y = entity.func_226278_cu_();
                    final double z = entity.func_226281_cx_();
                    HolySwordExcaliburRightClickedInAirProcedure.executeProcedure(Stream.of((AbstractMap.SimpleEntry[])new AbstractMap.SimpleEntry[] { new AbstractMap.SimpleEntry((K)"entity", (V)entity), new AbstractMap.SimpleEntry((K)"itemstack", (V)itemstack) }).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
                    return (ActionResult<ItemStack>)retval;
                }
                
                public void func_77663_a(final ItemStack itemstack, final World world, final Entity entity, final int slot, final boolean selected) {
                    super.func_77663_a(itemstack, world, entity, slot, selected);
                    final double x = entity.func_226277_ct_();
                    final double y = entity.func_226278_cu_();
                    final double z = entity.func_226281_cx_();
                    if (selected) {
                        HolySwordExcaliburToolInHandTickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<String, Entity>("entity", entity)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
                    }
                }
            };
            return (Item)swordItem.setRegistryName("holy_sword_excalibur");
        });
    }
    
    static {
        block = null;
    }
}
