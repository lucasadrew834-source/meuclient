package com.exemplo.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = MeuClient.MODID, version = MeuClient.VERSION)
public class MeuClient {
    public static final String MODID = "meuclient";
    public static final String VERSION = "1.0";

    public static KeyBinding openGuiKey;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        openGuiKey = new KeyBinding("Abrir Menu do Client", Keyboard.KEY_RSHIFT, "Meu Client");
        ClientRegistry.registerKeyBinding(openGuiKey);

        net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (openGuiKey.isPressed()) {
            Minecraft mc = Minecraft.getMinecraft();
            mc.displayGuiScreen(new GuiMeuClientMenu());
        }
    }
}
