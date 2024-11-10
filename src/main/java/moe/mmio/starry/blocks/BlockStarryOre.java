package moe.mmio.starry.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moe.mmio.starry.StarryMod;
import moe.mmio.starry.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;

// 是本模组第一个方块，放些笔记在这里
public class BlockStarryOre extends Block {


    /*
    // 如果是需要定义多面，用这个，这里只需要定义一面(备注以便后面开发)
    private IIcon[] sideIcons;  // 侧面纹理列表

    private IIcon topIcon;      // 顶部纹理

    private IIcon bottomIcon;   // 底部纹理
    */

    private IIcon Icon;

    public BlockStarryOre(Material material) {
        super(material.iron);        // 材质:铁块
        this.setHardness(15.0f);
        this.setResistance(15.0f);
        this.setBlockName("starry_ore");
        this.setBlockTextureName(StarryMod.MODID + ":starry_ore");
        this.setHarvestLevel("pickaxe", 2);   // 设置挖掘等级,木头/金:0,石头:1,铁:2,钻石:3

        /*
        // 其他的一些未来可能会用到的属性
        this.setLightLevel(0f);            // 光照等级，范围:0f~1.0f
        this.setLightOpacity(0);           // 透光程度，最高值255(完全不透光)
        this.setBlockUnbreakable();        // 使其不可破坏
        */
    }

    /*
    // 多纹理示例代码
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.topIcon = iconRegister.registerIcon(this.getTextureName() + "_top");
        this.bottomIcon = iconRegister.registerIcon(this.getTextureName() + "_bottom");
        this.sideIcons = new IIcon[4];
        this.sideIcons[0] = iconRegister.registerIcon(this.getTextureName() + "side_0");
        this.sideIcons[1] = iconRegister.registerIcon(this.getTextureName() + "side_1");
        this.sideIcons[2] = iconRegister.registerIcon(this.getTextureName() + "side_2");
        this.sideIcons[3] = iconRegister.registerIcon(this.getTextureName() + "side_3");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if ( side == 0 ) {
            return this.bottomIcon;             // 底部纹理
        } else if ( side == 1 ) {
            return this.topIcon;                // 顶部纹理
        } else if ( side >= 2 && side <= 5 ) {
            return this.sideIcons[side - 2];    // 四个侧面的纹理
        } else {
            return this.blockIcon;              // 当面的数字大于5时，返回默认纹理
        }
    }
    */

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

        // 添加掉落物
        drops.add(new ItemStack(ModItems.starry_ingot, 1));

        return drops;
    }

}
