package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers.ItemSlot;
import com.comphenix.protocol.wrappers.Pair;
import java.util.List;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetEquipmentPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.ENTITY_EQUIPMENT;

  private final PacketField<Integer> entityIdField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<List<Pair<ItemSlot, ItemStack>>> equipmentListField =
      new PacketField<>(container().getSlotStackPairLists(), 0);

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
  public PacketType type() {
    return TYPE;
  }

  public ClientboundSetEquipmentPacket entityId(int entityId) {
    entityIdField.write(entityId);
    return this;
  }

  public int entityId() {
    return entityIdField.read();
  }

  public ClientboundSetEquipmentPacket equipmentList(List<Pair<ItemSlot, ItemStack>> equipmentList) {
    equipmentListField.write(equipmentList);
    return this;
  }

  public List<Pair<ItemSlot, ItemStack>> equipmentList() {
    return equipmentListField.read();
  }
}
