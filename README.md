# Event Programming in Java

A collection of weekly Java exercises exploring event-driven programming, GUI development, JavaFX, and database-backed applications. Most weeks contain several small activities rather than one application.

## Weekly Topics

| Week | Topics and Projects |
|---|---|
| **1** | Procedural vs. event-driven calculators, a Smart Home prototype, and event-handling bug-fix exercises. |
| **2** | Observer pattern examples, including a weather station and custom observers; a JavaFX calculator using FXML. |
| **3** | Swing windows and components, layout managers, the Event Dispatch Thread (EDT), and a student portal mockup. |
| **4** | Swing event listeners: action, item, document, mouse, and keyboard events; counter, registration form, and drawing examples. |
| **5** | Swing lists, tables, trees, tabbed panes, menus, dialogs, and a mini file manager. |
| **6** | JavaFX fundamentals, layouts, FXML, Scene Builder, and dashboard/login examples. |
| **7** | JavaFX events, event propagation, mouse interaction, drag and drop, and custom events. |
| **8** | JavaFX properties and bindings, including one-way and bidirectional binding examples and a reactive form. |
| **9** | JavaFX background work and asynchronous tasks, including progress and task-state demonstrations. |
| **10** | A JavaFX university management application with student records, MySQL connectivity, and background loading/saving tasks. |

## Folder Structure

```text
Event Programming in Java/
│
├── week 1/
│   ├── BugFixChallenge/
│   ├── SmartHome/
│   ├── eventdriven/
│   └── procedural/
│
├── week 2/
│   ├── activity1-weather-station/
│   ├── activity2-legacy-observer/
│   ├── activity3-custom-observer/
│   ├── activity4-comparison/
│   ├── src/
│   └── pom.xml
│
├── week 3/
├── week 4/
├── week 5/
├── week 6/
├── week 7/
│   └── week07-javafx/
├── week 8/
│   └── week08-javafx-bindings/
├── week 9/
│   └── week09-async-javafx/
└── week 10/
    └── university-system/
```

## Requirements

- **Java Development Kit (JDK):** JDK 21 is a good starting point. Check each project's `pom.xml` for its configured Java version.
- **Apache Maven:** Required for projects containing a `pom.xml`.
- **MySQL:** Required for the Week 10 university management system.
- **Visual Studio Code or another Java IDE:** For editing and running the exercises.

## Running Maven Projects

Open a terminal in the relevant Maven project directory.

### Week 2 – JavaFX Calculator

```powershell
cd "week 2"
mvn clean javafx:run
```

### Week 10 – University Management System

```powershell
cd "week 10/university-system"
mvn javafx:run
```

The Week 10 application requires a local MySQL database connection. Configure the database and credentials for your own environment before running it. Do not commit passwords or sensitive credentials to source control.

## Additional Notes

- There is no single Maven project at the repository root. Run each Maven project from its own directory.
- Some activities are standalone Java examples and do not have their own Maven configuration.
- JavaFX projects may need their dependencies resolved before they can run.
- Each activity demonstrates a particular programming concept and may have its own entry-point class.
- Folder structures and running instructions may differ between individual weeks.
