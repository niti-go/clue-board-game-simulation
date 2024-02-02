/** Heading  **********************************************/
/*	Your names: Niti Goyal and Shireen Kumar
		Class block: G				Date Started: 4/25/2021
		Project: Clue Game Simulation
		Purpose: Provide a command-line based game simulation of Clue, a popular board game, using what we have learned in 
***********************************************************
  This class is used for storing information about 3 cards (Person, Weapon, and Room)
  and comparing or printing out that information.
  Useful for storing information about the Case File, Interrogatons, and Accusations
*/
import java.util.ArrayList;

public class ThreeCards
{
    private String personCard;
    private String weaponCard;
    private String placeCard;

    //Constructors
    public ThreeCards() //default constructor
    {
        personCard = "";
        weaponCard = "";
        placeCard = "";
    }
    public ThreeCards(String a, String b, String c)
    {
        personCard = a;
        weaponCard = b;
        placeCard = c;
    }

    //Getters and Setters
    public String getPersonCard()
    {
        return personCard;
    }

    public String getWeaponCard()
    {
        return weaponCard;
    }

    public String getPlaceCard()
    {
        return placeCard;
    }

    public void setPersonCard(String a)
    {
        personCard = a;
    }

    public void setWeaponCard(String a)
    {
        weaponCard = a;
    }

    public void setPlaceCard(String a)
    {
        placeCard = a;
    }

    //other methods
    public boolean equals(ThreeCards that)
    {
        if (this.personCard.equals(that.personCard) &&
                this.weaponCard.equals(that.weaponCard) &&
                this.placeCard.equals(that.placeCard))
        {
            return true;
        }
        return false;
    }

    //Comparing a card that was chosen by a player to another player's cards and returning true or false if they have that card
//Useful for checking which cards of an interrogation a player has
    public boolean comparePerson(ArrayList <String> otherPlayerCards)
    {
        for (String card : otherPlayerCards)
        {
            if (this.personCard.equals(card))
            {
                return true;
            }
        }
        return false;
    }

    public boolean compareWeapon(ArrayList <String> otherPlayerCards)
    {
        for (String card : otherPlayerCards)
        {
            if (this.weaponCard.equals(card))
            {
                return true;
            }
        }
        return false;
    }

    public boolean comparePlace(ArrayList <String> otherPlayerCards)
    {
        for (String card : otherPlayerCards)
        {
            if (this.placeCard.equals(card))
            {
                return true;
            }
        }
        return false;
    }

    //If a player has none of the cards of an interrogation, return true
    public boolean hasNoneOfThose(ArrayList <String> otherPlayerCards)
    {
        if (!comparePerson(otherPlayerCards) && !compareWeapon(otherPlayerCards) && !comparePlace(otherPlayerCards))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //Print out information of a ThreeCards object
    public String toString()
    {
        return (personCard + ", " + weaponCard + ", and " + placeCard);
    }


}