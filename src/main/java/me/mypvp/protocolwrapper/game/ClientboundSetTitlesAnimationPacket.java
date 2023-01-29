package me.mypvp.protocolwrapper.game;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import me.mypvp.protocolwrapper.AbstractPacket;
import me.mypvp.protocolwrapper.PacketField;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetTitlesAnimationPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SET_TITLES_ANIMATION;

  private final PacketField<Integer> fadeInField = new PacketField<>(container().getIntegers(), 0);
  private final PacketField<Integer> stayField = new PacketField<>(container().getIntegers(), 1);
  private final PacketField<Integer> fadeOutField = new PacketField<>(container().getIntegers(), 2);

  public ClientboundSetTitlesAnimationPacket() {
  }

  public ClientboundSetTitlesAnimationPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetTitlesAnimationPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType type() {
    return TYPE;
  }

  public ClientboundSetTitlesAnimationPacket fadeIn(int value) {
    fadeInField.write(value);
    return this;
  }

  public int fadeIn() {
    return fadeInField.read();
  }

  public ClientboundSetTitlesAnimationPacket stay(int value) {
    stayField.write(value);
    return this;
  }

  public int stay() {
    return stayField.read();
  }

  public ClientboundSetTitlesAnimationPacket fadeOut(int value) {
    fadeOutField.write(value);
    return this;
  }

  public int fadeOut() {
    return fadeOutField.read();
  }

}
