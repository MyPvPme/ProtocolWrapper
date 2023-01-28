package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

public class ClientboundAddPlayerPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.NAMED_ENTITY_SPAWN;

  private final PacketField<Integer> entityIdField = new PacketField<>(getContainer().getIntegers(), 0);
  private final PacketField<UUID> playerIdField = new PacketField<>(getContainer().getUUIDs(), 0);
  private final PacketField<Double> xField = new PacketField<>(getContainer().getDoubles(), 0);
  private final PacketField<Double> yField = new PacketField<>(getContainer().getDoubles(), 1);
  private final PacketField<Double> zField = new PacketField<>(getContainer().getDoubles(), 2);
  private final PacketField<Byte> yawField = new PacketField<>(getContainer().getBytes(), 0);
  private final PacketField<Byte> pitchField = new PacketField<>(getContainer().getBytes(), 1);

  public ClientboundAddPlayerPacket() {
  }

  public ClientboundAddPlayerPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundAddPlayerPacket(
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

  public void setPlayerId(UUID uuid) {
    playerIdField.write(uuid);
  }

  public UUID getPlayerId() {
    return playerIdField.read();
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

}
