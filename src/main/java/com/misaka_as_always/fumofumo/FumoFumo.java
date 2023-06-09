package com.misaka_as_always.fumofumo;

import com.misaka_as_always.fumofumo.common.event.FumoEvents;
import com.misaka_as_always.fumofumo.register.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FumoFumo.MOD_ID)
public class FumoFumo
{
    // Directly reference a log4j logger.

    // private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "fumofumo";

    public FumoFumo() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the setup method for modloading
        ModItems.register(eventBus);

        eventBus.addListener(this::setup);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(new FumoEvents());
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        // LOGGER.info("HELLO FROM PREINIT");
        // LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
//        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
    }


}
