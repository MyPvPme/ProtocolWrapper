package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import java.util.UUID;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
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

  public ClientboundAddPlayerPacket entityId(int entityId) {
    entityIdField.write(entityId);
    return this;
  }

  public int entityId() {
    return entityIdField.read();
  }

  public ClientboundAddPlayerPacket playerId(UUID uuid) {
    playerIdField.write(uuid);
    return this;
  }

  public UUID playerId() {
    return playerIdField.read();
  }

  public ClientboundAddPlayerPacket x(double value) {
    xField.write(value);
    return this;
  }

  public double x() {
    return xField.read();
  }

  public ClientboundAddPlayerPacket y(double value) {
    yField.write(value);
    return this;
  }

  public double y() {
    return yField.read();
  }

  public ClientboundAddPlayerPacket z(double value) {
    zField.write(value);
    return this;
  }

  public double z() {
    return zField.read();
  }

  public ClientboundAddPlayerPacket yaw(byte yaw) {
    yawField.write(yaw);
    return this;
  }

  public byte yaw() {
    return yawField.read();
  }

  public ClientboundAddPlayerPacket pitch(byte pitch) {
    pitchField.write(pitch);
    return this;
  }

  public byte pitch() {
    return pitchField.read();
  }

}
