package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ClientboundContainerSetSlotPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SET_SLOT;

  private final PacketField<Integer> containerIdField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Integer> stateIdField = new PacketField<>(container().getIntegers(), 1);
  private final PacketField<Integer> slotField = new PacketField<>(container().getIntegers(), 2);
  private final PacketField<ItemStack> itemStackField = new PacketField<>(container().getItemModifier(), 0);

  public ClientboundContainerSetSlotPacket() {
  }

  public ClientboundContainerSetSlotPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundContainerSetSlotPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundContainerSetSlotPacket containerId(int id) {
    containerIdField.write(id);
    return this;
  }

  public int containerId() {
    return containerIdField.read();
  }

  public ClientboundContainerSetSlotPacket stageId(int id) {
    stateIdField.write(id);
    return this;
  }

  public int stageId() {
    return stateIdField.read();
  }

  public ClientboundContainerSetSlotPacket slot(int slot) {
    slotField.write(slot);
    return this;
  }

  public int slot() {
    return slotField.read();
  }

  public ClientboundContainerSetSlotPacket itemStack(ItemStack itemStack) {
    itemStackField.write(itemStack);
    return this;
  }

  public ItemStack itemStack() {
    return itemStackField.read();
  }

}
