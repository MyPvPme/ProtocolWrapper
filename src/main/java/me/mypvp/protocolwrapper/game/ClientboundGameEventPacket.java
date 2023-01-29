package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import me.mypvp.protocolwrapper.types.GameEventAction;
import org.jetbrains.annotations.NotNull;

public class ClientboundGameEventPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.GAME_STATE_CHANGE;

  private final PacketField<InternalStructure> eventField = new PacketField<>(getContainer().getStructures(), 0);
  private final PacketField<Float> valueField = new PacketField<>(getContainer().getFloat(), 0);

  public ClientboundGameEventPacket() {
  }

  public ClientboundGameEventPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundGameEventPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType getType() {
    return TYPE;
  }

  public ClientboundGameEventPacket value(float value) {
    valueField.write(value);
    return this;
  }

  public float value() {
    return valueField.read();
  }

  public ClientboundGameEventPacket gameEvent(GameEventAction gameAction) {
    InternalStructure structure = eventField.read();
    structure.getIntegers().write(0, gameAction.getId());
    eventField.write(structure);
    return this;
  }

  public GameEventAction gameEvent() {
    InternalStructure structure = eventField.read();
    int key = structure.getIntegers().read(0);
    for (GameEventAction value : GameEventAction.values()) {
      if(value.getId() == key) {
        return value;
      }
    }
    return null;
  }

}
