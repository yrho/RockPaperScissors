import java.util.Scanner;

import static java.lang.System.exit;

public class RockPaperScissors {
  public static Scanner s;
  public static Player player;
  public static Computer computer;
  static int played = 0;
  static int wins = 0;
  static int losses = 0;
  static int draws = 0;
  static boolean stillPlaying = true;

  public enum Move {
    ROCK, PAPER, SCISSORS;

    public int compare(Move move) {
      //Draw
      if (this == move)
        return 0;

      switch (this) {
        case ROCK:
          return (move == Move.SCISSORS ? 1 : -1);
        case PAPER:
          return (move == Move.ROCK ? 1 : -1);
        case SCISSORS:
          return (move == Move.PAPER ? 1: -1);
      }
      return 0;
    }
  }

  public static void main(String args[]) {
    s = new Scanner(System.in);
    player = new Player(s);
    computer = new Computer();
    System.out.println("**********************");
    System.out.println("ROCK, PAPER, SCISSORS!");
    System.out.println("**********************");
    System.out.println("Played: ");
    System.out.println("P: Play  | Q: Quit");
    if (player.scanner.nextLine().equals("Q")) {
      quit();
    }
    Move playerMove = player.makeMove();
    Move computerMove = computer.makeMove();
    System.out.println(playerMove + " vs " + computerMove);
    int result = playerMove.compare(computerMove);
    if (result == 0) {
      System.out.println("Draw!");
      draws++;
    } else if (result == 1) {
      System.out.println("You Win!");
      wins++;
    } else {
      System.out.println("You Lost!");
      losses++;
    }

  }

  public static void quit() {
    System.out.println("Are you sure you want to quit? (y/n)");
    if (player.scanner.nextLine().equals("y")) {
      stillPlaying = false;
      exit(0);
    }
    else
      stillPlaying = true;
  }

}
