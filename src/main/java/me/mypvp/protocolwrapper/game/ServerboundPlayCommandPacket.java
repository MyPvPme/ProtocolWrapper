package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ServerboundPlayCommandPacket extends AbstractPacket {

  public static final PacketType TYPE = Client.ENTITY_ACTION;

  public enum PlayerAction {
    PRESS_SHIT_KEY,
    RELEASE_SHIT_KEY,
    STOP_SLEEPING,
    START_SPRINTING,
    STOP_SPRINTING,
    START_RIDING_JUMP,
    STOP_RIDING_JUMP,
    OPEN_INVENTORY,
    START_FALL_FLYING
  }

  private final PacketField<Integer> idField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<PlayerAction> actionField = new PacketField<>(
      container().getEnumModifier(PlayerAction.class, 1), 0);
  private final PacketField<Integer> dataField = new PacketField<>(container().getIntegers(), 1);

  public ServerboundPlayCommandPacket() {
  }

  public ServerboundPlayCommandPacket(@NotNull Object handle) {
    super(handle);
  }

  public ServerboundPlayCommandPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ServerboundPlayCommandPacket id(int id) {
    idField.write(id);
    return this;
  }

  public int id() {
    return idField.read();
  }

  public ServerboundPlayCommandPacket playerAction(PlayerAction action) {
    actionField.write(action);
    return this;
  }

  public PlayerAction playerAction() {
    return actionField.read();
  }

  public ServerboundPlayCommandPacket data(int data) {
    dataField.write(data);
    return this;
  }

  public int data() {
    return dataField.read();
  }

}
