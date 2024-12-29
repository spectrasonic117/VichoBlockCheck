package com.spectrasonic.VichoBlockCheck.Services;

import com.spectrasonic.VichoBlockCheck.Util.DatapackCommunicationUtil;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class BlockInteractionService {
    private final DatapackCommunicationUtil communicationUtil = new DatapackCommunicationUtil();

    public boolean processBlockBreak(Block block) {
        Player player = block.getWorld().getNearbyEntities(block.getLocation(), 50, 50, 50, entity -> entity instanceof Player)
                .stream()
                .map(entity -> (Player) entity)
                .findFirst()
                .orElse(null);

        if (player == null) return true;

        // Almacenar coordenadas del bloque
        communicationUtil.storeBlockCoordinates(block);

        // Consultar al datapack si se puede romper el bloque
        return communicationUtil.checkBlockBreakPermission();
    }
}