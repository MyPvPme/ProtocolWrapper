package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import java.util.UUID;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;

public class ClientboundAddEntityPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SPAWN_ENTITY;

  private final PacketField<Integer> entityIdField =
      new PacketField<>(container().getIntegers(), 0);
  private final PacketField<UUID> uuidField =
      new PacketField<>(container().getUUIDs(), 0);
  private final PacketField<EntityType> entityTypeField =
      new PacketField<>(container().getEntityTypeModifier(), 0);
  private final PacketField<Double> xField =
      new PacketField<>(container().getDoubles(), 0);
  private final PacketField<Double> yField =
      new PacketField<>(container().getDoubles(), 1);
  private final PacketField<Double> zField =
      new PacketField<>(container().getDoubles(), 2);
  private final PacketField<Integer> velocityXField =
      new PacketField<>(container().getIntegers(), 1);
  private final PacketField<Integer> velocityYField =
      new PacketField<>(container().getIntegers(), 2);
  private final PacketField<Integer> velocityZField =
      new PacketField<>(container().getIntegers(), 3);
  private final PacketField<Byte> pitchField =
      new PacketField<>(container().getBytes(), 0);
  private final PacketField<Byte> yawField =
      new PacketField<>(container().getBytes(), 1);
  private final PacketField<Byte> headYawField =
      new PacketField<>(container().getBytes(), 2);
  private final PacketField<Integer> entityDataField =
      new PacketField<>(container().getIntegers(), 4);

  public ClientboundAddEntityPacket() {
  }

  public ClientboundAddEntityPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundAddEntityPacket(@NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundAddEntityPacket entityId(int entityId) {
    entityIdField.write(entityId);
    return this;
  }

  public int entityId() {
    return entityIdField.read();
  }

  public ClientboundAddEntityPacket uuid(UUID uuid) {
    uuidField.write(uuid);
    return this;
  }

  public UUID uuid() {
    return uuidField.read();
  }

  public ClientboundAddEntityPacket x(double value) {
    xField.write(value);
    return this;
  }

  public double x() {
    return xField.read();
  }

  public ClientboundAddEntityPacket y(double value) {
    yField.write(value);
    return this;
  }

  public double y() {
    return yField.read();
  }

  public ClientboundAddEntityPacket z(double value) {
    zField.write(value);
    return this;
  }

  public double z() {
    return zField.read();
  }

  public ClientboundAddEntityPacket yaw(byte yaw) {
    yawField.write(yaw);
    return this;
  }

  public byte yaw() {
    return yawField.read();
  }

  public ClientboundAddEntityPacket headYaw(byte yaw) {
    headYawField.write(yaw);
    return this;
  }

  public byte headYaw() {
    return headYawField.read();
  }

  public ClientboundAddEntityPacket pitch(byte pitch) {
    pitchField.write(pitch);
    return this;
  }

  public byte pitch() {
    return pitchField.read();
  }

  public ClientboundAddEntityPacket velocityX(int value) {
    velocityXField.write(value);
    return this;
  }

  public int velocityX() {
    return velocityXField.read();
  }

  public ClientboundAddEntityPacket velocityY(int value) {
    velocityYField.write(value);
    return this;
  }

  public int velocityY() {
    return velocityYField.read();
  }

  public ClientboundAddEntityPacket velocityZ(int value) {
    velocityZField.write(value);
    return this;
  }

  public int velocityZ() {
    return velocityZField.read();
  }

  public ClientboundAddEntityPacket entityType(EntityType entityType) {
    entityTypeField.write(entityType);
    return this;
  }

  public EntityType entityType() {
    return entityTypeField.read();
  }

  public ClientboundAddEntityPacket entityData(int data) {
    entityDataField.write(data);
    return this;
  }

  public int entityData() {
    return entityDataField.read();
  }

}
