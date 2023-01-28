package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ClientboundRemoveEntitiesPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.ENTITY_DESTROY;

  private final PacketField<List<Integer>> entityIdsField = new PacketField<>(getContainer().getIntLists(), 0);

  public ClientboundRemoveEntitiesPacket() {
  }

  public ClientboundRemoveEntitiesPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundRemoveEntitiesPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType getType() {
    return TYPE;
  }

  public void setEntityIds(List<Integer> entityIds) {
    entityIdsField.write(entityIds);
  }

  public List<Integer> getEntityIds() {
    return entityIdsField.read();
  }
}