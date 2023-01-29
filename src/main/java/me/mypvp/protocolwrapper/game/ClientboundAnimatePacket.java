package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundAnimatePacket extends AbstractPacket {

  public static final PacketType TYPE = Server.ANIMATION;

  public static final int SWING_MAIN_HAND = 0;
  public static final int HURT = 1;
  public static final int WAKE_UP = 2;
  public static final int SWING_OFF_HAND = 3;
  public static final int CRITICAL_HIT = 4;
  public static final int MAGIC_CRITICAL_HIT = 5;

  private final PacketField<Integer> idField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Integer> actionField = new PacketField<>(container().getIntegers(), 1);

  public ClientboundAnimatePacket() {
  }

  public ClientboundAnimatePacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundAnimatePacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundAnimatePacket entityId(int id) {
    idField.write(id);
    return this;
  }

  public int entityId() {
    return idField.read();
  }

  public ClientboundAnimatePacket action(int action) {
    actionField.write(action);
    return this;
  }

  public int action() {
    return actionField.read();
  }
}
