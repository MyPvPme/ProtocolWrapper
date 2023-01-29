package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.InternalStructure;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundGameEventPacket extends AbstractPacket {

  public enum GameEventAction {
    NO_RESPAWN_BLOCK,
    START_RAINING,
    STOP_RAINING,
    CHANGE_GAME_MODE,
    WIN_GAME,
    DEMO_EVENT,
    ARROW_HIT_PLAYER,
    RAIN_LEVEL_CHANGE,
    THUNDER_LEVEL_CHANGE,
    PUFFER_FISH_STING,
    GUARDIAN_ELDER_EFFECT,
    IMMEDIATE_RESPAWN;

    public int id() {
      return ordinal();
    }
  }

  public static final PacketType TYPE = Server.GAME_STATE_CHANGE;

  private final PacketField<InternalStructure> eventField = new PacketField<>(container().getStructures(), 0);
  private final PacketField<Float> valueField = new PacketField<>(container().getFloat(), 0);

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
  public PacketType type() {
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
    structure.getIntegers().write(0, gameAction.id());
    eventField.write(structure);
    return this;
  }

  public GameEventAction gameEvent() {
    InternalStructure structure = eventField.read();
    int key = structure.getIntegers().read(0);
    for (GameEventAction value : GameEventAction.values()) {
      if(value.id() == key) {
        return value;
      }
    }
    return null;
  }

}
