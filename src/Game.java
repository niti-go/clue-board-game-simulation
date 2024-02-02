//Niti and Shireen's Clue Game Simulation!
/** Heading  **********************************************/
/*	Your names: Niti Goyal and Shireen Kumar
		Class block: G				Date Started: 4/25/2021
		Project: Clue Game Simulation
		Purpose: Provide a command-line based game simulation of Clue, a popular board game, Using what we have learned in AP Computer Science
    *******************************************************/
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Game{
    Game(){

        Scanner input;
        String playAgain = "";
        String userInput = "";
        do{
            playAgain = "";
            System.out.println("\nWelcome to Rainbow Mansion. Your host, Mr. Boe, has met an untimely end — he's the victim of foul play. To win this game, you must determine the answer to these three questions: Who done it? Where? And with what weapon?\n\nThree cards containing the answers to these questions have been kept in a confidential case file. The remaining cards have been distributed among you and two other players. Any card that is in your hand or another player's hand can't be in the case file — which means none of those cards were involved in the crime! Your task is to figure out which cards are in the Case File by narrowing down the suspects, weapons, and rooms.\n\nYou, Comp 1, and Comp 2 will take turns interrogating each other. Each time, you will interrogate another player about 3 cards, and they will show you one of those cards, if they have any. Then, you can eliminate that card from your list of suspects, since it isn't in the case file. Your notes will be updated automatically each time you take a turn, and you can reference them in the Notes.txt file. You wil have to press the \"enter\" key to continue to each person's turn. \n\nEvery 3 turns, you will be asked if you would like to make a final accusation. This is when you feel confident that you know all the information about the crime, and are ready to accuse the person, weapon, and room that were involved in the Case File. You only get to make the final accusation once; if you are correct, you win, but if you are incorrect, you lose. Be sure you make a final accusation as quickly as possible before any other player does! Now let's play!");

            input = new Scanner(System.in);
            String isReady = " ";
            //Declaring the array lists of (People, weapons, and place)
            ArrayList<String> personCards = new ArrayList<String>();
            ArrayList<String> weaponCards = new ArrayList<String>();
            ArrayList<String> placeCards = new ArrayList<String>();

            //Create array lists of Strings, which each represent a card
            //Assigning each person in the People cards
            personCards.add("Col. Mustard");
            personCards.add("Mrs. Peacock");
            personCards.add("Prof. Plum");
            personCards.add("Miss Scarlet");
            personCards.add("Mrs. White");
            personCards.add("Mr. Green");

            //Assigning each Weapon in the weapons cards
            weaponCards.add("Wrench");
            weaponCards.add("Lead Pipe");
            weaponCards.add("Pistol");
            weaponCards.add("Dagger");
            weaponCards.add("Candlestick");
            weaponCards.add("Rope");

            //Assigning each place in the place cards
            placeCards.add("Living Room");
            placeCards.add("Garage");
            placeCards.add("Courtyard");
            placeCards.add("Office");
            placeCards.add("Bathroom");
            placeCards.add("Game Room");
            placeCards.add("Kitchen");
            placeCards.add("Dining Room");
            placeCards.add("Bedroom");


            //Declaring the array lists of suspects for USER's notes
            ArrayList<String> personList = new ArrayList<String>();
            ArrayList<String> weaponList = new ArrayList<String>();
            ArrayList<String> placeList = new ArrayList<String>();

            for (int i = 0; i < personCards.size(); i++)
            {
                personList.add(personCards.get(i));
            }
            for (int i = 0; i < weaponCards.size(); i++)
            {
                weaponList.add(weaponCards.get(i));
            }

            for (int i = 0; i < placeCards.size(); i++)
            {
                placeList.add(placeCards.get(i));
            }

            //Declaring the array lists of suspects for COMP1's notes
            ArrayList<String> comp1personList = new ArrayList<String>();
            ArrayList<String> comp1weaponList = new ArrayList<String>();
            ArrayList<String> comp1placeList = new ArrayList<String>();

            for (int i = 0; i < personCards.size(); i++)
            {
                comp1personList.add(personCards.get(i));
            }
            for (int i = 0; i < weaponCards.size(); i++)
            {
                comp1weaponList.add(weaponCards.get(i));
            }

            for (int i = 0; i < placeCards.size(); i++)
            {
                comp1placeList.add(placeCards.get(i));
            }

            //Declaring the array lists of suspects for COMP2's notes
            ArrayList<String> comp2personList = new ArrayList<String>();
            ArrayList<String> comp2weaponList = new ArrayList<String>();
            ArrayList<String> comp2placeList = new ArrayList<String>();

            for (int i = 0; i < personCards.size(); i++)
            {
                comp2personList.add(personCards.get(i));
            }
            for (int i = 0; i < weaponCards.size(); i++)
            {
                comp2weaponList.add(weaponCards.get(i));
            }

            for (int i = 0; i < placeCards.size(); i++)
            {
                comp2placeList.add(placeCards.get(i));
            }

            //Shuffle the three piles of cards
            shuffleCards(personCards);
            shuffleCards(weaponCards);
            shuffleCards(placeCards);

            //Place one card from each array into Case File
            ThreeCards caseFile = new ThreeCards(personCards.get(0),weaponCards.get(0), placeCards.get(0));

            //Remove these 3 cards from the deck because they are in the Case File
            personCards.remove(0);
            weaponCards.remove(0);
            placeCards.remove(0);

            //Distribute the remaining cards to players
            ArrayList<String> cardDeck = new ArrayList<String>();
            ArrayList<String> userCards = new ArrayList<String>();
            ArrayList<String> comp1Cards = new ArrayList<String>();
            ArrayList<String> comp2Cards = new ArrayList<String>();

            //Combine all remaining cards into cardDeck
            for(int i = 0; i < personCards.size() ; i++)
            {
                cardDeck.add(personCards.get(i));
            }
            for (int i = 0; i < weaponCards.size(); i++)
            {
                cardDeck.add(weaponCards.get(i));
            }
            for (int i =0; i < placeCards.size(); i++)
            {
                cardDeck.add(placeCards.get(i));
            }

            //Shuffle the cards and distribute to players
            shuffleCards(cardDeck);

            //Dealing the cards to each player
            for(int x = 0; x< 6; x++)
            {
                userCards.add(cardDeck.get(0));
                cardDeck.remove(0);
                comp1Cards.add(cardDeck.get(0));
                cardDeck.remove(0);
                comp2Cards.add(cardDeck.get(0));
                cardDeck.remove(0);
            }

            //Printing out the User's cards
            System.out.print("\n\nHere are your cards:\n");
            for (int i = 0; i<userCards.size(); i++)
            {
                System.out.println(userCards.get(i));
            }

            //Write information to notes files, and remove the cards that each individual has from their
            //respective notes of suspects, since they have those cards in their hands
            removeFromNotes(personList, weaponList, placeList, userCards);
            writeNotes("Notes.txt", personList, weaponList, placeList, userCards);
            removeFromNotes(comp1personList, comp1weaponList, comp1placeList, comp1Cards);
            writeNotes("Comp1Notes.txt", comp1personList, comp1weaponList, comp1placeList, comp1Cards);
            removeFromNotes(comp2personList, comp2weaponList, comp2placeList, comp2Cards);
            writeNotes("Comp2Notes.txt", comp2personList, comp2weaponList, comp2placeList, comp2Cards);

            //PLAYING THE GAME (taking turns)
            do {
                String cardFound = "";
                //Let the user take their turn and be shown a card
                cardFound = usersTurn(userCards, comp1Cards, comp2Cards, personList, weaponList, placeList);

                //Remove the card they were shown from their list of suspects
                if (!cardFound.equals("no card"))
                {
                    for (int i = 0; i < personList.size(); i++)
                    {
                        if (personList.get(i).equals(cardFound))
                        {
                            personList.remove(i);
                            i--;
                        }
                    }
                    for (int i = 0; i < weaponList.size(); i++)
                    {
                        if (weaponList.get(i).equals(cardFound))
                        {
                            weaponList.remove(i);
                            i--;
                        }
                    }
                    for (int i = 0; i < placeList.size(); i++)
                    {
                        if (placeList.get(i).equals(cardFound))
                        {
                            placeList.remove(i);
                            i--;
                        }
                    }
                }
                //Rewrite the newly updated suspect lists to the user's notes
                writeNotes("Notes.txt", personList, weaponList, placeList, userCards); //edit the notes file

                input.nextLine(); //The player should press "enter" each time to continue to the next person's turn
                cardFound = comp1Turn(comp1Cards, comp2Cards, userCards, comp1personList, comp1weaponList, comp1placeList);

                //Remove the card they were shown from their list of suspects
                if (!cardFound.equals("no card"))
                {
                    for (int i = 0; i < comp1personList.size(); i++)
                    {
                        if (comp1personList.get(i).equals(cardFound))
                        {
                            comp1personList.remove(i);
                            i--;
                        }
                    }
                    for (int i = 0; i < comp1weaponList.size(); i++)
                    {
                        if (comp1weaponList.get(i).equals(cardFound))
                        {
                            comp1weaponList.remove(i);
                            i--;
                        }
                    }
                    for (int i = 0; i < comp1placeList.size(); i++)
                    {
                        if (comp1placeList.get(i).equals(cardFound))
                        {
                            comp1placeList.remove(i);
                            i--;
                        }
                    }
                }
                //Rewrite the newly updated suspect lists to Comp1's notes
                writeNotes("Comp1Notes.txt", comp1personList, comp1weaponList, comp1placeList, comp1Cards); //edit the notes file

                input.nextLine(); //The player should press "enter" each time to continue to the next person's turn

                //Let Comp 2 take their turn and be shown a card
                cardFound = comp2Turn(comp2Cards, userCards, comp1Cards, comp2personList, comp2weaponList, comp2placeList);

                //Remove the card they were shown from their list of suspects
                if (!cardFound.equals("no card"))
                {
                    for (int i = 0; i < comp2personList.size(); i++)
                    {
                        if (comp2personList.get(i).equals(cardFound))
                        {
                            comp2personList.remove(i);
                            i--;
                        }
                    }
                    for (int i = 0; i < comp2weaponList.size(); i++)
                    {
                        if (comp2weaponList.get(i).equals(cardFound))
                        {
                            comp2weaponList.remove(i);
                            i--;
                        }
                    }
                    for (int i = 0; i < comp2placeList.size(); i++)
                    {
                        if (comp2placeList.get(i).equals(cardFound))
                        {
                            comp2placeList.remove(i);
                            i--;
                        }
                    }
                }
                //Rewrite the newly updated suspect lists to Comp 2's notes
                writeNotes("Comp2Notes.txt", comp2personList, comp2weaponList, comp2placeList, comp2Cards); //edit the notes file

                System.out.print("\n\nWould you like to make a final accusation? (Y or N): ");
                isReady = input.nextLine();

            }while(!((isReady.equals("Y") || isReady.equals("y"))
                    || (comp1personList.size() == 1 && comp1weaponList.size() == 1 && comp1placeList.size() == 1)
                    || (comp2personList.size() == 1 && comp2weaponList.size() == 1 && comp2placeList.size() == 1)));
            //continue taking turns until the user is ready to take the final accusation
            //or until one of the computers is ready to make their accusation

            //If the User was ready to make the final accusation, let them make it
            if (isReady.equals("Y") || isReady.equals("y"))
            {
                ThreeCards accusation = new ThreeCards();
                System.out.print("\nEnter the person you accuse: ");
                userInput = input.nextLine();
                userInput = stringManipulate(userInput);
                accusation.setPersonCard(userInput);
                System.out.print("\nEnter the weapon you believe they used: ");
                userInput = input.nextLine();
                userInput = stringManipulate(userInput);
                accusation.setWeaponCard(userInput);
                System.out.print("\nEnter the room where the crime was committed: ");
                userInput = input.nextLine();
                userInput = stringManipulate(userInput);
                accusation.setPlaceCard(userInput);

                if (accusation.equals(caseFile))
                {
                    System.out.print("\n\nCongrats! You Win! :D "+caseFile.getPersonCard()+ " has been arrested.");
                }
                else
                {
                    System.out.print("\n\nSorry. You Lose D:\n The correct cards that were involved in the crime were " + caseFile);
                }
            }

            //Otherwise, if Comp 1 was ready to make an accusation, let them make it
            else if (comp1personList.size()==1 && comp1weaponList.size() == 1 && comp1placeList.size() == 1)
            {
                System.out.print("\nComp 1 has made a final accusation... Comp 1 guessed that " + caseFile +" were involved in the crime.");
                System.out.print("\n\nComp 1 has guessed corretly. You Lose! D:");
            }

            //Otherwise, if Comp 2 was ready to make an accusation, let them make it
            else if (comp2personList.size()==1 && comp2weaponList.size() == 1 && comp2placeList.size() == 1)
            {
                System.out.println("\nComp 2 has made a final accusation... Comp 2 guessed that the case file contains " + caseFile);

                System.out.println("\n\n Comp 2 has guessed correctly. You Lose D:");
            }

            System.out.print("\n\nWant to play again? (Y/N): ");
            playAgain = input.nextLine();
        }while(playAgain.equals("Y") || playAgain.equals("y")); //Play the game again if the user wants to

        System.out.print("\nThanks for playing Niti and Shireen's Clue Game Simulation!");
    }
//BEGINNING OF METHODS BELOW














    //STRING MANIPULATIONS METHOD
    //Remove accidental spaces in the beginning or ending of a user's input
    //Capitalize letters at the beginning of words
    //Ex. " mrs. white " will be converted to "Mrs. White"
    public static String stringManipulate(String str)
    {
        if (str.substring(0,1).equals(" "))
        {
            str = str.substring(1);
        }
        if (str.substring(str.length()-1).equals(" "))
        {
            str = str.substring(0,str.length()-1);
        }
        for(int x = 0;x< str.length(); x++)
        {
            if(str.charAt(x) == ' ')
            {
                str = str.substring(0,x+1) + str.substring(x+1,x+2).toUpperCase() + str.substring(x+2);
            }
        }
        str = str.substring(0,1).toUpperCase() + str.substring(1); //method in String class
        return str;
    }

    //SHUFFLING CARDS METHOD
    public static void shuffleCards(ArrayList<String> array)
    {
        for(int i = 0; i < array.size(); i++)
        {
            //Picking random index between i and end of array
            int randomIndex = (int)(Math.random() * (array.size()-i)+ i);

            //Swapping the randomly chosen card with the i card
            String temp = array.get(i);
            array.set(i, array.get(randomIndex));
            array.set(randomIndex, temp);
        }
    }

    //OVERWRITING NOTES FILE METHOD
    public static void writeNotes(String fileName, ArrayList <String> personList, ArrayList <String> weaponList, ArrayList <String> placeList, ArrayList <String> playerCards)
    {
        //Opening the Notes file
        String outputpathname = fileName;
        PrintWriter output = null;
        try
        {
            output = new PrintWriter(fileName);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("*** Cannot open " + outputpathname + " ***");
            System.exit(1);  // quit the program
        }

        //Adding people, weapons, and places to notes
        output.println("Notes");

        output.println("\nYour Cards:");
        for(String card : playerCards)
        {
            output.println(card);
        }
        output.println("\n---------------Suspects-----------------");
        for(String person : personList)
        {
            output.println(person);
        }
        output.println("\n----------------Weapons------------------");
        for(String weapon : weaponList)
        {
            output.println(weapon);
        }
        output.println("\n-----------------Places------------------");
        for(String place : placeList)
        {
            output.println(place);
        }

        output.close();//CLOSING THE FILE
    }

    //USER'S TURN METHOD
    public static String usersTurn(ArrayList <String> playerCards, ArrayList <String> comp1Cards, ArrayList <String> comp2Cards, ArrayList <String> personList, ArrayList <String> weaponList, ArrayList <String> placeList)
    {
        String userInput = "";
        Scanner input = new Scanner(System.in);

        //These will be the three cards that Comp 1 chooses for the interrogation
        ThreeCards interrogation = new ThreeCards ();

        do{
            //Asking the player for 3 things to interrogate about
            System.out.print("\nEnter a PERSON/SUSPECT to interrogate another player about (Use correct spelling): ");
            userInput = input.nextLine();
            userInput = stringManipulate(userInput); //edit the user's input to make it have proper format
            interrogation.setPersonCard(userInput);

            System.out.print("\nEnter a WEAPON to interrogate another player about (Use correct spelling): ");
            userInput = input.nextLine();
            userInput = stringManipulate(userInput);
            interrogation.setWeaponCard(userInput);

            System.out.print("\nEnter a ROOM to interrogate another player about (Use correct spelling): ");
            userInput = input.nextLine();
            userInput = stringManipulate(userInput);
            interrogation.setPlaceCard(userInput);

            System.out.print("\n\nYou are interrogating Comp 1 about " + interrogation + ". Make sure you have not made spelling errors. Are you sure you want to move on? (Y or N): ");
        }while(input.nextLine().equals("N"));


        ArrayList <String> hasCards = new ArrayList <String>();
        //Using the Compare to methods made in ThreeCards.java to determine which cards Comp 1 has of the interrogation
        if (interrogation.comparePerson(comp1Cards) == true)
        {
            // System.out.println ("Comp 1 has " + interrogation.getPersonCard());
            hasCards.add(interrogation.getPersonCard());
        }

        if (interrogation.compareWeapon(comp1Cards) == true)
        {
            // System.out.println ("Comp 1 has " + interrogation.getWeaponCard());
            hasCards.add(interrogation.getWeaponCard());
        }

        if (interrogation.comparePlace(comp1Cards) == true)
        {
            //System.out.println ("Comp 1 has " + interrogation.getPlaceCard());
            hasCards.add(interrogation.getPlaceCard());
        }


        if (interrogation.hasNoneOfThose(comp1Cards) == true) //If Comp 1 didn't have any of the cards of the interrogation, proceed to ask Comp 2
        {
            System.out.print("\nComp 1 does not have any of those cards, so now Comp 2 will be asked about those cards.");
            if (interrogation.comparePerson(comp2Cards) == true)
            {
                //System.out.println ("Comp 2 has " + interrogation.getPersonCard());
                hasCards.add(interrogation.getPersonCard());
            }

            if (interrogation.compareWeapon(comp2Cards) == true)
            {
                //System.out.println ("Comp 2 has " + interrogation.getWeaponCard());
                hasCards.add(interrogation.getWeaponCard());
            }

            if (interrogation.comparePlace(comp2Cards) == true)
            {
                // System.out.println ("Comp 2 has " + interrogation.getPlaceCard());
                hasCards.add(interrogation.getPlaceCard());
            }

            if (interrogation.hasNoneOfThose(comp2Cards) == true)
            {
                System.out.print ("\nComp 2 also does not have any of those cards.");
                boolean cardIsTherePerson = false;
                boolean cardIsThereWeapon = false;
                boolean cardIsTherePlace = false;
                for(int x = 0; x< personList.size(); x++)
                {
                    if(personList.get(x).equals(interrogation.getPersonCard()))
                    {
                        cardIsTherePerson = true;
                    }
                }
                for (int x = 0; x < weaponList.size(); x++)
                {
                    if(weaponList.get(x).equals(interrogation.getWeaponCard()))
                    {
                        cardIsThereWeapon = true;
                    }
                }
                for(int x = 0; x< placeList.size();x++)
                {
                    if(placeList.get(x).equals(interrogation.getPlaceCard()))
                    {
                        cardIsTherePlace = true;
                    }
                }

                if (cardIsTherePerson == true)
                {
                    for(int x = 0; x< personList.size(); x++)
                    {
                        if (!personList.get(x).equals(interrogation.getPersonCard()))
                        {
                            personList.remove(x);
                            x--;
                        }
                    }
                }
                if (cardIsThereWeapon == true)
                {
                    for(int x = 0; x< weaponList.size(); x++)
                    {
                        if (!weaponList.get(x).equals(interrogation.getWeaponCard()))
                        {
                            weaponList.remove(x);
                            x--;
                        }
                    }

                }
                if(cardIsTherePlace == true)
                {
                    for(int x = 0; x< placeList.size(); x++)
                    {
                        if (!placeList.get(x).equals(interrogation.getPlaceCard()))
                        {
                            placeList.remove(x);
                            x--;
                        }
                    }
                }
            }
        }
        String cardShow = "";
        if(hasCards.size()>0)
        {

            cardShow = hasCards.get((int)(Math.random()*hasCards.size()));
            System.out.print("\nYou have been shown "+ cardShow + ".");
        }
        else
        {
            System.out.print("\nNo one has any of those cards.");
            cardShow = "no card";
        }

        return cardShow;
    }

    //COMP 1'S TURN METHOD
    public static String comp1Turn(ArrayList <String> playerCards, ArrayList <String> comp2Cards, ArrayList <String> userCards, ArrayList <String> personList, ArrayList <String> weaponList, ArrayList <String> placeList)
    {
        Scanner input = new Scanner(System.in);
        //These will be the three cards that Comp 1 chooses for the interrogation
        ThreeCards interrogation = new ThreeCards ();

        String card1 = "";
        String card2 = "";
        String card3 = "";
        double rand1 = Math.random();
        double rand2 = Math.random();
        double rand3 = Math.random();

        //Randomizing three cards from Comp 1's list of remaining suspects to be part of the interrogation
        //There is a 30% chance that Comp 1 will ask about a card they already have, to throw off the other players sometimes
        if (personList.size() > 1 && rand1>0.3)
        {
            card1 = personList.get((int)(Math.random()*personList.size()));
        }
        else
        {
            do{
                //Choose a card that the player already has to be part of the interrogation
                card1 = playerCards.get((int)(Math.random()*playerCards.size()));
            }while(card1 != "Col. Mustard"&&card1 !=  "Mrs. Peacock"&&card1 != "Prof. Plum"&&card1 != "Miss Scarlet"&&card1 != "Mrs. White"&&card1 != "Mr. Green");
        }

        if (weaponList.size() > 1 && rand2>0.3)
        {
            card2 = weaponList.get((int)(Math.random()*weaponList.size()));
        }
        else
        {
            do{
                //choose a card that the player has
                card2 = playerCards.get((int)(Math.random()*playerCards.size()));
            }while (card2 != "Wrench" &&card2 != "Lead Pipe" && card2 != "Pistol" && card2 != "Dagger" && card2 != "Candlestick" && card2 != "Rope");
        }
        if (placeList.size() > 1 && rand3>0.3)
        {
            card3 = placeList.get((int)(Math.random()*placeList.size()));
        }
        else
        {
            do{
                //choose a card that the player has
                card3 = playerCards.get((int)(Math.random()*playerCards.size()));
            }while(card3 != "Living Room"&&card3 !=  "Garage"&&card3 != "Courtyard"&&card3 != "Office"&&card3 != "Bathroom"&& card3 != "Game Room"&&card3 != "Kitchen"&&card3 != "Dining Room"&& card3 != "Bedroom");
        }

        interrogation.setPersonCard(card1);
        interrogation.setWeaponCard(card2);
        interrogation.setPlaceCard(card3);

        System.out.println("\nComp 1 is interrogating Comp 2 about " + interrogation + ".");

        //Carry out the interrogation. Store the cards that Comp 2 has in the ArrayList hasCards
        ArrayList <String> hasCards = new ArrayList <String>();
        //Using the Compare to methods made in ThreeCards.java to determine which cards Comp 2 has
        if (interrogation.comparePerson(comp2Cards) == true)
        {
            //System.out.println ("Comp 2 has " + interrogation.getPersonCard());
            hasCards.add(interrogation.getPersonCard());
        }

        if (interrogation.compareWeapon(comp2Cards) == true)
        {
            //System.out.println ("Comp 2 has " + interrogation.getWeaponCard());
            hasCards.add(interrogation.getWeaponCard());
        }

        if (interrogation.comparePlace(comp2Cards) == true)
        {
            //System.out.println ("Comp 2 has " + interrogation.getPlaceCard());
            hasCards.add(interrogation.getPlaceCard());
        }
        int counter = 0; //Counts how many of the cards of the interrogation that the User has, if the User is asked.
        if (interrogation.hasNoneOfThose(comp2Cards) == true)
        {
            System.out.print("\nComp 2 did not have any of those cards, so now you will be asked about those cards.");

            if (interrogation.comparePerson(userCards) == true)
            {
                System.out.print("\nYou have " + interrogation.getPersonCard()+".");
                hasCards.add(interrogation.getPersonCard());
                counter++;
            }

            if (interrogation.compareWeapon(userCards) == true)
            {
                System.out.print("\nYou have " + interrogation.getWeaponCard()+".");
                hasCards.add(interrogation.getWeaponCard());
                counter++;
            }

            if (interrogation.comparePlace(userCards) == true)
            {
                System.out.print("\nYou have " + interrogation.getPlaceCard()+".");
                hasCards.add(interrogation.getPlaceCard());
                counter++;
            }

            if (interrogation.hasNoneOfThose(userCards) == true)
            {
                System.out.print("\nYou also do not have any of those cards.");
                //Now the player may have just figured out 1 or more of the cards in the Case File.
                boolean cardIsTherePerson = false;
                boolean cardIsThereWeapon = false;
                boolean cardIsTherePlace = false;

                //The player may have just figured out 1 or more of the cards in the Case File.
                //Check if the person they interrogated about is in their suspect list. If it is, then since none of the
                //other players had it in their hand, that must be the card in the Case File

                //Otherwise, if the the person is not in their suspect list, then they actually had that card in their hand
                //So they weren't really reavealed any new information (Think about asking another player if they had Col. Mustard, but
                // you have Col. Mustard in your hand, so obviously they would not have Col. Mustard)
                for(int x = 0; x< personList.size(); x++)
                {
                    if(personList.get(x).equals(interrogation.getPersonCard()))
                    {
                        cardIsTherePerson = true;
                    }
                }
                for (int x = 0; x < weaponList.size(); x++)
                {
                    if(weaponList.get(x).equals(interrogation.getWeaponCard()))
                    {
                        cardIsThereWeapon = true;
                    }
                }
                for(int x = 0; x< placeList.size();x++)
                {
                    if(placeList.get(x).equals(interrogation.getPlaceCard()))
                    {
                        cardIsTherePlace = true;
                    }
                }

                //If they figured out the person, then remove every other person from their suspect list except for that person.
                if (cardIsTherePerson == true)
                {
                    for(int x = 0; x< personList.size(); x++)
                    {
                        if (!personList.get(x).equals(interrogation.getPersonCard()))
                        {
                            personList.remove(x);
                            x--;
                        }
                    }
                }

                //If they figured out the weapon, then remove every other weapon from their suspect list except for that weapon.
                if (cardIsThereWeapon == true)
                {
                    for(int x = 0; x< weaponList.size(); x++)
                    {
                        if (!weaponList.get(x).equals(interrogation.getWeaponCard()))
                        {
                            weaponList.remove(x);
                            x--;
                        }
                    }
                }

                //If they figured out the room, then remove every other room from their suspect list except for that room.
                if(cardIsTherePlace == true)
                {
                    for(int x = 0; x< placeList.size(); x++)
                    {
                        if (!placeList.get(x).equals(interrogation.getPlaceCard()))
                        {
                            placeList.remove(x);
                            x--;
                        }
                    }
                }
            }
        }
        String cardShow = "";
        if (hasCards.size()>0 && counter>1)
        {
            System.out.println();
            for(int x = 0; x<hasCards.size(); x++)
            {
                System.out.print("\nEnter "+x+" to show Comp 1 "+ hasCards.get(x)+".");
            }
            cardShow = hasCards.get(Integer.valueOf(input.nextLine()));
            System.out.print("\nYou have shown your card to Comp 1.");
        }
        else if(hasCards.size()>0 && counter == 1)
        {
            cardShow = hasCards.get(0);
            System.out.print("\nYou have shown "+cardShow+" to Comp 1.");
        }
        else if(hasCards.size()>0)
        {
            cardShow = hasCards.get((int)Math.random()*hasCards.size()); //Randomize the card from hasCards that Comp 1 will be shown
            System.out.print("Comp 2 has shown Comp 1 a card.");
        }
        else
        {
            System.out.print("\nComp 1 has not been shown any card.");
            cardShow = "no card";
        }
        return cardShow;

    }

    public static String comp2Turn(ArrayList <String> playerCards, ArrayList <String> userCards, ArrayList <String> comp1Cards, ArrayList <String> personList, ArrayList <String> weaponList, ArrayList <String> placeList)
    {
        Scanner input = new Scanner(System.in);
        //These will be the three cards that Comp 2 chooses for the interrogation
        ThreeCards interrogation = new ThreeCards ();

        //Randomizing three cards to be part of the interrogation
        String card1 = "";
        String card2 = "";
        String card3 = "";
        double rand1 = Math.random();
        double rand2 = Math.random();
        double rand3 = Math.random();
        if (personList.size() > 1 && rand1 > 0.3)
        {
            card1 = personList.get((int)(Math.random()*personList.size()));
        }
        else
        {
            do{
                //choose a card that the player has
                card1 = playerCards.get((int)(Math.random()*playerCards.size()));
            }while(card1 != "Col. Mustard"&&card1 !=  "Mrs. Peacock"&&card1 != "Prof. Plum"&&card1 != "Miss Scarlet"&&card1 != "Mrs. White"&&card1 != "Mr. Green");
        }
        if (weaponList.size() > 1 && rand2 > 0.3)
        {
            card2 = weaponList.get((int)(Math.random()*weaponList.size()));
        }
        else
        {
            do{
                //choose a card that the player has
                card2 = playerCards.get((int)(Math.random()*playerCards.size()));
            }while (card2 != "Wrench" &&card2 != "Lead Pipe" && card2 != "Pistol" && card2 != "Dagger" && card2 != "Candlestick" && card2 != "Rope");
        }
        if (placeList.size() > 1 && rand3 > 0.3)
        {
            card3 = placeList.get((int)(Math.random()*placeList.size()));
        }
        else
        {
            do{
                //choose a card that the player has
                card3 = playerCards.get((int)(Math.random()*playerCards.size()));
            }while(card3 != "Living Room"&&card3 !=  "Garage"&&card3 != "Courtyard"&&card3 != "Office"&&card3 != "Bathroom"&& card3 != "Game Room"&&card3 != "Kitchen"&&card3 != "Dining Room"&& card3 != "Bedroom");
        }

        interrogation.setPersonCard(card1);
        interrogation.setWeaponCard(card2);
        interrogation.setPlaceCard(card3);

        System.out.println("\nComp 2 is interrogating you about " + interrogation + ".");

        //REMINDER!!!!! REMOVE THE "COMP 1 HAS" OR "COMP 2 HAS"
        ArrayList <String> hasCards = new ArrayList <String>();
        //Using the Compare to methods made in ThreeCards.java to have the Computer print out one card if they have it
        int counter = 0;
        if (interrogation.comparePerson(userCards) == true)
        {
            System.out.println ("You have " + interrogation.getPersonCard()+".");
            hasCards.add(interrogation.getPersonCard());
            counter++;
        }

        if (interrogation.compareWeapon(userCards) == true)
        {
            System.out.println ("You have " + interrogation.getWeaponCard()+".");
            hasCards.add(interrogation.getWeaponCard());
            counter++;
        }

        if (interrogation.comparePlace(userCards) == true)
        {
            System.out.println ("You have " + interrogation.getPlaceCard()+".");
            hasCards.add(interrogation.getPlaceCard());
            counter++;
        }


        if (interrogation.hasNoneOfThose(userCards) == true)
        {
            System.out.print("\nYou do not have any of those cards, so now Comp 1 will be asked about those 3 cards.");
            if (interrogation.comparePerson(comp1Cards) == true)
            {
                //System.out.println ("Comp 1 has " + interrogation.getPersonCard());
                hasCards.add(interrogation.getPersonCard());
            }

            if (interrogation.compareWeapon(comp1Cards) == true)
            {
                //System.out.println ("Comp 1 has " + interrogation.getWeaponCard());
                hasCards.add(interrogation.getWeaponCard());
            }

            if (interrogation.comparePlace(comp1Cards) == true)
            {
                //System.out.println ("Comp 1 has " + interrogation.getPlaceCard());
                hasCards.add(interrogation.getPlaceCard());
            }

            if (interrogation.hasNoneOfThose(comp1Cards) == true)
            {
                System.out.println("\nComp 1 also does not have any of those cards.");
                boolean cardIsTherePerson = false;
                boolean cardIsThereWeapon = false;
                boolean cardIsTherePlace = false;
                for(int x = 0; x< personList.size(); x++)
                {
                    if(personList.get(x).equals(interrogation.getPersonCard()))
                    {
                        cardIsTherePerson = true;
                    }
                }
                for (int x = 0; x < weaponList.size(); x++)
                {
                    if(weaponList.get(x).equals(interrogation.getWeaponCard()))
                    {
                        cardIsThereWeapon = true;
                    }
                }
                for(int x = 0; x< placeList.size();x++)
                {
                    if(placeList.get(x).equals(interrogation.getPlaceCard()))
                    {
                        cardIsTherePlace = true;
                    }
                }

                if (cardIsTherePerson == true)
                {
                    for(int x = 0; x< personList.size(); x++)
                    {
                        if (!personList.get(x).equals(interrogation.getPersonCard()))
                        {
                            personList.remove(x);
                            x--;
                        }
                    }
                }
                if (cardIsThereWeapon == true)
                {
                    for(int x = 0; x< weaponList.size(); x++)
                    {
                        if (!weaponList.get(x).equals(interrogation.getWeaponCard()))
                        {
                            weaponList.remove(x);
                            x--;
                        }
                    }

                }
                if(cardIsTherePlace == true)
                {
                    for(int x = 0; x< placeList.size(); x++)
                    {
                        if (!placeList.get(x).equals(interrogation.getPlaceCard()))
                        {
                            placeList.remove(x);
                            x--;
                        }
                    }
                }
            }
        }
        String cardShow = "";
        if (hasCards.size()>0 && counter>1)
        {
            for(int x = 0; x<hasCards.size(); x++)
            {
                System.out.print("\nEnter "+x+" to show Comp 2 "+ hasCards.get(x)+".");
            }
            cardShow = hasCards.get(Integer.valueOf(input.nextLine()));
            System.out.print("\nYou have shown your card to Comp 2.");
        }
        else if(hasCards.size()>0 && counter == 1)
        {

            cardShow = hasCards.get(0);
            System.out.print("\nYou have shown Comp 2 " +cardShow +".");
        }
        else if(hasCards.size()>0 && counter == 0)
        {

            cardShow = hasCards.get((int)Math.random()*hasCards.size());
            System.out.print("\nComp 1 has shown a card to Comp 2.");
        }
        else
        {
            System.out.print("\nComp 2 has not been shown any card.");
            cardShow = "no card";
        }
        return cardShow;

    }

    public static void removeFromNotes(ArrayList <String> personList, ArrayList <String> weaponList, ArrayList <String> placeList, ArrayList <String> playerCards)
    {
        for(int i = 0; i < personList.size(); i++)
        {
            for(int x = 0; x<playerCards.size();x++)
            {
                if (i < personList.size())
                {
                    if(personList.get(i).equals(playerCards.get(x)))
                    {
                        personList.remove(i);
                        x=-1;
                    }
                }
            }
        }

        for(int i = 0; i < weaponList.size(); i++)
        {
            for(int x = 0; x<playerCards.size();x++)
            {
                if (i < weaponList.size())
                {
                    if(weaponList.get(i).equals(playerCards.get(x)))
                    {
                        weaponList.remove(i);
                        x=-1;
                    }
                }
            }
        }

        for(int i = 0; i < placeList.size(); i++)
        {
            for(int x = 0; x < playerCards.size();x++)
            {
                if (i < placeList.size())
                {
                    if(placeList.get(i).equals(playerCards.get(x)))
                    {
                        placeList.remove(i);
                        x=-1;
                    }
                }
            }
        }
    }

}