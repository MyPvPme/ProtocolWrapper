package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetEntityLinkPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.ATTACH_ENTITY;

  private final PacketField<Integer> attachedField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Integer> holdingIdField = new PacketField<>(container().getIntegers(), 1);

  public ClientboundSetEntityLinkPacket() {
  }

  public ClientboundSetEntityLinkPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetEntityLinkPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundSetEntityLinkPacket attachedEntity(int entityId) {
    attachedField.write(entityId);
    return this;
  }

  public int attachedEntity() {
    return attachedField.read();
  }

  public ClientboundSetEntityLinkPacket holdingEntity(int entityId) {
    holdingIdField.write(entityId);
    return this;
  }

  public int holdingEntity() {
    return holdingIdField.read();
  }

}
