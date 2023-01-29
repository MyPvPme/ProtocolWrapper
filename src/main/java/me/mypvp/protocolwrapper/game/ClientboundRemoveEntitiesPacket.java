package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import java.util.List;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundRemoveEntitiesPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.ENTITY_DESTROY;

  private final PacketField<List<Integer>> entityIdsField = new PacketField<>(container().getIntLists(), 0);

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
  public PacketType type() {
    return TYPE;
  }

  public ClientboundRemoveEntitiesPacket entityIds(List<Integer> entityIds) {
    entityIdsField.write(entityIds);
    return this;
  }

  public List<Integer> entityIds() {
    return entityIdsField.read();
  }
}
