import os

# --------------------------------------------------
# Configuration
# --------------------------------------------------

BASE_DIR = "src/main/java/org/learning"
README_FILE = "README.md"

# Add your Java topics here.
# Change "In Progress" to "Completed" when you finish a topic.
topics = [
    {"name": "EnumAnnotation", "status": "Completed"},
    {"name": "Exception9", "status": "Completed"},
    {"name": "lambda8", "status": "Completed"},
    {"name": "services8", "status": "Completed"},
    {"name": "Multithreading", "status": "In Progress"}
]

# --------------------------------------------------
# Sort topics
# --------------------------------------------------

# Completed topics first.
# In Progress topics automatically move to the bottom.
topics.sort(key=lambda topic: topic["status"] == "In Progress")


# --------------------------------------------------
# Generate README
# --------------------------------------------------

readme = """# Java Learning Journey

A collection of my Java learning journey, including concepts, examples,
practice programs and detailed comments for revision.

## 📚 Java Topics

| Topic | Files | Status |
|-------|------:|--------|
"""


# --------------------------------------------------
# Generate topic table
# --------------------------------------------------

for topic in topics:

    folder_path = os.path.join(BASE_DIR, topic["name"])

    # Count .java files
    file_count = 0

    if os.path.exists(folder_path):
        for file in os.listdir(folder_path):
            if file.endswith(".java"):
                file_count += 1

    # Status
    if topic["status"] == "Completed":
        status = "✅ Completed"
    else:
        status = "🚧 In Progress"

    # GitHub folder link
    github_path = folder_path.replace(os.sep, "/")

    readme += (
        f"| [{topic['name']}]({github_path}) "
        f"| {file_count} "
        f"| {status} |\n"
    )


# --------------------------------------------------
# Learning Journey
# --------------------------------------------------

readme += """
## 🎯 Learning Journey

This repository is continuously updated as I learn new Java concepts.

### Topics Covered

"""

for topic in topics:
    readme += f"- {topic['name']}\n"


# --------------------------------------------------
# Notes
# --------------------------------------------------

readme += """
## 📝 Notes

The Java programs in this repository contain comments and explanations
to make them useful as personal revision notes.

---

⭐ Continuously learning and improving Java.
"""


# --------------------------------------------------
# Write README
# --------------------------------------------------

with open(README_FILE, "w", encoding="utf-8") as file:
    file.write(readme)

print("README updated successfully!")