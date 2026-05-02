# Design Notes

## 1. Why ArrayList instead of Array?

`ArrayList` was used instead of arrays because it provides dynamic resizing and better flexibility.

* Arrays have a fixed size, which makes them difficult to use when the number of elements is not known in advance
* `ArrayList` grows automatically as elements are added
* It provides useful built-in methods like `add()`, `remove()`, `size()` which simplify implementation
* It is more suitable for real-world applications where data is dynamic (e.g., adding/removing students or courses)

---

## 2. Where Static Members Were Used and Why

Static members were used in the `IdGenerator` utility class.

```java
private static int studentIdCounter;
```

### Why static?

* Ensures a **single shared counter** across the entire application
* Helps generate **unique IDs** for each entity (Student, Course, Enrollment)
* Avoids creating multiple instances of the generator
* Provides easy access using class name (e.g., `IdGenerator.getNextStudentId()`)

---

## 3. Where Inheritance Was Used and What Was Gained

Inheritance was used by creating a base class `Person` and extending it:

```java
class Student extends Person{}

class Trainer extends Person{}
```

### Benefits gained:

* **Code reuse** → Common fields like `id`, `firstName`, `lastName`, and `email` are defined once
* **Reduced duplication** → No need to rewrite common attributes in multiple classes
* **Better structure** → Clear relationship between entities
* **Extensibility** → Easy to add more roles (e.g., Admin, Mentor) in future
* **Polymorphism** → Allows method overriding (e.g., customized `getDisplayName()`)

---

## ✅ Summary

The design choices (ArrayList, static usage, inheritance) improve:

* Flexibility
* Maintainability
* Scalability
* Code readability

and reflect real-world backend development practices.
