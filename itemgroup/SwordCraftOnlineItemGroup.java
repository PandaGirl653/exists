// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.itemgroup;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.util.IItemProvider;
import net.mcreator.swordcraftonline.item.LogoItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements.ModElement;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements;

@Tag
public class SwordCraftOnlineItemGroup extends SwordcraftonlineModElements.ModElement
{
    public static ItemGroup tab;
    
    public SwordCraftOnlineItemGroup(final SwordcraftonlineModElements instance) {
        super(instance, 62);
    }
    
    @Override
    public void initElements() {
        SwordCraftOnlineItemGroup.tab = new ItemGroup("tabsword_craft_online") {
            @OnlyIn(Dist.CLIENT)
            public ItemStack func_78016_d() {
                return new ItemStack((IItemProvider)LogoItem.block);
            }
            
            @OnlyIn(Dist.CLIENT)
            public boolean hasSearchBar() {
                return false;
            }
        };
    }
}
