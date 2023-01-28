package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetEntityMotionPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.ENTITY_VELOCITY;

  private final PacketField<Integer> idField = new PacketField<>(getContainer().getIntegers(), 0);
  private final PacketField<Integer> velocityXField = new PacketField<>(getContainer().getIntegers(), 1);
  private final PacketField<Integer> velocityYField = new PacketField<>(getContainer().getIntegers(), 2);
  private final PacketField<Integer> velocityZField = new PacketField<>(getContainer().getIntegers(), 3);

  public ClientboundSetEntityMotionPacket() {
  }

  public ClientboundSetEntityMotionPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetEntityMotionPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType getType() {
    return TYPE;
  }

  public void setEntityId(int entityId) {
    idField.write(entityId);
  }

  public int getEntityId() {
    return idField.read();
  }

  public void setVelocityX(int value) {
    velocityXField.write(value);
  }

  public int getVelocityX() {
    return velocityXField.read();
  }

  public void setVelocityY(int value) {
    velocityYField.write(value);
  }

  public int getVelocityY() {
    return velocityYField.read();
  }
  public void setVelocityZ(int value) {
    velocityZField.write(value);
  }

  public int getVelocityZ() {
    return velocityZField.read();
  }

}
