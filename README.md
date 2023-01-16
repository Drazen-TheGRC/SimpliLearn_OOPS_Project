# SimpliLearn_OOPS_Project

![3860902-1](https://user-images.githubusercontent.com/33057499/212730365-49801c97-03ae-4fcc-805f-91aea95ae170.png)

Implement OOPS using JAVA with Data Structures and Beyond
Project 1

Virtual Key for Your Repository


Report content:
•	Basic Info
•	Specification document - Product’s capabilities, appearance, and user interactions
•	Project objective
•	Sprite planning 
•	Java concepts in use
•	App workflow chart
•	App sample snips
•	Algorithms with comments
•	Unique selling points
•	Conclusion

Basic Info

App name: Virtual Key for Your Repository
Developer: Drazen Drinic
GitHub: https://github.com/Drazen-BBG/SimpliLearn_OOPS_Project


Specification document - Product’s capabilities, appearance, and user interactions

This app is menu-based application which is able to navigate through the directories showing their content, user can sort or search the directory content. To ma it more interesting user is able to see file or folder details and to create and delete files from the directory. 

Taking in consideration that this is a console app I can tell its appearance is above expected since menus and other messages to the user are nicely presented through boxed content which was accomplished using developer made methods.

User interaction is console based and menu driven as previously said and the interaction is done through app messages displayed in the console where the user can interact using keyboard to choose provided options or past copied paths.


Project Objectives:

Project objective:
As a Full Stack Developer, complete the features of the application by planning the development in terms of sprints and then push the source code to the GitHub repository. As this is a prototyped application, the user interaction will be via a command line. 

Background of the problem statement:
Company Lockers Pvt. Ltd. hired you as a Full Stack Developer. They aim to digitize their products and chose LockedMe.com as their first project to start with. You’re asked to develop a prototype of the application. The prototype of the application will be then presented to the relevant stakeholders for the budget approval. Your manager has set up a meeting where you’re asked to present the following in the next 15 working days (3 weeks): 
•	Specification document - Product’s capabilities, appearance, and user interactions;
•	Number and duration of sprints required;
•	Setting up Git and GitHub account to store and track your enhancements of the prototype;
•	Java concepts being used in the project;
•	Data Structures where sorting and searching techniques are used;
•	Generic features and three operations: 
o	Retrieving the file names in an ascending order;
o	Business-level operations:
	Option to add a user specified file to the application;
	Option to delete a user specified file from the application;
	Option to search a user specified file from the application;
	Navigation option to close the current execution context and return to the main context;
o	Option to close the application.
The goal of the company is to deliver a high-end quality product as early as possible.  
 
The flow and features of the application:
•	Plan more than two sprints to complete the application;
•	Document the flow of the application and prepare a flow chart;
•	List the core concepts and algorithms being used to complete this application;
•	Code to display the welcome screen. It should display:
  o	Application name and the developer details;
  o	The details of the user interface such as options displaying the user interaction information;
  o	Features to accept the user input to select one of the options listed;
•	The first option should return the current file names in ascending order. The root directory can be either empty or contain few files or folders in it;
•	The second option should return the details of the user interface such as options displaying the following:
  o	Add a file to the existing directory list;
    	You can ignore the case sensitivity of the file names;
  o	Delete a user specified file from the existing directory list;
    	You can add the case sensitivity on the file name in order to ensure that the right file is deleted from the directory list;
    	Return a message if FNF (File not found);
  o	Search a user specified file from the main directory;
    	You can add the case sensitivity on the file name to retrieve the correct file;
    	Display the result upon successful operation;
    	Display the result upon unsuccessful operation;
  o	Option to navigate back to the main context;
•	There should be a third option to close the application;
•	Implement the appropriate concepts such as exceptions, collections, and sorting techniques for source code optimization and increased performance.

You must use the following:
•	Eclipse/IntelliJ: An IDE to code for the application;
•	Java: A programming language to develop the prototype;
•	Git: To connect and push files from the local system to GitHub;
•	GitHub: To store the application code and track its versions;
•	Scrum: An efficient agile framework to deliver the product incrementally;
•	Search and Sort techniques: Data structures used for the project;
•	Specification document: Any open-source document or Google Docs.

 
Following requirements should be met:
•	The source code should be pushed to your GitHub repository. You need to document the steps and write the algorithms in it;
•	The submission of your GitHub repository link is mandatory. In order to track your task, you need to share the link of the repository. You can add a section in your document;
•	Document the step-by-step process starting from sprint planning to the product release;
•	Application should not close, exit, or throw an exception if the user specifies an invalid input;
•	You need to submit the final specification document which includes:
  o	Project and developer details;
  o	Sprints planned and the tasks achieved in them;
  o	Algorithms and flowcharts of the application;
  o	Core concepts used in the project;
  o	Links to the GitHub repository to verify the project completion;
  o	Your conclusion on enhancing the application and defining the USPs (Unique Selling Points);

Sprint Planning

There are five sprites each taking 3-7 days. The goal here is to have a working console app the whole time with limited functionality until we achieve full functionality. 

Sprint 1:
The goal of the 1st sprint is to create an IntelliJ IDEA project, set up a git repository and push it to GitHub. The functionality goal is to have a working app the whole time and a very nice presentation in the console. We will create welcome message & goodbye message using developer made methods for nice and even console presentation. We will create numerus variables to store all the info needed for a proper app presentation and functionality. Few of those variables are going to hold app name, developer name, app path etc. 
In the second part of the 1st sprite we will create a method to display main menu, a method to get user input, we will need two variables to store the absolute app path and another one to be able to store current app path for the purpose of navigating through the directories. We need those and their getters and setters not only to go into directories or go back to parent directories, we need them also to manage file explorer presentation, sorting, searching, file creation and deletion and for many more options we want to implement into our app.
In the third part of the 1st sprite we will further develop the user input method to be able to handle incorrect user input in terms of data type and menu range.

Sprite 2:
In the 2nd sprite we want to add functionality to our main menu and we will start slowly firstly creating new methods to display developer info, delay method to have even better presentation, and then we will go forward and make organized execution of the app organizing the method calls in a start app method, we will also create a method to terminate the app.
In the second part of our 2nd sprite we will test newly created main menu and user input method, making sure all the methods work properly and checking if our user input can handle incorrect user input.

Sprint 3:
In the 3rd spring we will focus on the file explorer and its file details related methods. We need to be able to list all the files and folder in the directory path, need to display general options for our file explorer and most importantly need to be able to list all the files dynamically and offer a dynamic menu to be able to see file details or folder details from the file explorer. 
In the second part of the 3rd sprint we will develop go into directory method to be able to enter directories and go to parent directory method to be able to go to a parent directory. By now we will have nice main menu and file explorer where we can go through folders and see details for selected files or folders. Now when we can navigate through the directories we will create methods for creating and deleting files. We will test the app and finish for this sprite. 

Sprite 4:
Our app needs to keep developing and in the 4th sprite we will add the remaining needed functionality and that is sorting and searching. First, we will refactor the code and do a nice comment markup of the whole code before we go for implementation of the remaining functionally.
In the second part of our 4th sprite we will develop sort ascending and sort descending methods which are going to sort the files and then present them using the file explorer method. Those changes are going to influence the whole code and many changes in the code will need to be done to be able to join the soring functionality with the all existing functionality implemented in the file explorer.

In the third part of the 4th sprint we will implement the search directory method to give the user an option to search for a file or folder in the file explorer after this is done app needs to be tested and documented. 

Sprite 5:
In our 5th and last sprite we will test the app do necessary changes and refactoring to make the code shorter where it can be done easily. After all the testing is done we will add more comments in the code and then we will make the necessary documentation for this app to be able to make a nice report, app workflow chart and algorithm details.

Java concepts in use
•	Scanner – User input
•	Regular Expression and Paths
•	File handling
•	Collections
•	Sorting & Searching
•	Exceptions

App WorkFlow Chart

![image](https://user-images.githubusercontent.com/33057499/212731046-dd1804e9-c337-491a-a8b5-211eb6bf02de.png)

App sample snips

Welcome and Setting Absolute Working Directory path

![image](https://user-images.githubusercontent.com/33057499/212731087-72939580-add6-48a5-bbbe-c7c6d029a0a7.png)

Main menu

![image](https://user-images.githubusercontent.com/33057499/212731153-027fe052-d48a-4c26-b72d-0dc1c16c558f.png)

Updating Absolute Working Directory

![image](https://user-images.githubusercontent.com/33057499/212731190-3dcd1c1e-982d-40ea-a32b-7ab168476a61.png)

Developer Info 

![image](https://user-images.githubusercontent.com/33057499/212731236-199f6485-e151-4116-9f1e-8f10bef9d5f3.png)

File Explorer

![image](https://user-images.githubusercontent.com/33057499/212731272-86d4eb26-739b-4332-9821-fa7c1cb25e61.png)

Sort Descending

![image](https://user-images.githubusercontent.com/33057499/212731329-b27e707f-2b65-40ec-b5f4-d5a1dd1332cd.png)

Create a File

![image](https://user-images.githubusercontent.com/33057499/212731365-7cb82932-64cd-4618-9844-5121fbbf48dd.png)

File Details 

![image](https://user-images.githubusercontent.com/33057499/212731386-5a3fb8db-3aaa-45c8-83c5-e00a890762ee.png)

Delete File

![image](https://user-images.githubusercontent.com/33057499/212731439-c4680dca-9ce5-409f-8b65-ba6c9a1f3731.png)

Directory Details

![image](https://user-images.githubusercontent.com/33057499/212731476-c37b157d-7fc1-49c7-ac38-09b144df24c3.png)

Goodbye

![image](https://user-images.githubusercontent.com/33057499/212731507-0a8ab41d-e824-46d9-8b3a-2ae1c57e968e.png)































