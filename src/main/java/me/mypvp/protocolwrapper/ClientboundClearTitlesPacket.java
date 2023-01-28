package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import org.jetbrains.annotations.NotNull;

public class ClientboundClearTitlesPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.CLEAR_TITLES;

  private final PacketField<Boolean> resetTimesField = new PacketField<>(getContainer().getBooleans(), 0);

  public ClientboundClearTitlesPacket() {
  }

  public ClientboundClearTitlesPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundClearTitlesPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType getType() {
    return TYPE;
  }

  public void setResetTimes(boolean state) {
    resetTimesField.write(state);
  }

  public boolean getResetTimes() {
    return resetTimesField.read();
  }
}
