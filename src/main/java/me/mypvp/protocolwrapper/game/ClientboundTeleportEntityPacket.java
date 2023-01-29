package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundTeleportEntityPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.ENTITY_TELEPORT;

  private final PacketField<Integer> entityIdField = new PacketField<>(getContainer().getIntegers(), 0);
  private final PacketField<Double> xField = new PacketField<>(getContainer().getDoubles(), 0);
  private final PacketField<Double> yField = new PacketField<>(getContainer().getDoubles(), 1);
  private final PacketField<Double> zField = new PacketField<>(getContainer().getDoubles(), 2);
  private final PacketField<Byte> yawField = new PacketField<>(getContainer().getBytes(), 0);
  private final PacketField<Byte> pitchField = new PacketField<>(getContainer().getBytes(), 1);
  private final PacketField<Boolean> onGroundField = new PacketField<>(getContainer().getBooleans(), 0);

  public ClientboundTeleportEntityPacket() {
  }

  public ClientboundTeleportEntityPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundTeleportEntityPacket(
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

  public void setX(double value) {
    xField.write(value);
  }

  public double getX() {
    return xField.read();
  }

  public void setY(double value) {
    yField.write(value);
  }

  public double getY() {
    return yField.read();
  }

  public void setZ(double value) {
    zField.write(value);
  }

  public double getZ() {
    return zField.read();
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

  public void setOnGround(boolean state) {
    onGroundField.write(state);
  }

  public boolean isOnGround() {
    return onGroundField.read();
  }

}
