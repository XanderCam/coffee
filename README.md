# Coffee Counter App ☕

A native Android app that tracks your daily coffee consumption with fun features:
- Cup counter with daily tracking
- Funny coffee quotes
- User taunting for excessive consumption
- Glass effect UI with custom background
- Consumption history
- Coffee drink recommendations
- Spotify integration for coffee-themed music

## Features

### Core Functionality
- **Cup Counter**: Track your daily coffee intake
- **Daily Quotes**: Motivational/funny coffee quotes
- **Consumption Warnings**: Get notified when drinking too much
- **History Tracking**: View weekly/monthly consumption patterns

### Additional Features
- **Coffee Tips**: Discover new coffee drinks
- **Spotify Integration**: Play coffee-themed playlists
- **Beautiful UI**: Glass morphism design with custom background

## Technical Details

### Architecture
- MVVM (Model-View-ViewModel)
- Single Activity with Fragments
- Repository pattern for data access

### Technologies
- Kotlin
- Android Jetpack Components:
  - ViewModel
  - LiveData
  - Room Database
  - Navigation Component
- Spotify SDK
- MPAndroidChart

## Setup Instructions

### Prerequisites
- Android Studio (latest version)
- Spotify Developer Account
- Physical device or emulator with Android 8.0+

### Configuration Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/CoffeeCounter.git
   ```
2. Open project in Android Studio
3. Get Spotify Client ID:
   - Create app at [Spotify Developer Dashboard](https://developer.spotify.com/dashboard/)
   - Note your Client ID
4. Add Client ID:
   - Open `SpotifyManager.kt`
   - Replace `your_spotify_client_id_here` with your actual ID
5. Build and run the app

### Spotify Setup
1. Ensure you have Spotify app installed on your test device
2. Log in with a Premium account
3. Grant permissions when prompted

## Screenshots
| Main Screen | History | Tips | Music |
|-------------|---------|------|-------|
| ![Main](screenshots/main.png) | ![History](screenshots/history.png) | ![Tips](screenshots/tips.png) | ![Music](screenshots/music.png) |

## Contributing
1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Open a pull request

## Known Issues
- Spotify integration requires manual app restart after first connection
- Chart labels may overlap on small screens

## Requirements
- Android 8.0+ (API 26)
- Spotify Premium account for music features

## Screenshots
(Add screenshots after testing)

## License
MIT License