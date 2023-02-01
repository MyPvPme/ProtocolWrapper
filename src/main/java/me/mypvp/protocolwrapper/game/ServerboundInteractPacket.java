package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedEnumEntityUseAction;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ServerboundInteractPacket extends AbstractPacket {

  public static final PacketType TYPE = Client.ENTITY_ACTION;

  private final PacketField<Integer> entityIdField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<WrappedEnumEntityUseAction> actionField
      = new PacketField<>(container().getEnumEntityUseActions(), 0);
  private final PacketField<Boolean> secondaryActionField = new PacketField<>(container().getBooleans(), 0);

  public ServerboundInteractPacket() {}

  public ServerboundInteractPacket(@NotNull Object handle) {
    super(handle);
  }

  public ServerboundInteractPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ServerboundInteractPacket entityId(int entityId) {
    entityIdField.write(entityId);
    return this;
  }

  public int entityId() {
    return entityIdField.read();
  }

  public ServerboundInteractPacket action(WrappedEnumEntityUseAction action) {
    actionField.write(action);
    return this;
  }

  public WrappedEnumEntityUseAction action() {
    return actionField.read();
  }

  public ServerboundInteractPacket secondaryAction(boolean value) {
    secondaryActionField.write(value);
    return this;
  }

  public boolean secondaryAction() {
    return secondaryActionField.read();
  }
}
