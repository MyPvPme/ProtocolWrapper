package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import java.lang.reflect.Field;
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

  public void sendPacket(Player player, boolean filters) {
    ProtocolLibrary.getProtocolManager().sendServerPacket(player, container(), filters);
  }

  public void broadcast() {
    ProtocolLibrary.getProtocolManager().broadcastServerPacket(container());
  }

  public static PacketType getType(Class<? extends AbstractPacket> packetClass) {
    try {
      Field type = packetClass.getField("TYPE");
      Object obj = type.get(null);
      return (PacketType) obj;
    } catch (NoSuchFieldException | ClassCastException | IllegalAccessException e) {
      throw new IllegalStateException("Failed to get type of packet", e);
    }
  }

}
