package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedWatchableObject;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetEntityDataPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.ENTITY_METADATA;

  private final PacketField<Integer> entityIdField =
      new PacketField<>(getContainer().getIntegers(), 0);
  private final PacketField<List<WrappedWatchableObject>> trackedValuesField
      = new PacketField<>(getContainer().getWatchableCollectionModifier(), 0);

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
  public PacketType getType() {
    return TYPE;
  }

  public void setEntityId(int entityId) {
    entityIdField.write(entityId);
  }

  public int getEntityId() {
    return entityIdField.read();
  }

  public void setTrackedValues(List<WrappedWatchableObject> trackedValues) {
    trackedValuesField.write(trackedValues);
  }

  public List<WrappedWatchableObject> getTrackedValues() {
    return trackedValuesField.read();
  }

}
