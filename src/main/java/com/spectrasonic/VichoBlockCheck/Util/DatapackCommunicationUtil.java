package com.spectrasonic.VichoBlockCheck.Util;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;

import java.util.Objects;

public class DatapackCommunicationUtil {

    String dataPackCommand = "data merge storage vb0:0 {x:0,y:0,z:0,dim:\"minecraft:overworld\"}";


    public void storeBlockCoordinates(Block block) {
        // Comando para almacenar coordenadas en storage del datapack
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                String.format(dataPackCommand,
                        block.getX(), block.getY(), block.getZ())
        );
    }

    public boolean checkBlockBreakPermission() {
        // Ejecutar función del datapack para verificar permiso de ruptura
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                "function blockinteraction:check_block_break");

        // Obtener resultado del scoreboard
        // NOTA: En tu datapack, debes configurar un scoreboard llamado "CanThePlayerBreakBlock"
        int result = Objects.requireNonNull(Objects.requireNonNull(Bukkit.getScoreboardManager()).getMainScoreboard()
                        .getObjective("CanThePlayerBreakBlock"))
                .getScore("result")
                .getScore();

        return result == 1;
    }
}