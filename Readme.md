# 🎯 Quiz Management System (Java Swing)

A simple **Quiz Management System** developed using **Java Swing**. This desktop application provides separate modules for **Admin** and **Student**, allowing administrators to manage quiz questions and students to attempt quizzes with automatic score calculation.

---

## 📌 Features

### 👨‍💼 Admin Module
- Admin Dashboard
- Add Questions
- View Questions
- Delete Questions
- Logout

### 👨‍🎓 Student Module
- Student Dashboard
- Start Quiz
- Multiple Choice Questions (MCQ)
- Automatic Score Calculation
- Result with Percentage
- Pass/Fail Status

---

## 🛠️ Technologies Used

- Java
- Java Swing (GUI)
- OOP (Object-Oriented Programming)
- ArrayList (Question Storage)

---

## 📁 Project Structure

```
QuizManagementSystem/
│
├── Main.java
├── LoginFrame.java
├── AdminLogin.java
├── AdminDashboard.java
├── StudentDashboard.java
│
├── AddQuestionFrame.java
├── ViewQuestionFrame.java
├── QuizFrame.java
├── ResultFrame.java
├── ViewResultFrame.java
│
├── Question.java
├── QuestionStore.java
├── Result.java
├── ResultStore.java
│
└── README.md

---

## 🖥️ Screens

### Home Screen
- Admin Login
- Student Login
- Exit

### Admin Dashboard
- Add Question
- View Questions
- Delete Question
- Logout

### Student Dashboard
- Start Quiz
- Logout

### Quiz Window
- Displays one question at a time
- Four options (MCQ)
- Next/Finish button

### Result Window
- Total Questions
- Correct Answers
- Wrong Answers
- Percentage
- Pass/Fail Status

---

## ▶️ How to Run

### Step 1
Clone the repository

```bash
git clone https://github.com/your-username/QuizManagementSystem.git
```

### Step 2
Open the project in:

- VS Code
- Eclipse
- IntelliJ IDEA
- NetBeans

### Step 3
Compile all Java files

```bash
javac *.java
```

### Step 4
Run the application

```bash
java Main
```

---

## 🔄 Application Flow

```
Main
   │
   ▼
Login Frame
   │
   ├───────────────┐
   │               │
   ▼               ▼
Admin          Student
   │               │
Manage      Attempt Quiz
Questions         │
   │              ▼
View Questions  Result
```

---

## 🚀 Future Enhancements

- Admin Authentication
- Student Login with Username
- Save Questions to File
- Import Questions from PDF
- Export Results to PDF
- Quiz Timer
- Random Question Order
- Result History
- Leaderboard
- Dark Theme
- Better UI Design
- MySQL Database Support
- Charts using JFreeChart

---

## 📚 Learning Concepts

- Java Swing
- Event Handling
- Object-Oriented Programming
- ArrayList
- GUI Development
- Exception Handling

---

## 👨‍💻 Author

**Anshu Rajput**
<br/>
**Abhinav Tiwari**

GitHub: https://github.com/Abhinaav2003

---

## ⭐ Support

If you found this project useful, please ⭐ star the repository and share it with others.

---

## 📄 License

This project is licensed under the MIT License.
