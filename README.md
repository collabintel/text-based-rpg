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

-_**Misc Files**_

These files can be found in the same path with the application jar file.

- character.sav file is for saved characters.
- game.sav file is for saved games.

-_**Improvements For The Future**_


- All text and properties should be read from a json property file.
- Actions have high code complexity. Command pattern may be used for the business logic happens in there.
- Code coverage should be increased.
- Rooms should have descriptions. When you enter a room, you should see room's description. There should be a bunch of them loaded somewhere and while game was built, these should be appended to the rooms randomly.
- Characters should be saved in file. Experiences should be saved to that file, too. (DONE)
- There should be a final room (Boss room if you might call).
- After final room, there may be some more dungeons (different levels like 3D array) that player may want to visit. Or exit.
- There may be items in rooms.
- Enemies may drop some items like healing potions, attack damage items.
- Enemies created by their difficulties

-_**Bugs**_

- After a game saved and a new game played with same player, player's experience changes won't effect the saved game
player.