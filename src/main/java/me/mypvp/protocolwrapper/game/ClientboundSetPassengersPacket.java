package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetPassengersPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.MOUNT;

  private final PacketField<Integer> idField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<int[]> passengersField = new PacketField<>(container().getIntegerArrays(), 0);

  public ClientboundSetPassengersPacket() {
  }

  public ClientboundSetPassengersPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetPassengersPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundSetPassengersPacket entityId(int entityId) {
    idField.write(entityId);
    return this;
  }

  public int entityId() {
    return idField.read();
  }

  public ClientboundSetPassengersPacket passengers(int[] value) {
    passengersField.write(value);
    return this;
  }

  public int[] passengers() {
    return passengersField.read();
  }

}
