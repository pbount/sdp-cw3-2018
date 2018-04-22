# sdp-coursework3-2018

#### Group names and academic usernames
    `Vasilis Davios / vdavio01`
    `Pavlos Bountagkidis / pbount01`
    `Christian Reusch / creusc01`
    `Christos Aleiferis / caleif01`

### Task
The approach to the solution of the project was to divide the functionality into independent single-responsibility classes in order to maintain a clean structure and future-proof expandable design.

#### GamePlay
The program is configured and started with a number of predefined values. Once the program is running, a secret code is generated and the user is prompted to find the code in a series of inputs. For each input the user receives a feedback. Once all available tries have been used, the user is prompted to either terminate or restart the game.

#### Seperation of responsibilities
The afformentioned functionality is seperated into a number of Interfaces each responsible for a contained task.
* `Game`: Central point of the application.
* `Scanner`: Receives an game inputs.
* `MessageCenter`: Produces prompts, instructions and feedback.
* `Peg`: Representation of the Peg using which the game is played.
* `ColorCodeGenerator`: Generates all available Pegs which the user is allowed to use.
* `Validator`: Validates that the user input is valid and evaluates whether it is correct.

#### Diagram
![alt text](https://image.ibb.co/jMh7PH/diagram1.png "UML Diagram")

#### MasterMidDriver
This is from where the application is prepared and executed. A Game is instantiated and it's function `runGames()` called marking the start of the game.

#### Scanner
Interaction of the user with the game. It is implemented as `ScannerImpl`, which receives game data directly from the console. It is possible to another class as Scanner should a different source of data be required i.e a text file or database query etc...

#### MessageCenter
Feedback is provided via the MessageCenter. Currently implemented as `MessageCenterImpl`, which contains responses as string values and returns them upon function calls.

#### Peg

#### ColorCodeGenerator
Responsible for generating the secret code to be cracked by the user. arrayOfPegs represents all valid pegs which can be used to generate the secret code.
#### Validator
Validator is used to validate the input for compliance with game rules as well as for correctness against the secret code. validInput contains the Pegs which the user is allowed to use. Verifies that the input follows game rules.Returns true if input is valid and false otherwise.Compares the input against the secret code and returns a Pair of a Boolean indicating whether the input and code are the same and a Pair of the number of Black and White pegs (in that order).

### Testing
The game contains relevant tests for all logic parts such as input validation and code generation, however basic tests (which contain little or no logic) such as creation of a peg have been ommited.
