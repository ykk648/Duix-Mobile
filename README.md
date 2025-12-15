English | [简体中文](/README_zh.md) 

# 🚀🚀🚀 Duix Mobile — The Best Real-time Interactive AI Avatar Solution for Mobile Devices

## 🔧 Fork Modifications (Custom Model Support)

This fork adds support for loading **custom unencrypted NCNN models** while keeping the original config/bbox/weight files decrypted through `resource_loader.jar`.

### Key Changes

| File | Modification |
|------|--------------|
| `munet.h/cpp` | Input normalization: `[0,255]→[0,1]`, channel order: `[mask, real]`, output: Sigmoid `[0,1]→[0,255]` |
| `DUIX.java` | Added `setCustomModelPath(paramPath, binPath)` method |
| `RenderThread.java` | Added custom model path support |
| `DuixNcnn.java` | Added `initDirect()` native method |
| `DuixJni.cpp` | Added JNI implementation for `initDirect()` |

### Usage

```java
// Create DUIX instance
DUIX duix = new DUIX(context, "Kai", renderSink, callback);

// Set custom NCNN model paths (call BEFORE init())
duix.setCustomModelPath(
    "/path/to/your/model.param",  // Your trained NCNN param file
    "/path/to/your/model.bin"     // Your trained NCNN bin file
);

// Initialize (config.j, bbox.j, weight_168u.bin still decrypted via resource_loader.jar)
duix.init();
```

### Model Requirements

- Input normalization: `[0, 255] → [0, 1]` (ToTensor style)
- Input channel order: `[mask, real]` (6 channels)
- Output activation: **Sigmoid** `[0, 1]`
- Audio input: `256×20×1` (WeNet BNF features)

---

🔗 **Official website**：[www.duix.com](http://www.duix.com)

**📱 Cross-platform support: iOS / Android / Tablet / Automotive / VR / IoT / Large Screen Interaction, etc.**

https://github.com/user-attachments/assets/6cfb59fc-d4bb-4c9f-8a2b-54009ce594a1

## 😎 What is Duix Mobile?

Duix Mobile is an open-source SDK developed by [www.duix.com](http://www.duix.com) that enables developers to create real-time interactive AI avatars directly on **mobile devices** or **embedded screens**. It is designed for on-device deployment, with no dependency on cloud servers, making it lightweight, private, and highly responsive.

Developers can easily integrate their own or third-party Large Language Models (LLM), Automatic Speech Recognition (ASR), and Text-to-Speech (TTS) services to quickly build AI avatar interfaces that can naturally converse with users.

Duix Mobile supports one-click cross-platform deployment (Android/iOS), has a low learning curve, and is suitable for various application scenarios such as intelligent customer service, virtual doctors, virtual lawyers, virtual companions, and virtual tutors.

Start building your own interactive AI avatar now and significantly boost your product performance!

## 🤩 Application Scenarios

- Duix Mobile supports various practical application scenarios across Android/iOS/Pad/large screen devices;
- Significantly enhance your product performance and boost your revenue levels.

<!-- ![example.png](./res/example.png) -->

## 🥳 Advantages

- **Realistic AI avatar Experience**: Natural facial expressions, tone, and emotional cues enable truly human-like conversations.
- **Streaming Audio Support**: Synthesize and speak simultaneously, supports interruption and barge-in, making AI avatars not only talk but also behave more "human-like".
- **Ultra-Low Latency**: AI avatar response latency under 120ms (tested on Snapdragon® 8 Gen 2 SoC), delivering millisecond-level smooth interaction experience.
- **Cost-Friendly, Deploy Anywhere**: Lightweight operation, extremely low resource consumption, easily adaptable to phones, tablets, smart screens, and other terminals.
- **Stable in Poor Networks**: Core functions run locally with low network dependence, ideal for finance, government, and legal use cases.
- **Modular & Customizable**: Designed with modularity to support fast customization of industry-specific AI avatar solutions.

## 📑 Development Documentation

- For Android Developers: [Duix Mobile SDK for Android](./duix-android/dh_aigc_android/README.md)
- For iOS Developers: [Duix Mobile SDK for iOS](./duix-ios/GJLocalDigitalDemo/README.md)

## ✨ Public AI avatar Downloads

- 4 public AI avatars provided by Duix, available for download and integration.

<table>
    <tr>
      <td align="center">
        <img src="./res/avatar/Leo.jpg" alt="Model 5" width="100%"><br>
        <a href="https://github.com/duixcom/Duix.mobile/releases/download/v2.0.1/Leo.zip">Download</a>
      </td>
      <td align="center">
        <img src="./res/avatar/Oliver.jpg" alt="Model 6" width="100%"><br>
        <a href="https://github.com/duixcom/Duix.mobile/releases/download/v2.0.1/Oliver.zip">Download</a>
      </td>
      <td align="center">
        <img src="./res/avatar/Sofia.jpg" alt="Model 6" width="100%"><br>
        <a href="https://github.com/duixcom/Duix.mobile/releases/download/v2.0.1/Sofia.zip">Download</a>
      </td>
      <td align="center">
        <img src="./res/avatar/Lily.jpg" alt="Model 6" width="100%"><br>
        <a href="https://github.com/duixcom/Duix.mobile/releases/download/v2.0.1/Lily.zip">Download</a>
      </td>
    </tr>
    </table>

View more AI avatars online：[www.duix.com](http://www.duix.com)

## 🤗 How to Customize Private AI avatars?

- Please send an email to: [support@duix.com](mailto:support@duix.com)

## 🙌 Frequently Asked Questions

- Can I integrate my own Large Language Model (LLM), Speech Recognition (ASR), and Text-to-Speech (TTS)?
    
    Yes, Duix Mobile supports full integration with custom or third-party LLM, ASR, and TTS services.
    
- Does it support "lip synchronization"?
    
    Yes, it does.
    
- Does it support "multilingual subtitles"?
    
    Yes, it does.
    
- How can I create custom AI avatars?
    
    We offer 4 public avatar models. For custom avatars, please contact us via the email address above.
    
    Usually, providing a 15-second to 2-minute video is typically sufficient for customization.
    
- Is streaming audio supported?
    
    Yes, streaming audio with barge-in support is available from the July 17, 2025 release.
    
- Are voice start/end callbacks available?
    
    Yes, callback events for voice start and end are fully documented.
    

## 💡 Version Roadmap

- [x]  Streaming audio capability, launched on July 16, 2025
- [x]  Algorithm response optimization, expected by August 30, 2025

## ❇️ Other projects by Duix

- [Duix.com](http://Duix.com) - Easily integrable cloud-based real-time interactive AI avatar
- [Duix-Avatar](https://github.com/duixcom/Duix.Avatar) - The true open-source AI avatar video production
- [Duix-Reface](https://github.com/duixcom/Duix-Reface) - Truly open-source real-time, high-fidelity face-swap engine for AI avatar
