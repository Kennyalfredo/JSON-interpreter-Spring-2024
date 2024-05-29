README for demo
* run Interpreter
* using GUI, enter example.json and click ok
* enter zipcode as keyword and click ok
* choose case-insensitive for this demo
* click OK to confirm menu pop-up


DESCRIPTION for app
The Interpreter class is a Java program designed to facilitate interaction with JSON files. It provides a user-friendly interface for uploading JSON files, searching for specific keywords within the files, and displaying the search results.

Usage
To use the Interpreter class, follow these steps:

Upload JSON File: When the program starts, it prompts the user to enter the file path/name of the JSON file they want to upload. The file is then validated, and if valid, it is uploaded for further processing.

Enter Search Keyword: After uploading the JSON file, the user is prompted to enter a search keyword. This keyword is used to search for specific entries within the JSON file.

Choose Search Options: Next, the user can choose search options, including case sensitivity and regular expression usage. These options help customize the search process based on the user's preferences.

Display Search Results: Once the search options are selected, the program displays a menu interface where the user can choose various actions, such as fetching data based on the entered keyword.

Reset: Finally, after completing the search operation, the program resets its state, allowing the user to perform additional searches or exit the program.

The InteractionMenu class is a Java class responsible for managing user interaction within the Interpreter program. It provides methods for displaying a menu interface and performing searches within the uploaded JSON file.

Constructor
InteractionMenu(FileManager fileManager): Initializes an InteractionMenu object with a reference to the FileManager instance.
Methods
displayMenu(): Displays a menu interface using Swing components. The menu includes options for resetting the uploaded file and showing all content.

fetchData(String keyword, boolean caseSensitive, boolean useRegex): Searches for exact matches of data within the uploaded JSON file. The search can be performed with or without case sensitivity and using regular expressions if specified.

Dependencies
The InteractionMenu class relies on the following dependencies:

javax.swing.*: Java Swing library for creating graphical user interfaces.

FileManager Class
The FileManager class is a Java class responsible for managing the uploaded JSON file within the Interpreter program.

Fields
uploadedFile: A private field that stores the currently uploaded JSONFile.
Methods
uploadFile(JSONFile file): Uploads a JSONFile to the FileManager. If the provided file is not null and is valid, it sets the uploadedFile field to the provided file and returns true. Otherwise, it returns false.

reset(): Resets the uploadedFile field to null, effectively clearing any uploaded file.

getUploadedFile(): Returns the currently uploaded JSONFile.

The JSONFile class represents a JSON file within the Interpreter program. It provides methods for validating the file, retrieving its size and data, and creating a JSONFile object from a file path.

Fields
filename: A string representing the name of the JSON file.
size: An integer representing the size of the JSON file.
data: A string representing the content of the JSON file.
Constructor
JSONFile(String filename, int size, String data): Initializes a JSONFile object with the specified filename, size, and data.
Methods
isValid(): Checks if the JSON file is valid. It returns true if the file content starts and ends with curly braces {}, indicating a valid JSON format. Otherwise, it returns false.

getSize(): Returns the size of the JSON file.

getData(): Returns the content of the JSON file.

fromFile(String filePath): Static method that creates a JSONFile object from a file path. It reads the content of the file specified by the filePath, initializes a new JSONFile object with the filename, size, and content, and returns it. If an IO exception occurs during file reading, it prints the stack trace and returns null.
