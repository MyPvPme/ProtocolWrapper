package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundEntityEventPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.ENTITY_STATUS;

  private final PacketField<Integer> entityIdField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Byte> eventIdField = new PacketField<>(container().getBytes(), 0);

  public ClientboundEntityEventPacket() {

  }

  public ClientboundEntityEventPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundEntityEventPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundEntityEventPacket entityId(int entityId) {
    entityIdField.write(entityId);
    return this;
  }

  public int entityId() {
    return entityIdField.read();
  }

  public ClientboundEntityEventPacket eventId(byte eventId) {
    eventIdField.write(eventId);
    return this;
  }

  public byte eventId() {
    return eventIdField.read();
  }

}
