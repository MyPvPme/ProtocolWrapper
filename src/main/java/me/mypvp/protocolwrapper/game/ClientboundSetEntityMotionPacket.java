package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetEntityMotionPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.ENTITY_VELOCITY;

  private final PacketField<Integer> idField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Integer> velocityXField = new PacketField<>(container().getIntegers(), 1);
  private final PacketField<Integer> velocityYField = new PacketField<>(container().getIntegers(), 2);
  private final PacketField<Integer> velocityZField = new PacketField<>(container().getIntegers(), 3);

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
  public PacketType type() {
    return TYPE;
  }

  public ClientboundSetEntityMotionPacket entityId(int entityId) {
    idField.write(entityId);
    return this;
  }

  public int entityId() {
    return idField.read();
  }

  public ClientboundSetEntityMotionPacket velocityX(int value) {
    velocityXField.write(value);
    return this;
  }

  public int velocityX() {
    return velocityXField.read();
  }

  public ClientboundSetEntityMotionPacket velocityY(int value) {
    velocityYField.write(value);
    return this;
  }

  public int velocityY() {
    return velocityYField.read();
  }
  public ClientboundSetEntityMotionPacket velocityZ(int value) {
    velocityZField.write(value);
    return this;
  }

  public int velocityZ() {
    return velocityZField.read();
  }

}
