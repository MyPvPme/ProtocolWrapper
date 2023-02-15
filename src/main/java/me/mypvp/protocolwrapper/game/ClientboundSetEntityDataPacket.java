package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedDataValue;
import com.comphenix.protocol.wrappers.WrappedWatchableObject;
import java.util.Collection;
import java.util.List;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetEntityDataPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.ENTITY_METADATA;

  private final PacketField<Integer> entityIdField =
      new PacketField<>(container().getIntegers(), 0);

  public ClientboundSetEntityDataPacket() {
  }

  public ClientboundSetEntityDataPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetEntityDataPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundSetEntityDataPacket entityId(int entityId) {
    entityIdField.write(entityId);
    return this;
  }

  public int entityId() {
    return entityIdField.read();
  }

  public ClientboundSetEntityDataPacket trackedValues(List<WrappedWatchableObject> trackedValues) {
    container().getWatchableCollectionModifier().write(0, trackedValues);
    return this;
  }

  public List<WrappedWatchableObject> trackedValues() {
    return container().getWatchableCollectionModifier().read(0);
  }

  public ClientboundSetEntityDataPacket trackedValuesAsDataValueList(List<WrappedDataValue> trackedValues) {
    container().getDataValueCollectionModifier().write(0, trackedValues);
    return this;
  }

  public List<WrappedDataValue> trackedValuesAsDataValueList() {
    return container().getDataValueCollectionModifier().read(0);
  }

}
