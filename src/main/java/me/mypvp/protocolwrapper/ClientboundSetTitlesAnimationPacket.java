package me.mypvp.protocolwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetTitlesAnimationPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SET_TITLES_ANIMATION;

  private final PacketField<Integer> fadeInField = new PacketField<>(getContainer().getIntegers(), 0);
  private final PacketField<Integer> stayField = new PacketField<>(getContainer().getIntegers(), 1);
  private final PacketField<Integer> fadeOutField = new PacketField<>(getContainer().getIntegers(), 2);

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
  public PacketType getType() {
    return TYPE;
  }

  public void setFadeIn(int value) {
    fadeInField.write(value);
  }

  public int getFadeIn() {
    return fadeInField.read();
  }

  public void setStay(int value) {
    stayField.write(value);
  }

  public int getStay() {
    return stayField.read();
  }

  public void setFadeOut(int value) {
    fadeOutField.write(value);
  }

  public int getFadeOut() {
    return fadeOutField.read();
  }

}
