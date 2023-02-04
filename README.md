# ProtocolWrapper
Minecraft Protocol wrapper using [ProtocolLib](https://github.com/dmulloy2/ProtocolLib) inspired by [PacketWrapper](https://github.com/dmulloy2/PacketWrapper)

#### ⚠ Library is in alpha state, breaking changes may be possible! ⚠

## Goal
ProtocolWrapper is intended to contain wrappers for all packets of the current Minecraft protocols in there original names in the future.
This should be combined with a simple and clear API design, so that it should be possible to send packets to the players independently of Bukkit, even without a deeper understanding of this library as well as ProtocolLib.

## Use
#### Gradle
```GROOVY
repositories {
  maven {
    url "https://repo.mypvp.me/repository/maven"
  }
}
```
```GROOVY
implementation 'me.mypvp:ProtocolWrapper:0.0.5'
```

#### Maven
```XML
<repositories>
  <repository>
    <id>MyPvP</id>
    <url>https://repo.mypvp.me/repository/maven/</url>
  </repository>
</repositories>
```
```XML
<dependency>
  <groupId>me.mypvp</groupId>
  <artifactId>ProtocolWrapper</artifactId>
  <version>0.0.5</version>
</dependency>
```
