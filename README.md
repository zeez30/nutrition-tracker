# Nutrition Tracker

A mobile nutrition tracking application that provides **qualitative feedback** on meals without displaying calories or exact nutrient counts. Designed to support intuitive eating and healthy food relationships.

> **Note:** This is an active honours project for MEng Software Engineering at Edinburgh Napier University. Expected completion: April 2026.

---

## 🎯 Project Overview

Traditional nutrition apps often focus heavily on calorie counting and numerical metrics, which can trigger unhealthy behaviors in vulnerable users. This app takes a different approach by providing **gentle, qualitative guidance** (e.g., "High Fiber", "Low Iron") instead of exact numbers.

### Target Audience
- Adults seeking healthier eating habits
- Individuals in eating disorder recovery
- Anyone who wants nutritional awareness without calorie counting

### Core Philosophy
- **No calorie counts** - Removes anxiety-inducing numerical tracking
- **Qualitative feedback** - Simple, easy-to-understand labels
- **Intuitive eating support** - Focuses on balance, not restriction
- **Calming design** - Sage green aesthetic promotes wellness

---

## ✨ Features

### Currently Implemented
- ✅ **Dashboard** - View recent meals with qualitative nutrient badges
- ✅ **Log Food Options** - Choose from barcode scanning, database search, or AI meal builder
- ✅ **Sage Green Design System** - Calming, wellness-focused color palette
- ✅ **Qualitative Badges** - Color-coded nutrient feedback (Good Protein, High Sodium, etc.)

### In Development
- 🚧 Barcode scanner for packaged foods
- 🚧 Searchable food database
- 🚧 AI-powered meal builder with substitution suggestions
- 🚧 User profile and personalized goals
- 🚧 Nutrient classification algorithm

### Planned Features
- 📋 UK nutrition API integration (CoFID/Foodle)
- 📋 SQLite local database
- 📋 Goal tracking and insights
- 📋 User testing with target demographic

---

## 🎨 Design

### Color Palette

**Sage Green Theme** - Chosen for its calming, natural qualities
- Primary Background: Warm light sage (`#EAE9DD`)
- Cards: Darker sage (`#DDD9C8`)
- Primary Accent: Mauve (`#B5838D`)
- Text: Dark olive/green (`#333D29`)

**Badge Colors:**
- 🟢 **Positive** (Good/High beneficial): Soft olive green
- 🟡 **Caution** (Low levels): Warm tan
- 🔴 **Alert** (High concerning): Dusty rose (gentle, not harsh red)
- 🔵 **Info**: Soft periwinkle

### Design Principles
- **Calming over clinical** - Warm, earthy tones instead of sterile whites
- **Clear hierarchy** - Card-based UI with proper elevation
- **Accessible** - High contrast text on backgrounds
- **Touch-friendly** - Large, clear tap targets
- **Minimalist** - Outline icons, clean layouts

---

## 🛠 Tech Stack

- **Platform:** Native Android
- **Language:** Java
- **IDE:** Android Studio
- **Min SDK:** TBD
- **Target SDK:** API 34 (Android 14)
- **Architecture:** MVC pattern
- **Version Control:** Git with feature branching

### Key Dependencies
- AndroidX AppCompat
- Material Components
- CardView

### APIs (Planned)
- CoFID (UK Composition of Foods Integrated Dataset)
- Foodle API

---

## 📱 Screenshots

### Home Screen (Dashboard)
![Home Screen](docs/screenshots/home-screen.png)
*Dashboard showing recent meals with qualitative nutrient badges*

### Log Food Screen
![Log Food Screen](docs/screenshots/log-food-screen.png)
*Options for logging food: barcode scan, database search, or AI meal builder*

> **Note:** Screenshots will be added as development progresses.

---

## 🚀 Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- JDK 17 or later
- Android SDK
- Git

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/zeez30/nutrition-tracker.git
   cd nutrition-tracker
   ```

2. **Open in Android Studio**
   - File → Open
   - Select the `nutrition-tracker` directory
   - Wait for Gradle sync to complete

3. **Run the app**
   - Create an Android Virtual Device (AVD) or connect a physical device
   - Click the green "Run" button
   - Select your device/emulator

---

## 📂 Project Structure

```
NutritionTracker/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/syeda/nutrition_tracker/
│   │   │   │   ├── MainActivity.java
│   │   │   │   └── LogFoodActivity.java
│   │   │   ├── res/
│   │   │   │   ├── layout/          # XML layouts
│   │   │   │   ├── drawable/        # Icons, badges, buttons
│   │   │   │   └── values/          # Colors, strings, themes
│   │   │   └── AndroidManifest.xml
│   └── build.gradle
├── docs/                             # Documentation
└── README.md
```

---

## 🌿 Development Approach

This project follows **incremental development** with feature branching:

- `master` - Stable production code
- `dev` - Integration branch
- `feature/*` - Individual features

### Branching Strategy
```bash
# Create a new feature branch
git checkout -b feature/feature-name

# Work on the feature...
git add .
git commit -m "feat: description of feature"

# Push to GitHub
git push origin feature/feature-name
```

### Commit Convention
- `feat:` - New features
- `fix:` - Bug fixes
- `docs:` - Documentation changes
- `style:` - Formatting, UI changes
- `refactor:` - Code restructuring

---

## 🔬 Research Background

This project is grounded in academic research on nutrition apps and eating disorders:

- **Eikey et al. (2021)** - Documented harm caused by calorie-tracking apps
- **Hahn et al. (2021)** - User dissatisfaction with numerical tracking
- **Linardon & Messer (2019)** - Benefits of intuitive eating approaches
- **Hazzard et al. (2020)** - Long-term protective effects of intuitive eating
- **Solbrig et al. (2017)** - User perspectives on nutrition apps

---

## 🎓 Academic Context

**Course:** MEng Software Engineering, Year 4  
**Module:** Honours Project (40 Credits)  
**Institution:** Edinburgh Napier University  
**Supervisor:** Peter Chapman  
**Expected Completion:** April 2026

### Project Objectives
1. Design and implement a mobile nutrition app with qualitative feedback
2. Support intuitive eating principles through non-numerical guidance
3. Create a calming, accessible UI appropriate for vulnerable users
4. Evaluate effectiveness through user testing with target demographic
5. Demonstrate professional software engineering practices

---

## 📊 Project Status

**Current Phase:** Early Development (October 2025)

| Feature | Status |
|---------|--------|
| Home Screen | ✅ Complete |
| Log Food Navigation | ✅ Complete |
| Color System | ✅ Complete |
| Barcode Scanner | 🚧 In Progress |
| Food Database | 📋 Planned |
| AI Meal Builder | 📋 Planned |
| User Profile | 📋 Planned |
| Database Integration | 📋 Planned |

**Development Timeline:**
- Oct-Nov 2025: Core UI and navigation
- Dec 2025-Jan 2026: Database and API integration
- Feb 2026: Feature completion and refinement
- Mar 2026: User testing
- Apr 2026: Final evaluation and dissertation submission

---

## 🤝 Contributing

As this is an academic project, external contributions are not currently accepted. However, feedback and suggestions are welcome via Issues.

---

## 📝 License

This project is developed as part of an academic honours project. All rights reserved pending project completion and evaluation.

---

## 📧 Contact

**Developer:** Syeda  
**GitHub:** [@zeez30](https://github.com/zeez30)  
**Institution:** Edinburgh Napier University

---

## 🙏 Acknowledgments

- Edinburgh Napier University School of Computing
- Academic research on intuitive eating and nutrition app design
- Android development community
- Material Design guidelines

---

**Last Updated:** October 19, 2025