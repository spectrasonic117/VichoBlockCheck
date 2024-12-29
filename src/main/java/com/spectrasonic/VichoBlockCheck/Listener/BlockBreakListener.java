package com.spectrasonic.VichoBlockCheck.Listener;

import com.spectrasonic.VichoBlockCheck.Services.BlockInteractionService;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
    private final BlockInteractionService blockInteractionService = new BlockInteractionService();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();

        // Verificar si el bloque puede ser roto según el datapack
        boolean canBreakBlock = blockInteractionService.processBlockBreak(block);

        if (!canBreakBlock) {
            event.setCancelled(true);
        }
    }
}