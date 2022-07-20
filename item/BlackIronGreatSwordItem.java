// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.item;

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
public class BlackIronGreatSwordItem extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:black_iron_great_sword")
    public static final Item block;
    
    public BlackIronGreatSwordItem(final SwordcraftonlineModElements instance) {
        super(instance, 127);
    }
    
    @Override
    public void initElements() {
        final SwordItem swordItem;
        this.elements.items.add(() -> {
            new SwordItem(new IItemTier() {
                public int func_200926_a() {
                    return 2800;
                }
                
                public float func_200928_b() {
                    return 4.0f;
                }
                
                public float func_200929_c() {
                    return 16.0f;
                }
                
                public int func_200925_d() {
                    return 1;
                }
                
                public int func_200927_e() {
                    return 25;
                }
                
                public Ingredient func_200924_f() {
                    return Ingredient.func_193369_a(new ItemStack[] { new ItemStack((IItemProvider)DarkIronItem.block) });
                }
            }, 3, -3.1f, new Item.Properties().func_200916_a(SwordCraftOnlineItemGroup.tab).func_234689_a_()) {};
            return (Item)swordItem.setRegistryName("black_iron_great_sword");
        });
    }
    
    static {
        block = null;
    }
}
