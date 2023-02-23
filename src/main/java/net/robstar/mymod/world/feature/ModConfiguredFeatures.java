package net.robstar.mymod.world.feature;

import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.robstar.mymod.block.ModBlocks;
import net.robstar.mymod.mymod;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, mymod.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_LEAD_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.LEAD_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_LEAD_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.ENDSTONE_LEAD_ORE.get().defaultBlockState())));
    //public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_LEAD_ORES = Suppliers.memoize(() -> List.of(
    //        OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), ModBlocks.NETHERRACK_LEAD_ORE.get().defaultBlockState())));


    public static final RegistryObject<ConfiguredFeature<?, ?>> LEAD_ORE = CONFIGURED_FEATURES.register("lead_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_LEAD_ORES.get(), 7)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> END_LEAD_ORE = CONFIGURED_FEATURES.register("end_lead_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_LEAD_ORES.get(), 7)));
    //public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_LEAD_ORE = CONFIGURED_FEATURES.register("nether_lead_ore",
    //        () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_LEAD_ORES.get(), 7)));



    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
