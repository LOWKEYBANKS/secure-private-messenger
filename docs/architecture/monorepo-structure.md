 📦 BITCHAT++ Monorepo Structure

**Unified Architecture for Messaging · Mesh · Tor · Payments · LiveKit**

This document defines the **official directory structure** for the BITCHAT++ monorepo.
It serves as the foundation for all development, integration, and future scaling.

---

## 🗂️ Root Layout

```
/                          # Root of BITCHAT++
├── client-android/        # Main Android application
├── libs/                  # Forked upstream open-source libraries
├── modules/               # Custom integration modules
├── server/                # Optional backend components
├── docs/                  # Technical documentation
├── build.gradle.kts       # Root build
├── settings.gradle.kts    # Module registration
└── gradle.properties
```

---

# 1. 📱 **client-android/**

The core Android app containing UI, activities, services, and combined functionality.

```
client-android/
└── app/
    ├── src/main/
    │   ├── java/com/lowkeybanks/bitchat/
    │   │   ├── ui/                # Screens, components
    │   │   ├── crypto/            # App crypto usage
    │   │   ├── network/           # Tor, mesh, connection routing
    │   │   ├── voice/             # LiveKit talkback
    │   │   ├── payments/          # Cashu, Zeus & WC integrations
    │   │   └── storage/           # Secure local storage
    │   ├── res/                   # Layouts, icons, themes
    │   └── AndroidManifest.xml
    ├── build.gradle.kts
    └── proguard-rules.pro
```

---

# 2. 🔓 **libs/**

Forked dependencies stored locally to avoid external trust issues.

```
libs/
├── libsodium/              # Ed25519, X25519, AES-GCM crypto
├── briar/                  # Mesh networking, offline messaging
├── tor/                    # Embedded Tor binary + controller
├── livekit/                # WebRTC + RTC engine for talkback
└── zeus/                   # Lightning networking, LND/CLN RPC
```

Each library can be pinned to specific commit hashes in a `DEPENDENCY_LOCK` file.

---

# 3. 🧩 **modules/**

Custom code that integrates all libraries cleanly, modularly, and testably.

```
modules/
├── core-crypto/            # Libsodium wrappers + key mgmt
├── core-briar/             # Mesh P2P wrapper
├── module-livekit/         # LiveKit + Tor voice tunnel
├── module-payments/        # Cashu + Zeus + WalletConnect
└── ui/                     # Design system + shared UI utilities
```

### Module Purpose Summary

* **core-crypto** → Ed25519 signing, X25519 DH, AES-256-GCM
* **core-briar** → Offline mesh routing for text + file transfers
* **module-livekit** → Real-time voice/video over Tor
* **module-payments** → Bitcoin, Lightning, Cashu eCash, stablecoins
* **ui** → Shared UI library for consistent design

---

# 4. 🖥️ **server/** (future, optional)

Used only if you decide to add online routing, mailbox servers, or private LiveKit SFU.

```
server/
├── livekit-server/         # Self-hosted SFU (optional)
└── mailbox-server/         # Device inbox for async delivery
```

Not required for decentralized use.

---

# 5. 📚 **docs/**

Structured documentation for developers and contributors.

```
docs/
├── architecture/
│   ├── monorepo-structure.md
│   ├── architecture-overview.md
│   ├── component-diagrams.md
│   └── threat-model.md
├── protocol-spec/
│   ├── crypto-spec.md
│   ├── handshake.md
│   └── messaging-protocol.md
└── api/
    ├── briar-adapter.md
    ├── livekit-adapter.md
    └── payments-adapter.md
```

---

# 6. ⚙️ Build Files

```
build.gradle.kts            # Global Gradle config
settings.gradle.kts         # Module registration
gradle.properties           # JVM, versions, flags
```

---

# 🎯 Purpose of the Monorepo

This structure guarantees:

* Clean isolation between modules
* Easy updates to upstream open-source libraries
* Full offline build reproducibility
* Secure foundation (no untrusted remote dependencies)
* Rapid development speed as the product grows

---
