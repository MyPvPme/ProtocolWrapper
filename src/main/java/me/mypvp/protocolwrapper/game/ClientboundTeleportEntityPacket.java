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

  public ClientboundTeleportEntityPacket entityId(int entityId) {
    entityIdField.write(entityId);
    return this;
  }

  public int entityId() {
    return entityIdField.read();
  }

  public ClientboundTeleportEntityPacket x(double value) {
    xField.write(value);
    return this;
  }

  public double x() {
    return xField.read();
  }

  public ClientboundTeleportEntityPacket y(double value) {
    yField.write(value);
    return this;
  }

  public double y() {
    return yField.read();
  }

  public ClientboundTeleportEntityPacket z(double value) {
    zField.write(value);
    return this;
  }

  public double z() {
    return zField.read();
  }

  public ClientboundTeleportEntityPacket yaw(byte yaw) {
    yawField.write(yaw);
    return this;
  }

  public byte yaw() {
    return yawField.read();
  }

  public ClientboundTeleportEntityPacket pitch(byte pitch) {
    pitchField.write(pitch);
    return this;
  }

  public byte pitch() {
    return pitchField.read();
  }

  public ClientboundTeleportEntityPacket onGround(boolean state) {
    onGroundField.write(state);
    return this;
  }

  public boolean onGround() {
    return onGroundField.read();
  }

}
