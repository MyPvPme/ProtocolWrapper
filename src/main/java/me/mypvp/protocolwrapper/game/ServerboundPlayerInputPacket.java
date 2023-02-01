package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Client;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ServerboundPlayerInputPacket extends AbstractPacket {

  public static final PacketType TYPE = Client.STEER_VEHICLE;

  private final PacketField<Float> sidewaysField = new PacketField<>(container().getFloat(), 0);
  private final PacketField<Float> forwardField = new PacketField<>(container().getFloat(), 1);
  private final PacketField<Boolean> jumpingField = new PacketField<>(container().getBooleans(), 0);
  private final PacketField<Boolean> sneakingField = new PacketField<>(container().getBooleans(), 1);

  public ServerboundPlayerInputPacket() {
  }

  public ServerboundPlayerInputPacket(@NotNull Object handle) {
    super(handle);
  }

  public ServerboundPlayerInputPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ServerboundPlayerInputPacket sideways(float value) {
    sidewaysField.write(value);
    return this;
  }

  public float sideways() {
    return sidewaysField.read();
  }

  public ServerboundPlayerInputPacket forward(float value) {
    forwardField.write(value);
    return this;
  }

  public float forward() {
    return forwardField.read();
  }

  public ServerboundPlayerInputPacket jumping(boolean value) {
    jumpingField.write(value);
    return this;
  }

  public boolean jumping() {
    return jumpingField.read();
  }

  public ServerboundPlayerInputPacket sneaking(boolean value) {
    sneakingField.write(value);
    return this;
  }

  public boolean sneaking() {
    return sneakingField.read();
  }

}
