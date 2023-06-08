# Personal Information
* **Name** : Tran Truong Gia Phat

* **Email** : giaphat24072002@gmail.com

* **LinkedIn** :https://www.linkedin.com/in/phattran2002/ 

* **Link demo** : https://youtu.be/oXSRLsUe6DI
---

# Build a MusicLibrary Management System (Command line app)
# Application Introduction
## # Overview of My Applications
* I used Java to build this application.
* My app is built to meet the requirements of EMVN assignment.
* My app has two types of user : **normal user** and **admin**.
* User can use my app by command line interface.
## # Information to Login :
1. **Normal user**
    * username : ***user1***
    * password : ***user123***
2. **admin**
    * username : **admin**
    * password : **admin**
## # Functionalities of My Application :
### ## Main functionalities :
* **In terms of Admin** :
    1. Add a new music track with fields like title, artist, artist,album, genre, realease year and duration.
    
    2. View the details of specific music track by searching for it using the title or artist.
    3. Update the details of an existing music track.
    4. Delete a music track from the library
    5. Display a list of all music tracks in the library.
* **In terms of Normal user** :
    1. Create a new playlist with name of playlist.

    2. Show all playlists of this user.
    3. Remove a playlist of this user.
    4. Add music to playlist which was chosen by user.
    5. Display a list of all music tracks in the library.
    6. Search music in libray by title, artist, album or genre.
    7. Search music in playlists by title, artist, album or genre.
### ## Addtional functionalities :
* **For all types of users** :
    1. Login 

    2. Register
    3. Logout
    4. Exit Application.
---
# Advantages and Disadvantages
## # Advantages
1. The requirements are so comprehensive that I know what I need to do. 

2. I have enough time to meet the necessary requirements.
3. I have learned Java at University. Therefore, I do not have many difficulties in syntax or structure of Java.

## # Disadvantages
1. I have some difficulties when I set up tools or software to build this app. However, I luckily find solution on the Internet and I apply it to solve the problems.

2. Because this app is used command line interface to interact with user, I have to create many Interfaces to access to various functionalities.

3. About the source code, I try my best to write clean, maintainable and well-structured code. However, I think some structures of codes are not really good enough. 

4. Because I usally make reports at University by docx, this is the first time I have written the **.md** file. 
## # Experienced Lessions 
1. I have a chance to learn how to write **.md** file basically and correctly.

2. I learnt that how to organize or write maintainable and well-structured code.
---
# Instruction
## - You have to ensure that your computer was installed these things : 
* ### Tools :
    1. Eclipse IDE for Enterprise Java and Web Developers - 2022-12. 

        [Download Eclipse here](https://www.eclipse.org/downloads/)
    
    2. MySQL WorkBench 8.0 CE 

        [Download MySQL here](https://www.eclipse.org/downloads/)
    3. File mysql-connector-java-8.0.30 (You can download latest version)

        [Download File here](https://dev.mysql.com/downloads/connector/j/?os=26)
    
* ### Set up the environment :
    ### # Because I used Java for this app, you have to set up enviroment variable on your computer.
    ### # You can refer videos below : 
    1. Download Java (choose appropriate version): 
        
        [Download Java here](https://www.oracle.com/java/technologies/downloads/)
    2. Set up the environment variabe :

        [Link reference on Youtube](https://www.youtube.com/watch?v=-O4QVijnA7Y)

* ### Set up databae :
    ### - You can refer videos below to install MySQL:
    1. Install MySQL:
    
        #### [Link reference on Youtube](https://www.youtube.com/watch?v=2c2fUOgZMmY)
    ### - After successful installation, you should set username : **root** , password : **root**, link :**localhost** and port :**3000**.

##  # How to run my application
1. Download my source code from github :

        [Download source code here]()

2. Open Eclipse - choose any folder to store this source.

3. In the left of the window, choose **File** &rarr; **Import**.
4. In **Select an import wizard** &rarr; press **archive** &rarr; choose **Projects from Folder or Archive**.
5. In **Import Source** choose ***The path which you stored source code***.
6. Now, you have to import file **.sql** in root folder of source code to ***Database***.
7. In MySQL Workbench &rarr; choose MySQL connection (You have created).
8. When the new window is opened &rarr; choose **Server** on the toolbar &rarr; choose **Data Import**.
9. In **Import Options** &rarr; choose **Import from Self-contained File**
10. In **Default Schema to be Imported To** &rarr; choose **New ...** &rarr; Type name is **music_app**.
11. Finally, press button **Start Import**.
---
-----------------------------------------------------------------------**End**------------------------------------------------------
