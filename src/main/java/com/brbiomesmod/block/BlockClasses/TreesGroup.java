package com.brbiomesmod.block.BlockClasses;

import com.brbiomesmod.BrazillianBiomesMod;
import com.brbiomesmod.block.*;
import com.brbiomesmod.block.Custom.Leaves.*;
import com.brbiomesmod.block.Custom.Log.*;
import com.brbiomesmod.block.Saplings.*;
import com.brbiomesmod.item.ModItemGroup;
import com.brbiomesmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TreesGroup {
    public static List<Block> blocksList = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, BrazillianBiomesMod.MOD_ID);

    public static final RegistryObject<Block> SILK_FLOSS_LOG = registerBlock("silk_floss_log",
            SilkFlossLog::new);
    public static final RegistryObject<Block> WHITE_SILK_FLOSS_LEAVES = registerBlock("silk_floss_white_leaves",
            () -> new WhiteSilkFlossLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.WHITE_SILK_FLOSS_FLOWERING_LEAVES));
    public static final RegistryObject<Block> WHITE_SILK_FLOSS_FLOWERING_LEAVES = registerBlock("silk_floss_white_flowering_leaves",
            () -> new WhiteSilkFlossFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.WHITE_SILK_FLOSS_FRUITING_LEAVES));
    public static final RegistryObject<Block> WHITE_SILK_FLOSS_FRUITING_LEAVES = registerBlock("silk_floss_white_fruiting_leaves",
            () -> new WhiteSilkFlossFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.WHITE_SILK_FLOSS_LEAVES));
    public static final RegistryObject<Block> WHITE_SILK_FLOSS_SAPLING = registerBlock("silk_floss_white_sapling",
            KapokLeaves::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_WHITE_SILK_FLOSS_SAPLING = BLOCKS.register("potted_silk_floss_white_sapling",
            () -> new FlowerPotBlock(TreesGroup.WHITE_SILK_FLOSS_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance()));
    public static final RegistryObject<Block> PINK_SILK_FLOSS_LEAVES = registerBlock("silk_floss_pink_leaves",
            () -> new PinkSilkFlossLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.PINK_SILK_FLOSS_FLOWERING_LEAVES));
    public static final RegistryObject<Block> PINK_SILK_FLOSS_FLOWERING_LEAVES = registerBlock("silk_floss_pink_flowering_leaves",
            () -> new PinkSilkFlossFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.PINK_SILK_FLOSS_FRUITING_LEAVES));
    public static final RegistryObject<Block> PINK_SILK_FLOSS_FRUITING_LEAVES = registerBlock("silk_floss_pink_fruiting_leaves",
            () -> new PinkSilkFlossFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.PINK_SILK_FLOSS_LEAVES));
    public static final RegistryObject<Block> PINK_SILK_FLOSS_SAPLING = registerBlock("silk_floss_pink_sapling",
            PinkSilkFlossSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_PINK_SILK_FLOSS_SAPLING = BLOCKS.register("potted_silk_floss_pink_sapling",
            () -> new FlowerPotBlock(TreesGroup.PINK_SILK_FLOSS_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance()));


    public static final RegistryObject<Block> KAPOK_LOG = registerBlock("kapok_log",
            ModLogs::new);
    public static final RegistryObject<Block> KAPOK_LEAVES = registerBlock("kapok_leaves",
            KapokLeaves::new);
    public static final RegistryObject<Block> KAPOK_SAPLING = registerBlock("kapok_sapling",
            KapokSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_KAPOK_SAPLING = BLOCKS.register("potted_kapok_sapling",
            () -> new FlowerPotBlock(TreesGroup.KAPOK_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> PINK_PEROBA_LOG = registerBlock("pink_peroba_log",
            ModLogs::new);
    public static final RegistryObject<Block> PINK_PEROBA_LEAVES = registerBlock("pink_peroba_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> PINK_PEROBA_SAPLING = registerBlock("pink_peroba_sapling",
            PinkPerobaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_PINK_PEROBA_SAPLING = BLOCKS.register("potted_pink_peroba_sapling",
            () -> new FlowerPotBlock(TreesGroup.PINK_PEROBA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> JEQUITIBA_LOG = registerBlock("jequitiba_log",
            ModLogs::new);
    public static final RegistryObject<Block> JEQUITIBA_LEAVES = registerBlock("jequitiba_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> JEQUITIBA_SAPLING = registerBlock("jequitiba_sapling",
            JequitibaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_JEQUITIBA_SAPLING = BLOCKS.register("potted_jequitiba_sapling",
            () -> new FlowerPotBlock(TreesGroup.JEQUITIBA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> IPE_LOG = registerBlock("ipe_log",
            ModLogs::new);
    public static final RegistryObject<Block> YELLOW_IPE_BLOSSOM = registerBlock("yellow_ipe_blossom",
            ModLeaves::new);
    public static final RegistryObject<Block> YELLOW_IPE_SAPLING = registerBlock("yellow_ipe_sapling",
            YellowIpeSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_YELLOW_IPE_SAPLING = BLOCKS.register("potted_yellow_ipe_sapling",
            () -> new FlowerPotBlock(TreesGroup.YELLOW_IPE_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> PURPLE_IPE_BLOSSOM = registerBlock("purple_ipe_blossom",
            ModLeaves::new);
    public static final RegistryObject<Block> PURPLE_IPE_SAPLING = registerBlock("purple_ipe_sapling",
            PurpleIpeSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_PURPLE_IPE_SAPLING = BLOCKS.register("potted_purple_ipe_sapling",
            () -> new FlowerPotBlock(TreesGroup.PURPLE_IPE_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> APRICOT_IPE_BLOSSOM = registerBlock("apricot_ipe_blossom",
            ModLeaves::new);
    public static final RegistryObject<Block> APRICOT_IPE_SAPLING = registerBlock("apricot_ipe_sapling",
            ApricotIpeSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_APRICOT_IPE_SAPLING = BLOCKS.register("potted_apricot_ipe_sapling",
            () -> new FlowerPotBlock(TreesGroup.APRICOT_IPE_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> PINK_IPE_BLOSSOM = registerBlock("pink_ipe_blossom",
            ModLeaves::new);
    public static final RegistryObject<Block> PINK_IPE_SAPLING = registerBlock("pink_ipe_sapling",
            PinkIpeSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_PINK_IPE_SAPLING = BLOCKS.register("potted_pink_ipe_sapling",
            () -> new FlowerPotBlock(TreesGroup.PINK_IPE_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> WHITE_IPE_BLOSSOM = registerBlock("white_ipe_blossom",
            ModLeaves::new);
    public static final RegistryObject<Block> WHITE_IPE_SAPLING = registerBlock("white_ipe_sapling",
            WhiteIpeSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_WHITE_IPE_SAPLING = BLOCKS.register("potted_white_ipe_sapling",
            () -> new FlowerPotBlock(TreesGroup.WHITE_IPE_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> MANACA_DA_SERRA_LOG = registerBlock("manaca_da_serra_log",
            ModLogs::new);
    public static final RegistryObject<Block> MANACA_DA_SERRA_LEAVES = registerBlock("manaca_da_serra_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> MANACA_DA_SERRA_SAPLING = registerBlock("manaca_da_serra_sapling",
            ManacaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_MANACA_DA_SERRA_SAPLING = BLOCKS.register("potted_manaca_da_serra_sapling",
            () -> new FlowerPotBlock(TreesGroup.MANACA_DA_SERRA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> BRAZILLIAN_ROSEWOOD_LOG = registerBlock("brazillian_rosewood_log",
            ModLogs::new);
    public static final RegistryObject<Block> BRAZILLIAN_ROSEWOOD_LEAVES = registerBlock("brazillian_rosewood_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> BRAZILLIAN_ROSEWOOD_SAPLING = registerBlock("brazillian_rosewood_sapling",
            BrazillianRosewoodSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_BRAZILLIAN_ROSEWOOD_SAPLING = BLOCKS.register("potted_brazillian_rosewood_sapling",
            () -> new FlowerPotBlock(TreesGroup.BRAZILLIAN_ROSEWOOD_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> BRAZILLIAN_SASSAFRAS_LOG = registerBlock("brazillian_sassafras_log",
            ModLogs::new);
    public static final RegistryObject<Block> BRAZILLIAN_SASSAFRAS_LEAVES = registerBlock("brazillian_sassafras_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> BRAZILLIAN_SASSAFRAS_SAPLING = registerBlock("brazillian_sassafras_sapling",
            BrazillianSassafrasSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_BRAZILLIAN_SASSAFRAS_SAPLING = BLOCKS.register("potted_brazillian_sassafras_sapling",
            () -> new FlowerPotBlock(TreesGroup.BRAZILLIAN_SASSAFRAS_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> PARANA_PINE_LOG = registerBlock("parana_pine_log",
            ModLogs::new);
    public static final RegistryObject<Block> PARANA_PINE_LEAVES = registerBlock("parana_pine_leaves",
            () -> new ParanaPineLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.PARANA_PINE_FRUITING_LEAVES));
    public static final RegistryObject<Block> PARANA_PINE_FRUITING_LEAVES = registerBlock("parana_pine_fruiting_leaves",
            () -> new ParanaPineFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.PARANA_PINE_LEAVES));
    public static final RegistryObject<Block> PARANA_PINE_SAPLING = registerBlock("parana_pine_sapling",
            ParanaPineSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_PARANA_PINE_SAPLING = BLOCKS.register("potted_parana_pine_sapling",
            () -> new FlowerPotBlock(TreesGroup.PARANA_PINE_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> IMBUIA_LOG = registerBlock("imbuia_log",
            ModLogs::new);
    public static final RegistryObject<Block> IMBUIA_LEAVES = registerBlock("imbuia_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> IMBUIA_SAPLING = registerBlock("imbuia_sapling",
            ImbuiaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_IMBUIA_SAPLING = BLOCKS.register("potted_imbuia_sapling",
            () -> new FlowerPotBlock(TreesGroup.IMBUIA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> YERBA_MATE_LOG = registerBlock("yerba_mate_log",
            ModLogs::new);
    public static final RegistryObject<Block> YERBA_MATE_LEAVES = registerBlock("yerba_mate_leaves",
            YerbaMateLeaves::new);
    public static final RegistryObject<Block> YERBA_MATE_SAPLING = registerBlock("yerba_mate_sapling",
            YerbaMateSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_YERBA_MATE_SAPLING = BLOCKS.register("potted_yerba_mate_sapling",
            () -> new FlowerPotBlock(TreesGroup.YERBA_MATE_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> FEIJOA_LOG = registerBlock("feijoa_log",
            ModLogs::new);
    public static final RegistryObject<Block> FEIJOA_LEAVES = registerBlock("feijoa_leaves",
            () -> new FeijoaLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.FEIJOA_FLOWERING_LEAVES));
    public static final RegistryObject<Block> FEIJOA_FLOWERING_LEAVES = registerBlock("feijoa_flowering_leaves",
            () -> new FeijoaFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.FEIJOA_FRUITING_LEAVES));
    public static final RegistryObject<Block> FEIJOA_FRUITING_LEAVES = registerBlock("feijoa_fruiting_leaves",
            () -> new FeijoaFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.FEIJOA_LEAVES));
    public static final RegistryObject<Block> FEIJOA_SAPLING = registerBlock("feijoa_sapling",
            FeijoaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_FEIJOA_SAPLING = BLOCKS.register("potted_feijoa_sapling",
            () -> new FlowerPotBlock(TreesGroup.FEIJOA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> EUGENIA_LOG = registerBlock("eugenia_log",
            ModLogs::new);
    public static final RegistryObject<Block> PITANGA_LEAVES = registerBlock("pitanga_leaves",
            () -> new PitangaLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.PITANGA_FLOWERING_LEAVES));
    public static final RegistryObject<Block> PITANGA_FLOWERING_LEAVES = registerBlock("pitanga_flowering_leaves",
            () -> new PitangaFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.PITANGA_FRUITING_LEAVES));
    public static final RegistryObject<Block> PITANGA_FRUITING_LEAVES = registerBlock("pitanga_fruiting_leaves",
            () -> new PitangaFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.PITANGA_LEAVES));
    public static final RegistryObject<Block> BLACK_PITANGA_LEAVES = registerBlock("pitanga_black_leaves",
            () -> new BlackPitangaLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.BLACK_PITANGA_FLOWERING_LEAVES));
    public static final RegistryObject<Block> BLACK_PITANGA_FLOWERING_LEAVES = registerBlock("pitanga_black_flowering_leaves",
            () -> new BlackPitangaFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.BLACK_PITANGA_FRUITING_LEAVES));
    public static final RegistryObject<Block> BLACK_PITANGA_FRUITING_LEAVES = registerBlock("pitanga_black_fruiting_leaves",
            () -> new BlackPitangaFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.BLACK_PITANGA_LEAVES));
    public static final RegistryObject<Block> PITANGA_SAPLING = registerBlock("pitanga_sapling",
            PitangaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_PITANGA_SAPLING = BLOCKS.register("potted_pitanga_sapling",
            () -> new FlowerPotBlock(TreesGroup.PITANGA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> CAGAITA_LEAVES = registerBlock("cagaita_leaves",
            () -> new CagaitaLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.CAGAITA_FLOWERING_LEAVES));
    public static final RegistryObject<Block> CAGAITA_FLOWERING_LEAVES = registerBlock("cagaita_flowering_leaves",
            () -> new CagaitaFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.CAGAITA_FRUITING_LEAVES));
    public static final RegistryObject<Block> CAGAITA_FRUITING_LEAVES = registerBlock("cagaita_fruiting_leaves",
            () -> new CagaitaFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.CAGAITA_LEAVES));
    public static final RegistryObject<Block> CAGAITA_SAPLING = registerBlock("cagaita_sapling",
            CagaitaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CAGAITA_SAPLING = BLOCKS.register("potted_cagaita_sapling",
            () -> new FlowerPotBlock(TreesGroup.CAGAITA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance()));
    public static final RegistryObject<Block> RIO_GRANDE_CHERRY_LEAVES = registerBlock("rio_grande_cherry_leaves",
            () -> new RioGrandeCherryLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.RIO_GRANDE_CHERRY_FLOWERING_LEAVES));
    public static final RegistryObject<Block> RIO_GRANDE_CHERRY_FLOWERING_LEAVES = registerBlock("rio_grande_cherry_flowering_leaves",
            () -> new RioGrandeCherryFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.RIO_GRANDE_CHERRY_FRUITING_LEAVES));
    public static final RegistryObject<Block> RIO_GRANDE_CHERRY_FRUITING_LEAVES = registerBlock("rio_grande_cherry_fruiting_leaves",
            () -> new RioGrandeCherryFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.RIO_GRANDE_CHERRY_LEAVES));
    public static final RegistryObject<Block> RIO_GRANDE_CHERRY_SAPLING = registerBlock("rio_grande_cherry_sapling",
            RioGrandeCherrySapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_RIO_GRANDE_CHERRY_SAPLING = BLOCKS.register("potted_rio_grande_cherry_sapling",
            () -> new FlowerPotBlock(TreesGroup.RIO_GRANDE_CHERRY_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> CAMBUCI_LOG = registerBlock("cambuci_log",
            ModLogs::new);
    public static final RegistryObject<Block> CAMBUCI_LEAVES = registerBlock("cambuci_leaves",
            () -> new CambuciLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.CAMBUCI_FLOWERING_LEAVES));
    public static final RegistryObject<Block> CAMBUCI_FLOWERING_LEAVES = registerBlock("cambuci_flowering_leaves",
            () -> new CambuciFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.CAMBUCI_FRUITING_LEAVES));
    public static final RegistryObject<Block> CAMBUCI_FRUITING_LEAVES = registerBlock("cambuci_fruiting_leaves",
            () -> new CambuciFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.CAMBUCI_LEAVES));
    public static final RegistryObject<Block> CAMBUCI_SAPLING = registerBlock("cambuci_sapling",
            CambuciSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CAMBUCI_SAPLING = BLOCKS.register("potted_cambuci_sapling",
            () -> new FlowerPotBlock(TreesGroup.CAMBUCI_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> CARNAUBA_LOG = registerBlock("carnauba_log",
            ModLogs::new);
    public static final RegistryObject<Block> CARNAUBA_LEAVES = registerBlock("carnauba_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> CARNAUBA_SAPLING = registerBlock("carnauba_sapling",
            CarnaubaSapling::new);


    public static final RegistryObject<Block> UMBU_LOG = registerBlock("umbu_log",
            ModLogs::new);
    public static final RegistryObject<Block> UMBU_LEAVES = registerBlock("umbu_leaves",
            () -> new UmbuLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.UMBU_FRUITING_LEAVES));
    public static final RegistryObject<Block> UMBU_FRUITING_LEAVES = registerBlock("umbu_fruiting_leaves",
            () -> new UmbuLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.UMBU_FRUITING_LEAVES));
    public static final RegistryObject<Block> UMBU_SAPLING = registerBlock("umbu_sapling",
            UmbuSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_UMBU_SAPLING = BLOCKS.register("potted_umbu_sapling",
            () -> new FlowerPotBlock(TreesGroup.UMBU_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance()));


    public static final RegistryObject<Block> XAXIM_LOG = registerBlock("xaxim_log",
            ModLogs::new);
    public static final RegistryObject<Block> XAXIM_LEAVES = registerBlock("xaxim_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> XAXIM_SAPLING = registerBlock("xaxim_sapling",
            XaximSapling::new);


    public static final RegistryObject<Block> SAPUCAIA_LOG = registerBlock("sapucaia_log",
            ModLogs::new);
    public static final RegistryObject<Block> SAPUCAIA_LEAVES = registerBlock("sapucaia_leaves",
            () -> new SapucaiaLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.SAPUCAIA_FRUITING_LEAVES));
    public static final RegistryObject<Block> SAPUCAIA_FLOWERING_LEAVES = registerBlock("sapucaia_flowering_leaves",
            () -> new SapucaiaFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.SAPUCAIA_LEAVES));
    public static final RegistryObject<Block> SAPUCAIA_FRUITING_LEAVES = registerBlock("sapucaia_fruiting_leaves",
            () -> new SapucaiaFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.SAPUCAIA_FLOWERING_LEAVES));
    public static final RegistryObject<Block> SAPUCAIA_SAPLING = registerBlock("sapucaia_sapling",
            SapucaiaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_SAPUCAIA_SAPLING = BLOCKS.register("potted_sapucaia_sapling",
            () -> new FlowerPotBlock(TreesGroup.SAPUCAIA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> CECROPIA_LOG = registerBlock("cecropia_log",
            ModLogs::new);
    public static final RegistryObject<Block> CECROPIA_SILVER_LEAVES = registerBlock("cecropia_silver_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> CECROPIA_SILVER_SAPLING = registerBlock("cecropia_silver_sapling",
            SilverCecropiaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CECROPIA_SILVER_SAPLING = BLOCKS.register("potted_cecropia_silver_sapling",
            () -> new FlowerPotBlock(TreesGroup.CECROPIA_SILVER_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));
    public static final RegistryObject<Block> CECROPIA_LEAVES = registerBlock("cecropia_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> CECROPIA_SAPLING = registerBlock("cecropia_sapling",
            CecropiaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_CECROPIA_SAPLING = BLOCKS.register("potted_cecropia_sapling",
            () -> new FlowerPotBlock(TreesGroup.CECROPIA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> QUEEN_PALM_LOG = registerBlock("queen_palm_log",
            ModLogs::new);
    public static final RegistryObject<Block> QUEEN_PALM_LEAVES = registerBlock("queen_palm_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> QUEEN_PALM_SAPLING = registerBlock("queen_palm_sapling",
            QueenPalmSapling::new);


    public static final RegistryObject<Block> JABUTICABA_LOG = registerBlock("jabuticaba_log",
            JabuticabaLog::new);
    public static final RegistryObject<Block> JABUTICABA_FLOWERING_LOG = registerBlock("jabuticaba_flowering_log",
            JabuticabaFloweringLog::new);
    public static final RegistryObject<Block> JABUTICABA_FRUITING_LOG = registerBlock("jabuticaba_fruiting_log",
            JabuticabaFruitingLog::new);
    public static final RegistryObject<Block> JABUTICABA_LEAVES = registerBlock("jabuticaba_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> JABUTICABA_SAPLING = registerBlock("jabuticaba_sapling",
            JabuticabaSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_JABUTICABA_SAPLING = BLOCKS.register("potted_jabuticaba_sapling",
            () -> new FlowerPotBlock(TreesGroup.JABUTICABA_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> BRAZILWOOD_LOG = registerBlock("brazilwood_log",
            ModLogs::new);
    public static final RegistryObject<Block> BRAZILWOOD_LEAVES = registerBlock("brazilwood_leaves",
            ModLeaves::new);
    public static final RegistryObject<Block> BRAZILWOOD_SAPLING = registerBlock("brazilwood_sapling",
            BrazilwoodSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_BRAZILWOOD_SAPLING = BLOCKS.register("potted_brazilwood_sapling",
            () -> new FlowerPotBlock(TreesGroup.BRAZILWOOD_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance().notSolid()));


    public static final RegistryObject<Block> PALMITO_LOG = registerBlock("palmito_log",
            PalmitoLog::new);
    public static final RegistryObject<Block> ACAI_LEAVES = registerBlock("acai_leaves",
            () -> new AcaiLeaves(AbstractBlock.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly() // Enables random ticks
                    .notSolid()
                    .sound(SoundType.PLANT)));
    public static final RegistryObject<Block> ACAI_SAPLING = registerBlock("acai_sapling",
            AcaiSapling::new);
    public static final RegistryObject<Block> ACAI_BUNCH = registerBlock("acai_bunch",
            AcaiBunchBlock::new);
    public static final RegistryObject<Block> JUSSARA_LEAVES = registerBlock("jussara_leaves",
            () -> new AcaiLeaves(AbstractBlock.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly() // Enables random ticks
                    .notSolid()
                    .sound(SoundType.PLANT)));
    public static final RegistryObject<Block> JUSSARA_SAPLING = registerBlock("jussara_sapling",
            JussaraSapling::new);


    public static final RegistryObject<Block> BURITI_LOG = registerBlock("buriti_log",
            ModLogs::new);
    public static final RegistryObject<Block> BURITI_LEAVES = registerBlock("buriti_leaves",
            () -> new BuritiLeaves(AbstractBlock.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly() // Enables random ticks
                    .notSolid()
                    .sound(SoundType.PLANT)));
    public static final RegistryObject<Block> BURITI_SAPLING = registerBlock("buriti_sapling",
            BuritiSapling::new);
    public static final RegistryObject<Block> BURITI_BUNCH = registerBlock("buriti_bunch",
            BuritiBunchBlock::new);


    public static final RegistryObject<Block> WOLF_APPLE_LOG = registerBlock("wolf_apple_log",
            ModLogs::new);
    public static final RegistryObject<Block> WOLF_APPLE_LEAVES = registerBlock("wolf_apple_leaves",
            () -> new WolfAppleLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.WOLF_APPLE_FLOWERING_LEAVES));
    public static final RegistryObject<Block> WOLF_APPLE_FLOWERING_LEAVES = registerBlock("wolf_apple_flowering_leaves",
            () -> new WolfAppleFloweringLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.WOLF_APPLE_FRUITING_LEAVES));
    public static final RegistryObject<Block> WOLF_APPLE_FRUITING_LEAVES = registerBlock("wolf_apple_fruiting_leaves",
            () -> new WolfAppleFruitingLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly()
                    .notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE), TreesGroup.WOLF_APPLE_LEAVES));
    public static final RegistryObject<Block> WOLF_APPLE_SAPLING = registerBlock("wolf_apple_sapling",
            WolfAppleSapling::new);
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Block> POTTED_WOLF_APPLE_SAPLING = BLOCKS.register("potted_wolf_apple_sapling",
            () -> new FlowerPotBlock(TreesGroup.WOLF_APPLE_SAPLING.get(), AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .zeroHardnessAndResistance()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.ARAUCARIA_PLATEAU_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
