package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetBorderWarningDelayPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SET_BORDER_WARNING_DELAY;

  private final PacketField<Integer> warningTimeField = new PacketField<>(getContainer().getIntegers(), 0);

  public ClientboundSetBorderWarningDelayPacket() {
  }

  public ClientboundSetBorderWarningDelayPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetBorderWarningDelayPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType getType() {
    return TYPE;
  }

  public void setWarningTime(int time) {
    warningTimeField.write(time);
  }

  public int getWarningTime() {
    return warningTimeField.read();
  }

}
