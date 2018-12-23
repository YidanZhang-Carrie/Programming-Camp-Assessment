import java.util.*;
/**
 * The Game class is used to generate games of finding pairs.
 *
 * @author (Yidan Zhang)
 * @version (21/12/2018)
 */
public class Game
{
    private int firstNum;
    private String[] list; 
    private ArrayList<Integer> existNum;
    /**
     * Create objects of class Game
     */
    public Game()
    {
        firstNum = 0;
        existNum = new ArrayList<Integer>();
    }

    /**
     * Create objects of class Game with a given first number
     */
    public Game(int newFirstNum)
    {
        firstNum = newFirstNum;
    }

    /**
     * Invite the user to enter the list of positive integers
     * and check if the format is correct
     */
    public void inputList()
    {
        System.out.println("Please enter a list of positive integers (seperate by comma)");
        System.out.print("The list: ");
        Scanner console = new Scanner(System.in);
        boolean isFormat = false;
        String input = console.nextLine();
        while (!isFormat)
        {           
            boolean result = input.matches("^[0-9]*[1-9][0-9]*?(,[0-9]*[1-9][0-9]*?)+$"); 
            if (!result)
            {
                System.out.println("**Wrong format**");
                System.out.print("The list: ");
                isFormat = false;
                input = console.nextLine();
            }
            else
                isFormat = true;
        }
        list = input.split(",");                
    }

    /**
     * Invite the user to enter the first number
     * check if the content entered is number
     */
    public void inputNumber()
    {
        System.out.print("First number: ");
        Scanner console = new Scanner(System.in);
        boolean isNumber = true;
        do
        {
            String input = console.nextLine();
            boolean result = input.matches("[0-9]+");           
            if (!result)
            {
                System.out.println("**Please enter a number**");
                System.out.print("First number: ");
                isNumber = false;
            }
            else
            {
                firstNum = Integer.valueOf(input);
                isNumber = true;
            }
        }while (!isNumber);
        System.out.println("--------------------");        
    }

    /**
     * Generate the whole process of the game
     */
    public void menu()
    {
        inputNumber();
        inputList();
        outcome();
    }

    /**
     * Calculate all the pairs of number in the list that add up to the first number
     */
    public void outcome()
    {
        for ( int i = 0; i < list.length; i++)
        {
            int numOne = Integer.parseInt(list[i]);
            int numTwo = firstNum - numOne;            
            existNum.add(numTwo);
            boolean exist = false;
            String num2 = Integer.toString(numTwo);
            for (int k = 0; k < existNum.size(); k++)
            {
                if (numOne == existNum.get(k))
                    exist = true;
            }
            for (int n = 0; n < list.length; n++)
            {
                if (list[n].equals(num2) && list[n] != list[i] && !exist)                
                    System.out.println("[" + numOne + "," + numTwo + "]");                
            }
        }   
    }
}
