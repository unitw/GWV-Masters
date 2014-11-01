
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Search
{

    private final char GOAL_CHAR = 'g';
    private final char START_CHAR = 's';
    private final char UP = 'u';
    private final char RIGHT = 'r';
    private final char DOWN = 'd';
    private final char LEFT = 'l';

    private final char[][] _inputEnvironment;
    private char[][] _environment;
    private final int _startPosX;
    private final int _startPosY;

    private int _currentPosX;
    private int _currentPosY;

    private Stack<Character> _searchStack;

    /**
     *
     * @param environment
     * @param startPosX
     * @param startPosY
     * @return
     */
    public static List<Character> dfs(char[][] environment, int startPosX, int startPosY)
    {
        Search search = new Search(environment, startPosX, startPosY);
        return search.startDFS();
    }

    /**
     * Creates a new Search instance that can search for a goal in a given
     * environment
     *
     * @param environment The environment to be used in the form of a char[][],
     * 'x' denotes a wall, 'g' a goal and 's' the start point
     * @param startPosX The X-Coordinate of the start point in the environment
     * array. char[y][x]
     * @param startPosY The X-Coordinate of the start point in the environment
     * array. char[y][x]
     */
    public Search(char[][] environment, int startPosX, int startPosY)
    {
        _environment = Start.copy2DCharArray(environment);
        _inputEnvironment = Start.copy2DCharArray(environment);
        _startPosX = startPosX;
        _startPosY = startPosY;
        _currentPosX = startPosX;
        _currentPosY = startPosY;
        _searchStack = new Stack<Character>();
    }

    /**
     * Takes a direction as a char and returns the opposite direction
     * @param direction a direction ('u', 'r', 'd', 'l')
     * @return the opposite direction to the specified one
     */
    private char oppositeDirection(char direction)
    {
        char oppositeDir = ' ';

        switch (direction)
        {
            case 'u':
                oppositeDir = 'd';
                break;
            case 'r':
                oppositeDir = 'l';
                break;
            case 'd':
                oppositeDir = 'u';
                break;
            case 'l':
                oppositeDir = 'r';
                break;
        }

        return oppositeDir;
    }

    /**
     * Starts a depth first search on the environment that 
     * was specified during instanciation. 
     * @return If a path to a goal is found, the path is returned as a List, 
     *         if not a List containing only 's' (Start point) is returned.
     *         The path is specified as a series of actions 
     *          ('s' = go to start point, 'u' = move up, 'd' = move down, 
     *           'l' = move left and 'r' = move right)
     */
    public List<Character> startDFS()
    {
        reset(); // Resets all values to the start values, needed if multiple searches are performed
        
        _searchStack.push(START_CHAR);

        int schleifenzaehler = 0;

        while (!goalInReach() && !_searchStack.isEmpty())
        {
            if (topIsClear())
            {
                move(UP);
                _environment[_currentPosY][_currentPosX] = UP;
                _searchStack.push(UP);
            } else if (rightIsClear())
            {
                move(RIGHT);
                _environment[_currentPosY][_currentPosX] = RIGHT;
                _searchStack.push(RIGHT);
            } else if (bottomIsClear())
            {
                move(DOWN);
                _environment[_currentPosY][_currentPosX] = DOWN;
                _searchStack.push(DOWN);
            } else if (leftIsClear())
            {
                move(LEFT);
                _environment[_currentPosY][_currentPosX] = LEFT;
                _searchStack.push(LEFT);
            } else
            {
                //char topChar = _searchStack.peek();
                char topChar = _searchStack.pop();
                move(oppositeDirection(topChar));
            }
            ++schleifenzaehler;
            //System.out.println(_searchStack.toString());

            for (int y = 0; y < 10; ++y)
            {
                String line = "";
                for (int x = 0; x < 20; ++x)
                {
                    line = line + _environment[y][x];
                }
                System.out.println(line);
            }
            System.out.println();
        }

        System.out.println(schleifenzaehler);
        
        return new ArrayList(_searchStack);
    }

    /**
     * Changes the values of currentPosX or currentPosY to move 
     * in the specified diretion
     * @param direction 
     */
    private void move(char direction)
    {
        switch (direction)
        {
            case UP:
                _currentPosY -= 1;
                break;
            case RIGHT:
                _currentPosX += 1;
                break;
            case DOWN:
                _currentPosY += 1;
                break;
            case LEFT:
                _currentPosX -= 1;
                break;
        }
    }
    
    // ----Clear-Methods: ----
    //These methods check wether position next to the current 
    //position are clear and have not been visited during search yet.
    private boolean topIsClear()
    {
        return _environment[_currentPosY - 1][_currentPosX] == ' ';
    }

    private boolean bottomIsClear()
    {
        return _environment[_currentPosY + 1][_currentPosX] == ' ';
    }

    private boolean leftIsClear()
    {
        return _environment[_currentPosY][_currentPosX - 1] == ' ';
    }

    private boolean rightIsClear()
    {
        return _environment[_currentPosY][_currentPosX + 1] == ' ';
    }

    // ---- Goal Checking: ----
    // These Methods check wether a goal is in next to the current postion
    private boolean goalInReach()
    {
        if (topIsGoal())
        {
            _searchStack.push(UP);
        } else if (rightIsGoal())
        {
            _searchStack.push(RIGHT);
        } else if (bottomIsGoal())
        {
            _searchStack.push(DOWN);
        } else if (leftIsGoal())
        {
            _searchStack.push(LEFT);
        } else
        {
            return false;
        }

        return true;
    }

    private boolean topIsGoal()
    {
        return _environment[_currentPosY - 1][_currentPosX] == GOAL_CHAR;
    }

    private boolean bottomIsGoal()
    {
        return _environment[_currentPosY + 1][_currentPosX] == GOAL_CHAR;
    }

    private boolean leftIsGoal()
    {
        return _environment[_currentPosY][_currentPosX - 1] == GOAL_CHAR;
    }

    private boolean rightIsGoal()
    {
        return _environment[_currentPosY][_currentPosX + 1] == GOAL_CHAR;
    }
    
    private void reset()
    {
        _environment = Start.copy2DCharArray(_inputEnvironment);
        _searchStack.removeAllElements();
        _currentPosX = _startPosX;
        _currentPosY = _startPosY;
    }
}


