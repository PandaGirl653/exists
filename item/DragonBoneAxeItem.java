// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.item;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.ITextComponent;
import java.util.List;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.AxeItem;
import net.mcreator.swordcraftonline.itemgroup.SwordCraftOnlineItemGroup;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.IItemTier;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.item.Item;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements.ModElement;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements;

@Tag
public class DragonBoneAxeItem extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:dragon_bone_axe")
    public static final Item block;
    
    public DragonBoneAxeItem(final SwordcraftonlineModElements instance) {
        super(instance, 215);
    }
    
    @Override
    public void initElements() {
        final AxeItem axeItem;
        this.elements.items.add(() -> {
            new AxeItem(new IItemTier() {
                public int func_200926_a() {
                    return 3500;
                }
                
                public float func_200928_b() {
                    return 70.0f;
                }
                
                public float func_200929_c() {
                    return 83.0f;
                }
                
                public int func_200925_d() {
                    return 5;
                }
                
                public int func_200927_e() {
                    return 40;
                }
                
                public Ingredient func_200924_f() {
                    return Ingredient.field_193370_a;
                }
            }, 1.0f, -3.6f, new Item.Properties().func_200916_a(SwordCraftOnlineItemGroup.tab).func_234689_a_()) {
                public void func_77624_a(final ItemStack itemstack, final World world, final List<ITextComponent> list, final ITooltipFlag flag) {
                    super.func_77624_a(itemstack, world, (List)list, flag);
                    list.add((ITextComponent)new StringTextComponent("§4Mythic Tool"));
                    list.add((ITextComponent)new StringTextComponent("§cThis Tool is capable of breaking the trunks of the Gigas Cedar (Material not obtainable at the moment)"));
                }
            };
            return (Item)axeItem.setRegistryName("dragon_bone_axe");
        });
    }
    
    static {
        block = null;
    }
}
