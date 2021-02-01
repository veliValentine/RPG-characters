# RPG-characters
A Project to demonstrate modelling and class design principles.
<a name=""></a>
## Table of contents

- [Description](#description)
- [Usage](#usage)
    - [Main usage](#usageMain)
    - [Demo](#usageDemo)
- [About tests](#tests)
- [Structure](#structure)

<a name="description"></a>

## Description

[Full project description can be found here!](/documents/Task3.pdf)

This project is used to demonstrate modeling and class design principles.

Project has Heroes. There are three type of heroes. A Warrior, a ranged and a mage.
Each hero has slightly different base stats.

A hero can equip different kinds of armor and weapons. They boost heroes basic stats and can only be equipped if hero level is high enough.

<a name="usage"></a>
## Usage

<a name="usageMain"></a>
### Main usage
This project doesn't run on its own.

There is a demonstration about creation of different heroes and what happens when they equip an item.

<a name="usageDemo"></a>
### Demo
This demo includes snippets from the [main](/src/main) printout.
Snippets demonstrate features without running the application.
Features included in demonstration: 
- Generating heroes and leveling them up by giving them xp
- Generating different items
- Equipping these items to Warrior
- Changing Warriors equipment
- Show the amount of damage Warrior can make

Heading numbers indicates the printout from [main](/src/main).

#### 1. Print details and 2. Level up

![warrior](documents/1_warrior.PNG)
![warrior](documents/2_warrior.PNG)
---

![ranged](documents/1_range.PNG)
![ranged](documents/2_range.PNG)
---

![mage](documents/1_mage.PNG)
![mage](documents/2_mage.PNG)
#### 3. Melee, range and magic weapon for our heroes

![melee](documents/3_weapon_melee.PNG)
![range](documents/3_weapon_range.PNG)
![magic](documents/3_weapon_magic.PNG)

#### 4. And armors...

![cloth](documents/4_armor_helmet.PNG)

---
![leather](documents/4_armor_body.PNG)

---
![plate](documents/4_armor_legs.PNG)

#### 5. Equipped Warrior
![equipped warrior](documents/5_warrior.PNG)

#### 6. Warrior equipped with 100 body armors
![100_body_armors](documents/6_warrior.PNG)

#### 7. Warrior with only sword. Added leggings level is too high for our warrior
![warrior_with_too_high_leggings](documents/7_warrior.PNG)

#### 8. Added leggings, so our Warrior don't get cold
![warrior with leggings](documents/8_warrior.PNG)

<a name="tests"></a>
## About tests

Testing this project was not part of the description. Tests in this application covers only the basic examples given in the [task](/documents/Task3.pdf). 

First version of warrior class was build using principles of test driven development.
This led building far more tests than necessary for modelling and class design project.

<a name="structure"></a>
## Structure
