### **✅ README.md CONTENT:**
```markdown
# 🛡️ Secure Private Messenger

**Private messaging app using TOR foundation for friends with organic growth**

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com/)
[![Privacy](https://img.shields.io/badge/Privacy-First-blue.svg)](https://github.com/LOWKEYBANKS/secure-private-messenger)

---

## 🎯 Project Vision

Building the definitive private messaging experience where:
- ✅ **Privacy comes first** - No tracking, no data collection
- ✅ **Friends connect naturally** - Organic growth through trusted relationships  
- ✅ **TOR powers anonymity** - Proven secure foundation
- ✅ **Simple to use** - Beautiful interface for everyone

### 🚀 Getting Started

#### 1. Clone the Repository
```bash
git clone https://github.com/LOWKEYBANKS/secure-private-messenger.git
cd secure-private-messenger
__CODE_BLOCK_PLACEHOLDER_1bash
# Install Android Studio (required)
# Install JDK 17 or later
# Setup Android SDK


# 🛡️ BITCHAT++

### **Decentralized · Encrypted · Mesh + Tor · Payments Enabled**

BITCHAT++ is a **sovereign private communication platform** combining:

* **Briar-style P2P mesh networking** (Bluetooth + Wi-Fi Direct)
* **Tor-based anonymity layer** (already embedded in your fork)
* **LiveKit WebRTC** for secure voice/video *over Tor*
* **Libsodium cryptography** (Ed25519 + X25519 + AES-GCM)
* **Zeus Lightning, Cashu e-cash, WalletConnect**
* **Secure file sharing** over offline mesh
* **Android-only sovereign APK** for your inner circle

---

## 🎯 Vision

A fully private, self-sovereign, peer-to-peer communication system for your trusted circle — independent of SIM cards, ISPs, corporations, or cloud servers.

### Core Pillars

* **Zero central servers**
* **Zero cloud dependencies**
* **Zero metadata leakage**
* **Fully peer-to-peer**
* **Bluetooth mesh fallback**
* **Tor routing for anonymity**
* **Integrated Bitcoin + eCash payments**

## 📦 Monorepo Structure

```
/client-android/
│
├── app/                        
│   ├── src/main/
│   │   ├── java/com/lowkeybanks/bitchat/
│   │   ├── res/
│   │   └── AndroidManifest.xml
│   ├── build.gradle.kts
│   └── proguard-rules.pro
│
├── libs/
│   ├── libsodium/                # Crypto primitives
│   ├── livekit/                  # Real-time voice/video
│   ├── tor/                      # Embedded Tor daemon
│   ├── briar/                    # Bluetooth/WiFi mesh
│   └── zeus/                     # Lightning client
│
├── modules/
│   ├── core-crypto/              # Crypto wrappers (Ed25519/X25519/AES-GCM)
│   ├── module-livekit/           # LiveKit WebRTC integration
│   ├── module-payments/          # Cashu + Zeus + WalletConnect
│   ├── core-briar/               # Mesh networking abstraction
│   └── ui/                       # Android UI components
│
├── docs/
│   ├── architecture/
│   ├── protocol-spec/
│   └── api/
│
├── build.gradle.kts
├── settings.gradle.kts
└── gradle.properties
```


## 🔐 Security Overview

### Identity Layer

* Ed25519 long-term identity keys
* X25519 ephemeral session keys
* AES-256-GCM for message encryption
* Automatic perfect forward secrecy

### Network Layer

* Embedded Tor Socks5 proxy
* P2P mesh fallback using Briar protocol
* Zero internet mode supported

### Payment Layer

* **Zeus Lightning client**
* **Cashu e-cash** (Chaumian mints)
* **WalletConnect v2** for USDT/ETH stablecoin bridging
* Keys stored safely in **Android Keystore**


## 🚀 Development

### 1. Clone

```bash
git clone https://github.com/LOWKEYBANKS/secure-private-messenger.git
cd secure-private-messenger
```

### 2. Requirements

* Android Studio (latest)
* JDK 17+
* Android SDK
* NDK (for libsodium)

### 3. Build

```bash
./gradlew assembleDebug

## 🧩 Roadmap

### Phase 1 — Core Platform

* [ ] Complete monorepo setup
* [ ] Integrate libsodium wrappers
* [ ] Tor boot service
* [ ] Briar mesh abstraction layer
* [ ] LiveKit module running over Tor

### Phase 2 — Payments & Wallets

* [ ] Zeus Lightning integration
* [ ] Cashu Mint client
* [ ] WalletConnect bridge
* [ ] Encrypted payment sessions

### Phase 3 — UI/UX

* [ ] Home screen + chat list
* [ ] Encrypted voice notes
* [ ] Offline-first file sharing
* [ ] Real-time talkback

## 📜 License

MIT License

# Build the project
./gradlew build

