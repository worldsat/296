# VeloBank Production Design Specification
**Target Framework:** Jetpack Compose (Material 3)
**Visual Identity:** Futuristic Financial / Dark Glassmorphism

---

## 1. GLOBAL DESIGN TOKENS

### Color Palette (Material 3 Mapping)
| Role | Hex Code | Usage |
| :--- | :--- | :--- |
| **Primary** | `#ff3399` | Brand accent, active states, key icons. |
| **Primary Container** | `#4d0026` | Subtle background for active nav items. |
| **On-Primary** | `#ffffff` | Content on top of primary colors. |
| **Secondary (CTA)** | `#7000ff` | Secondary buttons, interactive accents. |
| **Surface** | `#131313` | Main app background. |
| **Surface Variant** | `#1c1b1b` | Cards, input fields, container backgrounds. |
| **On-Surface** | `#ffffff` | Primary text and headlines. |
| **On-Surface Variant** | `#3a3939` | Secondary text, inactive states, dividers. |
| **Outline** | `#ffffff1a` | Borders for cards and interactive elements. |
| **Glow (Custom)** | `rgba(255, 51, 153, 0.4)` | Outer glow for active elements and chart highlights. |

### Typography (Hanken Grotesk)
| Style | Size (sp) | Weight | Line Height |
| :--- | :--- | :--- | :--- |
| **Headline Large** | 32sp | Bold | 40sp |
| **Title Large** | 22sp | SemiBold | 28sp |
| **Title Medium** | 16sp | Medium | 24sp |
| **Body Large** | 16sp | Regular | 24sp |
| **Body Medium** | 14sp | Regular | 20sp |
| **Label Large** | 14sp | Medium | 20sp |
| **Label Small** | 11sp | Medium | 16sp |

### Spacing & Shapes
- **Page Margin:** 20dp
- **Component Spacing (Stack):** 16dp
- **Corner Radius (Standard):** 16dp (Cards, Buttons)
- **Corner Radius (Large):** 24dp (Main Dashboard Cards)
- **Corner Radius (Full):** 100dp (Pill Buttons, Search Bars, Nav Bar)

---

## 2. SCREEN REFERENCE GALLERY

| Screen Title | Technical ID | Structural Purpose |
| :--- | :--- | :--- |
| **VeloBank - Onboarding** | `SCREEN_18` | Entrance flow featuring brand value proposition and main CTA. |
| **VeloBank - Dashboard** | `SCREEN_19` | Main hub featuring balance, card management, recent transfers, and spending analytics. |

---

## 3. COMPONENT-LEVEL SPECIFICATIONS

### Scaffold & Navigation
- **TopAppBar:** Small centered layout. Leading: User Avatar (32dp). Trailing: Notification Bell with Dot.
- **BottomNavBar:** Floating Pill design (`fixed bottom-10`).
  - **Container:** `bg-surface-container/80`, 80% opacity with 3xl blur.
  - **Active State:** `bg-primary-container` with `shadow-[0_0_15px_rgba(255,70,157,0.4)]`.
  - **Destinations:** Home, Analytics, Cards, Settings.

### Custom Cards
- **Credit Card Hero:**
  - **Background:** Linear Gradient (`#ff3399` to `#7000ff`) at 135 degrees.
  - **Overlay:** Subtle concentric circles (SVG stroke).
  - **Layout:** Vertical arrangement. Top: Card Type Icon. Middle: Masked Card Number. Bottom: Cardholder Name + Expiry.
- **Analytics Card:**
  - **Background:** `Surface Variant`.
  - **Chart Component:** Vertical Bar Chart. Inactive bars: `#ffffff1a`. Active bar (Today): `#ff3399` with glow effect.

### Interactive Elements
- **Quick Action Buttons:** Square `Surface Variant` containers with centered icons and labels below.
- **Transfer List:** Horizontal `LazyRow` of circular profile images with names below.

---

## 4. FIXED IMAGE ASSET REGISTRY

| Asset | Description | Token/Placeholder |
| :--- | :--- | :--- |
| **Hero Card Stack** | Visual stack of colorful Velo cards for onboarding. | `{{DATA:IMAGE:IMAGE_10}}` |
| **PWA Icon** | Abstract 'V' motif with glassmorphism for app icon. | `{{DATA:IMAGE:IMAGE_20}}` |
| **Apple Touch Icon** | Premium shield/bank symbol for iOS home screens. | `{{DATA:IMAGE:IMAGE_9}}` |
| **User Profile** | High-quality portrait of Jude Kylian Jr. (Circular clip). | `{{DATA:IMAGE:IMAGE_4}}` |

---

## 5. AI IMPLEMENTATION SPECIAL INSTRUCTIONS

### Architecture & Patterns
- **Pattern:** MVVM (Model-View-ViewModel) using Compose State.
- **Theming:** Wrap app in a custom `VeloTheme` that provides the `VeloColors` and `VeloTypography` tokens.
- **Animations:**
  - Use `AnimatedVisibility` for entrance transitions of dashboard sections.
  - Implement `InfiniteTransition` for the subtle glow pulse on the active chart bar.

### Visual Constraints for AI Code-Generators (Cursor/Claude):
> "When generating Jetpack Compose code for VeloBank, strictly enforce the `#ff3399` primary accent. All buttons must use `RoundedCornerShape(100dp)`. For the Bottom Bar, use a `Box` with `Modifier.align(Alignment.BottomCenter)` and a `graphicsLayer` for the shadow and glassmorphism (blur) effect. Ensure the Bar Chart bars are generated using a `Canvas` or `Box` with fixed widths (12dp) and heights based on a normalized data set. Active states must include a shadow blur with `color = Color(0xFFFF3399).copy(alpha = 0.4f)`."

---
