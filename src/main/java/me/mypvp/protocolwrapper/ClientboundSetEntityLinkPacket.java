package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetEntityLinkPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.ATTACH_ENTITY;

  private final PacketField<Integer> attachedField = new PacketField<>(getContainer().getIntegers(), 0);
  private final PacketField<Integer> holdingIdField = new PacketField<>(getContainer().getIntegers(), 1);

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
  public PacketType getType() {
    return TYPE;
  }

  public void setAttachedEntity(int entityId) {
    attachedField.write(entityId);
  }

  public int getAttachedEntity() {
    return attachedField.read();
  }

  public void setHoldingEntity(int entityId) {
    holdingIdField.write(entityId);
  }

  public int getHoldingEntity() {
    return holdingIdField.read();
  }

}
