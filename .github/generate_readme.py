import os

BASE_PATH = "src/main/java/org/learning"

topics = []

if os.path.exists(BASE_PATH):

    for folder in sorted(os.listdir(BASE_PATH)):

        folder_path = os.path.join(BASE_PATH, folder)

        if not os.path.isdir(folder_path):
            continue

        java_files = []

        for root, dirs, files in os.walk(folder_path):
            for file in files:
                if file.endswith(".java"):
                    java_files.append(os.path.join(root, file))

        file_count = len(java_files)

        topics.append({
            "name": folder,
            "path": folder_path.replace("\\", "/"),
            "files": file_count
        })


readme = """# Java Learning Journey

A collection of my Java learning journey, including concepts, examples,
practice programs and detailed comments for revision.

## 📚 Java Topics

| Topic | Files | Status |
|---|---:|---|
"""

for topic in topics:

    name = topic["name"]
    path = topic["path"]
    files = topic["files"]

    readme += f"| [{name}]({path}) | {files} | 🚧 Learning |\\n"


readme += """
## 🎯 Learning Journey

This repository is continuously updated as I learn new Java concepts.

### Topics Covered

"""

for topic in topics:
    readme += f"- {topic['name']}\\n"


readme += """
## 📝 Notes

The Java programs in this repository contain comments and explanations
to make them useful as personal revision notes.

---

⭐ Continuously learning and improving Java.
"""


with open("README.md", "w", encoding="utf-8") as file:
    file.write(readme)

print("README updated successfully!")