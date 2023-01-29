package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetPassengersPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.MOUNT;

  private final PacketField<Integer> idField = new PacketField<>(getContainer().getIntegers(), 0);
  private final PacketField<int[]> passengersField = new PacketField<>(getContainer().getIntegerArrays(), 0);

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
  public PacketType getType() {
    return TYPE;
  }

  public void setEntityId(int entityId) {
    idField.write(entityId);
  }

  public int getEntityId() {
    return idField.read();
  }

  public void setPassengers(int[] value) {
    passengersField.write(value);
  }

  public int[] getPassengers() {
    return passengersField.read();
  }

}
