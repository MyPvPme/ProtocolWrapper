package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers.ItemSlot;
import com.comphenix.protocol.wrappers.Pair;
import java.util.List;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetEquipmentPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.ENTITY_EQUIPMENT;

  private final PacketField<Integer> entityIdField = new PacketField<>(getContainer().getIntegers(), 0);
  private final PacketField<List<Pair<ItemSlot, ItemStack>>> equipmentListField =
      new PacketField<>(getContainer().getSlotStackPairLists(), 0);

  public ClientboundSetEquipmentPacket() {
  }

  public ClientboundSetEquipmentPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetEquipmentPacket(
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

  public void setEquipmentList(List<Pair<ItemSlot, ItemStack>> equipmentList) {
    equipmentListField.write(equipmentList);
  }

  public List<Pair<ItemSlot, ItemStack>> getEquipmentList() {
    return equipmentListField.read();
  }
}
