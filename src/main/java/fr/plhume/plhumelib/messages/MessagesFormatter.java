package fr.plhume.plhumelib.messages;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

import java.util.Map;

public class MessagesFormatter {

    private final MiniMessage mm;

    public MessagesFormatter() {
        this.mm = MiniMessage.miniMessage();
    }

    /**
     * Passes from String to Component with placeholder replacement
     *
     * @param message The message to be transformed
     * @param placeholders Placeholders to replace
     * @return The message with placeholder replacement
     */
    public Component formatString(String message, Map<String, String> placeholders) {
        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            message = message.replace(entry.getKey(), entry.getValue());
        }

        return mm.deserialize(message);
    }

    /**
     * Send a formatted message to a Player
     *
     * @param player The player to send the message
     * @param message The message to be transformed
     * @param placeholders Placeholders to replace
     */
    public void sendPlayerFormatted(Player player, String message, Map<String, String> placeholders) {
        Component formatted = formatString(message, placeholders);
        player.sendMessage(formatted);
    }
}
