package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import java.util.List;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ClientboundContainerSetContentPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.WINDOW_ITEMS;

  private final PacketField<Integer> containerIdField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Integer> stateIdField = new PacketField<>(container().getIntegers(), 1);
  private final PacketField<List<ItemStack>> contentsField
      = new PacketField<>(container().getItemListModifier(), 0);
  private final PacketField<ItemStack> cursorItemStackField = new PacketField<>(container().getItemModifier(), 0);

  public ClientboundContainerSetContentPacket() {
  }

  public ClientboundContainerSetContentPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundContainerSetContentPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundContainerSetContentPacket containerId(int id) {
    containerIdField.write(id);
    return this;
  }

  public int containerId() {
    return containerIdField.read();
  }

  public ClientboundContainerSetContentPacket stateId(int id) {
    stateIdField.write(id);
    return this;
  }

  public int stateId() {
    return stateIdField.read();
  }

  public ClientboundContainerSetContentPacket contents(List<ItemStack> itemStacks) {
    contentsField.write(itemStacks);
    return this;
  }

  public List<ItemStack> contents() {
    return contentsField.read();
  }

  public ClientboundContainerSetContentPacket cursorItemStack(ItemStack itemStack) {
    cursorItemStackField.write(itemStack);
    return this;
  }

  public ItemStack cursorItemStack() {
    return cursorItemStackField.read();
  }

}
