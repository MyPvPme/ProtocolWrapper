package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import org.jetbrains.annotations.NotNull;

public class ClientboundMoveEntityPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.ENTITY;

  private final PacketField<Integer> entityIdField = new PacketField<>(getContainer().getIntegers(), 0);
  private final PacketField<Short> deltaXField = new PacketField<>(getContainer().getShorts(), 0);
  private final PacketField<Short> deltaYField = new PacketField<>(getContainer().getShorts(), 1);
  private final PacketField<Short> deltaZField = new PacketField<>(getContainer().getShorts(), 2);
  private final PacketField<Byte> yawField = new PacketField<>(getContainer().getBytes(), 0);
  private final PacketField<Byte> pitchField = new PacketField<>(getContainer().getBytes(), 1);
  private final PacketField<Boolean> onGroundField = new PacketField<>(getContainer().getBooleans(), 0);
  private final PacketField<Boolean> rotateField = new PacketField<>(getContainer().getBooleans(), 1);
  private final PacketField<Boolean> positionChangedField = new PacketField<>(getContainer().getBooleans(), 2);

  public ClientboundMoveEntityPacket() {
  }

  public ClientboundMoveEntityPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundMoveEntityPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType getType() {
    return TYPE;
  }

  public void setEntityId(int entityId) {
    entityIdField.write(entityId);
  }

  public int getEntityId() {
    return entityIdField.read();
  }

  public void setDeltaX(short value) {
    deltaXField.write(value);
  }

  public short getDeltaX() {
    return deltaXField.read();
  }

  public void setDeltaY(short value) {
    deltaYField.write(value);
  }

  public short getDeltaY() {
    return deltaYField.read();
  }

  public void setDeltaZ(short value) {
    deltaZField.write(value);
  }

  public short getDeltaZ() {
    return deltaZField.read();
  }

  public void setYaw(byte yaw) {
    yawField.write(yaw);
  }

  public byte getYaw() {
    return yawField.read();
  }

  public void setPitch(byte pitch) {
    pitchField.write(pitch);
  }

  public byte getPitch() {
    return pitchField.read();
  }

  public void setOnGround(boolean value) {
    onGroundField.write(value);
  }

  public boolean getOnGround() {
    return onGroundField.read();
  }

  public void setRotateChanged(boolean value) {
    rotateField.write(value);
  }

  public boolean getRotateChanged() {
    return rotateField.read();
  }

  public void setPositionChanged(boolean value) {
    positionChangedField.write(value);
  }

  public boolean getPositionChanged() {
    return positionChangedField.read();
  }

}
