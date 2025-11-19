# Nutrition Tracker

Honours project for MEng Software Engineering at Edinburgh Napier University.

## What is this?

A mobile nutrition app that gives you feedback on what you're eating without showing calories or exact numbers. Instead of "450 calories", it shows "High Fiber" or "Low Iron" - the kind of info that's actually useful without being triggering.

The idea came from research showing that calorie-counting apps can be harmful, especially for people with histories of disordered eating. This app tries to be helpful without adding to that problem.

## Current Status

**Active Development** - November 2025

### Completed:
- ✅ User authentication (Firebase)
- ✅ Sign up and login flow
- ✅ 6-step onboarding (age, height, weight, activity level, goals)
- ✅ Welcome screen with modern UI
- ✅ Data persistence with SharedPreferences
- ✅ Main app with tab navigation (Home, Log Meal, Profile)

### In Progress:
- Meal logging with SQLite database
- Food search functionality
- Barcode scanner integration

### Planned:
- Qualitative nutrient feedback algorithm
- Food database integration
- AI meal suggestions
- User testing with target demographic

## Tech Stack

- **Platform**: Native Android
- **Language**: Java
- **Authentication**: Firebase Auth
- **Database**: SQLite (planned)
- **UI**: Material Design 3
- **Min SDK**: API 24 (Android 7.0)
- **Target SDK**: API 36

## Setup

1. Clone the repo
   ```bash
   git clone https://github.com/your-username/nutrition-tracker.git
   ```

2. Open in Android Studio

3. Add your Firebase configuration:
   - Create a Firebase project
   - Download `google-services.json`
   - Place in `app/` directory

4. Sync Gradle and run

## Project Goals

The core idea is to provide nutritional guidance without the harmful aspects of traditional calorie-counting apps:

- No calorie counts or exact numbers
- Qualitative feedback only ("High Fiber", "Good Protein", etc.)
- Support intuitive eating principles
- Calm, non-judgmental design
- Appropriate for users with complicated relationships with food tracking

## Design Decisions

**Colors**: Forest green gradient with warm beige backgrounds. Trying to keep it calm and approachable rather than clinical or anxiety-inducing.

**Authentication**: Firebase for security and ease of implementation. Onboarding captures basic user info (age, height, weight, activity, goals) for future personalized recommendations.

**UI**: Material Design 3 with rounded corners, modern input fields, progress indicators. No harsh edges or intimidating forms.

## Academic Context

**Institution**: Edinburgh Napier University  
**Expected Completion**: April 2026  
**Credits**: 40 (Honours Project)

Research foundation:
- Eikey et al. (2021) - Harm from calorie-counting apps
- Hahn et al. (2021) - User dissatisfaction with tracking
- Linardon & Messer (2019) - Intuitive eating benefits
- Hazzard et al. (2020) - Long-term effects of intuitive eating
- Solbrig et al. (2017) - User perspectives on nutrition apps

## Development Timeline

- **Oct-Nov 2025**: UI design, authentication, onboarding ✅
- **Dec 2025-Jan 2026**: Meal logging, database, food search
- **Feb 2026**: Qualitative feedback system, feature completion
- **Mar 2026**: User testing and refinement
- **Apr 2026**: Dissertation writing and submission

## Notes

This is an active project and things will change as development continues. The focus is on building something that's actually helpful without being harmful.

---

Last updated: November 19, 2025
