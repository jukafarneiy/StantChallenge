# StantChallenge
Challenge for the Jr's Developer Job at Stant.

General Info: 

My application presents a list of movies that, when scrolling down, this list grows and never ends, because I used the concept of infinite loading, 
if the user clicks on any movie in the list, a new screen is presented at the display, where it shows the movie details, being: title, poster, release date, 
source language and overview. The user also can back to the first screen by clicking at the 'back' default button on android smartphones, and the list appears again
if the user wants to see others movies.

Technology: 

This project is 100% based on the Kotlin language, because it's the language that I have been studying for the last few months, and it is the 
language requested for the application;

Retrofit: to request network;

Coroutines: to perform actions in the background;

MVVM: presentation layout;

Lifecycle - to perform an action when lifecycle state changes;

RecyclerView - to display the movies data and can scroll it;

GLide - to open the movies posters and displays it.


Dificults: 

Undoubtedly, my biggest difficulties in carrying out this challenge was the part of performing API searches, at first I had some problems with the key provided, 
but after seeing some tutorials I managed to apply it. Another part that made me search for information on the internet was the application of the MVVM architecture, 
as these are concepts that I only saw in theory, but in practice it was more challenging. Coroutines was something I added based on a tutorial too, I still don't know 
well about this tool, anyway, I'll keep studying on android.

Librarys:

RecyclerView - 1.2.1;

GLide - 4.13.0;

Retrofit - 2.9.0;

LifeCycle - 'androidx.lifecycle:lifecycle-common:2.4.1'
            'androidx.lifecycle:lifecycle-runtime:2.4.1'
            'androidx.lifecycle:lifecycle-extensions:2.2.0'
            'androidx.lifecycle:lifecycle-livedata-ktx:2.4.1'
            
Coroutines: 1.4.1.





App Main Activity:

![image](https://user-images.githubusercontent.com/104699938/168661212-4fda60d5-96a1-41a0-947b-d8fdd16b3ecd.png)  


App Second Activity:

![image](https://user-images.githubusercontent.com/104699938/168661314-803fed02-505d-4b62-99bd-21864e038e59.png)



