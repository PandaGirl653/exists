// 
// Decompiled by Procyon v0.5.36
// 

package net.mcreator.swordcraftonline.item;

import net.mcreator.swordcraftonline.procedures.DarkKnightSpawnerRightClickedInAirProcedure;
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
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.mcreator.swordcraftonline.itemgroup.SwordCraftOnlineItemGroup;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.item.Item;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements.ModElement;
import net.mcreator.swordcraftonline.SwordcraftonlineModElements;

@Tag
public class DarkKnightSpawnerItem extends SwordcraftonlineModElements.ModElement
{
    @ObjectHolder("swordcraftonline:dark_knight_spawner")
    public static final Item block;
    
    public DarkKnightSpawnerItem(final SwordcraftonlineModElements instance) {
        super(instance, 265);
    }
    
    @Override
    public void initElements() {
        this.elements.items.add(() -> new ItemCustom());
    }
    
    static {
        block = null;
    }
    
    public static class ItemCustom extends Item
    {
        public ItemCustom() {
            super(new Item.Properties().func_200916_a(SwordCraftOnlineItemGroup.tab).func_200917_a(1).func_234689_a_().func_208103_a(Rarity.COMMON));
            this.setRegistryName("dark_knight_spawner");
        }
        
        public int func_77619_b() {
            return 0;
        }
        
        public int func_77626_a(final ItemStack itemstack) {
            return 0;
        }
        
        public float func_150893_a(final ItemStack par1ItemStack, final BlockState par2Block) {
            return 1.0f;
        }
        
        public void func_77624_a(final ItemStack itemstack, final World world, final List<ITextComponent> list, final ITooltipFlag flag) {
            super.func_77624_a(itemstack, world, (List)list, flag);
            list.add((ITextComponent)new StringTextComponent("§eSummon the Dark Knight"));
        }
        
        public ActionResult<ItemStack> func_77659_a(final World world, final PlayerEntity entity, final Hand hand) {
            final ActionResult<ItemStack> ar = (ActionResult<ItemStack>)super.func_77659_a(world, entity, hand);
            final ItemStack itemstack = (ItemStack)ar.func_188398_b();
            final double x = entity.func_226277_ct_();
            final double y = entity.func_226278_cu_();
            final double z = entity.func_226281_cx_();
            DarkKnightSpawnerRightClickedInAirProcedure.executeProcedure(Stream.of((AbstractMap.SimpleEntry[])new AbstractMap.SimpleEntry[] { new AbstractMap.SimpleEntry((K)"world", (V)world), new AbstractMap.SimpleEntry((K)"x", (V)x), new AbstractMap.SimpleEntry((K)"y", (V)y), new AbstractMap.SimpleEntry((K)"z", (V)z), new AbstractMap.SimpleEntry((K)"entity", (V)entity) }).collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
            return ar;
        }
    }
}
