package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundMoveEntityPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.REL_ENTITY_MOVE_LOOK;

  private final PacketField<Integer> entityIdField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Short> deltaXField = new PacketField<>(container().getShorts(), 0);
  private final PacketField<Short> deltaYField = new PacketField<>(container().getShorts(), 1);
  private final PacketField<Short> deltaZField = new PacketField<>(container().getShorts(), 2);
  private final PacketField<Byte> yawField = new PacketField<>(container().getBytes(), 0);
  private final PacketField<Byte> pitchField = new PacketField<>(container().getBytes(), 1);
  private final PacketField<Boolean> onGroundField = new PacketField<>(container().getBooleans(), 0);
  private final PacketField<Boolean> rotateField = new PacketField<>(container().getBooleans(), 1);
  private final PacketField<Boolean> positionChangedField = new PacketField<>(container().getBooleans(), 2);

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
  public PacketType type() {
    return TYPE;
  }

  public ClientboundMoveEntityPacket entityId(int entityId) {
    entityIdField.write(entityId);
    return this;
  }

  public int entityId() {
    return entityIdField.read();
  }

  public ClientboundMoveEntityPacket deltaX(short value) {
    deltaXField.write(value);
    return this;
  }

  public short deltaX() {
    return deltaXField.read();
  }

  public ClientboundMoveEntityPacket deltaY(short value) {
    deltaYField.write(value);
    return this;
  }

  public short deltaY() {
    return deltaYField.read();
  }

  public ClientboundMoveEntityPacket deltaZ(short value) {
    deltaZField.write(value);
    return this;
  }

  public short deltaZ() {
    return deltaZField.read();
  }

  public ClientboundMoveEntityPacket yaw(byte yaw) {
    yawField.write(yaw);
    return this;
  }

  public byte yaw() {
    return yawField.read();
  }

  public ClientboundMoveEntityPacket pitch(byte pitch) {
    pitchField.write(pitch);
    return this;
  }

  public byte pitch() {
    return pitchField.read();
  }

  public ClientboundMoveEntityPacket onGround(boolean value) {
    onGroundField.write(value);
    return this;
  }

  public boolean onGround() {
    return onGroundField.read();
  }

  public ClientboundMoveEntityPacket rotationChanged(boolean value) {
    rotateField.write(value);
    return this;
  }

  public boolean rotationChanged() {
    return rotateField.read();
  }

  public ClientboundMoveEntityPacket positionChanged(boolean value) {
    positionChangedField.write(value);
    return this;
  }

  public boolean positionChanged() {
    return positionChangedField.read();
  }

  public static class EntityMovePacket extends ClientboundMoveEntityPacket {

    public EntityMovePacket(int entityId, short deltaX, short deltaY, short deltaZ, boolean onGround) {
      entityId(entityId);
      deltaX(deltaX);
      deltaY(deltaY);
      deltaZ(deltaZ);
      onGround(onGround);
      positionChanged(true);
      rotationChanged(false);
    }

  }

  public static class EntityLookPacket extends ClientboundMoveEntityPacket {

    public EntityLookPacket(int entityId, byte yaw, byte pitch, boolean onGround) {
      entityId(entityId);
      yaw(yaw);
      pitch(pitch);
      onGround(onGround);
      positionChanged(false);
      rotationChanged(true);
    }

  }

  public static class EntityMoveLookPacket extends ClientboundMoveEntityPacket {

    public EntityMoveLookPacket(int entityId, short deltaX, short deltaY, short deltaZ,
        byte yaw, byte pitch, boolean onGround) {
      entityId(entityId);
      deltaX(deltaX);
      deltaY(deltaY);
      deltaZ(deltaZ);
      yaw(yaw);
      pitch(pitch);
      onGround(onGround);
      positionChanged(true);
      rotationChanged(true);
    }

  }

}
