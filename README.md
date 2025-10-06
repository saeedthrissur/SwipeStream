# SwipeStream — Watch, read, listen — your way

**SwipeStream** is an open-source, privacy-first content hub: a modular short-video & feed viewer that aggregates public content (shorts, reels, posts, stories, images, RSS) and local media into a single, customizable app. Designed Android-first (Dark AMOLED default), with a roadmap for desktop/web.

> Watch, read, listen — offline, private, and open.

---

## Key goals
- Unified viewer for short-video, posts, stories and images.  
- Privacy-first: no tracking, optional logins, data stored locally.  
- Modular extractors: add new platforms without rebuilding the core app.  
- Powerful local/offline features: local playlists, trimmed share, offline feeds.  
- Developer friendly: clear extractor APIs and extensible UI components.

---

## Features (short)
- Swipe-based short video viewer (vertical swipe).  
- Mixed feed: local + online content in one stream.  
- Extractor system: plug-in extractors for YouTube, Instagram, TikTok, X, Threads, RSS, custom URLs.  
- Offline collection manager: folders, playlists, adjustable clip lengths, mixed playback.  
- Powerful global search across configured sources with filters (platform, user/channel, tags, date, location).  
- Music/audio mode (audio-only playback and track search).  
- Privacy controls: local-only mode, optional network sources, per-source permissions.  
- Customization: change app name, logo, theme, tabs, feed order.  
- Minimal permissions approach and scoped storage for Android.

---

## Default settings & customization
- **Default app name:** `SwipeStream` (user can change app name & branding in Settings).  
- **Default theme:** Dark AMOLED (user-changeable to Light / Material / Hybrid).  
- **Platform target:** Android-first; desktop/web planned for later stages.  
- **Modes:** Online / Offline / Mixed (selectable in Settings).  
- **Branding:** name, logo, theme, tabs and home layout are configurable via Settings or config file.

---

## Tech stack (suggested)
- App: Kotlin + Jetpack Compose  
- Video playback: ExoPlayer  
- Extractors: NewPipe Extractor style / yt-dlp wrappers / custom scrapers (modular)  
- Music metadata: Spotube-style modules / public APIs (Jamendo, etc.)  
- Storage: Room (SQLite), file cache using Scoped Storage  
- Networking: Retrofit / OkHttp (with user-controlled network policy)  
- UI: Material 3 (customized for AMOLED), gesture system, Compose Navigation

---

## Architecture (high level)
```
App UI (Compose)
 ├─ Feed Manager
 │   ├─ Online Feed Adapter (multi-source)
 │   ├─ Local Feed Adapter (device storage)
 │   └─ Mixed Feed Composer (user rules)
 ├─ Extractor Manager
 │   ├─ Extractor API (v1) — standard interface for fetch/list/meta
 │   └─ Extractor plugins (YouTube, Insta, TikTok, RSS, Custom)
 ├─ Playback Module (ExoPlayer)
 │   ├─ Video Player
 │   └─ Audio Player (mini-mode)
 ├─ Storage
 │   ├─ Room DB (metadata)
 │   └─ File cache / local folders
 └─ Settings & Permissions
```

### Extractor API (example minimal interface)
- `search(query, platform, filters) -> SearchResults`
- `getFeed(sourceId, pageToken?) -> FeedPage`
- `getItem(itemId) -> ItemDetail`
- `downloadMedia(mediaUrl, destination, progressCallback)`
- `getAudioTrackMetadata(itemId) -> TrackInfo`

(Each extractor must declare `platform`, `permissionsRequired`, `rateLimitPolicy`.)

---

## Roadmap (staged)
**v1.0 (MVP)**  
- Core short video viewer (offline + YouTube via extractor)  
- Local playlists, swipe controls, basic settings

**v2.0**  
- Add Instagram & TikTok extractors  
- Basic search across sources

**v3.0**  
- Image/post/story viewer + mixed feed UI  
- Trim & share clip feature

**v4.0**  
- Global search with advanced filters, trending module, location filters  
- Recommendation bundle (local-only or opt-in)

**v5.0**  
- Audio/music based search, Spotube-like integration  
- Desktop/web prototype (Electron/Compose Multiplatform/React)

**v6.0+**  
- Modular feed store, user-created extractors marketplace (FOSS-licensed)  
- Federation support / decentralized content connectors (optional)

---

## UI / UX principles
- Single-column swipe stream for short form content.  
- Mixed content type support (videos, images, text posts) in one stream.  
- Lightweight profile and channel screens — no social graph required.  
- Full gesture set: swipe, long-press, two-finger pinch-to-zoom, drag to crop.  
- Minimal, accessible controls — one-handed use support.

---

## Settings (must-have)
- App branding: change app name, logo, accent color.  
- Theme: Dark AMOLED (default) / Light / Hybrid.  
- Home Feed: choose tabs, order, and default feed type (Shorts / Posts / Mixed / Offline).  
- Online Mode: Online / Offline / Mixed (selectable).  
- Privacy: analytics toggle, local-only toggle, per-source permission.  
- Storage: cache size, auto-clean rules, storage location.  
- Extractors: enable/disable extractors, manage update sources.  
- Developer: enable logging, extractor testing tools, mock mode.

---

## Example config (user-editable JSON)
```json
{
  "branding": {
    "appName": "SwipeStream",
    "logoPath": "icons/swipestream.png",
    "accentColor": "#00FFAA"
  },
  "theme": "dark_amoled",
  "mode": "mixed",
  "feeds": [
    { "id": "local1", "type": "local_folder", "path": "/sdcard/Movies/Shorts" },
    { "id": "yt_trending", "type": "extractor", "platform": "youtube", "query": "trending" },
    { "id": "custom_rss", "type": "rss", "url": "https://example.com/feed.xml" }
  ]
}
```

---

## Contributing
- Read `CONTRIBUTING.md` (create one).  
- Core areas: extractor plugins, UI/UX improvements, playback features, privacy audits.  
- Run tests and linters: Kotlin lint, Compose UI tests.  
- Submit PRs to `main` or feature branches; maintainers will review.  
- Translation and localization welcome (include Malayalam and Arabic for UI and sample content).

---

## Security & privacy notes
- Default behavior: no telemetry; user must explicitly enable analytics.  
- Extractors run locally or in app process; clearly document any external service calls.  
- Cache and downloads stored under user-controlled directories.  
- Provide easy data removal (clear cache, delete all downloads).

---

## Sample issue labels
- `bug`
- `enhancement`
- `extractor`
- `ui/ux`
- `privacy`
- `good first issue`
- `help wanted`

---

## Credits & Ownership
- **Original Concept:** Provided by a community member for public use.
- **Ownership:** This project is intentionally abandoned by the concept creator to encourage community takeover. Any developer is free to **Fork** the repository, become the new maintainer, and drive the project forward under the **permissive license**.
- **Customization:** App name, logo, and branding are fully customizable by the new maintainer or end user.

---

## License
This project is licensed under the **MIT License**.

This license grants maximum freedom for anyone to use, modify, and distribute the software, which aligns with the community takeover intent.
*(The full license text is available in the LICENSE file)*

---

## Quick start (developer)
1. Fork the repo.  
2. Set up Android dev environment (Android Studio, Kotlin, Compose).  
3. Implement / enable one extractor (YouTube recommended for v1).  
4. Build the core player and swipe feed.  
5. Open PR with implementation notes and sample extractor config.

---

## Contact & Coordination
This project is currently seeking a new maintainer/leader. 
If you wish to take ownership and coordinate development, please start by forking the repository and using **GitHub Discussions** in your own fork. The original concept creator will not be actively maintaining or coordinating.

---
