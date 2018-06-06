import java.util.Random;

public class Computer {

  /*
    Pick a random Move from ROCK, PAPER or SCISSORS
    Return: Move (ROCK, PAPER or SCISSORS)
   */
  public RockPaperScissors.Move makeMove() {
    RockPaperScissors.Move[] moves = RockPaperScissors.Move.values();
    Random rand = new Random();
    int idx = rand.nextInt(moves.length);
    return moves[idx];
  }
}
