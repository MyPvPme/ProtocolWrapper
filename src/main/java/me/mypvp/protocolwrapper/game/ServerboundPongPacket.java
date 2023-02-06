package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ServerboundPongPacket extends AbstractPacket {

  public static final PacketType TYPE = Client.PONG;

  private final PacketField<Integer> parameterField = new PacketField<>(container().getIntegers(), 0);

  public ServerboundPongPacket() {
  }

  public ServerboundPongPacket(@NotNull Object handle) {
    super(handle);
  }

  public ServerboundPongPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ServerboundPongPacket parameter(int param) {
    parameterField.write(param);
    return this;
  }

  public int parameter() {
    return parameterField.read();
  }

}
