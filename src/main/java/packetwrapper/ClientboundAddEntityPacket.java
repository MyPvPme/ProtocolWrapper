package packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import java.util.UUID;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;

public class ClientboundAddEntityPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SPAWN_ENTITY;

  private final PacketField<Integer> entityIdField =
      new PacketField<>(getContainer().getIntegers(), 0);
  private final PacketField<UUID> uuidField =
      new PacketField<>(getContainer().getUUIDs(), 0);
  private final PacketField<EntityType> entityTypeField =
      new PacketField<>(getContainer().getEntityTypeModifier(), 0);
  private final PacketField<Double> xField =
      new PacketField<>(getContainer().getDoubles(), 0);
  private final PacketField<Double> yField =
      new PacketField<>(getContainer().getDoubles(), 1);
  private final PacketField<Double> zField =
      new PacketField<>(getContainer().getDoubles(), 2);
  private final PacketField<Integer> velocityXField =
      new PacketField<>(getContainer().getIntegers(), 1);
  private final PacketField<Integer> velocityYField =
      new PacketField<>(getContainer().getIntegers(), 2);
  private final PacketField<Integer> velocityZField =
      new PacketField<>(getContainer().getIntegers(), 3);
  private final PacketField<Byte> pitchField =
      new PacketField<>(getContainer().getBytes(), 0);
  private final PacketField<Byte> yawField =
      new PacketField<>(getContainer().getBytes(), 1);
  private final PacketField<Byte> headYawField =
      new PacketField<>(getContainer().getBytes(), 2);
  private final PacketField<Integer> entityDataField =
      new PacketField<>(getContainer().getIntegers(), 4);

  public ClientboundAddEntityPacket() {
  }

  public ClientboundAddEntityPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundAddEntityPacket(@NotNull PacketContainer packetContainer) {
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

  public void setUUID(UUID uuid) {
    uuidField.write(uuid);
  }

  public UUID geUUID() {
    return uuidField.read();
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

  public void setHeadYaw(byte yaw) {
    headYawField.write(yaw);
  }

  public byte getHeadYaw() {
    return headYawField.read();
  }

  public void setPitch(byte pitch) {
    pitchField.write(pitch);
  }

  public byte getPitch() {
    return pitchField.read();
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

  public void setEntityType(EntityType entityType) {
    entityTypeField.write(entityType);
  }

  public EntityType getEntityType() {
    return entityTypeField.read();
  }

  public void setEntityData(int data) {
    entityDataField.write(data);
  }

  public int getEntityData() {
    return entityDataField.read();
  }

}
