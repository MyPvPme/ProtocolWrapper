package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractPacket {

  private final PacketContainer container;

  public AbstractPacket() {
    this.container = new PacketContainer(getType());
  }

  public AbstractPacket(@NotNull Object handle) {
    this.container = new PacketContainer(getType(), handle);
  }

  public AbstractPacket(@NotNull PacketContainer packetContainer) {
    if(packetContainer.getType() != getType()) {
      throw new IllegalStateException("Invalid packet container type: " + packetContainer.getType().name());
    }
    this.container = packetContainer;
  }

  public abstract PacketType getType();

  public PacketContainer getContainer() {
    return container;
  }

  public Object getHandle() {
    return container.getHandle();
  }

  public void sendPacket(Player player) {
    ProtocolLibrary.getProtocolManager().sendServerPacket(player, getContainer());
  }

}
