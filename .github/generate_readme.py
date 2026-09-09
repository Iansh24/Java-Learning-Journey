import os

# --------------------------------------------------
# Configuration
# --------------------------------------------------

BASE_DIR = "src/main/java/org/learning"
README_FILE = "README.md"

# Add your Java topics here.
#
# number  -> order in the learning journey
# name    -> actual folder name
# status  -> Completed / In Progress
#
# When you finish a topic:
# "In Progress" -> "Completed"
#
# Then add the next topic as "In Progress".

topics = [
    {"number": 1, "name": "lambda",          "status": "Completed"},
    {"number": 2, "name": "Interface",       "status": "Completed"},
    {"number": 3, "name": "Exception",       "status": "Completed"},
    {"number": 4, "name": "EnumAnnotation",  "status": "Completed"},
    {"number": 5, "name": "Multithreading",  "status": "Completed"},
    {"number": 6, "name": "StreamApi",       "status": "Completed"},
    {"number": 6, "name": "7)Servlet",       "status": "In Progress"}
]


# --------------------------------------------------
# Separate Completed and In-Progress Topics
# --------------------------------------------------

completed_topics = [
    topic for topic in topics
    if topic["status"] == "Completed"
]

in_progress_topics = [
    topic for topic in topics
    if topic["status"] == "In Progress"
]


# In-progress topics always appear at the bottom
ordered_topics = completed_topics + in_progress_topics


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
# Generate Topic Table
# --------------------------------------------------

for topic in ordered_topics:

    folder_path = os.path.join(BASE_DIR, topic["name"])

    # Count .java files
    file_count = 0

    if os.path.exists(folder_path):

        for root, dirs, files in os.walk(folder_path):

            for file in files:

                if file.endswith(".java"):
                    file_count += 1


    # Status
    if topic["status"] == "Completed":
        status = "✅ Completed"
    else:
        status = "🚧 In Progress"


    # GitHub folder link
    github_path = folder_path.replace(os.sep, "/")


    # Display number separately from folder name
    display_name = f"{topic['number']}) {topic['name']}"


    readme += (
        f"| [{display_name}]({github_path}) "
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


for topic in ordered_topics:

    display_name = f"{topic['number']}) {topic['name']}"

    readme += f"- {display_name}\n"


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