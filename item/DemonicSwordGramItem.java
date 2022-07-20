// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.item;

import net.mcreator.swordcraftonline.procedures.DemonicSwordGramToolInHandTickProcedure;
import net.minecraft.entity.Entity;
import net.mcreator.swordcraftonline.procedures.DemonicSwordGramLivingEntityIsHitWithToolProcedure;
import net.minecraft.entity.LivingEntity;
import net.mcreator.swordcraftonline.procedures.DemonicSwordGramRightClickedInAirProcedure;
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
public class DemonicSwordGramItem extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:demonic_sword_gram")
    public static final Item block;
    
    public DemonicSwordGramItem(final SwordcraftonlineModElements instance) {
        super(instance, 160);
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
                    return 46.0f;
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
                    list.add((ITextComponent)new StringTextComponent("§f- Gives the Wither Effect to enemies when you attack."));
                    list.add((ITextComponent)new StringTextComponent("§f- Gives the wearer strength 3 for 3 minutes with an 8 minute cooldown. (Right click)"));
                    list.add((ITextComponent)new StringTextComponent("§5Passive:"));
                    list.add((ITextComponent)new StringTextComponent("§fYou gain resistance to fire and resistance 2 when the weapon is in your hand."));
                }
                
                public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity entity, final Hand hand) {
                    final ActionResult retval = super.func_77659_a(world, entity, hand);
                    final ItemStack itemstack = (ItemStack)retval.func_188398_b();
                    final double x = entity.func_226277_ct_();
                    final double y = entity.func_226278_cu_();
                    final double z = entity.func_226281_cx_();
                    DemonicSwordGramRightClickedInAirProcedure.executeProcedure(Stream.of((AbstractMap.SimpleEntry[])new AbstractMap.SimpleEntry[] { new AbstractMap.SimpleEntry((K)"entity", (V)entity), new AbstractMap.SimpleEntry((K)"itemstack", (V)itemstack) }).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
                    return (ActionResult<ItemStack>)retval;
                }
                
                public boolean func_77644_a(final ItemStack itemstack, final LivingEntity entity, final LivingEntity sourceentity) {
                    final boolean retval = super.func_77644_a(itemstack, entity, sourceentity);
                    final double x = entity.func_226277_ct_();
                    final double y = entity.func_226278_cu_();
                    final double z = entity.func_226281_cx_();
                    final World world = entity.field_70170_p;
                    DemonicSwordGramLivingEntityIsHitWithToolProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<String, LivingEntity>("entity", entity)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
                    return retval;
                }
                
                public void func_77663_a(final ItemStack itemstack, final World world, final Entity entity, final int slot, final boolean selected) {
                    super.func_77663_a(itemstack, world, entity, slot, selected);
                    final double x = entity.func_226277_ct_();
                    final double y = entity.func_226278_cu_();
                    final double z = entity.func_226281_cx_();
                    if (selected) {
                        DemonicSwordGramToolInHandTickProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<String, Entity>("entity", entity)).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
                    }
                }
            };
            return (Item)swordItem.setRegistryName("demonic_sword_gram");
        });
    }
    
    static {
        block = null;
    }
}
