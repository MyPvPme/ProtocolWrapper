package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractPacket {

  private final PacketContainer container;

  public AbstractPacket() {
    this.container = new PacketContainer(type());
  }

  public AbstractPacket(@NotNull Object handle) {
    this.container = new PacketContainer(type(), handle);
  }

  public AbstractPacket(@NotNull PacketContainer packetContainer) {
    if(packetContainer.getType() != type()) {
      throw new IllegalStateException("Invalid packet container type: " + packetContainer.getType().name());
    }
    this.container = packetContainer;
  }

  public abstract PacketType type();

  public PacketContainer container() {
    return container;
  }

  public Object handle() {
    return container.getHandle();
  }

  public void sendPacket(Player player) {
    ProtocolLibrary.getProtocolManager().sendServerPacket(player, container());
  }

  public void broadcast() {
    ProtocolLibrary.getProtocolManager().broadcastServerPacket(container());
  }

}
