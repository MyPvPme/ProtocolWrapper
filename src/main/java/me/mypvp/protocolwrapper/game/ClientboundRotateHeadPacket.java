package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundRotateHeadPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.ENTITY_HEAD_ROTATION;

  private final PacketField<Integer> entityIdField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Byte> headYawField = new PacketField<>(container().getBytes(), 0);

  public ClientboundRotateHeadPacket() {
  }

  public ClientboundRotateHeadPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundRotateHeadPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundRotateHeadPacket entityId(int entitiyId) {
    entityIdField.write(entitiyId);
    return this;
  }

  public int entityId() {
    return entityIdField.read();
  }

  public ClientboundRotateHeadPacket headYaw(byte yaw) {
    headYawField.write(yaw);
    return this;
  }

  public byte headYaw() {
    return headYawField.read();
  }

}
