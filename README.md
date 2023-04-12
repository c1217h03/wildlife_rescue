# My Personal Project: Wildlife Rescue

## An Animal Donation Application
This application is essentially an application where users can 
donate money to endangered animals of their choice, and they can donate to as many 
animals as they want to. 

The application will allow users to view the previous donations they made, their receipts,
their favourite animals, as well as see the current amount donated to a specific animal, and the goal.

**Features** of this application include allowing users to _view previous donations_ they made, 
their _donation receipts_, their _favourite animals_, animals _categorised_ 
as *critically endangered, endangered, or vulnerable*.

From personal experience, my family fostered various shelter dogs back in Indonesia, 
where dog shelters are underfunded. The majority of dog shelters in Indonesia are 
run-down and filthy. Furthermore, many individuals prefer to buy puppies from breeders 
when there are so many dogs in shelters who need care. We had no room in our home for 
another dog because we already had two, so we "fostered" a puppy in a shelter by donating money to 
the shelter for the pup's food and healthcare. I was wondering whether we might apply this approach to other species, 
particularly endangered species. As a result, I'd like to create an application that will enable people 
like myself to assist other creatures in need that aren't physically within our reach.

## User Stories:
- as a user, I want to donate an amount of money to a specific animal.
- as a user, I want to add animals to a list of my favourite animals.
- as a user, I want to see a list of critically endangered, endagered, and vulnerable animals.
- as a user, I want to see animals I donated to.
- as a user, I want to have the option to save my entire donation progress. (favorites list, donated to list)
- as a user, I want to have the option to load my donation progress from file.
- as a user, I want to sign up to my account and add my card details.


## Instructions for Grader:
- to add the animal click the "Add To Favorites" button in the animal's page.
- to remove the animal from your favorites list click the "Remove From Favorites" button in the animal's page.
- to see the Favorites list, click the "Favorites" button on the sidebar.
- to donate an amount to an animal, click the "Donate" button in the animal's page, then enter an amount.
- you can save the state of my project by clicking "Save" button on the sidebar.
- you can load the project from a file by clicking the "Load" button on the sidebar.

## Phase 4: Task 2
````
Mon Apr 03 14:43:31 PDT 2023
Created an account with name: Charmaine

Mon Apr 03 14:43:33 PDT 2023
Added Tiger to favorites list.

Mon Apr 03 14:43:37 PDT 2023
Added Snow Leopard to favorites list.

Mon Apr 03 14:43:41 PDT 2023
Donated 5 to African Forest Elephants.

Mon Apr 03 14:43:41 PDT 2023
Added African Forest Elephant to account's donated to list.

Mon Apr 03 14:43:47 PDT 2023
Added Whale Shark to favorites list.

Mon Apr 03 14:43:50 PDT 2023
Removed Tiger from favorites list.
````

## Phase 4: Task 3

There are several ways I would like to refactor my code. The most prominent changes I would make is to change the 
classes Zoo and AnimalButtons have the Iterator pattern by making the classes implement Iterable<E>, where Zoo would implement Iterable<Animal> and AnimalButtons would implement Iterable<AnimalButton>. By doing so, classes can just have 
associations with one of these two classes and not have to have a list of Animal or AnimalButton. For example, in the
SpeciesPanel, from the UML diagram it can be seen that the class SpeciesPanel has associations with a collection of 
Animal and an association with Zoo. By implementing the iterator pattern, the SpeciesPanel could just have an 
association with Zoo instead of with Animal and instead of having to get the list of Animals in Zoo, Zoo itself can be
iterated and used.


