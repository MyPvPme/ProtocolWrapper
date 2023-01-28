package packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.PacketType.Play.Server;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import org.jetbrains.annotations.NotNull;

public class ClientboundSetSubtitleTextPacket extends AbstractPacket {

  public static final PacketType TYPE = Server.SET_SUBTITLE_TEXT;

  private final PacketField<WrappedChatComponent> subtitleField = new PacketField<>(
      getContainer().getChatComponents(), 0);

  public ClientboundSetSubtitleTextPacket() {
  }

  public ClientboundSetSubtitleTextPacket(@NotNull Object handle) {
    super(handle);
  }

  public ClientboundSetSubtitleTextPacket(
      @NotNull PacketContainer packetContainer) {
    super(packetContainer);
  }

  @Override
  public PacketType getType() {
    return TYPE;
  }

  public void setSubtitle(WrappedChatComponent wrappedChatComponent) {
    subtitleField.write(wrappedChatComponent);
  }

  public WrappedChatComponent getSubtitle() {
    return subtitleField.read();
  }

}
