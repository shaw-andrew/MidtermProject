# MidtermProject

## Description

I have worked in maintenance of all backgrounds, military and civilian, from a nuclear power plant to an Amazon warehouse. One thing I've noticed is that everywhere I go there's always the same problem. Old guys work in maintenance and they like to do things the way they've always done it. This means technology is slow to enter this world. 

In an enviornment where asset value can eclipse tens of millions of dollars, finding effecient, effective and reliable tools to ensure proper and adequate reporting are KEY to success. 

This program as it stands utilizes a relational database that provides and effective data input pipeline. It provides a means for scheduling and tracking maintenance. It provides multiple levels of access, ensuring the proper levels of edit authority reside at commensurate responsibility levels. It has a means for adding and removing members from a team. It provides a means to update maintenance steps on a job, to associate new parts, tools, certification or training requirements for each individual job. On top of it all, I utilized BootStrap to make this program mobile friendly. No need to be in front of your computer to get this work done.

The foundation of this program allows for extending from what already exsits to create a true enterprise level asset management system. There is room for location functionality, multiple levels of management access changes, inventory functionality and can be updated to allow for reporting anything from work done on equipment to storeroom DPMO.

## Class Desciptions

I broke down the project into 4 controllers: User, Supervisor, Technician and Maintenance Requirements respectively. With all the options for traffic through the program, this allows for efficient editing and eases the developer finding the methods they're looking to update.

I created a Data Access Object interface and it's Implemetanion class for every entity.

Finally, we broke down our site into approximately 50 .jsp files to create a comfortable user experience as the user navigates the program.

## What I Learned

This was by far the most advanced project I have worked on so far. Spring was a god-send for minimizing the amount of code we used between the database, and the entities however, with multiple many-to-many CRUD operations, our controller methods were more extensive than I thought existed. Some of these took hours to have properly load in a drop down menu. The results were beautiful though especially considering Bootstrap allows for a mobile friendly experience.

I was challenged with the more advanced Git useage. We ran into multiple merge conflicts but have now developed a process for efficient communication and push/pull activities. We quickly realized that breaking down entities, DAOs and Controllers to be many and small was key to success.

## Technologies Used

This project used: Java, Spring, SQL, MAMP, JPQL, JPA, Amazon AWS ECS2, Gradle, Git, Atom, MySQL Workbench

