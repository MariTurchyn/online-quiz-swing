# 🧠 Online Quiz (Java + Swing)

A **Java Swing desktop quiz application** designed to deliver a fun, interactive learning experience.
Built with &**Java 17/18, Swing, and FlatLaf**, it showcases elegant UI design, modular architecture, and clear user flow through multiple quiz categories.

## 📘 Overview

The **Online Quiz System** allows users to test their general knowledge through multiple categories.
It provides a seamless, step-by-step experience:

**Login → Choose Category → Answer 7 Questions → View Results → Retry**

Each quiz category has 7 multiple-choice questions with instant scoring and feedback.

## ✨ Features

- 🎨 **Modern UI** styled with FlatLaf (rounded corners, focus effects, and clean pastel look)

- 🖼️ **Global** background image shared across all panels

- 🧭 **Smooth navigation flow** between login, quiz, and results screens

- 🧩 **Five categories**: Capitals, Currencies, Languages, Flags, and Continents

- ✅ **7 questions per quiz**, each with 4 answer options

- ♻️ **Dynamic panel recreation** for each quiz attempt (no stale data)

- 🧪 **JUnit 5 testing support** for validating quiz logic and results

## 🧠 Architecture

The system is built with **modular design** and **CardLayout navigation**, ensuring easy extension and maintenance.

## 🧩 Core Components
```bash 
| Component           | Description                                         |
| ------------------- | --------------------------------------------------- |
| **AppFrame**        | Main window that manages all screens via CardLayout |
| **BackgroundPanel** | Holds the shared background image for all panels    |
| **LoginPanel**      | Collects player’s name before starting the quiz     |
| **CategoryPanel**   | Displays all quiz categories for selection          |
| **QuizPanel**       | Handles questions, user answers, and scoring        |
| **ResultPanel**     | Displays the final result and options to retry      |
| **QuizService**     | Supplies randomized questions per category          |
```
## 🛠️ Tech Stack
``` bash
| Category         | Tools & Libraries                            |
| ---------------- | -------------------------------------------- |
| **Language**     | Java 17 / 18                                 |
| **UI Framework** | Swing + FlatLaf                              |
| **Build Tool**   | Maven                                        |
| **Testing**      | JUnit 5                                      |
| **Architecture** | CardLayout + Service-Oriented Modular Design |
```

## 🚀 How to Run
### 🧩 Prerequisites

- JDK 17 or newer (built with Java 18)

- Maven 3.8 or later

### ▶️ Run from IntelliJ IDEA

1.Open the project in IntelliJ

2.Run the class:

```bash
app.Main

```
### ▶️ Run from Terminal

```bash
mvn -q exec:java -Dexec.mainClass=app.Main

```

## 📂 Project Structure
``` bash
src/main/java/
 ├─ app/
 │   ├─ Main.java              # Entry point
 │   ├─ AppFrame.java          # Main JFrame (CardLayout manager)
 │   ├─ BackgroundPanel.java   # Background layer shared across UI
 │   ├─ LoginPanel.java        # User login
 │   ├─ CategoryPanel.java     # Category selection screen
 │   ├─ QuizPanel.java         # Quiz logic and question flow
 │   └─ ResultPanel.java       # Displays final score and retry option
 ├─ model/
 │   └─ Question.java          # Represents quiz question data
 ├─ service/
 │   └─ QuizService.java       # Provides questions per category
src/main/resources/
 └─ background.jpg             # Shared background image

```
## 🖼️ Screenshots
### 🧭 Category Selection
<img width="1011" height="603" alt="image" src="https://github.com/user-attachments/assets/d92c9276-8f34-498b-95ac-cbe0ebb97e63" />
### 🧩 Quiz in Progress
<img width="987" height="607" alt="image" src="https://github.com/user-attachments/assets/d1837857-8c44-48c1-8af2-3ea06c335cda" />

## 🧾 Key Highlights

- ✅ FlatLaf modern look & feel
- ✅ Seamless multi-screen flow using CardLayout
- ✅ Clean modular MVC structure
- ✅ Instant scoring and quiz feedback
- ✅ Ready for JUnit 5 testing
- ✅ Lightweight, academic-grade Java project

## ⚙️ Technologies

**Java · Swing · FlatLaf · JUnit 5 · Maven (academic)**
