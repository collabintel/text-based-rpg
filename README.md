# text-based-rpg

**Welcome To The Dungeon Explorer**

Prerequirements: 

You need java 8 installed. 
This game is built for the command line.


-_**Build Game**_

`./gradlew build`

-_**Run Game**_

`java -jar build/libs/text-based-rpg.jar`

-_**Documentation**_

You can find the documentation in doc folder.

-_**Improvements For The Future**_


- All text and properties should be read from a json property file.
- Actions have high code complexity. Command pattern may be used for the business logic happens in there.
- Code coverage should be increased.
- Rooms should have descriptions. When you enter a room, you should see room's description. There should be a bunch of them loaded somewhere and while game was built, these should be appended to the rooms randomly.
- Characters should be saved in file. Experiences should be saved to that file, too.
- There should be a final room (Boss room if you might call).
- After final room, there may be some more dungeons that player may want to visit. Or exit.
- There may be items in rooms.
- Enemies may drop some items.
- Enemies created by their difficulties