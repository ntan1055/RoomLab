package Game;

import People.Person;
import Rooms.*;

import java.util.Scanner;

public class Runner {
	

	private static boolean gameOn = true;
	
	public static void main(String[] args)
	{
		Room[][] building = new Room[5][5];
		
		//Fill the building with normal rooms
		for (int x = 0; x<building.length; x++)
		{
			for (int y = 0; y < building[x].length; y++)
			{
				building[x][y] = new Room(x,y);
			}
		}


		//Create a random winning room.
		int x = (int)(Math.random()*building.length);
		int y = (int)(Math.random()*building.length);
		building[x][y] = new WinningRoom(x, y);
		 
		 //Setup player 1 and the input scanner
		Person player1 = new Person("FirstName", "FamilyName", 0,0);
		building[0][0].enterRoom(player1);
		Scanner in = new Scanner(System.in);
		while(gameOn)
		{
			System.out.println("Where would you like to move? (Choose N, S, E, W)");
			String move = in.nextLine();
			if(validMove(move, player1, building))
			{
				System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());
				
			}
			else {
				System.out.println("Please choose a valid move.");
			}
			
			
		}
		in.close();
	}

	/**
	 * Checks that the movement chosen is within the valid game map.
	 * @param move the move chosen
	 * @param p person moving
	 * @param map the 2D array of rooms
	 * @return
	 */
	public static boolean validMove(String move, Person p, Room[][] map)
	{
		move = move.toLowerCase().trim();
		switch (move) {
			case "n":
				if (p.getxLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			case "e":
				if (p.getyLoc()< map[p.getyLoc()].length -1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "w":
				if (p.getyLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			default:
				break;
					
		}
		return true;
	}

	public static boolean validMove(String move, Person p, Room2[][] map)
	{
		move = move.toLowerCase().trim();
		switch (move) {
			case "n":
				if (p.getxLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			case "e":
				if (p.getyLoc()< map[p.getyLoc()].length -1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "w":
				if (p.getyLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			default:
				break;

		}
		return true;
	}

	public static void teleport()
	{
		Person player2 = new Person("FirstName", "FamilyName", 0,0);
		Scanner in = new Scanner(System.in);
		while(gameOn)
		{
			Room2[][] Room2 = new Room2[5][5];
			for (int x = 0; x<Room2.length; x++)
			{
				for (int y = 0; y < Room2[x].length; y++)
				{
					Room2[x][y] = new Room2(x,y);
				}
			}
            int x = (int)(Math.random()*Room2.length);
            int y = (int)(Math.random()*Room2.length);
            Room2[x][y] = new Mine(x, y);
            int x1 = (int)(Math.random()*Room2.length);
            int y1 = (int)(Math.random()*Room2.length);
            Room2[x][y] = new Mine(x1, y1);
			System.out.println("Where would you like to move? (Choose N, S, E, W)");
			String move = in.nextLine();
			if(validMove(move, player2, Room2))
			{
				System.out.println("Your coordinates: row = " + player2.getxLoc() + " col = " + player2.getyLoc());
			}
			else
			{
				System.out.println("Please choose a valid move.");
			}
		}
		in.close();
	}

	public static void mineReset()
	{
        Person player2 = new Person("FirstName", "FamilyName", 0,0);
        Scanner in = new Scanner(System.in);
        while(gameOn)
        {
            Room2[][] Room2 = new Room2[5][5];
            for (int x = 0; x<Room2.length; x++)
            {
                for (int y = 0; y < Room2[x].length; y++)
                {
                    Room2[x][y] = new Room2(x,y);
                }
            }
            int x = (int)(Math.random()*Room2.length);
            int y = (int)(Math.random()*Room2.length);
            Room2[x][y] = new Mine(x, y);
            Room2[4][4] = new Exit(4, 4);
            System.out.println("Where would you like to move? (Choose N, S, E, W)");
            String move = in.nextLine();
            if(validMove(move, player2, Room2))
            {
                System.out.println("Your coordinates: row = " + player2.getxLoc() + " col = " + player2.getyLoc());
            }
            else
            {
                System.out.println("Please choose a valid move.");
            }
        }
        in.close();
	}

	public static void gameOff()
	{
		gameOn = false;
	}
}
