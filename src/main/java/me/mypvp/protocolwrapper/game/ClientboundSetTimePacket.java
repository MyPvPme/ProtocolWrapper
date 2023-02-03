package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetTimePacket extends AbstractPacket {

  public static final PacketType TYPE = Server.UPDATE_TIME;

  private final PacketField<Long> gameTimeField = new PacketField<>(container().getLongs(), 0);
  private final PacketField<Long> timeOfDayField = new PacketField<>(container().getLongs(), 1);

  public ClientboundSetTimePacket() {
  }

  public ClientboundSetTimePacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetTimePacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundSetTimePacket gameTime(long value) {
    gameTimeField.write(value);
    return this;
  }

  public long gameTime() {
    return gameTimeField.read();
  }

  public ClientboundSetTimePacket timeOfDay(long value) {
    timeOfDayField.write(value);
    return this;
  }

  public long timeOfDay() {
    return timeOfDayField.read();
  }

}
