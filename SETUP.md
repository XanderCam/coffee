# Android Project Setup Guide

## Prerequisites
1. Install Android Studio
2. Ensure Android SDK is installed (via SDK Manager)
3. Set environment variables:
```bash
export ANDROID_HOME=$HOME/Android/Sdk
export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/platform-tools
```

## Build Instructions
```bash
./gradlew assembleDebug
```

## Cloud Building
This project is configured for GitHub Actions CI/CD
- Last build triggered: $(date +"%Y-%m-%d %H:%M:%S")
