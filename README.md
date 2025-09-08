**Online Quiz (Java + Swing)**

A clean, desktop quiz app built with Java 17/18, Swing, and the FlatLaf modern look & feel.
Users enter their name → pick a category → answer 7 multiple-choice questions → see results.
Designed to be readable, themeable, and easy to extend.


**1.Features**

✨ Modern UI with FlatLaf (rounded corners, focus polish

🖼️ Global background image (one photo across all screens)

🧭 Clear flow: Login → Category → Quiz → Result → Back to Categories

🧩 5 categories (Capitals, Currencies, Languages, Flags, Continents)

✅ 7 questions per category, 4 answers each, instant scoring

♻️ Quiz panel recreated per category (no stale state)

🧪 JUnit 5 ready



**2.Tech Stack**

**Java 17/18, Swing**

**FlatLaf** for theming

**Maven** (build + exec plugin)

**JUnit 5** (tests)



**3.Quick Start**

**Prerequisites**

JDK 17+ (project uses release 18)

Maven 3.8+

**Run**

From IntelliJ

Open the project → run Main.

**From terminal**
mvn -q exec:java -Dexec.mainClass=app.Main

The repo already includes exec-maven-plugin so you don’t have to wire classpaths manually.

**4. Project Structure**

<img width="623" height="405" alt="image" src="https://github.com/user-attachments/assets/9146848c-7265-4cbd-a598-c115b41c26f6" />

**5. How It Works (Quick Architecture)**

**AppFrame** hosts a **CardLayout** with 4 screens: login, category, quiz, result.

**BackgroundPanel** is the **content pane**; all screens are non-opaque so the photo shows through.

**QuizService#getQuestions(Category)** returns a List<Question> with exactly 7 questions per category.

**QuizPanel** receives the questions, tracks progress/score, and calls onFinish(score, total).

**ResultPanel** displays the final score and routes back to the category picker.

<img width="1011" height="603" alt="image" src="https://github.com/user-attachments/assets/d92c9276-8f34-498b-95ac-cbe0ebb97e63" />
<img width="987" height="607" alt="image" src="https://github.com/user-attachments/assets/d1837857-8c44-48c1-8af2-3ea06c335cda" />
