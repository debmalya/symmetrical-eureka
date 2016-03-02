package cf;
public class Brickery
{

  // --------------------------------------------------------------------------
  // Static members
  // --------------------------------------------------------------------------



  // -------------------------------------------------------------------------
  // Members
  // -------------------------------------------------------------------------



  // -------------------------------------------------------------------------
  // Constructor
  // -------------------------------------------------------------------------



  // -------------------------------------------------------------------------
  // Implements interface <IMyInterface>
  // -------------------------------------------------------------------------



  // --------------------------------------------------------------------------
  // Methods
  // --------------------------------------------------------------------------
  /**
   * 
   * We want to make a row of bricks that is exactly goal inches long. We have
   * some small bricks (1 inch each) and some big ones (5 inches each). Return
   * true if it is possible to build the row by choosing from the given bricks.
   * 
   * Example:
   * 
   * makeBricks(3, 1, 8) = true It's possible to take one big brick and three
   * small ones.
   * 
   * makeBricks(3, 1, 9) = false There're not enough bricks to create a row of
   * length goal.
   * 
   * makeBricks(2, 3, 9) = false There's no way to make a row of length goal.
   * 
   * [input] integer small The number of small bricks (1 inch).
   * 
   * [input] integer big The number of big bricks (5 inches).
   * 
   * [input] integer goal The length of the raw we want to build. 0 ≤ small,
   * big, goal ≤ 10**9.
   * 
   * [output] boolean true if it's possible to build a row of length goal, false
   * otherwise.
   * 
   * 
   * 
   * @param small
   * @param big
   * @param goal
   * @return
   */
  boolean makeBricks (int small, int big, int goal)
  {

    if (goal == small)
    {
      return true;
    }
    if (goal == big * 5)
    {
      return true;
    }
    if (goal % 5 <= small)
    {
      return goal / 5 <= big;
    }
    return false;

  }


  // --------------------------------------------------------------------------
  // Any other separator such as "Utility methods", etc.
  // --------------------------------------------------------------------------
}
